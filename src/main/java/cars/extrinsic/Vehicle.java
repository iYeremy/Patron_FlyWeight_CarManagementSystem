package cars.extrinsic;

import cars.intrinsic.VehicleType;

public class Vehicle {
    private float x;
    private float y;
    private int licensePlate;
    private float currentSpeed;


    private VehicleType type;

    /** Constructor. */
    public Vehicle(float x, float y, int licensePlate, float currentSpeed, VehicleType type) {
        this.x = x;
        this.y = y;
        this.licensePlate = licensePlate;
        this.currentSpeed = currentSpeed;
        this.type = type;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    /** Returns license plate. */
    public int getLicensePlateAsLong() {
        return licensePlate;
    }

    /** Returns license plate as string. */
    public String getLicensePlateAsString() {
        return longToLicensePlate(licensePlate);
    }

    public float getCurrentSpeed() {
        return currentSpeed;
    }

    /** Returns vehicle type. */
    public VehicleType getType() {
        return type;
    }

    /** Displays vehicle information. */
    public void display() {
        type.displayVehicle(x, y, getLicensePlateAsString(), currentSpeed);
    }

    /** Converts long to license plate string. */
    private static String longToLicensePlate(long numericLicensePlate) {
        char[] plate = new char[8];

        for (int i = 3; i >= 0; i--) {
            plate[7 - (3 - i)] = (char) ('0' + (numericLicensePlate % 10));
            numericLicensePlate /= 10;
        }

        plate[3] = '-';

        for (int i = 2; i >= 0; i--) {
            plate[i] = (char) ('A' + (numericLicensePlate % 26));
            numericLicensePlate /= 26;
        }

        return new String(plate);
    }
}
