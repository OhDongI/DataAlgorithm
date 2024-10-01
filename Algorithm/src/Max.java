
public class Max {

	static class Page {
		Object o;
		int nextPage;
		Page(int next){ // init
			nextPage=next;
		}
	}
	static int memorySize;
	static Page [] memory ;

	static class MemoryManager{
		int headOfFreeList;
		int freeNOfPages;

		public MemoryManager(int size){ // init //////밑에서부터 채워라
			memorySize=size;
			memory = new Page[memorySize];
			for (int i=0; i<memorySize; i++) {
				memory[i]=new Page(i+1);
			}
			memory[memorySize-1].nextPage=-1;
			headOfFreeList=0;
			freeNOfPages=memorySize;//여기까지
		}

		public int allocate(int nOfPages) {//밑에서부터 채워라
			int headOfAllocatedList;
			if (nOfPages<=freeNOfPages) {
				if (nOfPages==1) {
					headOfAllocatedList=headOfFreeList;
					headOfFreeList=memory[headOfFreeList].nextPage;
					memory[headOfAllocatedList].nextPage=-1;
				}
				else {
					headOfAllocatedList=headOfFreeList;
					int p=headOfFreeList;
					for (int i=1; i<nOfPages; i++) {
						p=memory[p].nextPage;
					}
					headOfFreeList=memory[p].nextPage;
					memory[p].nextPage=-1;
				}
				freeNOfPages-=nOfPages;
			}
			else {
				headOfAllocatedList=-1;
			}
			return headOfAllocatedList;
		}//여기까지
		
		public void free(int headOfReturnedMemory) {//채워
			if (headOfFreeList==-1) {
				headOfFreeList=headOfReturnedMemory;
				memory[headOfReturnedMemory].nextPage=-1;
			}
			else {
				int p=headOfFreeList;
				while(memory[p].nextPage!=-1) {
					p=memory[p].nextPage;
				}
				memory[p].nextPage=headOfReturnedMemory;
				memory[headOfReturnedMemory].nextPage=-1;
			}
			freeNOfPages++;
		}//여기까지

		public void showFreeMemory() {
			System.out.println("\n[ Free Memory Status ]");
			System.out.println("*** Number of Free Memory Blocks : "+freeNOfPages);
			System.out.print("*** List of Free Pages : "+headOfFreeList);
			if (headOfFreeList!=-1) {
				int p=headOfFreeList;
				while(memory[p].nextPage!=-1) {
					p=memory[p].nextPage;
					System.out.print(" -> "+p);
				}
			}
		}
	}
	
	static class Process {
		int headOfMyMemory;
		int numberOfMyMemory;
		Process(){ // init
			headOfMyMemory = -1;
			numberOfMyMemory = 0;
		}
		public int computeMemoryRequred() {
			return (1 + (int) (3 * Math.random()));
		}
		public void getMemory(int headOfAllocatedList) {//여기서부터 채워리
			int p=headOfAllocatedList;
			while(memory[p].nextPage!=-1) {
				p=memory[p].nextPage;
				numberOfMyMemory++;
			}
			if (headOfMyMemory!=-1) {
				p=headOfMyMemory;
				while(memory[p].nextPage!=-1) {
					p=memory[p].nextPage;
				}
				memory[p].nextPage=headOfAllocatedList;
			}
			else {
				headOfMyMemory=headOfAllocatedList;
			}//여기까지
		}
		public int returnMemory() {
					int numberOfReturned = (1+(int)(numberOfMyMemory*Math.random()));
					int headOfReturnedList;
//채워
					if (numberOfReturned==1) {
						headOfReturnedList=headOfMyMemory;
						headOfMyMemory=memory[headOfMyMemory].nextPage;
						memory[headOfReturnedList].nextPage=-1;
						numberOfMyMemory--;
					}
					else {
						int p=headOfMyMemory;
						for (int i=1; i<numberOfReturned-1; i++) {
							p=memory[p].nextPage;
						}
						headOfReturnedList=memory[p].nextPage;
						memory[p].nextPage=memory[headOfReturnedList].nextPage;
						memory[headOfReturnedList].nextPage=-1;
						numberOfMyMemory-=numberOfReturned;
					}
//여기까지
					return headOfReturnedList;
				}
		public int size() {
			return numberOfMyMemory;
		}
		public void showProcessMemory() {
			System.out.print("*** List of My Pages ["+numberOfMyMemory+"] : "+headOfMyMemory);
			if (headOfMyMemory!=-1) {
				int p=headOfMyMemory;
				while(memory[p].nextPage!=-1) {
					p=memory[p].nextPage;
					System.out.print(" -> "+p);
				}
			}
		}
	}


	public static void main(String[] args) {
		
		MemoryManager mem = new MemoryManager(30);
		mem.showFreeMemory();
		Process p1 =new Process();
		Process p2 =new Process();
		Process p3 =new Process();
		
		for (int i=0; i<20; i++) {
			double operation =Math.random();
			double proc =1+(int)(3*Math.random());
			
			if(proc==1) {
				if (operation<0.7) {
					int memAllocated =mem.allocate(p1.computeMemoryRequred());
					if (memAllocated!=-1)
						p1.getMemory(memAllocated);
				}
				else {
					if (p1.size()>0) {
						mem.free(p1.returnMemory());
					}						

				}
			}
			else if(proc==2){
				if (operation<0.8) {
					int memAllocated =mem.allocate(p2.computeMemoryRequred());
					if (memAllocated!=-1)
						p2.getMemory(memAllocated);
				}
				else {
					if (p2.size()>0) {
						mem.free(p2.returnMemory());
					}
				}
			}
			else {
				if (operation<0.8) {
					int memAllocated =mem.allocate(p3.computeMemoryRequred());
					if (memAllocated!=-1)
						p3.getMemory(memAllocated);
				}
				else {
					if (p3.size()>0) {
						mem.free(p3.returnMemory());
					}
				}
			}
				mem.showFreeMemory();
				System.out.print("\n< Process 1 > ");
				p1.showProcessMemory();
				System.out.print("\n< Process 2 > ");
				p2.showProcessMemory();
				System.out.print("\n< Process 3 > ");
				p3.showProcessMemory();
		}
	}
}
