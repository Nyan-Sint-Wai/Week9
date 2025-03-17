package main;

public abstract class RallyCar {
    protected String make;
    protected String model;
    protected int horsePower;

    public RallyCar (String make, String model, int horsePower) {
        this.make = make;
        this.model = model;
        this.horsePower = horsePower;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }


    public abstract double calculatePerformance();

} // End of RallyCar

class GravelCar extends RallyCar {
    private double suspensionTravel;

    public GravelCar(String make, String model, int horsePower, double suspensionTravel) {
        super(make, model, horsePower);
        this.suspensionTravel = suspensionTravel;
    }

    public double getSuspensionTravel() {
        return suspensionTravel;
    }

    public double calculatePerformance() {
        return horsePower * 1.1 + suspensionTravel * 3;
    }
}   // End of GravelCar

class AsphaltCar extends RallyCar {
    private double downforce;

    public AsphaltCar(String make, String model, int horsePower, double downforce) {
        super(make, model, horsePower);
        this.downforce = downforce;
    }

    public double getDownforce() {
        return downforce;
    }

    public double calculatePerformance() {
        return horsePower * 1.15 + downforce * 5;
    }
} // End of AsphaltCar  
