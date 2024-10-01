package week6;

public class MyData {
	int value;
	String name;
	
	public MyData(int v) {
		// TODO Auto-generated constructor stub
		value = v;
	}
	
	public String toString() {
		return ""+value+"";
	}
	
	@Override
	public boolean equals(Object that) {
	  return(this.value ==((MyData)that).value);
		
	}
}
