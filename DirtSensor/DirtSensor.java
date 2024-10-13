public class DirtSensor {
    public boolean detectDirt() {
        // This method would interact with the hardware sensor
        // For simulation, let's randomly decide if there is dirt
        return Math.random() < 0.5; // 50% chance of detecting dirt
    }
}
