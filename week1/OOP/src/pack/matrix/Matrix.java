package pack.matrix;

public class Matrix {
    
    private Pixel[][] matrix;
    
    public Matrix(int nRows, int mCols) {
        matrix = matrixFactory(nRows, mCols);
    }
    
    public void setPixel(int x, int y, Pixel pixel) {
        if (!isPositionInBounds(x, y)) {
            throw new IllegalArgumentException("setPixel(): coordinates out of bounds!");   
        }
        
        matrix[x][y] = pixel;
    }
    
    public Pixel getPixel(int x, int y) {
        if (!isPositionInBounds(x, y)) {
            throw new IllegalArgumentException("setPixel(): coordinates out of bounds!");
        }
        
        return matrix[x][y];
    }
    
    public void operate(MatrixOperation op) {
        Pixel[][] newMatrix = new Pixel[matrix.length][matrix[0].length];
        
        for (int row = 0; row < matrix.length; ++row) {
            for (int col = 0; col < matrix[row].length; ++col) {
                newMatrix[row][col] = op.withPixel(row, col, matrix);
            }
        }
        
        matrix = newMatrix;
    }
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        
        for (int row = 0; row < matrix.length; ++row) {
            for (int col = 0; col < matrix[row].length; ++col) {
                str.append(matrix[row][col].toString() + " ");
            }
            str.append("\n\n");
        }
        
        return str.toString();
    }
    
    private boolean isPositionInBounds(int x, int y) {
        return (x >= 0 && x < matrix[0].length)
                || (y >= 0 && y < matrix.length);
    }
    
    private Pixel[][] matrixFactory(int nRows, int mCols) {
        Pixel[][] matrix = new Pixel[nRows][mCols];
        
        for (int row = 0; row < matrix.length; ++row) {
            for (int col = 0; col < matrix[row].length; ++col) {
                matrix[row][col] = new Pixel(0.0f, 0.0f, 0.0f);
            }
        }
        
        return matrix;
    }
    
    public static void main(String[] args) {
        Matrix matrix = new Matrix(5, 6);
        matrix.setPixel(1, 1, new Pixel(1, 2, 3));
        System.out.println(matrix);
    }
    
}
