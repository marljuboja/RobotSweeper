import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RobotMovement {
    private int x, y;  // Robot's current position
    private RoomMap roomMap;
    private Set<String> visited;
    private String[][] path;
    private int size;

    public RobotMovement(RoomMap roomMap) {
        this.roomMap = roomMap;
        this.visited = new HashSet<>();
        this.path = new String[roomMap.getRoomMap().length][roomMap.getRoomMap()[0].length];
        this.size = roomMap.getRoomMap().length;

        // Initialize path grid with "." for unexplored cells
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                path[i][j] = ".";
            }
        }

        placeRobot();
    }

    // Place robot at random position without obstacles
    private void placeRobot() {
        Random rand = new Random();
        do {
            x = rand.nextInt(size);
            y = rand.nextInt(size);
        } while (roomMap.isObstacle(x, y) || visited.contains(x + "," + y));
        System.out.println("Robot placed at: (" + x + ", " + y + ")");
        path[x][y] = "S";
    }

    // Explore the room with DFS and reposition if stuck
    public void exploreRoom() {
        while (visited.size() < size * size - countObstacles()) {  // Run until all cells are visited
            dfsMove(x, y);
            
            // If the robot is stuck, print the current path pattern
            if (visited.size() < size * size - countObstacles()) {
                System.out.println("The robot is stuck and can't move further. owner picked up robot . Printing current path pattern:");
                printPathPattern();  // Print the movement pattern before repositioning

                // Reposition the robot to a new unexplored cell
                placeRobot();
            }
        }
        System.out.println("Exploration finished. The robot covered all possible spaces.");
        printPathPattern();  // Final path printout after the entire room is covered
    }


    // DFS-based movement in four directions
    private void dfsMove(int curX, int curY) {
        visited.add(curX + "," + curY);
        System.out.println("Exploring position: (" + curX + ", " + curY + ")");
        reportTileInfo(curX, curY);

        // Try moving in all four directions (up, down, left, right)
        if (!move("up", curX, curY) && !move("down", curX, curY) &&
            !move("left", curX, curY) && !move("right", curX, curY)) {
            System.out.println("The robot is stuck and can't move further.");
        }
    }

    // Function to handle movement and avoid obstacles
    private boolean move(String direction, int curX, int curY) {
        int newX = curX, newY = curY;

        switch (direction.toLowerCase()) {
            case "up": newX -= 1; break;
            case "down": newX += 1; break;
            case "left": newY -= 1; break;
            case "right": newY += 1; break;
            default: return false;
        }

        if (isValidMove(newX, newY, direction)) {
            if (!visited.contains(newX + "," + newY)) {
                path[newX][newY] = "S";  // Mark the cell as visited
                System.out.println("Moved " + direction + " to (" + newX + ", " + newY + ")");
                dfsMove(newX, newY);  // Recursively move to the next position
                return true;
            }
        }
        return false;
    }

    // Check if a move is valid
    private boolean isValidMove(int newX, int newY, String direction) {
        if (newX < 0 || newX >= size || newY < 0 || newY >= size) {
            System.out.println("Cannot move " + direction + ": Out of bounds.");
            return false;
        }

        if (roomMap.isObstacle(newX, newY)) {
            String obstacleType = getObstacleType(newX, newY);
            System.out.println("Cannot move " + direction + ": Obstacle encountered - " + obstacleType + ".");
            return false;
        }

        if (roomMap.hasWall(x, y, direction) || roomMap.hasWall(newX, newY, oppositeDirection(direction))) {
            System.out.println("Cannot move " + direction + ": Wall blocking the path.");
            return false;
        }

        if (roomMap.hasClosedDoor(x, y, direction)) {
            System.out.println("Cannot move " + direction + ": Closed door blocking the path.");
            return false;
        } else if (roomMap.hasOpenDoor(x, y, direction)) {
            System.out.println("Moving through an open door...");
        }

        return true;
    }

    // Report tile type and dirt level
    private void reportTileInfo(int x, int y) {
        String tile = roomMap.getRoomMap()[x][y];
        char tileType = tile.charAt(0);
        char dirtLevel = tile.charAt(10);

        switch (tileType) {
            case '0': System.out.println("Tile type: Bare floor. Normal movement."); break;
            case '1': System.out.println("Tile type: Low-pile carpet. Slowing down."); break;
            case '2': System.out.println("Tile type: High-pile carpet. High resistance."); break;
            default: System.out.println("Tile type: Unknown.");
        }

        System.out.println("Dirt level at current position: " + dirtLevel + "/9");
    }

    // Count obstacles on the map
    private int countObstacles() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (roomMap.isObstacle(i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    // Get the type of obstacle encountered
    private String getObstacleType(int x, int y) {
        char obstacle = roomMap.getRoomMap()[x][y].charAt(1);
        switch (obstacle) {
            case '1': return "Furniture";
            case '2': return "Charging Station";
            case '3': return "Stairs";
            default: return "No obstacle";
        }
    }

    // Get the opposite direction for wall and door checks
    private String oppositeDirection(String direction) {
        switch (direction.toLowerCase()) {
            case "up": return "down";
            case "down": return "up";
            case "left": return "right";
            case "right": return "left";
            default: return "";
        }
    }

    // Print the path pattern of the robot
    public void printPathPattern() {
        System.out.println("\nRobot Movement Path:");
        for (String[] row : path) {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
