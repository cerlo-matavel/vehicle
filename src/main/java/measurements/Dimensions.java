package measurements;

public class Dimensions {

    //Comprimento length, largura width e altura height

    private float length, width, height;

    public Dimensions(float length, float width, float height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public Dimensions(float height) {
        this.height = height;
    }

    public float getLength() {
        return length;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "length=" + length +
                ", width=" + width +
                ", height=" + height;
    }
}
