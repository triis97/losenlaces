package org.losenlaces.algorithms.sort;

public class SelectionSort {

    public static long sort(int[] listToSort) {
        long init = System.currentTimeMillis();
        for (int i = 0; i < listToSort.length; i++) {
            for (int j = i + 1; j < listToSort.length; j++) {
                if (listToSort[i] > listToSort[j]) {
                    Utils.swap(listToSort, i, j);
                }
            }
        }
        return System.currentTimeMillis() - init;
    }
}
