package org.example.homework2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class TaskOne {

    private static final Logger log = LoggerFactory.getLogger(TaskOne.class);
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        bubbleSort();
    }

    private static void bubbleSort() {
        System.out.println("Input n: ");
        int n = sc.nextInt();

        int[] inputArr = inputArray(n);
        sortArray(inputArr);

    }

    private static int[] inputArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Input arr[" + i + "]: ");
            int inputVal = sc.nextInt();
            arr[i] = inputVal;
        }
        return arr;
    }

    private static void sortArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            logCurrentArrState(arr);
        }
    }

    private static void logCurrentArrState(int[] arr) {
        StringBuilder builder = new StringBuilder();
        for (int j : arr) {
            builder.append(j)
                    .append(" ");
        }
        log.info(builder.toString());
    }

}
