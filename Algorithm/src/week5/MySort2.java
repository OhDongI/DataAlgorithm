package week5;

public class MySort2 {

    public int[] selectionSort(int[] data) {
        int n = data.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++)
                if (data[i] > data[j])
                    data = swap(data, i, j);
        }
        return data;
    }

    public int[] bubbleSort(int[] data) {
        int n = data.length;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++)
                if (data[j] > data[j + 1])
                    data = swap(data, j, j + 1);
        }
        return data;
    }

    public int[] quickSort(int[] data) {
        quickSort(data, 0, data.length - 1);
        return data;
    }

    private void quickSort(int[] data, int p, int r) {
        if (p < r) {
            int q = partition(data, p, r);
            quickSort(data, p, q - 1);
            quickSort(data, q + 1, r);
        }
    }

    private int partition(int[] data, int p, int r) {
        int pivot = data[r];
        int i = p - 1;

        for (int j = p; j < r; j++) {
            if (data[j] <= pivot) {
                i++;
                swap(data, i, j);
            }
        }
        swap(data, i + 1, r);
        return i + 1;
    }

    public void mergeSort(int[] data) {
        mergeSort(data, 0, data.length - 1);
    }

    private void mergeSort(int[] data, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(data, p, q);
            mergeSort(data, q + 1, r);
            merge(data, p, q, r);
        }
    }

    private void merge(int[] data, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = data[p + i];
        for (int j = 0; j < n2; j++)
            R[j] = data[q + 1 + j];

        int i = 0, j = 0;
        int k = p;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                data[k] = L[i];
                i++;
            } else {
                data[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            data[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            data[k] = R[j];
            j++;
            k++;
        }
    }

    public int[] insertionSort(int[] data) {
        int dataSize = data.length;
        if (dataSize > 1) {
            for (int i = 1; i < dataSize; i++) {
                int j = 0;
                while (data[i] > data[j] && j < i) {
                    j++;
                }
                if (j < i) {
                    int temp = data[i];
                    for (int k = i - 1; k >= j; k--) {
                        data[k + 1] = data[k];
                    }
                    data[j] = temp;
                }
            }
        }
        return data;
    }

    private int[] swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
        return data;
    }

    public static void main(String[] args) {
        int[] data = {113, 336, 74, 71, 86, 176, 313, 80, 225, 342,
                170, 292, 275, 266, 79, 16, 109, 175, 245, 156,
                50, 61, 277, 167, 81, 24, 76, 186, 78, 101,
                301, 62, 152, 219, 294};
        int dataSize = data.length;
        int[] dataSorted = new int[dataSize];

        System.out.println("\n< Initial Data >");
        showData(data);

        MySort2 ms = new MySort2();

        dataSorted = data.clone();
        ms.selectionSort(dataSorted);
        System.out.println("\n< Selection Sort >");
        showData(dataSorted);

        dataSorted = data.clone();
        ms.bubbleSort(dataSorted);
        System.out.println("\n< Bubble Sort >");
        showData(dataSorted);

        dataSorted = data.clone();
      ms.quickSort(dataSorted);
       System.out.println("\n< Quick Sort >");
       showData(dataSorted);

        dataSorted = data.clone();
        ms.mergeSort(dataSorted);
        System.out.println("\n< Merge Sort >");
        showData(dataSorted);

        dataSorted = data.clone();
        ms.insertionSort(dataSorted);
        System.out.println("\n< Insertion Sort >");
        showData(dataSorted);
    }

    private static void showData(int[] data) {
        int n = data.length;
        int nRow = 1 + (int) n / 10;
        for (int i = 0; i < nRow; i++) {
            for (int j = i * 10; j < Math.min(n, (i + 1) * 10); j++)
                System.out.print("  " + data[j]);
            System.out.println();
        }
    }
}


