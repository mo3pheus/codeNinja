package sorting;

public class AnotherMergedSort {

    public static void merge(int[] a, int start, int mid, int end) {
        int   leftIndex  = start;
        int   rightIndex = mid + 1;
        int   tempIndex  = 0;
        int[] temp       = new int[end - start + 1];

        while ((leftIndex <= mid) && (rightIndex <= end)) {
            if (a[leftIndex] < a[rightIndex]) {
                temp[tempIndex++] = a[leftIndex++];
            } else {
                temp[tempIndex++] = a[rightIndex++];
            }
        }

        while (leftIndex <= mid) {
            temp[tempIndex++] = a[leftIndex++];
        }

        while (rightIndex <= end) {
            temp[tempIndex++] = a[rightIndex++];
        }

        for (int i = start; i <= end; i++) {
            a[i] = temp[i - start];
        }
    }

    public static void mergeSort(int[] a, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(a, start, mid);
            mergeSort(a, mid + 1, end);
            merge(a, start, mid, end);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello and welcome to another merged sort.");
        int[] unSorted = {23, 34, 12, 1, 2, -10, 999, 987, 34, 234, 14};
        mergeSort(unSorted, 0, unSorted.length - 1);
        for (int i : unSorted) {
            System.out.println(i);
        }
    }
}
