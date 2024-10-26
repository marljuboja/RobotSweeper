import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RobotMovement {
    private int x, y;
    private RoomMap roomMap;
    private Set<String> visited;

    public RobotMovement(RoomMap roomMap) {
        this.roomMap = roomMap;
        this.visited = new HashSet<>();
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

    // Main function to explore the room
    public void exploreRoom() {
        dfsMove(x, y);
        System.out.println("Exploration finished. The robot explored all possible spaces.");
    }

    // DFS-based movement in four directions
    private void dfsMove(int curX, int curY) {
        // Mark this cell as visited
        visited.add(curX + "," + curY);
        System.out.println("Exploring position: (" + curX + ", " + curY + ")");
        
        // Report the tile type and dirt level
        reportTileInfo(curX, curY);

        // Try to move in all four directions (up, down, left, right)
        if (!move("up", curX, curY) && !move("down", curX, curY) && 
            !move("left", curX, curY) && !move("right", curX, curY)) {
            System.out.println("The robot is stuck and can't move further. Owner needs to pick it up.");
        }
    }

    // Function to handle movement and avoid obstacles
    private boolean move(String direction, int curX, int curY) {
        int newX = curX, newY = curY;

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
                return false;
        }

        // Check if the new position is valid
        if (isValidMove(newX, newY, direction)) {
            if (!visited.contains(newX + "," + newY)) {
                System.out.println("Moved " + direction + " to (" + newX + ", " + newY + ")");
                dfsMove(newX, newY); // Recursively move to the next position
                return true; // Move was successful
            }
        }
        return false; // Move was not successful
    }

    // Check if a move is valid
    private boolean isValidMove(int newX, int newY, String direction) {
        // Check if the new position is within bounds
        if (newX < 0 || newX >= roomMap.getRoomMap().length || newY < 0 || newY >= roomMap.getRoomMap()[0].length) {
            System.out.println("Cannot move " + direction + ": Out of bounds.");
            return false;
        }

        // Check for obstacles (furniture, charging station, stairs)
        if (roomMap.isObstacle(newX, newY)) {
            String obstacleType = getObstacleType(newX, newY);
            System.out.println("Cannot move " + direction + ": Obstacle encountered - " + obstacleType + ".");
            return false;
        }

        // Check for walls
        if (roomMap.hasWall(x, y, direction) || roomMap.hasWall(newX, newY, oppositeDirection(direction))) {
            System.out.println("Cannot move " + direction + ": Wall blocking the path.");
            return false;
        }

        // Check for doors (open/closed)
        if (roomMap.hasClosedDoor(x, y, direction)) {
            System.out.println("Cannot move " + direction + ": Closed door blocking the path.");
            return false;
        } else if (roomMap.hasOpenDoor(x, y, direction)) {
            System.out.println("Moving through an open door...");
        }

        return true;
    }

    // Report the tile type and dirt level
    private void reportTileInfo(int x, int y) {
        String tile = roomMap.getRoomMap()[x][y];
        char tileType = tile.charAt(0);  // First character is the tile type
        char dirtLevel = tile.charAt(10);  // Eleventh character is the dirt level

        // Print tile type
        switch (tileType) {
            case '0':
                System.out.println("Tile type: Bare floor. Normal movement.");
                break;
            case '1':
                System.out.println("Tile type: Low-pile carpet. Slowing down.");
                break;
            case '2':
                System.out.println("Tile type: High-pile carpet. High resistance.");
                break;
            default:
                System.out.println("Tile type: Unknown.");
        }

        // Print dirt level
        System.out.println("Dirt level at current position: " + dirtLevel + "/9");
    }

    // Get the type of obstacle encountered
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

    // Get the opposite direction for wall and door checks
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
}
