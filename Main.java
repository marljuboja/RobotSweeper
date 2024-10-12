//Main Class

public class Main {
    public static void main(String[] args) {
        int roomSize = 5;  // Define the size of the room
        RoomMap roomMap = new RoomMap(roomSize);

        // Print the generated room map
        roomMap.printRoomMap();

        // Create multiple robots
        Robot robot1 = new Robot(roomMap);
        Robot robot2 = new Robot(roomMap);

        // Each robot checks for obstacles and moves
        System.out.println("\nRobot 1:");
        robot1.checkObstacles();
        robot1.move();

        System.out.println("\nRobot 2:");
        robot2.checkObstacles();
        robot2.move();
    }
}
