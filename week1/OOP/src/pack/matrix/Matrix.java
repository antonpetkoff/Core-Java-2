package pack.matrix;

import java.util.Random;

public class Matrix {
    
    private Pixel[][] matrix;
    private int height;
    private int width;
    
    public Matrix(int nRows, int mCols) {
        if (nRows <= 0 || mCols <= 0) {
            throw new IllegalArgumentException("Matrix(): constructor needs positive integers!");
        }
        
        this.height = nRows;
        this.width = mCols;
        this.matrix = matrixFactory(nRows, mCols);
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public void setPixel(int x, int y, Pixel pixel) {
        if (!isPositionInBounds(x, y)) {
            throw new IllegalArgumentException("setPixel(): coordinates out of bounds!");   
        }
        
        matrix[x][y] = pixel;
    }
    
    public void setPixel(int x, int y, float r, float g, float b) {
        if (!isPositionInBounds(x, y)) {
            throw new IllegalArgumentException("setPixel(): coordinates out of bounds!");   
        }
        
        matrix[x][y].setR(r);
        matrix[x][y].setG(g);
        matrix[x][y].setB(b);
    }
    
    public Pixel getPixel(int x, int y) {
        if (!isPositionInBounds(x, y)) {
            throw new IllegalArgumentException("setPixel(): coordinates out of bounds!");
        }
        
        return matrix[x][y];
    }
    
    public void operate(MatrixOperation op) {
        Pixel[][] newMatrix = new Pixel[matrix.length][matrix[0].length];
        
        for (int row = 0; row < height; ++row) {
            for (int col = 0; col < width; ++col) {
                newMatrix[row][col] = op.withPixel(row, col, matrix);
            }
        }
        
        matrix = newMatrix;
    }
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        
        for (int row = 0; row < height; ++row) {
            for (int col = 0; col < width; ++col) {
                str.append(matrix[row][col].toString() + " ");
            }
            str.append("\n\n");
        }
        
        return str.toString();
    }
    
    private boolean isPositionInBounds(int x, int y) {
        return (x >= 0 && x < height)
                || (y >= 0 && y < width);
    }
    
    private Pixel[][] matrixFactory(int nRows, int mCols) {
        Pixel[][] matrix = new Pixel[nRows][mCols];
        
        for (int row = 0; row < height; ++row) {
            for (int col = 0; col < width; ++col) {
                matrix[row][col] = new Pixel(0.0f, 0.0f, 0.0f);
            }
        }
        
        return matrix;
    }
    
    public void randomizeMatrix() {
        Random rand = new Random();
        
        for (int row = 0; row < height; ++row) {
            for (int col = 0; col < width; ++col) {
                setPixel(row, col, rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
            }
        }
    }
    
    public static void main(String[] args) {
        Matrix matrix = new Matrix(5, 4);
        matrix.randomizeMatrix();
        System.out.println(matrix);
        matrix.operate(new BrightnessReduce(0.5f));
        System.out.println(matrix);
        matrix.operate(new Grayscale());
        System.out.println(matrix);
        matrix.operate(new GaussianBlur());
        System.out.println(matrix);
    }
    
}
