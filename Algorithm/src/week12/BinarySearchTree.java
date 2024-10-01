package week12;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinarySearchTree {

	class Node {
		int key;
		Node left, right, parent;
		
		Node(int d){
			key = d;
			left=null;
			right=null;
			parent=null;
		}
		
		public String toString() {
			return ""+key+" ";
		}
	}
	
	Node root;
	
	public BinarySearchTree() {
		root=null;
	}
	
	public void insert(int d) {
		if (root==null) {
			root = new Node(d);
		}
		else {
			if(d<root.key) {
				if(root.left==null) {
					root.left =new Node(d);
					root.left.parent = root;
				}
				else {
					insert(root.left,d);
				}
			}
			else {
				if(root.right==null) {
				   root.right = new Node(d);
				   root.right.parent=root;
				}
				else {			
					insert(root, d)
		}	
			
		
	
	private void insert(Node node, int d) {
		if(d<root.key) {
			if(node.left==null) {
				node.left =new Node(d);
				node.left.parent = node;
			}
			else {
				insert(node.left,d);
			}
		}
		else {
			if(node.right==null) {
			   node.right = new Node(d);
			   node.right.parent=root;
			}
			else {			
				insert(node, d);
	}	
		}
	}
	
	
	public void showTree() {
		System.out.println();
		showTree(root);
		System.out.println();

	}

	private void showTree(Node p) {
//		if (p!=null) {
//			showTree(p.left);
//			System.out.print(p.key);
//			showTree(p.right);
//		}
		levelOrder(root);		
	}
	
	private void levelOrder(Node node) {
		Deque<Node> queue = new ArrayDeque<>();
		queue.add(node);
		
		while(!queue.isEmpty()) {
			Node p = queue.removeFirst();
			System.out.print(p.toString());
			if(p.left!=null)queue.add(p.left);
			if(p.right!=null)queue.add(p.right);
			
		}
		
	}

	public boolean search(int d) {
		return search(root, d);
	}

	private boolean search(Node node, int d) {
		if (node==null)
			return false;
		if (node.key==d)
	return true;
		if (d<node.key)
			return search(node.left, d);
		else
			return search(node.right, d);
	}
	
	private Node searchNode(Node node, int d) {
		
		while(node!=null&&node.key!=d) {
			if(d<node.key)
				node = node.left;
			else
				node=node.right;
	}
		return node;
	}

	public void delete(int d) {
		Node node = searchNode(root, d);
		if (node != null) {   //  <----  ADDED !
			if (root==node)
				root = deleteNode(root);
			else {
				if (node.key<node.parent.key)
					node.parent.left = deleteNode(node);
				else
					node.parent.right = deleteNode(node);
			}
		}
	}

	private Node deleteNode(Node node) {
		// case 1 : no child
		if (node.left==null && node.right==null)
			return null;
		
		// case 2 : 1 child
		else if (node.left==null && node.right!=null) {
			node.right.parent = node.parent;
			return node.right;
		}
		else if (node.left!=null && node.right==null) {
			node.left.parent = node.parent;
			return node.left;
		}
		
		// case 3 : 2 children
		else {
			Node s = node.right;
			while (s.left!=null)
				s=s.left;
			// now, s = successor !
			node.key = s.key;
			// now, let's delete successor !
			if (s==node.right) {
				node.right = s.right;
				if ( s.right!=null)
					s.right.parent = node;
			}
			else {
				s.parent.left = s.right;
				if ( s.right!=null)
					s.right.parent = s.parent;
			}
			return node;
		}	
	}

	public static void main(String[] args) {
		int [] keys = {4,7,5,1,0,3,9,2,6,8};
		

		BinarySearchTree t = new BinarySearchTree();
		
		for (int i=0; i<keys.length;i++) {
			t.insert(keys[i]);
			t.showTree();
		}
		
		
		System.out.println(t.search(3));
		System.out.println(t.search(11));
		
		t.delete(3);
		System.out.println("\nAfter delete 3 (case2 : only left child)");
		t.showTree();
		t.delete(4);
		System.out.println("\nAfter delete 4 (case3) ");
		t.showTree();
		t.delete(2);
		System.out.println("\nAfter delete 2 (case1 : right end) :");
		t.showTree();
		t.delete(10);
		System.out.println("\nAfter delete 10 (Not Found) :");
		t.showTree();

	}

}

