package solent.ac.uk.ood.examples.week10.model;

public abstract class Vehicle {

    private Double weight;

    private String registration;

    public abstract Double calculateFee();

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "weight=" + weight + ", registration=" + registration + '}';
    }
    
}
