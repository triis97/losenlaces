package org.losenlaces.algorithms.sort;

public class BubbleSort {

    public static long sort(int[] listToSort) {
        long init = System.currentTimeMillis();
        for (int i = 0; i < listToSort.length; i++) {
            boolean swaped = false;
            for (int j = listToSort.length - 1; j > i; j--) {
                if (listToSort[j] > listToSort[j - 1]) {
                    Utils.swap(listToSort, j, j - 1);
                    swaped = true;
                }
            }
            if (!swaped) break;
        }
        return System.currentTimeMillis() - init;
    }
}
