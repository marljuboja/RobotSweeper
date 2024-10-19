public class AvoidStairs {

    String[][] floorMap = FloorPlan.getFloorPlan();
    public AvoidStairs () {}

    public int[] avoidStairs (int currentPositionX, int currentPositionY) {

        //int obs = new FloorNode(floorMap[currentPositionX][currentPositionY]).getObstacle();
        int[] coor = new int[2];

        if (((currentPositionX + 1) < 10) && (currentPositionY < 10) && ((currentPositionX + 1) > -1) &&
                (currentPositionY > -1) &&
                (new FloorNode(floorMap[currentPositionX+1][currentPositionY]).getObstacle() == 3)) {
            coor[0] = currentPositionX + 1;
            coor[1] = currentPositionY;

        } else if ((currentPositionX < 10) && ((currentPositionY + 1) < 10) && (currentPositionX > -1) &&
                ((currentPositionY + 1) > -1) &&
                (new FloorNode(floorMap[currentPositionX+1][currentPositionY]).getObstacle() == 3)) {
            coor[0] = currentPositionX;
            coor[1] = currentPositionY + 1;

        } else if (((currentPositionX + 1) < 10) && ((currentPositionY + 1) < 10) && ((currentPositionX + 1) > -1) &&
                ((currentPositionY + 1) > -1) &&
                (new FloorNode(floorMap[currentPositionX+1][currentPositionY]).getObstacle() == 3)) {
            coor[0] = currentPositionX + 1;
            coor[1] = currentPositionY + 1;

        } else if (((currentPositionX - 1) < 10) && ((currentPositionY - 1) < 10) && ((currentPositionX - 1) > -1) &&
                ((currentPositionY - 1) > -1) &&
                (new FloorNode(floorMap[currentPositionX+1][currentPositionY]).getObstacle() == 3)) {
            coor[0] = currentPositionX - 1;
            coor[1] = currentPositionY - 1;

        } else if (((currentPositionX - 1) < 10) && (currentPositionY < 10) && ((currentPositionX - 1) > -1) &&
                (currentPositionY > -1) &&
                (new FloorNode(floorMap[currentPositionX+1][currentPositionY]).getObstacle() == 3)) {
            coor[0] = currentPositionX - 1;
            coor[1] = currentPositionY;

        } else if ((currentPositionX < 10) && ((currentPositionY - 1) < 10) && (currentPositionX > -1) &&
                ((currentPositionY - 1) > -1) &&
                (new FloorNode(floorMap[currentPositionX+1][currentPositionY]).getObstacle() == 3)) {
            coor[0] = currentPositionX;
            coor[1] = currentPositionY - 1;

        } else if ((currentPositionX < 10) && ((currentPositionY) < 10) && (currentPositionX > -1) &&
                ((currentPositionY) > -1) &&
                (new FloorNode(floorMap[currentPositionX+1][currentPositionY]).getObstacle() == 3)) {
            coor[0] = currentPositionX;
            coor[1] = currentPositionY;

        } else if (((currentPositionX - 1) < 10) && ((currentPositionY + 1) < 10) && (currentPositionX > -1) &&
                ((currentPositionY + 1) > -1) &&
                (new FloorNode(floorMap[currentPositionX+1][currentPositionY]).getObstacle() == 3)) {
            coor[0] = currentPositionX - 1;
            coor[1] = currentPositionY + 1;

        } else if (((currentPositionX + 1) < 10) && ((currentPositionY - 1) < 10) && ((currentPositionX + 1) > -1) &&
                ((currentPositionY - 1) > -1) &&
                (new FloorNode(floorMap[currentPositionX+1][currentPositionY]).getObstacle() == 3)) {
            coor[0] = currentPositionX + 1;
            coor[1] = currentPositionY - 1;

        }
        return coor;
    }

}
