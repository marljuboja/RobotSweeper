public class DetectChargeStation {
    public DetectChargeStation () {}

    public int[] detectCS (int currentPositionX, int currentPositionY) {
        int[] coor = new int[2];
        coor[0] = 10;
        coor[1] = 10;

        if ((FloorPlan.floorPlan[currentPositionX+1][currentPositionY].substring(1,1)) == "2") {
            coor[0] = currentPositionX+1;
            coor[1] = currentPositionY;
        }
        if ((FloorPlan.floorPlan[currentPositionX][currentPositionY+1].substring(1,1)) == "2") {
            coor[0] = currentPositionX;
            coor[1] = currentPositionY+1;
        }
        if ((FloorPlan.floorPlan[currentPositionX+1][currentPositionY+1].substring(1,1)) == "2") {
            coor[0] = currentPositionX+1;
            coor[1] = currentPositionY+1;
        }
        if ((FloorPlan.floorPlan[currentPositionX-1][currentPositionY-1].substring(1,1)) == "2") {
            coor[0] = currentPositionX-1;
            coor[1] = currentPositionY-1;
        }
        if ((FloorPlan.floorPlan[currentPositionX-1][currentPositionY].substring(1,1)) == "2") {
            coor[0] = currentPositionX-1;
            coor[1] = currentPositionY;
        }
        if ((FloorPlan.floorPlan[currentPositionX][currentPositionY-1].substring(1,1)) == "2") {
            coor[0] = currentPositionX;
            coor[1] = currentPositionY-1;
        }

        if ((FloorPlan.floorPlan[currentPositionX+2][currentPositionY].substring(1,1)) == "2") {
            coor[0] = currentPositionX+2;
            coor[1] = currentPositionY;
        }
        if ((FloorPlan.floorPlan[currentPositionX][currentPositionY+2].substring(1,1)) == "2") {
            coor[0] = currentPositionX;
            coor[1] = currentPositionY+2;
        }
        if ((FloorPlan.floorPlan[currentPositionX+2][currentPositionY+2].substring(1,1)) == "2") {
            coor[0] = currentPositionX+2;
            coor[1] = currentPositionY+2;
        }
        if ((FloorPlan.floorPlan[currentPositionX-2][currentPositionY-2].substring(1,1)) == "2") {
            coor[0] = currentPositionX-2;
            coor[1] = currentPositionY-2;
        }
        if ((FloorPlan.floorPlan[currentPositionX-2][currentPositionY].substring(1,1)) == "2") {
            coor[0] = currentPositionX-2;
            coor[1] = currentPositionY;
        }
        if ((FloorPlan.floorPlan[currentPositionX][currentPositionY-2].substring(1,1)) == "2") {
            coor[0] = currentPositionX;
            coor[1] = currentPositionY-2;
        }

        //if array has 10's then no charging station was found
        return coor;

    }
}
