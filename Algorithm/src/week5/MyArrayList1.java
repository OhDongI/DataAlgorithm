package week5;
import java.util.ArrayList;
import java.util.List;

public class MyArrayList1 {

    int maxSize = 20;
    int[] array = new int[maxSize];
    int nOfItems = 0;

    public void add(int data) {  // add last
        if (nOfItems >= maxSize) {
            grow();
        }

        array[nOfItems++] = data;
    }

    private void grow() {
        int[] newArray = new int[maxSize * 2];
        for (int i = 0; i < nOfItems; i++)
            newArray[i] = array[i];
        array = newArray;
        maxSize *= 2;
    }

    public void add(int index, int data) {
        if (nOfItems >= maxSize) {
            grow();
        }

        if (index < 0 || index > nOfItems) {
            System.out.println("Invalid Index !");
            return;
        }

        for (int i = nOfItems - 1; i >= index; i--)
            array[i + 1] = array[i];

        array[index] = data;
        nOfItems++;
    }

    public int removeIndex(int index) { // return value
        if (index < 0 || index >= nOfItems) {
            System.out.println("Invalid Index !");
            return -1;
        }

        int removedItem = array[index];
        for (int i = index; i < nOfItems - 1; i++)
            array[i] = array[i + 1];
        nOfItems--;
        return removedItem;
    }

    public int removeData(int data) { // return index
        int index = indexOf(data);
        if (index != -1) {
            removeIndex(index);
        }
        return index;
    }

    public int get(int index) { // return value
        if (index < 0 || index >= nOfItems) {
            System.out.println("Invalid Index !");
            return -1;
        }
        return array[index];
    }

    public void set(int index, int data) {
        if (index < 0 || index >= nOfItems) {
            System.out.println("Invalid Index !");
            return;
        }
        array[index] = data;
    }

    public int indexOf(int data) {  // return index, if not found, return -1
        for (int i = 0; i < nOfItems; i++) {
            if (array[i] == data)
                return i;
        }
        return -1;
    }

    public int size() {
        return nOfItems;
    }

    public void showArray() {
        for (int i = 0; i < nOfItems; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] data = {113, 336, 74, 71, 86, 176, 313, 80, 225, 342,
                170, 292, 275, 266, 79, 16, 109, 175, 245, 156,
                50, 61, 277, 167, 81, 24, 76, 186, 78, 101,
                301, 62, 152, 219, 294};

        MyArrayList1 al = new MyArrayList1();

        for (int i = 0; i < 10; i++)
            al.add(data[i]);
        al.showArray();

        al.add(5, 100);
        al.showArray();

        System.out.println(al.indexOf(100));

        // Add codes for testing each methods !
    }

}
