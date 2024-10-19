// Updated RoomMap to be compatible with FloorPlan

public class RoomMap {
    private String[][] roomMap;
    private int size = 10;  // Default size from FloorPlan
    
    public RoomMap() {
        // Load the floor plan from FloorPlan class
        FloorPlan floorPlan = new FloorPlan();
        this.roomMap = floorPlan.getFloorPlan();
    }

    public String[][] getRoomMap() {
        return roomMap;
    }

    public boolean isObstacle(int x, int y) {
        if (x < 0 || x >= size || y < 0 || y >= size) {
            return true; // Out of bounds counts as obstacle
        }
        // Check the second character for obstacle (0 = nothing, 1 = furniture, 2 = charging station, 3 = stairs)
        char obstacle = roomMap[x][y].charAt(1);
        return obstacle != '0'; // If it's anything other than 0, it's considered an obstacle
    }

    public void printRoomMap() {
        System.out.println("Room Map:");
        for (String[] row : roomMap) {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
