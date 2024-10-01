package week6;

public class MyLinkedList0 {

	int capa;
	int [][] mPool;
	int nOfItems;
	int free, list;
	
	public MyLinkedList0(int n) {
		capa=n;
		mPool = new int[capa][2];
		nOfItems =0;
		free = 0;
		list = -1;
				
		for(int i=0; i<capa;i++)
			mPool[i][1] = i+1;
		mPool[capa-1][1]=-1;
	}
	public void add(int data) {  // add first
		if (free==-1){//memory Full!
			return;
		}
		if(list == -1) {
			list = free;
			free = mPool[free][1];
			mPool[list][0] =data;
			mPool[list][1] = -1;
		}
		else {
			int temp =list;
			list = free;
			free = mPool[free][1];
			mPool[list][0] =data;
			mPool[list][1] = temp;
		}
		nOfItems++;
		
	}
	

	private boolean validIndex(int index) {
		if(index <0 || index>=nOfItems)
		return false;
		else
			return true;
	}
	
	public int removeFirst() { // return value
		if(list ==-1)
			return -9999;
		else {
		 int temp =mPool[list][0];
		 
		 list = mPool[list][1];
		 // add deleted memory to free list
		 
		 nOfItems--;
		 return temp;		
		}
				
	}
	
	public int get(int index) { // return value
		if (validIndex(index)) {
			int temp = list;
			int i=0;
			while(i<index) {
				temp = mPool[temp][1];
				i++;
			}
			return mPool[temp][0];
		}
		else
			return -9999;
	}
	
	
//	  public boolean set(int index, int data) { 
//	 	if (validIndex(index)) {
//	  	array[index]=data; 
//	  	return true; }
//	 else return false; }
//	  
//	  public int indexOf(int data) { // return index, if not found, return -1
//	  for(int i=0;i<nOfItems;i++) 
//		  if(array[i]==data) 
//			  return i; 
//	  return -1;
//	 }
	 	
	public int size() {
		return nOfItems;
	}
	
	public void showArray() {
		int temp = list;
		while(temp !=-1) {
			System.out.print(" "+mPool[temp][0]);
			temp = mPool[temp][1];
		}	
			System.out.println();
		}
	
	public static void main(String[] args) {
		int [] data = {113,  336,  74,  71,  86,  176,  313,  80,  225,  342,
				  170,  292,  275,  266 , 79,  16,  109,  175 , 245,  156,
				  50,  61,  277,  167,  81,  24,  76,  186,  78,  101,
				  301,  62,  152,  219,  294};

		MyLinkedList0 al = new MyLinkedList0(35);
		
		System.out.println(">>> Test:add(data),grow()");
		for (int i=0; i<10; i++)
			al.add(data[i]);
		al.showArray();
		
		
//		 System.out.println(">>> Test:add(index,data)");
//		 al.add(5, 100); al.add(5,
//		 200); al.add(5, 300);
//		 al.add(al.size(),400);
//		 al.showArray();
//		  
//		  System.out.println(">>> Test:indexOf(data)");
//		  System.out.println(100+":"+al.indexOf(100));
//		  System.out.println(200+":"+al.indexOf(200));
//		  System.out.println(300+":"+al.indexOf(300));
//		 

		System.out.println(">>> Test: set(index,data),get(index)");		
		System.out.println("Before : "+al.get(3));		
//		al.set(3, 400); 
//		System.out.println("After : "+al.get(3));
		 
		System.out.println(">>> Test: removeFirst()");		
		System.out.println("Before : ");
		al.showArray();
		System.out.println("removeFirst : "+al.removeFirst());
		System.out.println("After : ");
		al.showArray();
		
//		System.out.println(">>> Test: removeIndex(index)");		
//		System.out.println("Before : ");
//		al.showArray();
//		System.out.println("removeIndex : "+al.removeIndex(3));
//		System.out.println("After : ");
//		al.showArray();
//		
//		System.out.println(">>> Test: removeData(data)");		
//		System.out.println("Before : ");
//		al.showArray();
//		System.out.println("removeData : "+al.removeData(100));
//		System.out.println("After : ");
//		al.showArray();

    }

}
