package com.leetcode.matrix;

import java.util.*;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        
        int top = 0; 
        int bottom = matrix.length - 1;
        int left = 0; 
        int right = matrix[0].length - 1;
        
        while (top <= bottom && left <= right) {
            // Traverse from left to right along the top row
            for (int col = left; col <= right; col++) {
            	System.out.println(matrix[top][col]);
                result.add(matrix[top][col]);
            }
            top++;
            
            // Traverse from top to bottom along the right column
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--;
            
            if (top <= bottom) {
                // Traverse from right to left along the bottom row
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--;
            }
            
            if (left <= right) {
                // Traverse from bottom to top along the left column
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        
        System.out.println(spiralOrder(matrix1)); // Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
        System.out.println(spiralOrder(matrix2)); // Output: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
    }
}
