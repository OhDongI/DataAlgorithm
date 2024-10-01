//week4

import java.util.Stack;

public class Hanoi {

	public void hanoi(int n, int f, int t) {
	if(n==1) {
		System.out.println("moved from"+f+"to"+t);
		return;
	}
	else {
		hanoi(n-1,f,3-f-t);
		hanoi(1,f,t);
		hanoi(n-1,3-f-t,t);
	  }	
	}
	public void hanoiIter(int n, int f, int t) {
		Stack<Integer> s = new Stack<>();
		s.push(n); s.push(f); s.push(t);
		int num,from,to;
		
		while(!s.isEmpty()) {
			
		 to=s.pop();
		 from=s.pop();
		 num=s.pop();
		
	//	 System.out.println(num+""+f+""+t);
		 
		if(num==1)
			System.out.println("moved from"+f+"to"+t);
		else {
			s.push(num-1);
			s.push(3-from-to);
			s.push(to);
						
			s.push(1); 
			s.push(from); 
			s.push(to);
			
			s.push(num-1); 
			s.push(from); 
			s.push(3-from-to);
		}
	}
}
	public static void main(String[] args) {
		Hanoi h = new Hanoi();

		h.hanoi(3,0,1);
		
		h.hanoiIter(3,0,1);
	}

}
