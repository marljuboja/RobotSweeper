public class DirtContainer {
    private final int capacity = 50;  // Capacity of the dirt container as per project specification
    private int currentDirtLevel;
    private boolean isCleaningActive;


    public DirtContainer() {
        this.currentDirtLevel = 0;
        this.isCleaningActive = true;
    }


    public void addDirt() {
        if (!isCleaningActive) {
            System.out.println("Cleaning is currently paused. The container is full.");
            return;
        }

        currentDirtLevel++;  // Increment dirt level
        System.out.println("Added dirt. Current dirt level is: " + currentDirtLevel);

        if (currentDirtLevel >= capacity) {
            notifyFull();
            stopCleaning();
        }
    }


    public boolean isFull() {
        return currentDirtLevel >= capacity;
    }

    // method to notify if the container is full
    private void notifyFull() {
        System.out.println("Notification: The dirt container is full. Please empty the container.");
    }

    //method to stop cleaning
    private void stopCleaning() {
        isCleaningActive = false;
        System.out.println("Cleaning has been stopped due to a full dirt container.");
    }

    //empty container method
    public void emptyContainer() {
        currentDirtLevel = 0;
        isCleaningActive = true;
        System.out.println("The dirt container has been emptied. Cleaning resumed.");
    }

    // Getter methods for current dirt level and cleaning status
    public int getCurrentDirtLevel() {
        return currentDirtLevel;
    }

    public boolean isCleaningActive() {
        return isCleaningActive;
    }
}
