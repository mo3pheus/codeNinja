package sorting;

public class MergeSort {
    public static void merge(int[] a, int left, int middle, int right) {
        int   i    = left;
        int   j    = middle + 1;
        int   k    = 0;
        int[] temp = new int[right - left + 1];

        while ((i <= middle) && (j <= right)) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        while (i <= middle) {
            temp[k++] = a[i++];
        }

        while (j <= right) {
            temp[k++] = a[j++];
        }

        for (i = left; i <= right; i++) {
            a[i] = temp[i - left];
        }
    }

    public static void mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(a, left, middle);
            mergeSort(a, middle + 1, right);
            merge(a, left, middle, right);
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Merge Sort! The divide and conquer sort algorithm!");
        int[] unsortedArray = {-12, 23, 2, 34, -90, -40, -10, 14, 55, 43, 37, -100, - 1000, 999, 765, 232, 435 };
        int   right         = unsortedArray.length - 1;
        int   left          = 0;
        mergeSort(unsortedArray, left, right);
        for (int i : unsortedArray) {
            System.out.println(i);
        }
    }
}
