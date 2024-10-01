package week9;

public class MyLinkedList2 {
    class Node {
        int data;
        Node prev;
        Node next;

        public Node(int d) {
            data = d;
            next = null;
            prev = null;
        }

        public String toString() {
            return "" + data;
        }
    }

    Node head;
    Node tail;
    int nOfNodes;

    public MyLinkedList2() {
        head = null;
        tail = null;
    }

    public void add(int data) {  // add last
        addLast(data);
    }

    public void addFirst(int data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
        } else {
            Node newNode = new Node(data);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addLast(int data) {
        if (tail == null) {
            tail = new Node(data);
            head = tail;
        } else {
            Node newNode = new Node(data);
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void add(int index, int data) {
        if (!validIndex(index)) {
            System.out.println("Invalid Index !");
            return;
        }
        if (index == 0) {
            addFirst(data);
        } else if (index == nOfNodes()) {
            addLast(data);
        } else {
            Node newNode = new Node(data);
            Node p = head;
            for (int i = 0; i < index - 1; i++)
                p = p.next;
            newNode.next = p.next;
            p.next.prev = newNode;
            p.next = newNode;
            newNode.prev = p;
        }
    }

    private boolean validIndex(int index) {
        return index >= 0 && index <= nOfNodes();
    }

    private int nOfNodes() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public int removeFirst() {
        if (head == null)
            return -9999;
        else {
            int retV = head.data;
            head = head.next;
            if (head == null)
                tail = null;
            else
                head.prev = null;
            return retV;
        }
    }

    public int removeLast() {
        if (tail == null)
            return -9999;
        else {
            int retV = tail.data;
            tail = tail.prev;
            if (tail == null)
                head = null;
            else
                tail.next = null;
            return retV;
        }
    }

    public int removeIndex(int index) { // return value
        if (!validIndex(index)) {
            System.out.println("Invalid Index !");
            return -9999;
        }
        if (index == 0)
            return removeFirst();
        else if (index == nOfNodes() - 1)
            return removeLast();
        else {
            Node temp = head;
            for (int i = 0; i < index; i++)
                temp = temp.next;
            int retV = temp.data;
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
            return retV;
        }
    }

    public int removeData(int d) { // return index
        if (head == null)
            return -9999;
        else {
            if (head.data == d)
                return removeFirst();
            else if (tail.data == d)
                return removeLast();
            else {
                Node temp = head;
                while (temp != null && temp.data != d)
                    temp = temp.next;
                if (temp == null)
                    return -9999;
                else {
                    int retV = temp.data;
                    temp.next.prev = temp.prev;
                    temp.prev.next = temp.next;
                    return retV;
                }
            }
        }
    }

    public int get(int index) { // return value
        if (!validIndex(index)) {
            System.out.println("Invalid Index !");
            return -9999;
        }
        Node p = head;
        for (int i = 0; i < index; i++)
            p = p.next;
        return p.data;
    }

    public boolean set(int index, int data) {
        if (!validIndex(index)) {
            System.out.println
            ("Invalid Index !");
            return false;
        }
        Node p = head;
        for (int i = 0; i < index; i++)
            p = p.next;
        p.data = data;
        return true;
    }

    public int size() {
        return nOfNodes();
    }

    public void showList() {
        System.out.println();
        Node p = head;
        while (p != null) {
            System.out.println("v->" + p.data);
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] data = {113, 336, 74, 71, 86, 176, 313, 80, 225, 342,
                170, 292, 275, 266, 79, 16, 109, 175, 245, 156,
                50, 61, 277, 167, 81, 24, 76, 186, 78, 101,
                301, 62, 152, 219, 294};

        MyLinkedList2 ll = new MyLinkedList2();

        System.out.println(">>> Test: add(data)");
        for (int i = 0; i < 10; i++)
            ll.add(data[i]);
        ll.showList();

        System.out.println(">>> Test: add(index, data)");
        ll.add(5, 100);
        ll.add(5, 200);
        ll.add(5, 300);
        ll.add(ll.size(), 400);
        ll.showList();

        System.out.println(">>> Test: removeIndex(index)");
        System.out.println("Before : ");
        ll.showList();
        System.out.println("removeIndex : " + ll.removeIndex(3));
        System.out.println("After : ");
        ll.showList();

        System.out.println(">>> Test: removeData(data)");
        System.out.println("Before : ");
        ll.showList();
        System.out.println("removeData : " + ll.removeData(100));
        System.out.println("After : ");
        ll.showList();
    }
}

