public class RoomMap {
    private String[][] roomMap;
    private int size = 10;  // 10x10 map from FloorPlan
    
    public RoomMap() {
        // Load the predefined floor plan from FloorPlan class
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

    // Check if there's a wall in the given direction (N, S, E, W)
    public boolean hasWall(int x, int y, String direction) {
        char wall;
        switch (direction) {
            case "up":
                wall = roomMap[x][y].charAt(2); // North wall (3rd character)
                break;
            case "down":
                wall = roomMap[x][y].charAt(3); // South wall (4th character)
                break;
            case "left":
                wall = roomMap[x][y].charAt(5); // West wall (6th character)
                break;
            case "right":
                wall = roomMap[x][y].charAt(4); // East wall (5th character)
                break;
            default:
                return false;
        }
        return wall == '1'; // If "1", there's a wall in that direction
    }

    // Check if there's a closed door in the given direction (N, S, E, W)
    public boolean hasClosedDoor(int x, int y, String direction) {
        char door;
        switch (direction) {
            case "up":
                door = roomMap[x][y].charAt(6); // North door (7th character)
                break;
            case "down":
                door = roomMap[x][y].charAt(7); // South door (8th character)
                break;
            case "left":
                door = roomMap[x][y].charAt(9); // West door (10th character)
                break;
            case "right":
                door = roomMap[x][y].charAt(8); // East door (9th character)
                break;
            default:
                return false;
        }
        return door == '2'; // If "2", the door is closed
    }

    // Check if there's an open door in the given direction (N, S, E, W)
    public boolean hasOpenDoor(int x, int y, String direction) {
        char door;
        switch (direction) {
            case "up":
                door = roomMap[x][y].charAt(6); // North door (7th character)
                break;
            case "down":
                door = roomMap[x][y].charAt(7); // South door (8th character)
                break;
            case "left":
                door = roomMap[x][y].charAt(9); // West door (10th character)
                break;
            case "right":
                door = roomMap[x][y].charAt(8); // East door (9th character)
                break;
            default:
                return false;
        }
        return door == '1'; // If "1", the door is open
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
