import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Marina Ljuboja - Testing Battery Maintenance")
class BatteryMaintenanceTest {

    @BeforeEach
    public void setup() {
        BatteryMaintenance.currentBatteryLevel = 250.0;
    }

    @Test
    @DisplayName("Marina Ljuboja - Testing for Wrong Parameters and Calculating Battery Successfully")
    void startBatteryMaintenance() {

        Assertions.assertThrows(Exception.class, () -> {
            BatteryMaintenance.startBatteryMaintenance(-5,-5,true, false);
        });

        Assertions.assertThrows(Exception.class, () -> {
            BatteryMaintenance.startBatteryMaintenance(3,3,true, false);
        });

        BatteryMaintenance.currentBatteryLevel = 250.0;
        BatteryMaintenance.startBatteryMaintenance(0,1,false, false);
        assertEquals(247.0,BatteryMaintenance.currentBatteryLevel);
    }

    @Test
    @DisplayName("Marina Ljuboja - Testing to see if it checks for enough " +
            "battery and if it throws exception when parameters are wrong")
    void isEnoughBattery() {

        Assertions.assertThrows(Exception.class, () -> {
            BatteryMaintenance.isEnoughBattery(-5.0);
        });

        Assertions.assertThrows(Exception.class, () -> {
            BatteryMaintenance.isEnoughBattery(255.0);
        });

        BatteryMaintenance.currentBatteryLevel = 49.0;
        assertFalse(BatteryMaintenance.isEnoughBattery(10.0));

        BatteryMaintenance.currentBatteryLevel = 250.0;
        assertTrue(BatteryMaintenance.isEnoughBattery(10.0));
    }

    @Test
    @DisplayName("Marina Ljuboja - Testing for charging battery successfully when at charging station")
    void testRecharge() {

        BatteryMaintenance.currentBatteryLevel = 50.0;
        BatteryMaintenance.isAtCS();
        assertEquals(250.0,BatteryMaintenance.currentBatteryLevel);
    }
}