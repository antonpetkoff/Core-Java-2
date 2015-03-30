package pack.matrix;

public class BrightnessReduce implements MatrixOperation {

    private float factor;

    public BrightnessReduce(float factor) {
        this.factor = factor;
    }

    @Override
    public Pixel withPixel(int x, int y, Pixel[][] matrix) {
        return new Pixel(
                matrix[x][y].getR() * factor, 
                matrix[x][y].getG() * factor, 
                matrix[x][y].getB() * factor);
    }
}
