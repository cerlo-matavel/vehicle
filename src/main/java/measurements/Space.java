package measurements;

public class Space extends Dimensions{

    private double availableSpace;

    public Space(float length, float width, float height) {
        super(length, width, height);
        this.availableSpace = this.calculateVector();
    }

    public double getAvailableSpace() {
        return availableSpace;
    }

    public void setAvailableSpace(double availableSpace) {
        this.availableSpace = availableSpace;
    }
}
