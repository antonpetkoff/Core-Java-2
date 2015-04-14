package pack.matrix;

public class GaussianBlur implements MatrixOperation {

    @Override
    public Pixel withPixel(int x, int y, Pixel[][] matrix) {
        int count = 0;
        float sumR = 0.0f, sumG = 0.0f, sumB = 0.0f;
        
        for (int row = y - 1; row <= y + 1; ++row) {
            for (int col = x - 1; col <= x + 1; ++col) {
                if (col != x && row != y
                    && col >= 0 && col < matrix[0].length
                    && row >= 0 && row < matrix.length) {
                    
                    sumR += matrix[row][col].getR();
                    sumG += matrix[row][col].getG();
                    sumB += matrix[row][col].getB();
                    ++count;
                }
            }
        }
        
        return new Pixel(sumR / count, sumG / count, sumB / count);
    }

}
