package transported;

import measurements.Dimensions;

public class Person {

    private String name;
    private short weight;
    private Dimensions dimensions;

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public Person(String passangerName) {
        this.name = passangerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getWeight() {
        return weight;
    }

    public void setWeight(short weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Passanger{" +
                "passangerName='" + name + '\'' +
                ", passangerWeight=" + weight +
                '}';
    }
}
