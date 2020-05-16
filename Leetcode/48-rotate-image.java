/**
 * 
 * Leetcode #48 - https://leetcode.com/problems/rotate-image/
 */

class Solution {
    public void rotate(int[][] matrix) {
        int left;
        int right;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                swap(matrix, i, j, j, i);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            left = 0;
            right = matrix[i].length - 1;
            while (left < right) {
                swap(matrix, i, i, left, right);
                left++;
                right--;
            }
        }
    }

    public void swap(int[][] matrix, int i, int j, int k, int l) {
        int temp = matrix[i][k];
        matrix[i][k] = matrix[j][l];
        matrix[j][l] = temp;
    }
}