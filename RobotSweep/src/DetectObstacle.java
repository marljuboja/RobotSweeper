import java.util.ArrayList;
import java.util.List;

public class DetectObstacle {

    static String[][] floorMap = FloorPlan.getFloorPlan();
    static ArrayList<int[]> list = new ArrayList<>();
    public DetectObstacle () {}

    public static ArrayList<int[]> detectObs (int currentPositionX, int currentPositionY) {

        int obs = new FloorNode(floorMap[currentPositionX][currentPositionY]).getObstacle();

        if (((currentPositionX + 1) < 10) && (currentPositionY < 10) && ((currentPositionX + 1) > -1) &&
                (currentPositionY > -1) &&
                ((new FloorNode(floorMap[currentPositionX+1][currentPositionY]).getObstacle() == 1)
                        || (new FloorNode(floorMap[currentPositionX+1][currentPositionY]).getObstacle() == 2)
                        || (new FloorNode(floorMap[currentPositionX+1][currentPositionY]).getObstacle() == 3))) {
            int[] coor = new int[2];
            coor[0] = currentPositionX + 1;
            coor[1] = currentPositionY;
            list.add(coor);
        }
        if ((currentPositionX < 10) && ((currentPositionY + 1) < 10) && (currentPositionX > -1) &&
                ((currentPositionY + 1) > -1) &&
                ((new FloorNode(floorMap[currentPositionX][currentPositionY+1]).getObstacle() == 1)
                        || (new FloorNode(floorMap[currentPositionX][currentPositionY+1]).getObstacle() == 2)
                        || (new FloorNode(floorMap[currentPositionX][currentPositionY+1]).getObstacle() == 3))) {
            int[] coor = new int[2];
            coor[0] = currentPositionX;
            coor[1] = currentPositionY + 1;
            list.add(coor);
        }
        if (((currentPositionX + 1) < 10) && ((currentPositionY + 1) < 10) && ((currentPositionX + 1) > -1) &&
                ((currentPositionY + 1) > -1) &&
                ((new FloorNode(floorMap[currentPositionX+1][currentPositionY+1]).getObstacle() == 1)
                        || (new FloorNode(floorMap[currentPositionX+1][currentPositionY+1]).getObstacle() == 2)
                        || (new FloorNode(floorMap[currentPositionX+1][currentPositionY+1]).getObstacle() == 3))) {
            int[] coor = new int[2];
            coor[0] = currentPositionX + 1;
            coor[1] = currentPositionY + 1;
            list.add(coor);
        }
        if (((currentPositionX - 1) < 10) && ((currentPositionY - 1) < 10) && ((currentPositionX - 1) > -1) &&
                ((currentPositionY - 1) > -1) &&
                ((new FloorNode(floorMap[currentPositionX-1][currentPositionY-1]).getObstacle() == 1)
                        || (new FloorNode(floorMap[currentPositionX-1][currentPositionY-1]).getObstacle() == 2)
                        || (new FloorNode(floorMap[currentPositionX-1][currentPositionY-1]).getObstacle() == 3))) {
            int[] coor = new int[2];
            coor[0] = currentPositionX - 1;
            coor[1] = currentPositionY - 1;
            list.add(coor);
        }
        if (((currentPositionX - 1) < 10) && (currentPositionY < 10) && ((currentPositionX - 1) > -1) &&
                (currentPositionY > -1) &&
                ((new FloorNode(floorMap[currentPositionX-1][currentPositionY]).getObstacle() == 1)
                        || (new FloorNode(floorMap[currentPositionX-1][currentPositionY]).getObstacle() == 2)
                        || (new FloorNode(floorMap[currentPositionX-1][currentPositionY]).getObstacle() == 3))) {
            int[] coor = new int[2];
            coor[0] = currentPositionX - 1;
            coor[1] = currentPositionY;
            list.add(coor);
        }
        if ((currentPositionX < 10) && ((currentPositionY - 1) < 10) && (currentPositionX > -1) &&
                ((currentPositionY - 1) > -1) &&
                ((new FloorNode(floorMap[currentPositionX][currentPositionY-1]).getObstacle() == 1)
                        || (new FloorNode(floorMap[currentPositionX][currentPositionY-1]).getObstacle() == 2)
                        || (new FloorNode(floorMap[currentPositionX][currentPositionY-1]).getObstacle() == 3))) {
            int[] coor = new int[2];
            coor[0] = currentPositionX;
            coor[1] = currentPositionY - 1;
            list.add(coor);
        }

        if ((currentPositionX < 10) && ((currentPositionY) < 10) && (currentPositionX > -1) &&
                ((currentPositionY) > -1) &&
                ((new FloorNode(floorMap[currentPositionX][currentPositionY]).getObstacle() == 1)
                        || (new FloorNode(floorMap[currentPositionX][currentPositionY]).getObstacle() == 2)
                        || (new FloorNode(floorMap[currentPositionX][currentPositionY]).getObstacle() == 3))) {
            int[] coor = new int[2];
            coor[0] = currentPositionX;
            coor[1] = currentPositionY;
            list.add(coor);
        }
        if (((currentPositionX - 1) < 10) && ((currentPositionY + 1) < 10) && (currentPositionX > -1) &&
                ((currentPositionY + 1) > -1) &&
                ((new FloorNode(floorMap[currentPositionX-1][currentPositionY+1]).getObstacle() == 1)
                        || (new FloorNode(floorMap[currentPositionX-1][currentPositionY+1]).getObstacle() == 2)
                        || (new FloorNode(floorMap[currentPositionX-1][currentPositionY+1]).getObstacle() == 3))) {
            int[] coor = new int[2];
            coor[0] = currentPositionX - 1;
            coor[1] = currentPositionY + 1;
            list.add(coor);
        }
        if (((currentPositionX + 1) < 10) && ((currentPositionY - 1) < 10) && ((currentPositionX + 1) > -1) &&
                ((currentPositionY - 1) > -1) &&
                ((new FloorNode(floorMap[currentPositionX+1][currentPositionY-1]).getObstacle() == 1)
                        || (new FloorNode(floorMap[currentPositionX+1][currentPositionY-1]).getObstacle() == 2)
                        || (new FloorNode(floorMap[currentPositionX+1][currentPositionY-1]).getObstacle() == 3))) {
            int[] coor = new int[2];
            coor[0] = currentPositionX + 1;
            coor[1] = currentPositionY - 1;
            list.add(coor);
        }

        return list;

    }
}

