package week7;

import week6.MyArrayList1;

public class MyLinkedList1 {
	class Node{
		int data;
		Node next;
	
		public Node(int d) {
			data = d;
			next = null;
	}
	
	public String toString() {
		return ""+data;
	}
 }

	Node head;
	int nOfNodes ;
		
	public MyLinkedList1() {
		head = null;
		nOfNodes =0;
	}

	public void add(int data) {  // add last
		if (nOfNodes >=maxSize) {
			grow();
		}
		
		array[nOfNodes++]=data;
	}
		addFirst(data);
		}
		public void addFirst(int data) {
//			Node newNode = new Node(data);
//		
//			if(head == null)
//				head = newNode;
//			else {
//				newNode.next = head;
//				head =  newNode;

				Node temp = head;
				head = new Node(data);
				head.next = temp;
						
				nOfNodes++;
			}


	public void add(int index, int data) {
		if (!validIndex(index)) {
			System.out.println("Invalid Index !");
			return;
		}
		if(index==0) {
			addFirst(data);
		}
		else {
			Node newNode = new Node (data);
			Node p = head;
			for (int i=0; i<index-1; i++)
				p=p.next;
			newNode.next=p.next;
			p.next=newNode;

			nOfNodes++;
		}
	}
	private boolean validIndex(int index) {
		if(index <0 || index>=nOfNodes)
		return false;
		else
			return true;
	}
	
	public int removeFirst() {
	 if (head==null)
		 return -9999; 
	 int retV = head.data;
	 head = head.next;
	 nOfNodes--;
	 return retV;
		
	}
		
	public int removeIndex(int index) { // return value
		if(!validIndex(index)) {
			System.out.println("Invalid Index !");
			return -9999;
		}
		int retV;
		if(index==0)
			return removeFirst();
		else {
			Node p = head;
			for (int i=0; i<index-1; i++)
				p=p.next;
			retV=p.next.data;
			p.next = p.next.next;
			nOfNodes--;
			return retV;
			
		}
	}
	
	public   int   removeData(int data) { // return index
		int index = indexOf(data);
		removeIndex(index);
		return index; 
	}

	public int get(int index) { // return value
		if (validIndex(index))
			return array[index];
		else
			return -9999;
	}
	
	public boolean set(int index, int data) {
		if (validIndex(index)) {
			array[index]=data;
		return true;
	}
		else
			return false;	
	}
	
	public int indexOf(int data) {  // return index, if not found, return -1
		Node p = head;
		for(int i=0;i<nOfNodes;i++)
			if(p.data==data)
				return i;
		p=p.next;
	
		return -1;
	}
	
	public int size() {
		return nOfNodes;
	}
	
	public void showList() {
	 System.out.println();
	 Node p = head;
	 while (p!=null) {
		 System.out.println("v->"+p.data);
		 p=p.next;
	 }
	 System.out.println();
	 
}
	
	public static void main(String[] args) {
		int [] data = {113,  336,  74,  71,  86,  176,  313,  80,  225,  342,
				  170,  292,  275,  266 , 79,  16,  109,  175 , 245,  156,
				  50,  61,  277,  167,  81,  24,  76,  186,  78,  101,
				  301,  62,  152,  219,  294};

		MyArrayList1 al = new MyArrayList1(2);
		
		System.out.println(">>> Test:add(data),grow()");
		for (int i=0; i<10; i++)
			al.add(data[i]);
		al.showArray();
		
		System.out.println(">>> Test:add(index,data)");
		al.add(5, 100);
		al.add(5, 200);
		al.add(5, 300);
		al.add(al.size(),400);		
		al.showArray();
		
		System.out.println(">>> Test:indexOf(data)");		
		System.out.println(100+":"+al.indexOf(100));
		System.out.println(200+":"+al.indexOf(200));
		System.out.println(300+":"+al.indexOf(300));

		System.out.println(">>> Test: set(index,data),get(index)");		
		System.out.println("Before : "+al.get(3));
		al.set(3, 400);
		System.out.println("After : "+al.get(3));

		System.out.println(">>> Test: removeIndex(index)");		
		System.out.println("Before : ");
		al.showArray();
		System.out.println("removeIndex : "+al.removeIndex(3));
		System.out.println("After : ");
		al.showArray();
		
		System.out.println(">>> Test: removeData(data)");		
		System.out.println("Before : ");
		al.showArray();
		System.out.println("removeData : "+al.removeData(100));
		System.out.println("After : ");
		al.showArray();

    }

}
}
