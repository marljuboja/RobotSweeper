public class Runnable {
    public static void main(String[] args) {
        String[][] floorPlan = FloorPlan.getFloorPlan();  // Ensure this is initialized correctly
        VacuumCleaner vacuum = new VacuumCleaner(floorPlan, 0, 0);  // Starting at top-left corner

        System.out.println("Starting vacuum simulation...");
        for (int i = 0; i < floorPlan.length * floorPlan[0].length; i++) {  // Loop through all tiles
            System.out.println("\nOperation " + (i + 1) + ":");
            vacuum.checkAndClean();  // Check and clean at the vacuum's current position
            vacuum.move();  // Move to the next position
        }

        System.out.println("Simulation complete.");
    }
}
