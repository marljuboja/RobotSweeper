

import java.util.Objects;
import java.util.*;

public class FloorPlan {

    //Please keep in mind this is the layout of the room not what the robot has already seen
    //and taken note of
    static String[][] floorPlan = new String[10][10];;


    public FloorPlan() {
        //this.floorPlan = null;
    }

    public static String[][] getFloorPlan() {
        floorPlan[0][0] = "00100100010";
        floorPlan[0][1] = "001000";
        floorPlan[0][2] = "006100";
        floorPlan[0][3] = "001000";
        floorPlan[0][4] = "001100";
        floorPlan[0][5] = "001100";
        floorPlan[0][6] = "001100";
        floorPlan[0][7] = "001000";
        floorPlan[0][8] = "006200";
        floorPlan[0][9] = "006900";

        floorPlan[1][0] = "003000";
        floorPlan[1][1] = "004049";
        floorPlan[1][2] = "003039";
        floorPlan[1][3] = "200000";
        floorPlan[1][4] = "210000";
        floorPlan[1][5] = "210000";
        floorPlan[1][6] = "200000";
        floorPlan[1][7] = "200000";
        floorPlan[1][8] = "004049";
        floorPlan[1][9] = "007009";

        return floorPlan;
    }


    //floor plan is a 10 by 10 two-dimensional array
    //each number is 4 digits representing four aspects of the tile
    //first digit is tile type; bare, low-pile, or high-pile (0,1,2)
    //second digit is obstacles; nothing, furniture, charging station, stairs  (0,1,2,3)
    //third, fourth, fifth, sixth; is position of wall N,S,E,W
    //seventh, eighth, ninth, tenth; is door position, N,S,E,W with 0 -no door, 1- open door, 2- closed door
    //eleventh is amount of dirt with 0- no dirt; (0-9)

    //creating floor plan




    //System.out.println("The floor plan string in point(0,1) is: " + floorPlan[0][1]);


}
