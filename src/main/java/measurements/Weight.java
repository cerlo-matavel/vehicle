package measurements;

public class Weight {

    private double weight;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Weight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.valueOf(weight);
    }
}
