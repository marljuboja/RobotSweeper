// This class ties everything together
// creating a room map and a robot
// running the obstacle check-and-move feature.
public class Main {
    public static void main(String[] args) {
        int roomSize = 5;
        RoomMap roomMap = new RoomMap(roomSize);
        Robot robot = new Robot(roomMap);

        roomMap.printRoomMap();
        System.out.println();

        // Sample movements
        robot.printPosition();
        robot.checkAndMove("up");
        robot.checkAndMove("right");
        robot.checkAndMove("down");
        robot.checkAndMove("left");
    }
}
