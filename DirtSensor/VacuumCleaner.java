public class VacuumCleaner {
    private DirtSensor sensor;
    private boolean isCleaning;
    private int posX, posY;
    private int floorWidth, floorHeight; // Dimensions of the floor

    public VacuumCleaner(String[][] floorPlan, int startX, int startY) {
        this.sensor = new DirtSensor(floorPlan);
        this.posX = startX;
        this.posY = startY;
        this.floorWidth = floorPlan[0].length;  // Width is the number of columns
        this.floorHeight = floorPlan.length;    // Height is the number of rows
        this.isCleaning = false;
    }

    // Method to check for dirt and start or stop cleaning accordingly
    public void checkAndClean() {
        if (sensor.detectDirt(posX, posY)) {
            startCleaning();
            sensor.cleanDirt(posX, posY);
        } else {
            stopCleaning();
        }
    }

    // Method to start the cleaning process
    private void startCleaning() {
        if (!isCleaning) {
            System.out.println("Starting cleaning at position (" + posX + ", " + posY + ")");
            isCleaning = true;
        }
    }

    // Method to stop the cleaning process
    private void stopCleaning() {
        if (isCleaning) {
            System.out.println("Stopping cleaning at position (" + posX + ", " + posY + ")");
            isCleaning = false;
        }
    }

    // Moves the robot to the next position
    public void move() {
        // Simple movement logic: move right until the end of the row, then move down to the next row
        if (posY < floorWidth - 1) {
            posY++;
        } else if (posX < floorHeight - 1) {
            posX++;
            posY = 0; // Reset to the start of the next row
        }
    }
}
