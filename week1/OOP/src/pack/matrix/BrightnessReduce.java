package pack.matrix;

public class BrightnessReduce implements MatrixOperation {

    private float factor;

    public BrightnessReduce(float factor) {
        if (factor < 0.0f || factor > 1.0f) {
            throw new IllegalArgumentException("BrightnessReduce(): factor must be in [0.0f, 1.0f]");
        }
        
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
