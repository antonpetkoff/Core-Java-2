package pack.matrix;

public class Pixel {

    private float R;
    private float G;
    private float B;

    public Pixel(float r, float b, float g) {
        this.R = r;
        this.G = g;
        this.B = b;
    }

    public float getR() {
        return R;
    }

    public void setR(float r) {
        R = r;
    }

    public float getG() {
        return G;
    }

    public void setG(float g) {
        G = g;
    }

    public float getB() {
        return B;
    }

    public void setB(float b) {
        B = b;
    }
    
    @Override
    public String toString() {
        return String.format("(%.3f,%.3f,%.3f)", R, G, B);
    }
    
}
