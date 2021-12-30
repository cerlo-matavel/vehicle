package transported;

import measurements.Dimensions;
import measurements.Weight;

public class Cargo{

    private Weight weight;
    private Dimensions dimensions;
    private String description;

    public Cargo(Weight weight, Dimensions dimensions, String description) {
        this.weight = weight;
        this.dimensions = dimensions;
        this.description = description;
    }

    public static Cargo copy(Cargo cargo){
        return new Cargo(new Weight(cargo.getWeight()),
                new Dimensions(cargo.getDimensions().getLength(), cargo.getDimensions().getWidth(),
                        cargo.getDimensions().getHeight()),
                cargo.description);
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
