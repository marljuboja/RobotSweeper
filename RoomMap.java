import java.util.Random;
// RoomMap Class

public class RoomMap {
    private int[][] roomMap;
    private int roomSize;

    public RoomMap(int size) {
        this.roomSize = size;
        this.roomMap = generateRandomRoomMap(size);
    }

    // Generates a random room map where 0 = free space, 1 = obstacle
    private int[][] generateRandomRoomMap(int size) {
        Random rand = new Random();
        int[][] map = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = rand.nextInt(100) < 30 ? 1 : 0;
            }
        }
        return map;
    }

    public int[][] getRoomMap() {
        return roomMap;
    }

    public int getRoomSize() {
        return roomSize;
    }

    // Prints the room map to the console
    public void printRoomMap() {
        System.out.println("Generated Room Map:");
        for (int i = 0; i < roomSize; i++) {
            for (int j = 0; j < roomSize; j++) {
                System.out.print(roomMap[i][j] + " ");
            }
            System.out.println();
        }
    }
}
