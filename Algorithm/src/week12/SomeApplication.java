package week12;

import java.util.ArrayList;

public class SomeApplication {
	
	ArrayList<Integer> group = new ArrayList<>();
	ArrayList<BinarySearchTree> menmber = new ArrayList<>();
	
	public void insert(int gid,int mid) {
		int index;
		if(group.contains(gid){
			index = group.indexOf(gid);
		}
		else {
			group.add(gid);
			index = group.size()-1;
			member.add(new BinarySearchTree());
		}
		member.get(index).insert(mid);
		
		member.add(mid);
		
	}

	public static void main(String[] args) {
		SomeApplication sa = new SomeApplication();
		
		sa.insert(1,101);//groupID,pID
	}

}
