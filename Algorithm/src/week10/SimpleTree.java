package week10;

public class SimpleTree {

	class Node {
		char data;
		Node left;
		Node right;
		
		Node(char c){
			data = c;
			left = null;
			right = null;
		}
		
		public String toString() {
			return ""+data;			
		}
	}
	
	Node root;
	
	SimpleTree(){
		root = null;		
	}
	
	public Node makeTree(char c) {
		root = new Node(c);
		return root;
	}
	
	public Node makeTree(SimpleTree leftSubTree,char c, SimpleTree rightSubTree) {
		root = new Node(c);
		root.left = leftSubTree.root;
		root.right = rightSubTree.root;
		return root;
	}
	
	public void showTree() {
		showTree(root);
	}
	
		public void showTree(Node p) {
		if(p!=null) {
		showTree(p.left);
		System.out.print(p.toString());
		showTree(p.right);
		}
	}
	
	public static void main(String[] args) {
		//a*b-c/d
		SimpleTree t1 = new SimpleTree();
		t1.makeTree('a');
		SimpleTree t2 = new SimpleTree();
		t2.makeTree('b');
		SimpleTree t3 = new SimpleTree();
		t3.makeTree('c');
		SimpleTree t4 = new SimpleTree();
		t4.makeTree('d');
		
		
		SimpleTree t5 = new SimpleTree();
		t5.makeTree(t1,'*',t2);
		SimpleTree t6 = new SimpleTree();
		t6.makeTree(t3,'/',t4);
		SimpleTree t7 = new SimpleTree();
		t7.makeTree(t5,'-',t6);
		
		t7.showTree();
		
		
		
		
	}

}
