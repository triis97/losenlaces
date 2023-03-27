package org.losenlaces.algorithms.sort;

public class ShellSort {
    public static long sort(int[] listToSort) {
        long init = System.currentTimeMillis();
        int increment = listToSort.length / 2;
        while (increment >= 1) {
            for (int startIndex = 0; startIndex < increment; startIndex++) {
                insertionSort(listToSort, startIndex, increment);
            }
            increment /= 2;
        }
        return System.currentTimeMillis() - init;
    }

    private static void insertionSort(int[] listToSort, int startIndex, int increment) {
        for (int i = startIndex; i < listToSort.length; i += increment) {
            for (int j = Math.min(i + increment, listToSort.length - 1);
                 j - increment >= 0;
                 j = j - increment) {
                if (listToSort[j] < listToSort[j - increment]) {
                    Utils.swap(listToSort, j, j - increment);
                } else {
                    break;
                }
            }
        }
    }
}
