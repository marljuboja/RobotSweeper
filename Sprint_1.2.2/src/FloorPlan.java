

import java.util.Objects;
import java.util.*;

public class FloorPlan {

    //Please keep in mind this is the layout of the room not what the robot has already seen
    //and taken note of
    static String[][] floorPlan = new String[10][10];;

    public FloorPlan() {
    }

    //floor plan is a 10 by 10 two-dimensional array
    //each number is 4 digits representing four aspects of the tile
    //first digit is tile type; bare, low-pile, or high-pile (0,1,2)
    //second digit is obstacles; nothing, furniture, charging station, stairs  (0,1,2,3)
    //third, fourth, fifth, sixth; is position of wall N,S,E,W
    //seventh, eighth, ninth, tenth; is door position, N,S,E,W with 0 -no door, 1- open door, 2- closed door
    //eleventh is amount of dirt with 0- no dirt; (0-9)

    //creating floor plan

    public static String[][] getFloorPlan() {
        floorPlan[0][0] = "00100100000";
        floorPlan[0][1] = "00101000000";
        floorPlan[0][2] = "00100100000";
        floorPlan[0][3] = "00100000000";
        floorPlan[0][4] = "00110000000";
        floorPlan[0][5] = "00110000000";
        floorPlan[0][6] = "00110000000";
        floorPlan[0][7] = "00100000000";
        floorPlan[0][8] = "00101000000";
        floorPlan[0][9] = "00101100000";

        floorPlan[1][0] = "00000100000";
        floorPlan[1][1] = "00001000109";
        floorPlan[1][2] = "00001000109";
        floorPlan[1][3] = "20000000000";
        floorPlan[1][4] = "21000000000";
        floorPlan[1][5] = "21000000000";
        floorPlan[1][6] = "20000000000";
        floorPlan[1][7] = "20000000000";
        floorPlan[1][8] = "00010000009";
        floorPlan[1][9] = "00011000009";

        floorPlan[2][0] = "00010100000";
        floorPlan[2][1] = "00011000009";
        floorPlan[2][2] = "00000100009";
        floorPlan[2][3] = "20000000000";
        floorPlan[2][4] = "20000000009";
        floorPlan[2][5] = "20000000009";
        floorPlan[2][6] = "20000000000";
        floorPlan[2][7] = "20000000000";
        floorPlan[2][8] = "00001000109";
        floorPlan[2][9] = "00001100019";

        floorPlan[3][0] = "00110100000";
        floorPlan[3][1] = "00110000000";
        floorPlan[3][2] = "00010000000";
        floorPlan[3][3] = "00010000009";
        floorPlan[3][4] = "00010001009";
        floorPlan[3][5] = "00010000009";
        floorPlan[3][6] = "00010000000";
        floorPlan[3][7] = "00010000000";
        floorPlan[3][8] = "00011000009";
        floorPlan[3][9] = "00011100000";

        floorPlan[4][0] = "00110100000";
        floorPlan[4][1] = "00110000009";
        floorPlan[4][2] = "00110001009";
        floorPlan[4][3] = "00111000000";
        floorPlan[4][4] = "00101110000";
        floorPlan[4][5] = "00101100009";
        floorPlan[4][6] = "00101100000";
        floorPlan[4][7] = "10100100009";
        floorPlan[4][8] = "10100000000";
        floorPlan[4][9] = "10101000000";

        floorPlan[5][0] = "11100100000";
        floorPlan[5][1] = "10100000000";
        floorPlan[5][2] = "10100010009";
        floorPlan[5][3] = "10101000109";
        floorPlan[5][4] = "00001100010";
        floorPlan[5][5] = "00011101009";
        floorPlan[5][6] = "00011100100";
        floorPlan[5][7] = "10000100019";
        floorPlan[5][8] = "10000000000";
        floorPlan[5][9] = "10001000000";

        floorPlan[6][0] = "11000100000";
        floorPlan[6][1] = "11000000000";
        floorPlan[6][2] = "10000000009";
        floorPlan[6][3] = "10001000009";
        floorPlan[6][4] = "00000100009";
        floorPlan[6][5] = "00101010009";
        floorPlan[6][6] = "00101100000";
        floorPlan[6][7] = "10000100000";
        floorPlan[6][8] = "11000000000";
        floorPlan[6][9] = "11001000000";

        floorPlan[7][0] = "11000100000";
        floorPlan[7][1] = "11000000000";
        floorPlan[7][2] = "10000000000";
        floorPlan[7][3] = "10001000000";
        floorPlan[7][4] = "00000100009";
        floorPlan[7][5] = "00001000109";
        floorPlan[7][6] = "00011100019";
        floorPlan[7][7] = "10000100000";
        floorPlan[7][8] = "11000000000";
        floorPlan[7][9] = "11001000000";

        floorPlan[8][0] = "10000100009";
        floorPlan[8][1] = "10000000009";
        floorPlan[8][2] = "10000000009";
        floorPlan[8][3] = "10001000000";
        floorPlan[8][4] = "00000100009";
        floorPlan[8][5] = "00001000109";
        floorPlan[8][6] = "10100100019";
        floorPlan[8][7] = "10000000009";
        floorPlan[8][8] = "10000000000";
        floorPlan[8][9] = "11001000000";

        floorPlan[9][0] = "12010100000";
        floorPlan[9][1] = "10010000009";
        floorPlan[9][2] = "10010000009";
        floorPlan[9][3] = "10011000000";
        floorPlan[9][4] = "03000100000";
        floorPlan[9][5] = "00011000009";
        floorPlan[9][6] = "10010100009";
        floorPlan[9][7] = "10010000009";
        floorPlan[9][8] = "10010000000";
        floorPlan[9][9] = "10011000000";

        return floorPlan;
    }


}