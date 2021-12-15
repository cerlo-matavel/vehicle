package transported;

import measurements.Dimensions;
import measurements.Weight;

public class Cargo{

    private Weight weight;
    private Dimensions dimensions;
    private String description;

    public Cargo(double weight, Dimensions dimensions, String description) {
        this.weight = new Weight(weight);
        this.dimensions = dimensions;
        this.description = description;
    }

    public double getWeight() {
        return weight.getWeight();
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    @Override
    public String toString() {
        return "Cargo: " +
                "weight=" + weight +
                ", dimensions=" + dimensions +
                ", description=" + description + "\n";
    }
}
