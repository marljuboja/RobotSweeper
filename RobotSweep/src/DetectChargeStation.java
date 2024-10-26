public class DetectChargeStation {
    public final static int maxIndex = 10;
    public static String[][] floorMap = FloorPlan.getFloorPlan();
    public DetectChargeStation () {}

    public static int[] detectCS(int currentPositionX, int currentPositionY) {
        int[] coor = new int[2];
        coor[0] = -1;
        coor[1] = -1;

        int obs = new FloorNode(floorMap[currentPositionX][currentPositionY]).getObstacle();

        if ((currentPositionX == -1) || (currentPositionY == -1) || (currentPositionX >= maxIndex) || (currentPositionY >= maxIndex)) {
            throw new IllegalArgumentException("Cannot use coordinate out of index bounds for detecting charge station");
        }


            if (((currentPositionX + 1) < 10) && (currentPositionY < 10) && ((currentPositionX + 1) > -1) &&
                    (currentPositionY > -1) &&
                    (new FloorNode(floorMap[currentPositionX+1][currentPositionY]).getObstacle() == 2)) {
                coor[0] = currentPositionX + 1;
                coor[1] = currentPositionY;
            }
            else if ((currentPositionX < 10) && ((currentPositionY + 1) < 10) && (currentPositionX > -1) &&
                    ((currentPositionY + 1) > -1) &&
                    (new FloorNode(floorMap[currentPositionX][currentPositionY+1]).getObstacle() == 2)) {
                coor[0] = currentPositionX;
                coor[1] = currentPositionY + 1;
            }
            else if (((currentPositionX + 1) < 10) && ((currentPositionY + 1) < 10) && ((currentPositionX + 1) > -1) &&
                    ((currentPositionY + 1) > -1) &&
                    (new FloorNode(floorMap[currentPositionX+1][currentPositionY+1]).getObstacle() == 2)) {
                coor[0] = currentPositionX + 1;
                coor[1] = currentPositionY + 1;
            }
            else if (((currentPositionX - 1) < 10) && ((currentPositionY - 1) < 10) && ((currentPositionX - 1) > -1) &&
                    ((currentPositionY - 1) > -1) &&
                    (new FloorNode(floorMap[currentPositionX-1][currentPositionY-1]).getObstacle() == 2)) {
                coor[0] = currentPositionX - 1;
                coor[1] = currentPositionY - 1;
            }
            else if (((currentPositionX - 1) < 10) && (currentPositionY < 10) && ((currentPositionX - 1) > -1) &&
                    (currentPositionY > -1) &&
                    (new FloorNode(floorMap[currentPositionX-1][currentPositionY]).getObstacle() == 2)) {
                coor[0] = currentPositionX - 1;
                coor[1] = currentPositionY;
            }
            else if ((currentPositionX < 10) && ((currentPositionY - 1) < 10) && (currentPositionX > -1) &&
                    ((currentPositionY - 1) > -1) &&
                    (new FloorNode(floorMap[currentPositionX][currentPositionY-1]).getObstacle() == 2)) {
                coor[0] = currentPositionX;
                coor[1] = currentPositionY - 1;
            }

            else if (((currentPositionX + 2) < 10) && (currentPositionY < 10) && ((currentPositionX + 2) > -1) &&
                    (currentPositionY > -1) &&
                    (new FloorNode(floorMap[currentPositionX+2][currentPositionY]).getObstacle() == 2)) {
                coor[0] = currentPositionX + 2;
                coor[1] = currentPositionY;
            }
            else if ((currentPositionX < 10) && ((currentPositionY + 2) < 10) && (currentPositionX > -1) &&
                    ((currentPositionY + 2) > -1) &&
                    (new FloorNode(floorMap[currentPositionX][currentPositionY+2]).getObstacle() == 2)) {
                coor[0] = currentPositionX;
                coor[1] = currentPositionY + 2;
            }
            else if (((currentPositionX + 2) < 10) && ((currentPositionY + 2) < 10) && ((currentPositionX + 2) > -1) &&
                    ((currentPositionY + 2) > -1) &&
                    (new FloorNode(floorMap[currentPositionX+2][currentPositionY+2]).getObstacle() == 2)) {
                coor[0] = currentPositionX + 2;
                coor[1] = currentPositionY + 2;
            }
            else if (((currentPositionX - 2) < 10) && ((currentPositionY - 2) < 10) && ((currentPositionX - 2) > -1) &&
                    ((currentPositionY - 2) > -1) &&
                    (new FloorNode(floorMap[currentPositionX-2][currentPositionY-2]).getObstacle() == 2)) {
                coor[0] = currentPositionX - 2;
                coor[1] = currentPositionY - 2;
            }
            else if (((currentPositionX - 2) < 10) && (currentPositionY < 10) && ((currentPositionX - 2) > -1) &&
                    (currentPositionY > -1) &&
                    (new FloorNode(floorMap[currentPositionX-2][currentPositionY]).getObstacle() == 2)) {
                coor[0] = currentPositionX - 2;
                coor[1] = currentPositionY;
            }
            else if ((currentPositionX < 10) && ((currentPositionY - 2) < 10) && (currentPositionX > -1) &&
                    ((currentPositionY - 2) > -1) &&
                    (new FloorNode(floorMap[currentPositionX][currentPositionY-2]).getObstacle() == 2)) {
                coor[0] = currentPositionX;
                coor[1] = currentPositionY - 2;
            }
            else if ((currentPositionX < 10) && ((currentPositionY) < 10) && (currentPositionX > -1) &&
                    ((currentPositionY) > -1) &&
                    (new FloorNode(floorMap[currentPositionX][currentPositionY]).getObstacle() == 2)) {
                coor[0] = currentPositionX;
                coor[1] = currentPositionY;
            }
            else if (((currentPositionX - 1) < 10) && ((currentPositionY + 1) < 10) && (currentPositionX > -1) &&
                    ((currentPositionY + 1) > -1) &&
                    (new FloorNode(floorMap[currentPositionX-1][currentPositionY+1]).getObstacle() == 2)) {
                coor[0] = currentPositionX - 1;
                coor[1] = currentPositionY + 1;
            }
            else if (((currentPositionX + 1) < 10) && ((currentPositionY - 1) < 10) && ((currentPositionX + 1) > -1) &&
                    ((currentPositionY - 1) > -1) &&
                    (new FloorNode(floorMap[currentPositionX+1][currentPositionY-1]).getObstacle() == 2)) {
                coor[0] = currentPositionX + 1;
                coor[1] = currentPositionY - 1;
            }
            else if (((currentPositionX + 2) < 10) && ((currentPositionY + 1) < 10) && ((currentPositionX + 2) > -1) &&
                    ((currentPositionY + 1) > -1) &&
                    (new FloorNode(floorMap[currentPositionX+2][currentPositionY+1]).getObstacle() == 2)) {
                coor[0] = currentPositionX + 2;
                coor[1] = currentPositionY + 1;
            }
            else if (((currentPositionX + 1) < 10) && ((currentPositionY + 2) < 10) && ((currentPositionX + 1) > -1) &&
                    ((currentPositionY + 2) > -1) &&
                    (new FloorNode(floorMap[currentPositionX+1][currentPositionY+2]).getObstacle() == 2)) {
                coor[0] = currentPositionX + 1;
                coor[1] = currentPositionY + 2;
            }
            else if (((currentPositionX + 2) < 10) && ((currentPositionY - 1) < 10) && ((currentPositionX + 2) > -1) &&
                    ((currentPositionY - 1) > -1) &&
                    (new FloorNode(floorMap[currentPositionX+2][currentPositionY-1]).getObstacle() == 2)) {
                coor[0] = currentPositionX + 2;
                coor[1] = currentPositionY - 1;
            }
            else if (((currentPositionX - 2) < 10) && ((currentPositionY + 1) < 10) && ((currentPositionX - 2) > -1) &&
                    ((currentPositionY + 1) > -1) &&
                    (new FloorNode(floorMap[currentPositionX-2][currentPositionY+1]).getObstacle() == 2)) {
                coor[0] = currentPositionX - 2;
                coor[1] = currentPositionY + 1;
            }
            else if (((currentPositionX - 2) < 10) && ((currentPositionY - 1) < 10) && ((currentPositionX - 2) > -1) &&
                    ((currentPositionY - 1) > -1) &&
                    (new FloorNode(floorMap[currentPositionX-2][currentPositionY-1]).getObstacle() == 2)) {
                coor[0] = currentPositionX - 2;
                coor[1] = currentPositionY - 1;
            }
            else if (((currentPositionX + 2) < 10) && ((currentPositionY - 2) < 10) && ((currentPositionX + 2) > -1) &&
                    ((currentPositionY - 2) > -1) &&
                    (new FloorNode(floorMap[currentPositionX+2][currentPositionY-2]).getObstacle() == 2)) {
                coor[0] = currentPositionX + 2;
                coor[1] = currentPositionY - 2;
            }
            else if (((currentPositionX + 1) < 10) && ((currentPositionY - 2) < 10) && (currentPositionX > -1) &&
                    ((currentPositionY + 1) > -1) &&
                    (new FloorNode(floorMap[currentPositionX][currentPositionY+1]).getObstacle() == 2)) {
                coor[0] = currentPositionX;
                coor[1] = currentPositionY + 1;
            }
            else if (((currentPositionX - 1) < 10) && ((currentPositionY + 2) < 10) && ((currentPositionX - 1) > -1) &&
                    ((currentPositionY + 2) > -1) &&
                    (new FloorNode(floorMap[currentPositionX-1][currentPositionY+2]).getObstacle() == 2)) {
                coor[0] = currentPositionX - 1;
                coor[1] = currentPositionY + 2;
            }
            else if (((currentPositionX - 1) < 10) && ((currentPositionY - 2) < 10) && ((currentPositionX - 1) > -1) &&
                    ((currentPositionY - 2) > -1) &&
                    (new FloorNode(floorMap[currentPositionX-1][currentPositionY-2]).getObstacle() == 2)) {
                coor[0] = currentPositionX - 1;
                coor[1] = currentPositionY - 2;
            }
            else if (((currentPositionX - 2) < 10) && ((currentPositionY + 2) < 10) && ((currentPositionX - 2) > -1) &&
                    ((currentPositionY + 2) > -1) &&
                    (new FloorNode(floorMap[currentPositionX-2][currentPositionY+2]).getObstacle() == 2)) {
                coor[0] = currentPositionX - 2;
                coor[1] = currentPositionY + 2;
            }

        return coor;

    }
}
