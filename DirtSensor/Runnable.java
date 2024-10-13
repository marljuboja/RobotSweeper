public class Runnable {
    public static void main(String[] args) {
        VacuumCleaner vacuum = new VacuumCleaner(); // Create a new vacuum cleaner instance

        // Simulate the vacuum cleaner operation
        System.out.println("Starting vacuum simulation...");
        for (int i = 0; i < 10; i++) { // Simulate checking and cleaning 10 times
            System.out.println("\nOperation " + (i + 1) + ":");
            vacuum.checkAndClean(); // Check for dirt and clean if dirt is detected
            try {
                Thread.sleep(1000); // Pause for a second before the next operation
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Simulation complete.");
    }
}
