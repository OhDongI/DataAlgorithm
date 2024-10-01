package week10; //더블 링크트 리스트로

public class MyScheduler <T extends Comparable<T>>{
	class Node {
//		int time;//타입이 속에 들어가 있음
//		String task;
		T aPlan;
		Node prev;
		Node next;
		
		Node(T p){
			aPlan = p;
			next = null;
		}
		
		public String toString() {
			return aPlan.toString();
		}
	}
	
	Node head,tail;
	
	
	public MyScheduler() {
		head = null;
		tail = null;
	}
	

	public void register(T p) {
		if (head==null) {
			head = new Node(p);
			tail=head;
		}
		else {
			if (p.compareTo(head.aPlan)<0) {
				Node newNode =new Node(p);
				newNode.next = head;
				head.prev = newNode;
				head= newNode;
			}
			else {
				Node temp;
				temp=head.next;
				while(temp!=null &&  p.compareTo(temp.aPlan)>0) {		
				temp=temp.next;
				}				
				Node newNode = new Node(p);
				if(temp!=null) {
					newNode.next = temp;
					newNode.prev=temp.prev;
					temp.prev.next=newNode;
					temp.prev= newNode;
			}
				else { 
					tail.next=newNode;
					newNode.prev=tail;
					tail = newNode;
				}
			
		}
	 }
	}
	public void done(T p) {
	    Node current = head;
	    while (current != null) {
	        if (current.aPlan.equals(p)) {
	            if (current.prev == null) {
	                head = current.next;
	                if (head != null) {
	                    head.prev = null;
	                } else {
	                    tail = null;
	                }
	            } else {
	                current.prev.next = current.next;
	                if (current.next != null) {
	                    current.next.prev = current.prev;
	                } else {
	                    tail = current.prev;
	                }
	            }
	            break;
	        }
	        current = current.next;
	    }
	}
	
//	public void showSchedule() {
//		Node temp = head;
//		while (temp !=null) {
//			System.out.println(temp.toString());
//			temp=temp.next;
//		}
//		System.out.println(nOfTasks());
//	}
	
	public void showSchedule() {//리컬전 연습
		System.out.println();
		showSchedule(head);
	}
	
	private void showSchedule(Node p) {
		if(p!=null) {
			System.out.println(p.toString());
			showSchedule(p.next);			
		}
	}
	
//	public int nOfTasks() {
//		Node temp = head;
//		int count =0;
//		while (temp !=null) {
//			count++;
//			temp=temp.next;
//		}
//		return count;
//	}
	public int nOfTasks()	{//리컬전 연습
		return nOfTasks(head);
	}
	
	private int nOfTasks(Node p) {
		if(p==null)
			return 0;
		else return 1+nOfTasks(p.next);
	}
		
	
	

	public static void main(String[] args) {

		MyScheduler<Plan> ms = new MyScheduler<>();
		
		ms.showSchedule();
		ms.register(new Plan(10, "Seminar"));
		ms.register(new Plan(19, "Party"));
		ms.register(new Plan(7, "Swimming"));
		ms.showSchedule();
		ms.register(new Plan(9, "Tea Meeting"));
		ms.register(new Plan(13, "Lunch"));
		ms.done(new Plan(7, "Swimming"));
		ms.showSchedule();
		ms.done(new Plan(9, "Tea Meeting"));
		ms.register(new Plan(17, "Tennis"));
		ms.showSchedule();
		ms.done(new Plan(9, "Seminar"));
		ms.showSchedule();
		ms.done(new Plan(10, "Seminar"));
		ms.showSchedule();

	
		
	}

}

