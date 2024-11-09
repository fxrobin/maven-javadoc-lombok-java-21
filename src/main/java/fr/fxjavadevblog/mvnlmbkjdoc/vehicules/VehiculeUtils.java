package fr.fxjavadevblog.mvnlmbkjdoc.vehicules;

import lombok.experimental.UtilityClass;


/**
 * Utility class for vehicules.
 * 
 * This class contains utility methods to:
 * <li>format a vehicule as a string for pretty printing.</li>
 * 
 */
@UtilityClass
class VehiculeUtils {

    private static final String FORMAT_STRING = "Registration number: %s, Brand: %s, Energy: %s";

    /**
     * Format a vehicule as a string for pretty printing.
     * 
     * @param vehicule
     * @return a formatted string representing the vehicule.
     */
    String format(Vehicule vehicule) {
        return String.format(FORMAT_STRING, 
            vehicule.getRegistrationNumber(), 
            vehicule.getBrand(), 
            vehicule.getEnergy());
    }

}
