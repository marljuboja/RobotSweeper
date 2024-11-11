import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Initialize RoomMap: Creates a RoomMap instance to set up the room environment.
        RoomMap roomMap = new RoomMap();
        
        // Initialize RobotMovement: Creates a RobotMovement instance, which places the robot in a random start position.
        RobotMovement robotMovement = new RobotMovement(roomMap);

        // Start exploring the room with DFS movement
        robotMovement.exploreRoom();

        
    }
}