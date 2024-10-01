package midExam;



public class MyQueue {
	class Node{
		int level, id ;
		Node next;
		
		Node(int l, int i){
			level=l;
			id=i;
			next=null;
		}
		
		public String toString() {
			return ""+id+"["+level+"]";
		}
	}
	
	Node front, rear;
	MyQueue(){
		front=null;
		rear=null;
	}
	
	public void enqueue(int id) { //default 999
// Q 2-1) HERE !
	    Node newNode = new Node(999, id);
	    if (rear == null) {
	        front = newNode;
	        rear = newNode;
	    } else {
	        rear.next = newNode;
	        rear = newNode;
	    }
	}
	
	
	public void enqueue(int lev, int id) {//id 들고 오면 레벨 찾아주기
// Q 2-2) HERE !
		   Node newNode = new Node(lev, id);
		    if (front == null || front.level > lev) {
		        newNode.next = front;
		        front = newNode;
		        if (rear == null) {
		            rear = newNode;
		        }
		    } else {
		        Node current = front;
		        while (current.next != null && current.next.level <= lev) {
		            current = current.next;
		        }
		        newNode.next = current.next;
		        current.next = newNode;
		        if (current == rear) {
		            rear = newNode;
		        }
		    }
		}
	
	public int dequeue() {
	
// Q 2-3) HERE !
	    if (front == null) {
	        System.out.println("Queue is empty");
	        return -1;
	    }
	    int dequeuedId = front.id;
	    front = front.next;
	    if (front == null) {
	        rear = null;
	    }
	    return dequeuedId;
	}
	
	public int dequeue(int lev) {
		
// Q 2-4) HERE !
		  if (front == null) {
		        System.out.println("Queue is empty");
		        return -1;
		    }
		    if (front.level == lev) {
		        return dequeue();
		    }
		    Node current = front;
		    while (current.next != null && current.next.level != lev) {
		        current = current.next;
		    }
		    if (current.next == null) {
		        System.out.println("Level not found in the queue");
		        return -1;
		    } else {
		        int dequeuedId = current.next.id;
		        current.next = current.next.next;
		        if (current.next == null) {
		            rear = current;
		        }
		        return dequeuedId;
		    }
		}
		
		
		
		

	
	public void showQ() {
		System.out.print("\n>>> Queue Status  : -");
		Node temp = front;
		while (temp!=null) {
			System.out.print(" > "+temp.toString());
			temp=temp.next;
		}
	}

	public static void main(String[] args) {
		MyQueue q = new MyQueue();
		
		int[][] data = {{3,101},{2,102},{1,103},{2,104},{1,105},{3,106},
				{1,107},{2,108},{1,109},{3,110},{2,111},{1,112}
				};

		q.showQ();
		for (int i=0;i<6;i++) {
			q.enqueue(data[i][0], data[i][1]);
			System.out.print("\nAfter enqueue "+ data[i][0]+","+data[i][1]);
			q.showQ();
		}

		q.enqueue(113);
		q.enqueue(114);
		System.out.print("\nAfter enqueue(113), enqueue(114)" );
		q.showQ();

		System.out.print("\n\n >>> dequeued id (overall levels) = "+q.dequeue()); // returns id
		q.showQ();
		System.out.print("\n >>> dequeued id (level 3) = "+q.dequeue(3));
		q.showQ();
		System.out.print("\n >>> dequeued id (level 3) = "+q.dequeue(3));
		q.showQ();
		System.out.print("\n >>> dequeued id (level 2) = "+q.dequeue(2));
		q.showQ();
		System.out.print("\n >>> dequeued id (level 1) = "+q.dequeue(1));
		q.showQ();
		System.out.print("\n >>> dequeued id (non-level<=999) = "+q.dequeue(999));

	}
}

