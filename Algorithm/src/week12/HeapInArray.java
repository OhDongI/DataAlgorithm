package week12;

import java.util.ArrayList;

public class HeapInArray {
    
    ArrayList<Character> heap = new ArrayList<>();
    
    public HeapInArray() {
        heap.add(null); // 힙은 1번 인덱스부터 시작하도록 설정
    }

    public void insert(char ch) {
        int lastIndex = heap.size();
        heap.add(ch); // 요소를 힙의 마지막에 추가
        fixUpward(lastIndex);
    }
    
    private void fixUpward(int index) {
        int pIndex = index / 2;
        if (pIndex > 0 && heap.get(index) > heap.get(pIndex)) {
            swap(index, pIndex);
            fixUpward(pIndex);
        }
    }

    private void swap(int i, int j) {
        char temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    
    public void showHeap() {
        System.out.println(heap);        
    }

    public Character delete() {
        if (heap.size() <= 1)
            return null;
        
        char retVal = heap.get(1);
        
        if (heap.size() == 2)
            heap.remove(1); // 1번 인덱스를 제거
        else {
            heap.set(1, heap.remove(heap.size() - 1));
            fixDownward(1);
        }
        
        return retVal;
    }

    private void fixDownward(int i) {
        int bigger = 2 * i;
        
        if (bigger >= heap.size())
            return;
        
        if ((bigger + 1) < heap.size() && heap.get(bigger) < heap.get(bigger + 1))
            bigger++;
        
        if (heap.get(i) < heap.get(bigger)) {
            swap(i, bigger);
            fixDownward(bigger);
        }
    }

    public static void main(String[] args) {
        HeapInArray heap = new HeapInArray();
        
        for (int i = 0; i < 26; i++) {
            heap.insert((char)('A' + i));
            heap.showHeap();
        }
        
        for (int i = 0; i < 26; i++) {
            System.out.println(heap.delete());
        }
    }
}



