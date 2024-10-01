package week7;

import java.util.HashSet;
import java.util.Set;

public class MemoryManager {
	
	int maxSize, freeSize;
	Slot memory;
	public MemoryManager(int n) {
		maxSize = n;
		freeSize = n;
		initMemory(maxSize);
	}
	private void initMemory(int n) {
		memory = new Slot();
		memory.next = null;
		
		for(int i=0;i<maxSize-1;i++) {
			Slot newS = new Slot();
			newS.next = memory;
			memory = newS;
		
		}
	
	}
	
	public Slot myNew() { //기본적인 new
		if (memory==null) // no more free memory
			return null;
		else {
			Slot temp=  memory;
			memory = memory.next;
			freeSize--;
			return temp;
		}
	}
	
	public void myDelete(Slot s) { //기본적인 delete
		if (s!=null) {
			s.next =  memory;
			memory = s;
			freeSize++;
		}

		
		
		
	}
	
	public int freeSlot() {
		return freeSize;
	}
	
	public static void main(String[] args) {
		MemoryManager mgr = new MemoryManager(5);
		
		Slot m1= mgr.myNew();
		m1.mem=10;
		System.out.println("\nInteger : "+m1.mem);
		System.out.println("Current # of FreeSlot = "+mgr.freeSlot());

		Slot m2= mgr.myNew();
		m2.mem="MyungJi Univ";
		System.out.println("\nString : "+m2.mem);
		System.out.println("Current # of FreeSlot = "+mgr.freeSlot());
		
		mgr.myDelete(m1); 
		System.out.println("\nA Slot deleted ");
		System.out.println("Current # of FreeSlot = "+mgr.freeSlot());
		
		Slot m3= mgr.myNew();
		m3.mem=true;
		System.out.println("\nBoolean : "+m3.mem);
		System.out.println("Current # of FreeSlot = "+mgr.freeSlot());

		Slot m4= mgr.myNew();
		Set<Integer> d = new HashSet<>();
		d.add(1);
		d.add(2);
		d.add(3);
		d.add(4);
		m4.mem= d;
		System.out.println("\nSet : "+m4.mem);
		System.out.println("Current # of FreeSlot = "+mgr.freeSlot());
		
		mgr.myDelete(m4); 
		System.out.println("\nA Slot deleted ");
		System.out.println("Current # of FreeSlot = "+mgr.freeSlot());
		
		m4 = mgr.myNew();
		m4.mem= new MyData(101, "Superman");
		System.out.println("\nUse-defined Type : "+m4.mem);
		System.out.println("Current # of FreeSlot = "+mgr.freeSlot());

		System.out.println("\nInsert 3 Slots ");
		Slot m5= mgr.myNew();
		System.out.println(m5);

		Slot m6= mgr.myNew();
		System.out.println(m6);
		
		Slot m7= mgr.myNew();
		System.out.println(m7);
		System.out.println("Current # of FreeSlot = "+mgr.freeSlot());

		System.out.println("\nDelete 3 Slots ");

		mgr.myDelete(m5); 
		mgr.myDelete(m6); 
		mgr.myDelete(m7); 
		System.out.println("Current # of FreeSlot = "+mgr.freeSlot());

	}
	
	static class Slot {
		Object mem = new Object();
		Slot next;
		
		public String toString() {
			return mem.toString();
		}
	}
	
	
	
}


