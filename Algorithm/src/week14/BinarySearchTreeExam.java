package week14;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinarySearchTreeExam {

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
	
	public BinarySearchTreeExam() {
		root=null;
	}
	
	public void insert(int d) {
		if (root==null) {
			root = new Node(d);
		}
		else {
			insert(root, d, null);
		}	
	}

	private void insert(Node node, int d, Node parent) {
		if (node==null) { // insert here !
			Node newNode = new Node(d);
			if (d <parent.key) {
				parent.left = newNode;
				newNode.parent = parent;
			}
			else { //d >parent.key
				parent.right = newNode;
				newNode.parent = parent;
			}
		}
		else if (d <node.key) 
			insert(node.left, d, node);
		else // d > node.key
			insert(node.right, d, node);
	}
	private void insertIter( int d) {
	// 3-1) add your code...

		
		
		
		
		
		
	}
	
	public void showLevel() {
		System.out.print("\n=== Level-Order ===");

		Deque<Node> q = new ArrayDeque<Node>();
		if (root==null)
			return;
		q.add(root); // addLast
		int curLevel = -1;
		while(!q.isEmpty()) {
			Node node = q.removeFirst();
			if (curLevel<level(node)) {
				curLevel++;
				System.out.print("\nLevel "+curLevel+" : ");
			}
			System.out.print(node.key+" ");
			if (node.left!=null) q.add(node.left);
			if (node.right!=null) q.add(node.right);
		}
	}
	
	private int level(Node node) {
		if (node==root) return 0;
		else return 1+level(node.parent);
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
	
	private void rotateLeft(Node pp) {
		if (pp==root) {
			root = pp.right;
			pp.right.parent = null;
			pp.right.left = pp;
			pp.parent = pp.right;
			pp.right=null;
		}
		else {
			if (pp==pp.parent.left) {
				pp.parent.left =pp.right;
				pp.right.parent = pp.parent;
				pp.right.left = pp;
				pp.parent =pp.right;
				pp.right=null;
				
			}
			else {
				pp.parent.right =pp.right;
				pp.right.parent = pp.parent;
				pp.right.left = pp;
				pp.parent =pp.right;
				pp.right=null;
			}
		}
	
	}

	private void rotateRight(Node pp) {
	// 3-2) add your code...
		
		
		
		
		
		
		
	}
	
	private boolean isBalanced(Node node) {
		if (node==null)
			return true;
		else {
			return (Math.abs(height(node.left)-height(node.right))<2);
		}
	}
	private int height(Node node) {
		if (node==null)
			return 0;
		else 
			return 1+ Math.max(height(node.left), height(node.right));
	}

	public void insertWithRotate(int k) {
		if (root==null)
			root = new Node(k);
		else 
			insertWithRotate(root, k, root.parent);
	}

	private void insertWithRotate(Node node, int k, Node parent) {
	// 3-3) add your code...

		
		
		
		
		
		
		
		
		
		
		
		
	}

	public static void main(String[] args) {
		int [] keys = {5,4,3,2,1,0,6,7,8,9,10,11};
		
		BinarySearchTreeExam t = new BinarySearchTreeExam();

		System.out.println("\n\n<<< Normal Binary Search Tree >>>");
		for (int i=0; i<keys.length;i++) {
			t.insertIter(keys[i]);
			t.showLevel();
		}
		
		BinarySearchTreeExam tb = new BinarySearchTreeExam();
		System.out.println("\n\n\n<<< Partially-Balanced Binary Search Tree >>> ");
		for (int i=0; i<keys.length;i++) {
			tb.insertWithRotate(keys[i]);
			tb.showLevel();
		}
	}

	private void insertIter(int d) {
	    Node newNode = new Node(d);
	    if (root == null) {
	        root = newNode;
	        return;
	    }
	    Node current = root;
	    Node parent = null;
	    while (true) {
	        parent = current;
	        if (d < current.key) {
	            current = current.left;
	            if (current == null) {
	                parent.left = newNode;
	                newNode.parent = parent;
	                // 3-1) add your code...
	                balanceTree(parent);
	                return;
	            }
	        } else {
	            current = current.right;
	            if (current == null) {
	                parent.right = newNode;
	                newNode.parent = parent;
	                // 3-1) add your code...
	                balanceTree(parent);
	                return;
	            }
	        }
	    }
	}

	private void rotateRight(Node pp) {
	    if (pp == root) {
	        root = pp.left;
	        pp.left.parent = null;
	        pp.left.right = pp;
	        pp.parent = pp.left;
	        pp.left = null;
	    } else {
	        if (pp == pp.parent.left) {
	            pp.parent.left = pp.left;
	            pp.left.parent = pp.parent;
	            pp.left.right = pp;
	            pp.parent = pp.left;
	            pp.left = null;
	        } else {
	            pp.parent.right = pp.left;
	            pp.left.parent = pp.parent;
	            pp.left.right = pp;
	            pp.parent = pp.left;
	            pp.left = null;
	        }
	    }
	}

	private void insertWithRotate(Node node, int k, Node parent) {
	    if (node == null) { // insert here !
	        Node newNode = new Node(k);
	        if (k < parent.key) {
	            parent.left = newNode;
	            newNode.parent = parent;
	        } else { // k > parent.key
	            parent.right = newNode;
	            newNode.parent = parent;
	        }
	    } else if (k < node.key)
	        insertWithRotate(node.left, k, node);
	    else // k > node.key
	        insertWithRotate(node.right, k, node);
	    // 3-3) add your code...
	}

	
	
	
	balanceInsertion(newNode);을 사용하면 메소드를 추가해야하잖아. 츄가하지마 젭
	
다시 문제를 설명해줄게.
3-1) method insert(..)를 Iteration으로 바꾸어 insertIter(…)를 완성하시오. (15점)

3-2) method rotateRight(..)를 완성하시오. (10점) 

