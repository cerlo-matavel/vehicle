package measurements;

public class TareGrossWeight extends Weight{

    private float tare, grossWeight;

    public TareGrossWeight(float tare, float grossWeight) {
        super(0);
        this.tare = tare;
        this.grossWeight = grossWeight;
    }

    public float getTare() {
        return tare;
    }

    public float getGrossWeight() {
        return grossWeight;
    }

    public double getTotalWeight(){
        return this.tare + this.grossWeight;
    }

    public double getAvailableWeight() {
        return this.grossWeight - this.getWeight();
    }

    @Override
    public String toString() {
        return "TareGrossWeight{" +
                "tare=" + tare +
                ", grossWeight=" + grossWeight +
                '}';
    }
}