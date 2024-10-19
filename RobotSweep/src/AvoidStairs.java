public class AvoidStairs {
    public AvoidStairs () {}

    public boolean avoidStairs (int currentPositionX, int currentPositionY) {
        if (((currentPositionX + 1) < 10) && (currentPositionY < 10) && ((currentPositionX + 1) > -1) &&
                (currentPositionY > -1) &&
                ((FloorPlan.floorPlan[currentPositionX + 1][currentPositionY].substring(1, 2).equals("3")))) {
            if (DetectObstacle.detectObs(currentPositionX + 1, currentPositionY) == [-1,-1]) {
                currentPositionX = currentPositionX + 1;
            }

        } else if ((currentPositionX < 10) && ((currentPositionY + 1) < 10) && (currentPositionX > -1) &&
                ((currentPositionY + 1) > -1) &&
                ((FloorPlan.floorPlan[currentPositionX][currentPositionY + 1].substring(1, 2).equals("1"))
                        || (FloorPlan.floorPlan[currentPositionX][currentPositionY + 1].substring(1, 2).equals("2"))
                        || (FloorPlan.floorPlan[currentPositionX][currentPositionY + 1].substring(1, 2).equals("3")))) {

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
