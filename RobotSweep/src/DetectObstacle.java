public class DetectObstacle {

    String[][] floorMap = FloorPlan.getFloorPlan();
    public DetectObstacle () {}

    public int[] detectObs (int currentPositionX, int currentPositionY) {
        int[] coor = new int[2];
        coor[0] = -1;
        coor[1] = -1;

        int obs = new FloorNode(floorMap[currentPositionX][currentPositionY]).getObstacle();

        if (((currentPositionX + 1) < 10) && (currentPositionY < 10) && ((currentPositionX + 1) > -1) &&
                (currentPositionY > -1) &&
                ((FloorPlan.floorPlan[currentPositionX + 1][currentPositionY].substring(1, 2).equals("1"))
                        || (FloorPlan.floorPlan[currentPositionX + 1][currentPositionY].substring(1, 2).equals("2"))
                        || (FloorPlan.floorPlan[currentPositionX + 1][currentPositionY].substring(1, 2).equals("3")))) {
            coor[0] = currentPositionX + 1;
            coor[1] = currentPositionY;
        }
        else if ((currentPositionX < 10) && ((currentPositionY + 1) < 10) && (currentPositionX > -1) &&
                ((currentPositionY + 1) > -1) &&
                ((FloorPlan.floorPlan[currentPositionX][currentPositionY + 1].substring(1, 2).equals("1"))
                        || (FloorPlan.floorPlan[currentPositionX][currentPositionY + 1].substring(1, 2).equals("2"))
                        || (FloorPlan.floorPlan[currentPositionX][currentPositionY + 1].substring(1, 2).equals("3")))) {
            coor[0] = currentPositionX;
            coor[1] = currentPositionY + 1;
        }
        else if (((currentPositionX + 1) < 10) && ((currentPositionY + 1) < 10) && ((currentPositionX + 1) > -1) &&
                ((currentPositionY + 1) > -1) &&
                ((FloorPlan.floorPlan[currentPositionX + 1][currentPositionY + 1].substring(1, 2).equals("1"))
                        || (FloorPlan.floorPlan[currentPositionX + 1][currentPositionY + 1].substring(1, 2).equals("2"))
                        || (FloorPlan.floorPlan[currentPositionX + 1][currentPositionY + 1].substring(1, 2).equals("3")))) {
            coor[0] = currentPositionX + 1;
            coor[1] = currentPositionY + 1;
        }
        else if (((currentPositionX - 1) < 10) && ((currentPositionY - 1) < 10) && ((currentPositionX - 1) > -1) &&
                ((currentPositionY - 1) > -1) &&
                ((FloorPlan.floorPlan[currentPositionX - 1][currentPositionY - 1].substring(1, 2).equals("1"))
                        || (FloorPlan.floorPlan[currentPositionX - 1][currentPositionY - 1].substring(1, 2).equals("2"))
                        || (FloorPlan.floorPlan[currentPositionX - 1][currentPositionY - 1].substring(1, 2).equals("3")))) {
            coor[0] = currentPositionX - 1;
            coor[1] = currentPositionY - 1;
        }
        else if (((currentPositionX - 1) < 10) && (currentPositionY < 10) && ((currentPositionX - 1) > -1) &&
                (currentPositionY > -1) &&
                ((FloorPlan.floorPlan[currentPositionX - 1][currentPositionY].substring(1, 2).equals("1"))
                        || (FloorPlan.floorPlan[currentPositionX - 1][currentPositionY].substring(1, 2).equals("2"))
                        || (FloorPlan.floorPlan[currentPositionX - 1][currentPositionY].substring(1, 2).equals("3")))) {
            coor[0] = currentPositionX - 1;
            coor[1] = currentPositionY;
        }
        else if ((currentPositionX < 10) && ((currentPositionY - 1) < 10) && (currentPositionX > -1) &&
                ((currentPositionY - 1) > -1) &&
                ((FloorPlan.floorPlan[currentPositionX][currentPositionY - 1].substring(1, 2).equals("1"))
                        || (FloorPlan.floorPlan[currentPositionX][currentPositionY - 1].substring(1, 2).equals("2"))
                        || (FloorPlan.floorPlan[currentPositionX][currentPositionY - 1].substring(1, 2).equals("3")))) {
            coor[0] = currentPositionX;
            coor[1] = currentPositionY - 1;
        }

        else if ((currentPositionX < 10) && ((currentPositionY) < 10) && (currentPositionX > -1) &&
                ((currentPositionY) > -1) &&
                ((FloorPlan.floorPlan[currentPositionX][currentPositionY].substring(1, 2).equals("1"))
                        || (FloorPlan.floorPlan[currentPositionX][currentPositionY].substring(1, 2).equals("2"))
                        || (FloorPlan.floorPlan[currentPositionX][currentPositionY].substring(1, 2).equals("3")))) {
            coor[0] = currentPositionX;
            coor[1] = currentPositionY;
        }
        else if (((currentPositionX - 1) < 10) && ((currentPositionY + 1) < 10) && (currentPositionX > -1) &&
                ((currentPositionY + 1) > -1) &&
                ((FloorPlan.floorPlan[currentPositionX - 1][currentPositionY + 1].substring(1, 2).equals("1"))
                        || (FloorPlan.floorPlan[currentPositionX - 1][currentPositionY + 1].substring(1, 2).equals("2"))
                        || (FloorPlan.floorPlan[currentPositionX - 1][currentPositionY + 1].substring(1, 2).equals("3")))) {
            coor[0] = currentPositionX - 1;
            coor[1] = currentPositionY + 1;
        }
        else if (((currentPositionX + 1) < 10) && ((currentPositionY - 1) < 10) && ((currentPositionX + 1) > -1) &&
                ((currentPositionY - 1) > -1) &&
                ((FloorPlan.floorPlan[currentPositionX + 1][currentPositionY - 1].substring(1, 2).equals("1"))
                        || (FloorPlan.floorPlan[currentPositionX + 1][currentPositionY - 1].substring(1, 2).equals("2"))
                        || (FloorPlan.floorPlan[currentPositionX + 1][currentPositionY - 1].substring(1, 2).equals("3")))) {
            coor[0] = currentPositionX + 1;
            coor[1] = currentPositionY - 1;
        }

            /*if (coor[0] == -1) {
                return true;
            }
            else {
                return false;
            }*/

        return coor;

    }
}

