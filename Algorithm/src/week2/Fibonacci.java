//week2
package week2;

public class Fibonacci {

	public int fiboRec(int n) {
		if(n<=2)
			return 1;
		else
			return fiboRec(n-1)+fiboRec(n-2);
	}

	
	public int fiboIter(int n) {
		
		int[] val = new int [n+1];
		val[0]=0; val[1]=1;
		
		for(int i=2; i<=n;i++) {
			val[i]=val[i-1]+val[i-2];
		}
		return val[n];
			
	}
	public static void main (String[]args) {
		Fibonacci f = new Fibonacci();
		System.out.println("Iter-Answer="+f.fiboIter(30));
		System.out.println("Rec-Answer="+f.fiboIter(30));
		
	}
}
