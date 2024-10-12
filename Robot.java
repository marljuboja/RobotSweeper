import java.util.Random;
// Robot Class
public class Robot {
    private int x;
    private int y;
    private RoomMap roomMap;

    // Constructor that places the robot at a random free space
    public Robot(RoomMap roomMap) {
        this.roomMap = roomMap;
        Random rand = new Random();
        int size = roomMap.getRoomSize();
        int[][] map = roomMap.getRoomMap();

        do {
            this.x = rand.nextInt(size);
            this.y = rand.nextInt(size);
        } while (map[x][y] == 1);  // Ensure robot starts in a free space
    }

    public void checkObstacles() {
        System.out.println("Robot Position: (" + x + ", " + y + ")");
        int[][] map = roomMap.getRoomMap();
        int size = roomMap.getRoomSize();

        if (map[x][y] == 1) {
            System.out.println("Warning: Robot is positioned on an obstacle!");
        } else {
            System.out.println("No obstacle at the robot's current position.");
        }

        if (x > 0 && map[x - 1][y] == 1) System.out.println("Obstacle detected above.");
        if (x < size - 1 && map[x + 1][y] == 1) System.out.println("Obstacle detected below.");
        if (y > 0 && map[x][y - 1] == 1) System.out.println("Obstacle detected to the left.");
        if (y < size - 1 && map[x][y + 1] == 1) System.out.println("Obstacle detected to the right.");
    }

    public void move() {
        int[][] map = roomMap.getRoomMap();
        int size = roomMap.getRoomSize();

        System.out.println("Attempting to move Robot at: (" + x + ", " + y + ")");
        
        if (x < size - 1 && map[x + 1][y] == 0) {
            x++;
            System.out.println("Moved down to: (" + x + ", " + y + ")");
        } else if (x > 0 && map[x - 1][y] == 0) {
            x--;
            System.out.println("Moved up to: (" + x + ", " + y + ")");
        } else if (y < size - 1 && map[x][y + 1] == 0) {
            y++;
            System.out.println("Moved right to: (" + x + ", " + y + ")");
        } else if (y > 0 && map[x][y - 1] == 0) {
            y--;
            System.out.println("Moved left to: (" + x + ", " + y + ")");
        } else {
            System.out.println("No available move. Robot is surrounded by obstacles.");
        }
    }
}
