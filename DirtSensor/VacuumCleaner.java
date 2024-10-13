public class VacuumCleaner {
    private DirtSensor sensor;
    private boolean isCleaning;

    public VacuumCleaner() {
        this.sensor = new DirtSensor();
        this.isCleaning = false;
    }

    // Method to check for dirt and start cleaning
    public void checkAndClean() {
        if (sensor.detectDirt()) {
            startCleaning();
        } else {
            stopCleaning();
        }
    }

    private void startCleaning() {
        if (!isCleaning) {
            System.out.println("Starting cleaning process.");
            isCleaning = true;
            // More cleaning logic here
        }
    }

    private void stopCleaning() {
        if (isCleaning) {
            System.out.println("Stopping cleaning process.");
            isCleaning = false;
            // Additional logic to stop cleaning
        }
    }

    public boolean isCleaning() {
        return isCleaning;
    }
}
