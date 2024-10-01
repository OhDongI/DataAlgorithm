//week2
package week2;

public class Search {
	
	public int seq1(int[]input, int val) { //value
		for (int i=0;i<input.length;i++) {
			if(input[1]==val)
				return i;
		}
		return -1;
	}			
			public int seq2(int[]input, int val) {
				int index=0;
				while(input[index]<=val) {
					if(input[index]==val)
						return index;
					else
					index++;
					
				}
				return -1;
			}
			
	public int binSR(int[]input, int val, int s, int e) {//s=start
		if(s>e)
		
			return -1;
		int mid = (s+e)/2;
		
		if(input[mid]==val)
			return mid;
		else if(input[mid]>val)
			return binSR(input, val, s,mid-1);
			else 
				return binSR(input,val,mid+1,e);	
		
	}
	
	public static void main(String[]args) {
	 int[]rdata= {10,40,20,15,50,25};
	 int[]sdata= {10,15,20,25,40,50};

	 Search s =new Search();
	
	 System.out.println(s.seq1(rdata, 25));
	 System.out.println(s.binSR(rdata, 25,0,sdata.length-1));
 
	}
	}
