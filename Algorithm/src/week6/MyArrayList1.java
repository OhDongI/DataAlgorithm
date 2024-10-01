package week6;
public class MyArrayList1 {

	int maxSize;
	int [] array;
	int nOfItems;
	
	public MyArrayList1(int n) {
		maxSize=n;
		array = new int[maxSize];
		nOfItems =0;
		
	}
	public void add(int data) {  // add last
		if (nOfItems >=maxSize) {
			grow();
		}
		
		array[nOfItems++]=data;
	}
	
	private void grow() {
		int [] newArray = new int [maxSize*2];
		for (int i=0;i<nOfItems; i++)
			newArray[i]=array[i];
		array=newArray;
		maxSize *=2;
	
		System.out.println("Memory Doublu-up !");//Doublu?
		
	}

	public void add(int index, int data) {
		
		if (nOfItems >=maxSize) {
			grow();
		}
		
		if (!validIndex(index)) {
			System.out.println("Invalid Index !");
			return;
		}
		
		for (int i=nOfItems-1; i>=index; i--)
			array[i+1]=array[i];
		
		array[index] = data;
		nOfItems++;
		
	}
	private boolean validIndex(int index) {
		if(index <0 || index>=nOfItems)
		return false;
		else
			return true;
	}
	
	public int removeIndex(int index) { // return value
		if(validIndex(index)) {
			int temp = array[index];
			for(int i =index;i<nOfItems-1;i++)
				array[i] = array[i+1];
			nOfItems--;
			return temp;
		}
		else
		return -9999 ; // let it mean NULL
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
		for(int i=0;i<nOfItems;i++)
			if(array[i]==data)
				return i;
		return -1;  
	}
	
	public int size() {
		return nOfItems;
	}
	
	public void showArray() {
		int n =nOfItems;
		int nRow = 1+(int)n/10;
		for(int i=0;i<nRow; i++) {
			for(int j=i*10; j<Math.min(n,(i+1)*10); j ++)
				System.out.print(" "+array[j]);
			System.out.println();
		}}
	
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
//원래의 과제:각 method들을 test하는 코드를 추가

