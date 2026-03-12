package cars;

import cars.intrinsic.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class VehicleFactory {
    private static final Map<String, VehicleType> vehicleTypes = new HashMap<>();

    /** Returns an existing or new VehicleType (flyweight) */
    public static VehicleType getVehicleType(String brand, String color, String model) {
        String key = brand + "_" + color + "_" + model;
        VehicleType type = vehicleTypes.get(key);

        if (type == null) {
            type = new VehicleType(brand, color, model);
            vehicleTypes.put(key, type);
        }
        return type;
    }

    /** Returns count of unique VehicleType instances */
    public static int getNumberOfUniqueVehicleTypes() {
        return vehicleTypes.size();
    }
}
