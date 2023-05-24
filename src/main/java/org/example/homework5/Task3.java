package org.example.homework5;

import java.util.Arrays;

/*
На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. И вывести Доску. Пример вывода доски 8x8
 */
public class Task3 {

    public static void main(String[] args) {
        final int boardSize = 8;
        int[][] board = new int[boardSize][boardSize];
        if (!solveQueens(board, 0)) {
            throw new RuntimeException("No solution found");
        }
    }

    private static boolean solveQueens(int[][] board, int col) {
        int maxQueenNumber = board.length;

        if (col == maxQueenNumber) {
            for (int[] row : board)
                System.out.println(Arrays.toString(row));
            System.out.println();
            return true;
        }

        for (int i = 0; i < maxQueenNumber; i++) {
            if (isSafePosition(board, i, col)) {
                board[i][col] = 1;
                if (solveQueens(board, col + 1)) {
                    return true;
                }

                board[i][col] = 0;
            }
        }

        return false;
    }

    private static boolean isSafePosition(int[][] board, int row, int col) {
        int size = board.length;

        // same row to the left
        for (int x = 0; x < col; x++) {
            if (board[row][x] == 1) return false;
        }

        // the upper left diagonal
        for (int x = row, y = col; x >= 0 && y >= 0; x--, y--) {
            if (board[x][y] == 1) return false;
        }

        // the lower left diagonal
        for (int x = row, y = col; x < size && y >= 0; x++, y--) {
            if (board[x][y] == 1) return false;
        }

        return true;
    }
}
