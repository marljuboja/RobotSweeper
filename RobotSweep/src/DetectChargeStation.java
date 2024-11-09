public class DetectChargeStation {
    /*public final static int maxIndex = 10;
    public static String[][] floorMap = FloorPlan.getFloorPlan();
    public DetectChargeStation () {}

    *//**
     * Looks for charging station within two tiles away from current position
     * @author Marina Ljuboja
     * @param currentPositionX,currentPositionY the coordinates to the current position
     * @return integer array with x and y coordinates of place with charging station
     *//*
    public static int[] detectCS(int currentPositionX, int currentPositionY) {
        int[] coor = new int[2];
        coor[0] = -1;
        coor[1] = -1;

        int obs = new FloorNode(floorMap[currentPositionX][currentPositionY], currentPositionX,currentPositionY).getObstacle();

        if ((currentPositionX == -1) || (currentPositionY == -1) || (currentPositionX >= maxIndex) || (currentPositionY >= maxIndex)) {
            throw new IllegalArgumentException("Cannot use coordinate out of index bounds for detecting charge station");
        }


            if (((currentPositionX + 1) < maxIndex) && (currentPositionY < maxIndex) && ((currentPositionX + 1) > -1) &&
                    (currentPositionY > -1) &&
                    (new FloorNode(floorMap[currentPositionX+1][currentPositionY],currentPositionX+1,currentPositionY).getObstacle() == 2)) {
                coor[0] = currentPositionX + 1;
                coor[1] = currentPositionY;
            }
            else if ((currentPositionX < maxIndex) && ((currentPositionY + 1) < maxIndex) && (currentPositionX > -1) &&
                    ((currentPositionY + 1) > -1) &&
                    (new FloorNode(floorMap[currentPositionX][currentPositionY+1],currentPositionX,currentPositionY+1).getObstacle() == 2)) {
                coor[0] = currentPositionX;
                coor[1] = currentPositionY + 1;
            }
            else if (((currentPositionX + 1) < maxIndex) && ((currentPositionY + 1) < maxIndex) && ((currentPositionX + 1) > -1) &&
                    ((currentPositionY + 1) > -1) &&
                    (new FloorNode(floorMap[currentPositionX+1][currentPositionY+1],currentPositionX+1,currentPositionY+1).getObstacle() == 2)) {
                coor[0] = currentPositionX + 1;
                coor[1] = currentPositionY + 1;
            }
            else if (((currentPositionX - 1) < maxIndex) && ((currentPositionY - 1) < maxIndex) && ((currentPositionX - 1) > -1) &&
                    ((currentPositionY - 1) > -1) &&
                    (new FloorNode(floorMap[currentPositionX-1][currentPositionY-1],currentPositionX+1,currentPositionY+1).getObstacle() == 2)) {
                coor[0] = currentPositionX - 1;
                coor[1] = currentPositionY - 1;
            }
            else if (((currentPositionX - 1) < maxIndex) && (currentPositionY < maxIndex) && ((currentPositionX - 1) > -1) &&
                    (currentPositionY > -1) &&
                    (new FloorNode(floorMap[currentPositionX-1][currentPositionY],currentPositionX-1,currentPositionY).getObstacle() == 2)) {
                coor[0] = currentPositionX - 1;
                coor[1] = currentPositionY;
            }
            else if ((currentPositionX < maxIndex) && ((currentPositionY - 1) < maxIndex) && (currentPositionX > -1) &&
                    ((currentPositionY - 1) > -1) &&
                    (new FloorNode(floorMap[currentPositionX][currentPositionY-1],currentPositionX,currentPositionY-1).getObstacle() == 2)) {
                coor[0] = currentPositionX;
                coor[1] = currentPositionY - 1;
            }

            else if (((currentPositionX + 2) < maxIndex) && (currentPositionY < maxIndex) && ((currentPositionX + 2) > -1) &&
                    (currentPositionY > -1) &&
                    (new FloorNode(floorMap[currentPositionX+2][currentPositionY],currentPositionX+2,currentPositionY).getObstacle() == 2)) {
                coor[0] = currentPositionX + 2;
                coor[1] = currentPositionY;
            }
            else if ((currentPositionX < maxIndex) && ((currentPositionY + 2) < maxIndex) && (currentPositionX > -1) &&
                    ((currentPositionY + 2) > -1) &&
                    (new FloorNode(floorMap[currentPositionX][currentPositionY+2],currentPositionX,currentPositionY+2).getObstacle() == 2)) {
                coor[0] = currentPositionX;
                coor[1] = currentPositionY + 2;
            }
            else if (((currentPositionX + 2) < maxIndex) && ((currentPositionY + 2) < maxIndex) && ((currentPositionX + 2) > -1) &&
                    ((currentPositionY + 2) > -1) &&
                    (new FloorNode(floorMap[currentPositionX+2][currentPositionY+2],currentPositionX+2,currentPositionY+2).getObstacle() == 2)) {
                coor[0] = currentPositionX + 2;
                coor[1] = currentPositionY + 2;
            }
            else if (((currentPositionX - 2) < maxIndex) && ((currentPositionY - 2) < maxIndex) && ((currentPositionX - 2) > -1) &&
                    ((currentPositionY - 2) > -1) &&
                    (new FloorNode(floorMap[currentPositionX-2][currentPositionY-2],currentPositionX-2,currentPositionY-2).getObstacle() == 2)) {
                coor[0] = currentPositionX - 2;
                coor[1] = currentPositionY - 2;
            }
            else if (((currentPositionX - 2) < maxIndex) && (currentPositionY < maxIndex) && ((currentPositionX - 2) > -1) &&
                    (currentPositionY > -1) &&
                    (new FloorNode(floorMap[currentPositionX-2][currentPositionY],currentPositionX-2,currentPositionY).getObstacle() == 2)) {
                coor[0] = currentPositionX - 2;
                coor[1] = currentPositionY;
            }
            else if ((currentPositionX < maxIndex) && ((currentPositionY - 2) < maxIndex) && (currentPositionX > -1) &&
                    ((currentPositionY - 2) > -1) &&
                    (new FloorNode(floorMap[currentPositionX][currentPositionY-2],currentPositionX,currentPositionY-2).getObstacle() == 2)) {
                coor[0] = currentPositionX;
                coor[1] = currentPositionY - 2;
            }
            else if ((currentPositionX < maxIndex) && ((currentPositionY) < maxIndex) && (currentPositionX > -1) &&
                    ((currentPositionY) > -1) &&
                    (new FloorNode(floorMap[currentPositionX][currentPositionY],currentPositionX,currentPositionY).getObstacle() == 2)) {
                coor[0] = currentPositionX;
                coor[1] = currentPositionY;
            }
            else if (((currentPositionX - 1) < maxIndex) && ((currentPositionY + 1) < maxIndex) && (currentPositionX > -1) &&
                    ((currentPositionY + 1) > -1) &&
                    (new FloorNode(floorMap[currentPositionX-1][currentPositionY+1],currentPositionX-1,currentPositionY+1).getObstacle() == 2)) {
                coor[0] = currentPositionX - 1;
                coor[1] = currentPositionY + 1;
            }
            else if (((currentPositionX + 1) < maxIndex) && ((currentPositionY - 1) < maxIndex) && ((currentPositionX + 1) > -1) &&
                    ((currentPositionY - 1) > -1) &&
                    (new FloorNode(floorMap[currentPositionX+1][currentPositionY-1],currentPositionX-1,currentPositionY+1).getObstacle() == 2)) {
                coor[0] = currentPositionX + 1;
                coor[1] = currentPositionY - 1;
            }
            else if (((currentPositionX + 2) < maxIndex) && ((currentPositionY + 1) < maxIndex) && ((currentPositionX + 2) > -1) &&
                    ((currentPositionY + 1) > -1) &&
                    (new FloorNode(floorMap[currentPositionX+2][currentPositionY+1],currentPositionX+2,currentPositionY+1).getObstacle() == 2)) {
                coor[0] = currentPositionX + 2;
                coor[1] = currentPositionY + 1;
            }
            else if (((currentPositionX + 1) < maxIndex) && ((currentPositionY + 2) < maxIndex) && ((currentPositionX + 1) > -1) &&
                    ((currentPositionY + 2) > -1) &&
                    (new FloorNode(floorMap[currentPositionX+1][currentPositionY+2],currentPositionX+1,currentPositionY+2).getObstacle() == 2)) {
                coor[0] = currentPositionX + 1;
                coor[1] = currentPositionY + 2;
            }
            else if (((currentPositionX + 2) < maxIndex) && ((currentPositionY - 1) < maxIndex) && ((currentPositionX + 2) > -1) &&
                    ((currentPositionY - 1) > -1) &&
                    (new FloorNode(floorMap[currentPositionX+2][currentPositionY-1],currentPositionX+2,currentPositionY-1).getObstacle() == 2)) {
                coor[0] = currentPositionX + 2;
                coor[1] = currentPositionY - 1;
            }
            else if (((currentPositionX - 2) < maxIndex) && ((currentPositionY + 1) < maxIndex) && ((currentPositionX - 2) > -1) &&
                    ((currentPositionY + 1) > -1) &&
                    (new FloorNode(floorMap[currentPositionX-2][currentPositionY+1],currentPositionX-2,currentPositionY+1).getObstacle() == 2)) {
                coor[0] = currentPositionX - 2;
                coor[1] = currentPositionY + 1;
            }
            else if (((currentPositionX - 2) < maxIndex) && ((currentPositionY - 1) < maxIndex) && ((currentPositionX - 2) > -1) &&
                    ((currentPositionY - 1) > -1) &&
                    (new FloorNode(floorMap[currentPositionX-2][currentPositionY-1],currentPositionX-2,currentPositionY-1).getObstacle() == 2)) {
                coor[0] = currentPositionX - 2;
                coor[1] = currentPositionY - 1;
            }
            else if (((currentPositionX + 2) < maxIndex) && ((currentPositionY - 2) < maxIndex) && ((currentPositionX + 2) > -1) &&
                    ((currentPositionY - 2) > -1) &&
                    (new FloorNode(floorMap[currentPositionX+2][currentPositionY-2],currentPositionX+2,currentPositionY-2).getObstacle() == 2)) {
                coor[0] = currentPositionX + 2;
                coor[1] = currentPositionY - 2;
            }
            else if (((currentPositionX + 1) < maxIndex) && ((currentPositionY - 2) < maxIndex) && (currentPositionX > -1) &&
                    ((currentPositionY + 1) > -1) &&
                    (new FloorNode(floorMap[currentPositionX][currentPositionY+1],currentPositionX+1,currentPositionY-2).getObstacle() == 2)) {
                coor[0] = currentPositionX;
                coor[1] = currentPositionY + 1;
            }
            else if (((currentPositionX - 1) < maxIndex) && ((currentPositionY + 2) < maxIndex) && ((currentPositionX - 1) > -1) &&
                    ((currentPositionY + 2) > -1) &&
                    (new FloorNode(floorMap[currentPositionX-1][currentPositionY+2],currentPositionX-1,currentPositionY+2).getObstacle() == 2)) {
                coor[0] = currentPositionX - 1;
                coor[1] = currentPositionY + 2;
            }
            else if (((currentPositionX - 1) < maxIndex) && ((currentPositionY - 2) < maxIndex) && ((currentPositionX - 1) > -1) &&
                    ((currentPositionY - 2) > -1) &&
                    (new FloorNode(floorMap[currentPositionX-1][currentPositionY-2],currentPositionX-1,currentPositionY-2).getObstacle() == 2)) {
                coor[0] = currentPositionX - 1;
                coor[1] = currentPositionY - 2;
            }
            else if (((currentPositionX - 2) < maxIndex) && ((currentPositionY + 2) < maxIndex) && ((currentPositionX - 2) > -1) &&
                    ((currentPositionY + 2) > -1) &&
                    (new FloorNode(floorMap[currentPositionX-2][currentPositionY+2],currentPositionX-2,currentPositionY+2).getObstacle() == 2)) {
                coor[0] = currentPositionX - 2;
                coor[1] = currentPositionY + 2;
            }

        return coor;

    }*/
}
