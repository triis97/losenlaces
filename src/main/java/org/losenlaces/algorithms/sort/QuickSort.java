package org.losenlaces.algorithms.sort;

public class QuickSort {

    public static int count = 0;

    public static void sort(int[] listToSort, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivotIndex = partition(listToSort, low, high);
        sort(listToSort, low, pivotIndex - 1);
        sort(listToSort, pivotIndex + 1, high);
    }

    public static int partition(int[] listToSort, int low, int high) {
        int pivot = listToSort[low];
        int l = low;
        int h = high;

        while (l < h) {
            while (listToSort[l] <= pivot && l < h) {
                l++;
            }
            while (listToSort[h] > pivot) {
                h--;
            }
            if (l < h) {
                count++;
                Utils.swap(listToSort, l, h);
            }
        }
        count++;
        Utils.swap(listToSort, low, h);

        System.out.println("Pivot :" + pivot);
        Utils.print(listToSort);
        return h;
    }
}
