package org.losenlaces.algorithms.sort;

public class MergeSort {

    public static void sort(int[] listToSort) {
        if (listToSort.length == 1) {
            return;
        }

        int midIndex = listToSort.length / 2 + listToSort.length % 2;
        int[] listFirstHalf = new int[midIndex];
        int[] listSecondHalf = new int[listToSort.length - midIndex];
        split(listToSort, listFirstHalf, listSecondHalf);

        sort(listFirstHalf);
        sort(listSecondHalf);

        merge(listToSort, listFirstHalf, listSecondHalf);
        Utils.print(listToSort);
    }

    public static void split(int[] listToSort, int[] listFirstHalf, int[] listSecondHalf) {
        int index = 0;
        int secondHalfFirstIndex = listFirstHalf.length;
        for (int element : listToSort) {
            if (index < secondHalfFirstIndex) {
                listFirstHalf[index] = listToSort[index];
            } else {
                listSecondHalf[index - secondHalfFirstIndex] = listToSort[index];
            }
            index++;
        }
    }

    public static int count = 0;

    public static void merge(int[] listToSort, int[] listFirstHalf, int[] listSecondHalf) {
        int mergeIndex = 0;
        int firstHalfIndex = 0;
        int secodnHalfIndex = 0;

        while (firstHalfIndex < listFirstHalf.length && secodnHalfIndex < listSecondHalf.length) {
            if (listFirstHalf[firstHalfIndex] < listSecondHalf[secodnHalfIndex]) {
                listToSort[mergeIndex] = listFirstHalf[firstHalfIndex];
                firstHalfIndex++;
            } else if (listFirstHalf[firstHalfIndex] > listSecondHalf[secodnHalfIndex]) {
                count++;
                listToSort[mergeIndex] = listSecondHalf[secodnHalfIndex];
                secodnHalfIndex++;
            }
            mergeIndex++;
        }

        if (firstHalfIndex < listFirstHalf.length) {
            while (mergeIndex < listToSort.length) {
                listToSort[mergeIndex++] = listFirstHalf[firstHalfIndex++];
            }
        }
        if (secodnHalfIndex < listSecondHalf.length) {
            while (mergeIndex < listToSort.length) {
                listToSort[mergeIndex++] = listSecondHalf[secodnHalfIndex++];
            }
        }
    }
}
