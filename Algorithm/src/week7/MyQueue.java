package week7;

import week7.MyLinkedList1.Node;

public class MyQueue extends MyLinkedList1 {

	Node front, rear;
	
	public MyQueue() {
		super();
		front = null;
		rear = null;
	}
	
	public void enqueue(int data) { 
		if (rear==null) {
			rear = new Node(data);
			front=rear; 
		}
		else {
			rear.next = new Node(data);
			rear=rear.next;
			nOfNodes++; 
		}
	}
	public int dequeue() {
		if (front==null)
			return -9999;
		else {
			int retVal = front.data;
			front=front.next;
			if (front==null)
				rear=front;
			return retVal;
		}
	}
	public void showQ() {
		System.out.print("\nQueue Status : ");
		head= front;
		showList();
		if (front==null)  // it means  rear==null at the same time
			System.out.println("Current front & rear  = null");
		else
			System.out.println("Current front = "+front.data+"   Current rear = "+rear.data);
	}
	
	public static void main(String[] args) {
		MyQueue q = new MyQueue();
		
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		
		q.showQ();
		
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());

		q.showQ();
		
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());

		q.showQ();
		
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		
		q.showQ();

	}

}

