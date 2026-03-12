package cars.intrinsic;

public class VehicleType {
    private final String brand;
    private final String color;
    private final String model;

    /** Constructor */
    public VehicleType(String brand, String color, String model) {
        this.brand = brand;
        this.color = color;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    /** Displays vehicle type info with extrinsic state */
    public void displayVehicle(float x, float y, String licensePlate, float currentSpeed) {
        System.out.println("Displaying Vehicle: " + brand + " " + model + " (" + color + ")");
        System.out.println("  License Plate: " + licensePlate + ", Position: (" + x + ", " + y + "), Speed: " + currentSpeed + " km/h");
    }

    /** Compares VehicleType objects */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleType that = (VehicleType) o;
        return brand.equals(that.brand) &&
               color.equals(that.color) &&
               model.equals(that.model);
    }

    /** Generates hash code */
    @Override
    public int hashCode() {
        return java.util.Objects.hash(brand, color, model);
    }
}
