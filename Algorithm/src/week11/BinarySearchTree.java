package week11;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    class Node {
        int key;
        Node left, right, parent;

        Node(int d) {
            key = d;
            left = null;
            right = null;
            parent = null;
        }

        public String toString() {
            return "" + key;
        }
    }

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int d) {
        if (root == null) {
            root = new Node(d);
        } else {
            insert(root, d, null);
        }
    }

    private void insert(Node node, int d, Node parent) {
        if (node == null) {
            Node newNode = new Node(d);
            if (d < parent.key) {
                parent.left = newNode;
                newNode.parent = parent;
            } else {
                parent.right = newNode;
                newNode.parent = parent;
            }
        } else if (d < node.key) {
            insert(node.left, d, node);
        } else {
            insert(node.right, d, node);
        }
    }

    public void showTree() {
        System.out.println();
        showTree(root);
        System.out.println();
    }

    private void showTree(Node p) {
        if (p != null) {
            showTree(p.left);
            System.out.print(p.key + " ");
            showTree(p.right);
        }
    }

    public boolean search(int d) {
        return search(root, d);
    }

    private boolean search(Node node, int d) {
        if (node == null)
            return false;
        if (node.key == d)
            return true;
        if (d < node.key)
            return search(node.left, d);
        else
            return search(node.right, d);
    }

    private Node searchNode(Node node, int d) {
        if (node == null)
            return null;
        if (node.key == d)
            return node;
        if (d < node.key)
            return searchNode(node.left, d);
        else
            return searchNode(node.right, d);
    }

    public void delete(int d) {
        Node node = searchNode(root, d);

        if (node == null) {
            return; // 삭제할 노드가 없는 경우
        }

        if (node.parent == null) {
            root = deleteNode(node);
        } else {
            if (node == node.parent.left) {
                node.parent.left = deleteNode(node);
            } else {
                node.parent.right = deleteNode(node);
            }
        }
    }

    private Node deleteNode(Node node) {
        // case 1: no child
        if (node.left == null && node.right == null) {
            return null;
        }

        // case 2: one child
        else if (node.left == null) {
            node.right.parent = node.parent;
            return node.right;
        } else if (node.right == null) {
            node.left.parent = node.parent;
            return node.left;
        }

        // case 3: two children
        else {
            Node s = node.right;
            while (s.left != null)
                s = s.left;
            // now, s is successor
            node.key = s.key;
            // now, delete successor
            if (s.parent != node) {
                s.parent.left = s.right;
                if (s.right != null) {
                    s.right.parent = s.parent;
                }
            } else {
                node.right = s.right;
                if (s.right != null) {
                    s.right.parent = node;
                }
            }
            return node;
        }
    }

    public void levelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.key + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] keys = { 4, 7, 5, 1, 0, 3, 9, 2, 6, 8 };

        BinarySearchTree t = new BinarySearchTree();

        for (int i = 0; i < keys.length; i++)
            t.insert(keys[i]);

        t.showTree();
        t.levelOrder();

        System.out.println(t.search(3));
        System.out.println(t.search(11));

        t.delete(3);
        t.showTree();
        t.levelOrder();
        
        t.delete(4);
        t.showTree();
        t.levelOrder();
    }
}



