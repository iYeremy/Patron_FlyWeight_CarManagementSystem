package cars;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cars.extrinsic.Vehicle;
import cars.intrinsic.VehicleType;

public class Main {
    private static final int NUMBER_OF_VEHICLES = 40000000;
    private static final String[] BRANDS = {"Toyota", "Ford", "Honda", "BMW", "Mercedes", "Audi"};
    private static final String[] COLORS = {"Red", "Blue", "Black", "White", "Silver", "Gray"};
    private static final String[] MODELS = {"Sedan", "SUV", "Truck", "Hatchback", "Coupe", "Van"};

    private static List<Vehicle> vehicles;

    /** Main method to simulate vehicle creation and measure memory. */
    public static void main(String[] args) {
        vehicles = new ArrayList<>(NUMBER_OF_VEHICLES);
        Random random = new Random();


        long startTime = System.currentTimeMillis();

        for (int i = 0; i < NUMBER_OF_VEHICLES; i++) {
            String randomBrand = BRANDS[random.nextInt(BRANDS.length)];
            String randomColor = COLORS[random.nextInt(COLORS.length)];
            String randomModel = MODELS[random.nextInt(MODELS.length)];

            VehicleType type = VehicleFactory.getVehicleType(randomBrand, randomColor, randomModel);
            int licensePlate = generateRandomLicensePlate(random);
            float x = random.nextFloat() * 1000;
            float y = random.nextFloat() * 1000;
            float currentSpeed = random.nextFloat() * 200;

            vehicles.add(new Vehicle(x, y, licensePlate, currentSpeed, type));
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken to create " + NUMBER_OF_VEHICLES + " vehicles: " + (endTime - startTime) + " ms");
        System.out.println("Number of unique VehicleType objects (flyweights): " + VehicleFactory.getNumberOfUniqueVehicleTypes());



        System.out.println("\n--- Displaying a few vehicles ---");
        for (int i = 0; i < Math.min(5, NUMBER_OF_VEHICLES); i++) {
            vehicles.get(i).display();
        }



        Runtime runtime = Runtime.getRuntime();
        runtime.gc();

        long totalMemoryMB = runtime.totalMemory() / (1024L * 1024L);
        long freeMemoryMB = runtime.freeMemory() / (1024L * 1024L);
        long usedMemoryMB = totalMemoryMB - freeMemoryMB;
        long maxMemoryMB = runtime.maxMemory() / (1024L * 1024L);

        System.out.println("\nMemory Usage (MB):");
        System.out.println("Total: " + totalMemoryMB);
        System.out.println("Free: " + freeMemoryMB);
        System.out.println("Used: " + usedMemoryMB);
        System.out.println("Max: " + maxMemoryMB);

    }

    /** Generates a random license plate. */
    private static int generateRandomLicensePlate(Random random) {
        int letters = random.nextInt(26 * 26 * 26);
        int digits = random.nextInt(10000);
        return letters * 10000 + digits;
    }
}
