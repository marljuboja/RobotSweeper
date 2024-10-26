import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class CleaningNavigator {
    private FloorNode[][] floorPlan;
    private Set<String> cleanedTiles;
    private int startX, startY;

    // Constructor to initialize the CleaningNavigator with the floor plan, set of cleaned tiles, and starting position
    public CleaningNavigator(FloorNode[][] floorPlan, Set<String> cleanedTiles, int startX, int startY) {
        this.floorPlan = floorPlan;
        this.cleanedTiles = cleanedTiles;
        this.startX = startX;
        this.startY = startY;
    }

    // Method to move to the nearest uncleaned area using BFS
    public int[] moveToUncleanedArea() {
        boolean[][] visited = new boolean[floorPlan.length][floorPlan[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // Check if this tile is uncleaned and cleanable
            if (!cleanedTiles.contains(x + "," + y) && floorPlan[x][y].getDirt() > 0) {
                System.out.println("Moving to uncleaned area at: (" + x + ", " + y + ")");
                return new int[]{x, y};  // Return the coordinates of the uncleaned area
            }

            // Explore neighbors (up, down, left, right)
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newX < floorPlan.length && newY >= 0 && newY < floorPlan[0].length && !visited[newX][newY]) {
                    queue.offer(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }

        System.out.println("No uncleaned areas accessible.");
        return new int[]{-1, -1};  // Return -1, -1 if no uncleaned areas are found
    }
}
