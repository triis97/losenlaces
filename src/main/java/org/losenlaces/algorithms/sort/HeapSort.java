package org.losenlaces.algorithms.sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {10, 20, 10, 40, 50, 40, 30, 30};
        int n = arr.length;

        heapSort(arr, n);
        System.out.println(Arrays.toString(arr));
    }

    static void heapSort(int arr[], int n) {
        buildHeap(arr, n);

        for (int i = n - 1; i >= 1; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            maxHeapify(arr, i, 0);
        }
    }

    static void buildHeap(int arr[], int n) {

        for (int i = (n - 2) / 2; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }
    }

    static void maxHeapify(int arr[], int n, int i) {
        int largest = i, left = 2 * i + 1, right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int tmp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = tmp;
            maxHeapify(arr, n, largest);
        }
    }
}
