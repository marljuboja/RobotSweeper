public class AvoidStairs {

    String[][] floorMap = FloorPlan.getFloorPlan();
    public AvoidStairs () {}

    public boolean avoidStairs (int currentPositionX, int currentPositionY) {

        int obs = new FloorNode(floorMap[currentPositionX][currentPositionY]).getObstacle();

        if (((currentPositionX + 1) < 10) && (currentPositionY < 10) && ((currentPositionX + 1) > -1) &&
                (currentPositionY > -1) &&
                (obs == 3)) {
            int obs1 = new FloorNode(floorMap[currentPositionX + 1][currentPositionY]).getObstacle();

            if (obs1 == 0) {
                currentPositionX = currentPositionX + 1;
            }

        } else if ((currentPositionX < 10) && ((currentPositionY + 1) < 10) && (currentPositionX > -1) &&
                ((currentPositionY + 1) > -1) &&
                (obs == 3)) {

        } else if (((currentPositionX + 1) < 10) && ((currentPositionY + 1) < 10) && ((currentPositionX + 1) > -1) &&
                ((currentPositionY + 1) > -1) &&
                ((FloorPlan.floorPlan[currentPositionX + 1][currentPositionY + 1].substring(1, 2).equals("1"))
                        || (FloorPlan.floorPlan[currentPositionX + 1][currentPositionY + 1].substring(1, 2).equals("2"))
                        || (FloorPlan.floorPlan[currentPositionX + 1][currentPositionY + 1].substring(1, 2).equals("3")))) {

        } else if (((currentPositionX - 1) < 10) && ((currentPositionY - 1) < 10) && ((currentPositionX - 1) > -1) &&
                ((currentPositionY - 1) > -1) &&
                ((FloorPlan.floorPlan[currentPositionX - 1][currentPositionY - 1].substring(1, 2).equals("1"))
                        || (FloorPlan.floorPlan[currentPositionX - 1][currentPositionY - 1].substring(1, 2).equals("2"))
                        || (FloorPlan.floorPlan[currentPositionX - 1][currentPositionY - 1].substring(1, 2).equals("3")))) {

        } else if (((currentPositionX - 1) < 10) && (currentPositionY < 10) && ((currentPositionX - 1) > -1) &&
                (currentPositionY > -1) &&
                ((FloorPlan.floorPlan[currentPositionX - 1][currentPositionY].substring(1, 2).equals("1"))
                        || (FloorPlan.floorPlan[currentPositionX - 1][currentPositionY].substring(1, 2).equals("2"))
                        || (FloorPlan.floorPlan[currentPositionX - 1][currentPositionY].substring(1, 2).equals("3")))) {

        } else if ((currentPositionX < 10) && ((currentPositionY - 1) < 10) && (currentPositionX > -1) &&
                ((currentPositionY - 1) > -1) &&
                ((FloorPlan.floorPlan[currentPositionX][currentPositionY - 1].substring(1, 2).equals("1"))
                        || (FloorPlan.floorPlan[currentPositionX][currentPositionY - 1].substring(1, 2).equals("2"))
                        || (FloorPlan.floorPlan[currentPositionX][currentPositionY - 1].substring(1, 2).equals("3")))) {

        } else if ((currentPositionX < 10) && ((currentPositionY) < 10) && (currentPositionX > -1) &&
                ((currentPositionY) > -1) &&
                ((FloorPlan.floorPlan[currentPositionX][currentPositionY].substring(1, 2).equals("1"))
                        || (FloorPlan.floorPlan[currentPositionX][currentPositionY].substring(1, 2).equals("2"))
                        || (FloorPlan.floorPlan[currentPositionX][currentPositionY].substring(1, 2).equals("3")))) {

        } else if (((currentPositionX - 1) < 10) && ((currentPositionY + 1) < 10) && (currentPositionX > -1) &&
                ((currentPositionY + 1) > -1) &&
                ((FloorPlan.floorPlan[currentPositionX - 1][currentPositionY + 1].substring(1, 2).equals("1"))
                        || (FloorPlan.floorPlan[currentPositionX - 1][currentPositionY + 1].substring(1, 2).equals("2"))
                        || (FloorPlan.floorPlan[currentPositionX - 1][currentPositionY + 1].substring(1, 2).equals("3")))) {

        } else if (((currentPositionX + 1) < 10) && ((currentPositionY - 1) < 10) && ((currentPositionX + 1) > -1) &&
                ((currentPositionY - 1) > -1) &&
                ((FloorPlan.floorPlan[currentPositionX + 1][currentPositionY - 1].substring(1, 2).equals("1"))
                        || (FloorPlan.floorPlan[currentPositionX + 1][currentPositionY - 1].substring(1, 2).equals("2"))
                        || (FloorPlan.floorPlan[currentPositionX + 1][currentPositionY - 1].substring(1, 2).equals("3")))) {

        }
        return true;
    }

}
