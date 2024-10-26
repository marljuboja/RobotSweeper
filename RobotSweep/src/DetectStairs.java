public class DetectStairs {

    static String[][] floorMap = FloorPlan.getFloorPlan();
    public final static int maxIndex = 10;
    public DetectStairs() {}

    public static int[] detectStair (int currentPositionX, int currentPositionY) {

        int[] coor = new int[2];
        coor[0] = -1;
        coor[1] = -1;

        int obs = new FloorNode(floorMap[currentPositionX][currentPositionY],currentPositionX,currentPositionY).getObstacle();

        if ((currentPositionX == -1) || (currentPositionY == -1) || (currentPositionX >= maxIndex) || (currentPositionY >= maxIndex)) {
            throw new IllegalArgumentException("Cannot use coordinate out of index bounds for detecting stairs");
        }

        if (((currentPositionX + 1) < 10) && (currentPositionY < 10) && ((currentPositionX + 1) > -1) &&
                (currentPositionY > -1) &&
                (new FloorNode(floorMap[currentPositionX+1][currentPositionY],currentPositionX+1,currentPositionY).getObstacle() == 3)) {
            coor[0] = currentPositionX + 1;
            coor[1] = currentPositionY;

        } else if ((currentPositionX < 10) && ((currentPositionY + 1) < 10) && (currentPositionX > -1) &&
                ((currentPositionY + 1) > -1) &&
                (new FloorNode(floorMap[currentPositionX+1][currentPositionY],currentPositionX,currentPositionY+1).getObstacle() == 3)) {
            coor[0] = currentPositionX;
            coor[1] = currentPositionY + 1;

        } else if (((currentPositionX + 1) < 10) && ((currentPositionY + 1) < 10) && ((currentPositionX + 1) > -1) &&
                ((currentPositionY + 1) > -1) &&
                (new FloorNode(floorMap[currentPositionX+1][currentPositionY],currentPositionX+1,currentPositionY+1).getObstacle() == 3)) {
            coor[0] = currentPositionX + 1;
            coor[1] = currentPositionY + 1;

        } else if (((currentPositionX - 1) < 10) && ((currentPositionY - 1) < 10) && ((currentPositionX - 1) > -1) &&
                ((currentPositionY - 1) > -1) &&
                (new FloorNode(floorMap[currentPositionX+1][currentPositionY],currentPositionX-1,currentPositionY-1).getObstacle() == 3)) {
            coor[0] = currentPositionX - 1;
            coor[1] = currentPositionY - 1;

        } else if (((currentPositionX - 1) < 10) && (currentPositionY < 10) && ((currentPositionX - 1) > -1) &&
                (currentPositionY > -1) &&
                (new FloorNode(floorMap[currentPositionX+1][currentPositionY],currentPositionX-1,currentPositionY).getObstacle() == 3)) {
            coor[0] = currentPositionX - 1;
            coor[1] = currentPositionY;

        } else if ((currentPositionX < 10) && ((currentPositionY - 1) < 10) && (currentPositionX > -1) &&
                ((currentPositionY - 1) > -1) &&
                (new FloorNode(floorMap[currentPositionX+1][currentPositionY],currentPositionX,currentPositionY-1).getObstacle() == 3)) {
            coor[0] = currentPositionX;
            coor[1] = currentPositionY - 1;

        } else if ((currentPositionX < 10) && ((currentPositionY) < 10) && (currentPositionX > -1) &&
                ((currentPositionY) > -1) &&
                (new FloorNode(floorMap[currentPositionX+1][currentPositionY],currentPositionX,currentPositionY).getObstacle() == 3)) {
            coor[0] = currentPositionX;
            coor[1] = currentPositionY;

        } else if (((currentPositionX - 1) < 10) && ((currentPositionY + 1) < 10) && (currentPositionX > -1) &&
                ((currentPositionY + 1) > -1) &&
                (new FloorNode(floorMap[currentPositionX+1][currentPositionY],currentPositionX-1,currentPositionY+1).getObstacle() == 3)) {
            coor[0] = currentPositionX - 1;
            coor[1] = currentPositionY + 1;

        } else if (((currentPositionX + 1) < 10) && ((currentPositionY - 1) < 10) && ((currentPositionX + 1) > -1) &&
                ((currentPositionY - 1) > -1) &&
                (new FloorNode(floorMap[currentPositionX+1][currentPositionY],currentPositionX+1,currentPositionY-1).getObstacle() == 3)) {
            coor[0] = currentPositionX + 1;
            coor[1] = currentPositionY - 1;

        }
        return coor;
    }

}
