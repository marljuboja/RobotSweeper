import java.util.Random;
//This class will be responsible for generating a random room layout with obstacles 
//providing methods to check for obstacles in the robot's path.
public class RoomMap {
    private int[][] roomMap;
    private int size;

    public RoomMap(int size) {
        this.size = size;
        this.roomMap = generateRandomRoomMap(size);
    }

    private int[][] generateRandomRoomMap(int size) {
        Random rand = new Random();
        int[][] map = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = rand.nextInt(100) < 30 ? 1 : 0; // 30% chance of an obstacle
            }
        }
        return map;
    }

    public int[][] getRoomMap() {
        return roomMap;
    }

    public boolean isObstacle(int x, int y) {
        if (x < 0 || x >= size || y < 0 || y >= size) {
            return true; // Out of bounds counts as obstacle
        }
        return roomMap[x][y] == 1;
    }

    public void printRoomMap() {
        System.out.println("Room Map:");
        for (int[] row : roomMap) {
            for (int cell : row) {
                System.out.print((cell == 1 ? "X" : "O") + " ");
            }
            System.out.println();
        }
    }
}
