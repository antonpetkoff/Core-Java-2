package pack.matrix;

public class Grayscale implements MatrixOperation {
    
    @Override
    public Pixel withPixel(int x, int y, Pixel[][] matrix) {
        float grey = 0.2126f * matrix[x][y].getR()
                    + 0.7152f * matrix[x][y].getG()
                    + 0.0722f * matrix[x][y].getB();
        return new Pixel(grey, grey, grey);
    }
    
}
