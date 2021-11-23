package transported;

import measurements.Dimensions;

public class Cargo{

    private float size;
    private float weight;
    private Dimensions dimensions;
    private String description;

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Cargo: " +
                "size= " + size +
                ", weight= " + weight +
                ", description= '" + description + '\'';
    }
}
