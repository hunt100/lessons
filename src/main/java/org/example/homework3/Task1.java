package org.example.homework3;

import java.util.Arrays;

public class Task1 {
    /*
    (Дополнительно) Реализовать алгоритм сортировки слиянием
     */
    public static void main(String[] args) {
        int[] actual = { 5, 1, 6, 2, 3, 4 };
        mergeSort(actual);

        System.out.println(Arrays.stream(actual)
                .boxed()
                .toList());
    }

    public static void mergeSort(int[] arr) {
        int length = arr.length;
        if (length < 2) {
            return;
        }

        int middle = length / 2;
        int[] left = new int[middle];
        int[] right = new int[length - middle];

        System.arraycopy(arr, 0, left, 0, middle);

        if (length - middle >= 0)
            System.arraycopy(arr, middle, right, 0, length - middle);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int leftSize = left.length;
        int rightSize = right.length;

        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < leftSize) {
            arr[k++] = left[i++];
        }

        while (j < rightSize) {
            arr[k++] = right[j++];
        }
    }
}
