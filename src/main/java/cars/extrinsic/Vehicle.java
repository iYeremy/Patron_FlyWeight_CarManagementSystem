package cars.extrinsic;

import cars.intrinsic.VehicleType;

public class Vehicle {
    private float x; // position (x)
    private float y; // position (y)
    private int licensePlate; // Matricula (represented as a long for memory efficiency)
    private float currentSpeed; // Velocidad actual


    private VehicleType type; // Reference to the intrinsic VehicleType

    /** Constructor for Vehicle */
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

    /** Returns the license plate as a long. */
    public int getLicensePlateAsLong() {
        return licensePlate;
    }

    /** Returns the license plate as a String, generated only when needed. */
    public String getLicensePlateAsString() {
        return longToLicensePlate(licensePlate);
    }

    public float getCurrentSpeed() {
        return currentSpeed;
    }

    /** Returns vehicle type (intrinsic part) */
    public VehicleType getType() {
        return type;
    }

    /** Displays vehicles full information */
    public void display() {
        type.displayVehicle(x, y, getLicensePlateAsString(), currentSpeed);
    }

    /**
     * Converts a long representation of a license plate back to its String format (e.g., "AAA-1234").
     * This method assumes the license plate is composed of 3 uppercase letters and 4 digits.
     */
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
