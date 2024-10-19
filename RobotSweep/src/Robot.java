// Updated Robot.java to be compatible with FloorPlan


import java.util.Random;

public class Robot {
    private int x, y;
    private RoomMap roomMap;

    public Robot(RoomMap roomMap) {
        this.roomMap = roomMap;
        placeRobot();
    }

    private void placeRobot() {
        Random rand = new Random();
        int size = roomMap.getRoomMap().length;
        do {
            x = rand.nextInt(size);
            y = rand.nextInt(size);
        } while (roomMap.isObstacle(x, y));
        System.out.println("Robot placed at: (" + x + ", " + y + ")");
    }

    public void checkAndMove(String direction) {
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
                System.out.println("Unknown direction!");
                return;
        }

        if (!roomMap.isObstacle(newX, newY)) {
            x = newX;
            y = newY;
            System.out.println("Moved " + direction + " to (" + x + ", " + y + ")");
        } else {
            System.out.println("Obstacle detected in the " + direction + " direction. Staying at (" + x + ", " + y + ")");
        }
    }

    public void printPosition() {
        System.out.println("Robot is currently at: (" + x + ", " + y + ")");
    }
}
