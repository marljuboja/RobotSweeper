public class DetectChargeStation {
    public final int maxIndex = 10;
    public DetectChargeStation () {}

    public static int[] detectCS (int currentPositionX, int currentPositionY) {
        int[] coor = new int[2];
        coor[0] = -1;
        coor[1] = -1;

        if (((currentPositionX+2) <= 10) && (currentPositionY <= 10) && ((currentPositionX+2) > -1) &&
                (currentPositionY > -1) &&
                ((FloorPlan.floorPlan[currentPositionX+2][currentPositionY].substring(0,1)) == "2")) {
            coor[0] = currentPositionX+2;
            coor[1] = currentPositionY;
        }
        if ((currentPositionX <= 10) && ((currentPositionY+2) <= 10) && (currentPositionX > -1) &&
                ((currentPositionY+2) > -1) &&
                ((FloorPlan.floorPlan[currentPositionX][currentPositionY+2].substring(0,1)) == "2")) {
            coor[0] = currentPositionX;
            coor[1] = currentPositionY+2;
        }
        if (((currentPositionX+2) <= 10) && ((currentPositionY+2) <= 10) && ((currentPositionX+2) > -1) &&
                ((currentPositionY+2) > -1) &&
                (FloorPlan.floorPlan[currentPositionX + 2][currentPositionY + 2].substring(0, 1).equals("2"))) {
            coor[0] = currentPositionX+2;
            coor[1] = currentPositionY+2;
        }
        if (((currentPositionX-2) <= 10) && ((currentPositionY-2) <= 10) && ((currentPositionX-2) > -1) &&
                ((currentPositionY-2) > -1) &&
                (FloorPlan.floorPlan[currentPositionX - 2][currentPositionY - 2].substring(0, 1).equals("2"))) {
            coor[0] = currentPositionX-2;
            coor[1] = currentPositionY-2;
        }
        if ( ((currentPositionX-2) <= 10) && (currentPositionY <= 10) && ((currentPositionX-2) > -1) &&
                (currentPositionY > -1) &&
                (FloorPlan.floorPlan[currentPositionX - 2][currentPositionY].substring(0, 1).equals("2"))) {
            coor[0] = currentPositionX-2;
            coor[1] = currentPositionY;
        }
        if ((currentPositionX <= 10) && ((currentPositionY-2) <= 10) && (currentPositionX > -1) &&
                ((currentPositionY-2) > -1) &&
                (FloorPlan.floorPlan[currentPositionX][currentPositionY - 2].substring(0, 1).equals("2"))) {
            coor[0] = currentPositionX;
            coor[1] = currentPositionY-2;
        }

        return coor;

    }
}
