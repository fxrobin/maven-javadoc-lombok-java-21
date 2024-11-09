package fr.fxjavadevblog.mvnlmbkjdoc.garage;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import fr.fxjavadevblog.mvnlmbkjdoc.vehicules.Energy;
import fr.fxjavadevblog.mvnlmbkjdoc.vehicules.Vehicule;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * Unit tests for the Garage class.
 */
class GarageTest {

    @Test
    @DisplayName("Given a garage, when adding a vehicle, then the vehicle is in the garage.")
    void testAddVehicule() {
        // given
        Garage garage = Garage.builder().build();
        Vehicule vehicule = Vehicule.builder()
                .registrationNumber("AZ-123-XY")
                .brand("Porsche")
                .energy(Energy.GASOLINE).build();

        // when
        garage.addVehicule(vehicule);

        // then
        assertThat(garage.getVehicules()).contains(vehicule);
    }

    @Test
    @DisplayName("Given a garage with a vehicle, when removing the vehicle, then the vehicle is not in the garage.")
    void testRemoveVehicule() {
        // given
        Garage garage = Garage.builder().build();
        Vehicule vehicule = Vehicule.builder()
                .registrationNumber("AZ-123-XY")
                .brand("Porsche")
                .energy(Energy.GASOLINE).build();

        // when        
        garage.addVehicule(vehicule);
        garage.removeVehicule(vehicule);
        
        // then
        assertThat(garage.getVehicules()).doesNotContain(vehicule);
    }

    @Test
    void testUnmodifiableSet() {

        Garage garage = Garage.builder().build();
        Vehicule vehicule = Vehicule.builder()
                .registrationNumber("AZ-123-XY")
                .brand("Porsche")
                .energy(Energy.GASOLINE).build();


        garage.addVehicule(vehicule);
        Set<Vehicule> vehicules = garage.getVehicules();
        assertThatExceptionOfType(UnsupportedOperationException.class).isThrownBy(() -> vehicules.add(vehicule));
    }
}