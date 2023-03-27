package org.losenlaces.algorithms.sort;

public class InsertionSort {
    public static long sort(int[] listToSort) {
        long init = System.currentTimeMillis();
        for (int i = 0; i < listToSort.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (listToSort[j] < listToSort[j - 1]) {
                    Utils.swap(listToSort, j, j - 1);
                } else {
                    break;
                }
            }
        }
        return System.currentTimeMillis() - init;
    }
}
