package measurements;

public class Dimensions {

    //Comprimento length, largura width e altura height

    private float length, width, height, volume;

    public Dimensions(float length, float width, float height) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.volume = length * width * height;
    }
}
