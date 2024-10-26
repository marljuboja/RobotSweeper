import java.util.Random;

public class Robot {
    private int x, y;
    private RoomMap roomMap;

    public Robot(RoomMap roomMap) {
        this.roomMap = roomMap;
        placeRobot();
    }

    // Places the robot in a random position without obstacles
    private void placeRobot() {
        Random rand = new Random();
        int size = roomMap.getRoomMap().length;
        do {
            x = rand.nextInt(size);
            y = rand.nextInt(size);
        } while (roomMap.isObstacle(x, y));
        System.out.println("Robot placed at: (" + x + ", " + y + ")");
    }

    // Move function to handle movement in different directions
    public void move(String direction) {
        int newX = x, newY = y;

        switch (direction.toLowerCase()) {
            case "up":
                newX -= 1;
                break;
            case "down":
                newX += 1;
                break;
            case "left":
                newY -= 1;
                break;
            case "right":
                newY += 1;
                break;
            default:
                System.out.println("Invalid direction!");
                return;
        }

        if (isValidMove(newX, newY, direction)) {
            x = newX;
            y = newY;
            System.out.println("Moved " + direction + " to (" + x + ", " + y + ")");
            reportTileInfo(x, y);  // Report both tile type and dirt level
        } else {
            System.out.println("Could not move " + direction + ". Staying at (" + x + ", " + y + ").");
        }
    }

    // Function to check if a move is valid and print all details (walls, doors, obstacles, etc.)
    private boolean isValidMove(int newX, int newY, String direction) {
        // Check if the new position is within bounds
        if (newX < 0 || newX >= roomMap.getRoomMap().length || newY < 0 || newY >= roomMap.getRoomMap()[0].length) {
            System.out.println("Cannot move " + direction + ": Out of bounds.");
            return false;
        }
        
        // Check if there's an obstacle (furniture, charging station, stairs)
        if (roomMap.isObstacle(newX, newY)) {
            String obstacleType = getObstacleType(newX, newY);
            System.out.println("Cannot move " + direction + ": Obstacle encountered - " + obstacleType + ".");
            return false;
        }

        // Check if there's a wall in the way
        if (roomMap.hasWall(x, y, direction) || roomMap.hasWall(newX, newY, oppositeDirection(direction))) {
            System.out.println("Cannot move " + direction + ": Wall blocking the path.");
            return false;
        }

        // Check if there's a closed door in the way
        if (roomMap.hasClosedDoor(x, y, direction) || roomMap.hasClosedDoor(newX, newY, oppositeDirection(direction))) {
            System.out.println("Cannot move " + direction + ": Closed door blocking the path.");
            return false;
        }

        // If no block, no door, no wall, no furniture, print the free path message
        System.out.println("Move " + direction + " is clear. No obstacles, walls, or closed doors.");
        return true;  // Valid move
    }

    // Get the type of obstacle encountered (furniture, charging station, stairs)
    private String getObstacleType(int x, int y) {
        char obstacle = roomMap.getRoomMap()[x][y].charAt(1);
        switch (obstacle) {
            case '1':
                return "Furniture";
            case '2':
                return "Charging Station";
            case '3':
                return "Stairs";
            default:
                return "No obstacle";
        }
    }

    // Get the opposite direction (to check walls and doors between tiles)
    private String oppositeDirection(String direction) {
        switch (direction.toLowerCase()) {
            case "up":
                return "down";
            case "down":
                return "up";
            case "left":
                return "right";
            case "right":
                return "left";
            default:
                return "";
        }
    }

    // Report both the tile type and dirt level at the robot's current position
    private void reportTileInfo(int x, int y) {
        char tileType = roomMap.getRoomMap()[x][y].charAt(0); // Tile type is the 1st character
        char dirtLevel = roomMap.getRoomMap()[x][y].charAt(10); // Dirt is the 11th character

        // Print tile type
        switch (tileType) {
            case '0':
                System.out.println("Tile type: Bare floor.");
                break;
            case '1':
                System.out.println("Tile type: Low-pile carpet.");
                break;
            case '2':
                System.out.println("Tile type: High-pile carpet.");
                break;
            default:
                System.out.println("Tile type: Unknown.");
        }

        // Print dirt level
        System.out.println("Dirt level at current position: " + dirtLevel + "/9");
    }

    public void printPosition() {
        System.out.println("Robot is currently at: (" + x + ", " + y + ")");
    }
}
