

import java.util.Objects;
import java.util.*;

public class FloorPlan {

    //Please keep in mind this is the layout of the room not what the robot has already seen
    //and taken note of
    static String[][] floorPlan;

    public FloorPlan() {
        this.floorPlan = null;
        floorPlan = new String[10][10];
    }


    //floor plan is a 10 by 10 two-dimensional array
    //each number is 4 digits representing four aspects of the tile
    //first digit is tile type; bare, low-pile, or high-pile (0,1,2)
    //second digit is obstacles; nothing, furniture, charging station, stairs  (0,1,2,3)
    //third is wall; no wall, wall up, wall down, wall left, wall right, up-down, other, left-right (0-7)
    //fourth is more door options; none, wall up-left, up-right, up-left, down-left, down-right,
    // down-left-right, up-down-right, up-down-left, up-left-right, (0-9)
    //fifth is door; no door, door open-up, door open-down, open-left, open-right, door closed-up,
    // door closed-down, closed-left, closed-right (0-8)
    //sixth is dirt; no dirt, dirt (0,1)

    //creating floor plan
    floorPlan[0][0] = "006100";
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
    floorPlan[1][1] = "004041";
    floorPlan[1][2] = "003031";
    floorPlan[1][3] = "200000";
    floorPlan[1][4] = "210000";
    floorPlan[1][5] = "210000";
    floorPlan[1][6] = "200000";
    floorPlan[1][7] = "200000";
    floorPlan[1][8] = "004041";
    floorPlan[1][9] = "007001";


    //System.out.println("The floor plan string in point(0,1) is: " + floorPlan[0][1]);


}
