// Updated Main.java 


public class Main {
    public static void main(String[] args) {
        RoomMap roomMap = new RoomMap();
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
