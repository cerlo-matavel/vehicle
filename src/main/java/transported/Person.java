package transported;

import measurements.Dimensions;
import measurements.Weight;

public class Person {

    private String name;
    private Weight weight;
    private Dimensions height;

    public Person(String name, short weight, float height) {
        this.name = name;
        this.weight = new Weight(weight);
        this.height = new Dimensions(height);
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight.getWeight();
    }

    public float getHeight() {
        return height.getHeight();
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", weight=" + weight +
                ", height=" + height;
    }
}