3-3) 다음 설명에 따라서, rotateLeft, rotateRight를 이용하여 극단적인 skewed tree가 되지 않도록 insert를 수행하는 method insertWithRotate(…)를 완성하시오. (30점)

극단적으로 skewed 되지 않도록, 최소한의 방법을 다음과 같이 추가하고자 한다.
새로 하나의 node가 insert된 후에 “새 node의 부모의 부모”를 기준으로 좌우 subtree의 높이 차이가 2 이상이 되면 balance가 깨진 것으로 판단하여 적절한 rotate를 수행함으로써 subtree의 높이 차이를 1로 만든다. ( boolean isBalanced(node) 제공)
다음의 4가지 경우가 발생하면 적절한 rotate를 수행한다. (참고 : 새로 삽입된 노드는 언제나 parent의 유일한 노드이다.)
type 1은 rotateRight(parent of parent)
type 2은 rotateLeft(parent of parent)
type 3은 rotateLeft(parent)->rotateRight(parent of parent
type 4은 rotateRight(parent)->rotateLeft(parent of parent)
조건과 문제야. 근데 메소드를 추가하지 못하고 오직 빈칸으로 두고 코드를 채워넣으라는 곳만 가능해. 


<<< Normal Binary Search Tree >>>

=== Level-Order ===
Level 0 : 5 
=== Level-Order ===
Level 0 : 5 
Level 1 : 4 
=== Level-Order ===
Level 0 : 5 
Level 1 : 4 
Level 2 : 3 
(생략)

=== Level-Order ===
Level 0 : 5 
Level 1 : 4 6 
Level 2 : 3 7 
Level 3 : 2 8
Level 4 : 1 9
Level 5 : 0 10
Level 6 : 11
(생략)

<<< Partially-Balanced Binary Search Tree >>> 

=== Level-Order ===
Level 0 : 5 
=== Level-Order ===
Level 0 : 5 
Level 1 : 4 
>>>Rotate:type 1 with inserting 3
=== Level-Order ===
Level 0 : 4 
Level 1 : 3 5 
(생략)
=== Level-Order ===
Level 0 : 4 
Level 1 : 2 6 
Level 2 : 1 3 5 8
Level 3 : 0 7 10 
Level 4 : 9 10 








private void insertIter(int d) {
	Node newNode = new Node(d);
	if (root == null) {
		root = newNode;
		return;
	}
	Node current = root;
	Node parent = null;
	while (true) {
		parent = current;
		if (d < current.key) {
			current = current.left;
			if (current == null) {
				parent.left = newNode;
				newNode.parent = parent;
				// 3-1) add your code...
				balanceTree(parent);
				return;
			}
		} else {
			current = current.right;
			if (current == null) {
				parent.right = newNode;
				newNode.parent = parent;
				// 3-1) add your code...
				balanceTree(parent);
				return;
			}
		}
	}
}

private void rotateRight(Node pp) {
	if (pp == root) {
		root = pp.left;
		pp.left.parent = null;
		pp.left.right = pp;
		pp.parent = pp.left;
		pp.left = null;
	} else {
		if (pp == pp.parent.left) {
			pp.parent.left = pp.left;
			pp.left.parent = pp.parent;
			pp.left.right = pp;
			pp.parent = pp.left;
			pp.left = null;
		} else {
			pp.parent.right = pp.left;
			pp.left.parent = pp.parent;
			pp.left.right = pp;
			pp.parent = pp.left;
			pp.left = null;
		}
	}
}

private void insertWithRotate(Node node, int k, Node parent) {
	if (node == null) { // insert here !
		Node newNode = new Node(k);
		if (k < parent.key) {
			parent.left = newNode;
			newNode.parent = parent;
		} else { // k > parent.key
			parent.right = newNode;
			newNode.parent = parent;
		}
	} else if (k < node.key)
		insertWithRotate(node.left, k, node);
	else // k > node.key
		insertWithRotate(node.right, k, node);
	// 3-3) add your code...
	balanceTree(parent); // Adjust balance after insertion
}
