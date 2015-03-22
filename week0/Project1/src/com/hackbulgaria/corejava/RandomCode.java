package com.hackbulgaria.corejava;

public class RandomCode {
    
    public static int sumMatrix(int[][] matrix, int x, int y, int height, int width) {
        int sum = 0;
        for (int row = x; row < height; ++row) {
            for (int col = y; col < width; ++col) {
                sum += matrix[row][col];
            }
        }
        return sum;
    }
    
    public static int[][] rescale(int[][] original, int newWidth, int newHeight) {
        int height = original.length;
        int width = original[0].length;
        
        int hRatio = height / newHeight;
        int wRatio = width / newWidth;
        
        
        int[][] newImage = new int[newHeight][newWidth];
        
        for (int row = 0; row < newHeight; ++row) {
            for (int col = 0; col < newWidth; ++col) {
                newImage[row][col] = original[row * hRatio][col * wRatio];
            }
        }
        
        return newImage;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 1, 2, 2},
            {1, 1, 2, 2},
            {3, 3, 4, 4},
            {3, 3, 4, 4}
        };
        
        int[][] result = rescale(matrix, 2, 2);
        
        //System.out.println(sumOfNumbers("000 three five -1 1----"));
    }
    
}
