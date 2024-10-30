import java.util.ArrayList;
import java.util.List;

public class DetectObstacle {

    static String[][] floorMap = FloorPlan.getFloorPlan();
    static ArrayList<int[]> list = new ArrayList<>();
    public final static int maxIndex = 10;
    public DetectObstacle () {}

    /**
     * Looks for obstacles within one tile away from current position
     * @author Marina Ljuboja
     * @param currentPositionX,currentPositionY the coordinates to the current position
     * @return array list of integer arrays with x and y coordinates of places with obstacles
     */
    public static ArrayList<int[]> detectObs (int currentPositionX, int currentPositionY) {

        int obs = new FloorNode(floorMap[currentPositionX][currentPositionY],currentPositionX,currentPositionY).getObstacle();

        if ((currentPositionX == -1) || (currentPositionY == -1) || (currentPositionX >= maxIndex) || (currentPositionY >= maxIndex)) {
            throw new IllegalArgumentException("Cannot use coordinate out of index bounds for detecting obstacle");
        }

        if (((currentPositionX + 1) < maxIndex) && (currentPositionY < maxIndex) && ((currentPositionX + 1) > -1) &&
                (currentPositionY > -1) &&
                ((new FloorNode(floorMap[currentPositionX+1][currentPositionY],currentPositionX+1,currentPositionY).getObstacle() == 1)
                        || (new FloorNode(floorMap[currentPositionX+1][currentPositionY],currentPositionX+1,currentPositionY).getObstacle() == 2)
                        || (new FloorNode(floorMap[currentPositionX+1][currentPositionY],currentPositionX+1,currentPositionY).getObstacle() == 3))) {
            int[] coor = new int[2];
            coor[0] = currentPositionX + 1;
            coor[1] = currentPositionY;
            list.add(coor);
        }
        if ((currentPositionX < maxIndex) && ((currentPositionY + 1) < maxIndex) && (currentPositionX > -1) &&
                ((currentPositionY + 1) > -1) &&
                ((new FloorNode(floorMap[currentPositionX][currentPositionY+1],currentPositionX,currentPositionY+1).getObstacle() == 1)
                        || (new FloorNode(floorMap[currentPositionX][currentPositionY+1],currentPositionX,currentPositionY+1).getObstacle() == 2)
                        || (new FloorNode(floorMap[currentPositionX][currentPositionY+1],currentPositionX,currentPositionY+1).getObstacle() == 3))) {
            int[] coor = new int[2];
            coor[0] = currentPositionX;
            coor[1] = currentPositionY + 1;
            list.add(coor);
        }
        if (((currentPositionX + 1) < maxIndex) && ((currentPositionY + 1) < maxIndex) && ((currentPositionX + 1) > -1) &&
                ((currentPositionY + 1) > -1) &&
                ((new FloorNode(floorMap[currentPositionX+1][currentPositionY+1],currentPositionX+1,currentPositionY+1).getObstacle() == 1)
                        || (new FloorNode(floorMap[currentPositionX+1][currentPositionY+1],currentPositionX+1,currentPositionY+1).getObstacle() == 2)
                        || (new FloorNode(floorMap[currentPositionX+1][currentPositionY+1],currentPositionX+1,currentPositionY+1).getObstacle() == 3))) {
            int[] coor = new int[2];
            coor[0] = currentPositionX + 1;
            coor[1] = currentPositionY + 1;
            list.add(coor);
        }
        if (((currentPositionX - 1) < maxIndex) && ((currentPositionY - 1) < maxIndex) && ((currentPositionX - 1) > -1) &&
                ((currentPositionY - 1) > -1) &&
                ((new FloorNode(floorMap[currentPositionX-1][currentPositionY-1],currentPositionX-1,currentPositionY-1).getObstacle() == 1)
                        || (new FloorNode(floorMap[currentPositionX-1][currentPositionY-1],currentPositionX-1,currentPositionY-1).getObstacle() == 2)
                        || (new FloorNode(floorMap[currentPositionX-1][currentPositionY-1],currentPositionX-1,currentPositionY-1).getObstacle() == 3))) {
            int[] coor = new int[2];
            coor[0] = currentPositionX - 1;
            coor[1] = currentPositionY - 1;
            list.add(coor);
        }
        if (((currentPositionX - 1) < maxIndex) && (currentPositionY < maxIndex) && ((currentPositionX - 1) > -1) &&
                (currentPositionY > -1) &&
                ((new FloorNode(floorMap[currentPositionX-1][currentPositionY],currentPositionX-1,currentPositionY).getObstacle() == 1)
                        || (new FloorNode(floorMap[currentPositionX-1][currentPositionY],currentPositionX-1,currentPositionY).getObstacle() == 2)
                        || (new FloorNode(floorMap[currentPositionX-1][currentPositionY],currentPositionX-1,currentPositionY).getObstacle() == 3))) {
            int[] coor = new int[2];
            coor[0] = currentPositionX - 1;
            coor[1] = currentPositionY;
            list.add(coor);
        }
        if ((currentPositionX < maxIndex) && ((currentPositionY - 1) < maxIndex) && (currentPositionX > -1) &&
                ((currentPositionY - 1) > -1) &&
                ((new FloorNode(floorMap[currentPositionX][currentPositionY-1],currentPositionX,currentPositionY-1).getObstacle() == 1)
                        || (new FloorNode(floorMap[currentPositionX][currentPositionY-1],currentPositionX,currentPositionY-1).getObstacle() == 2)
                        || (new FloorNode(floorMap[currentPositionX][currentPositionY-1],currentPositionX,currentPositionY-1).getObstacle() == 3))) {
            int[] coor = new int[2];
            coor[0] = currentPositionX;
            coor[1] = currentPositionY - 1;
            list.add(coor);
        }

        if ((currentPositionX < maxIndex) && ((currentPositionY) < maxIndex) && (currentPositionX > -1) &&
                ((currentPositionY) > -1) &&
                ((new FloorNode(floorMap[currentPositionX][currentPositionY],currentPositionX,currentPositionY).getObstacle() == 1)
                        || (new FloorNode(floorMap[currentPositionX][currentPositionY],currentPositionX,currentPositionY).getObstacle() == 2)
                        || (new FloorNode(floorMap[currentPositionX][currentPositionY],currentPositionX,currentPositionY).getObstacle() == 3))) {
            int[] coor = new int[2];
            coor[0] = currentPositionX;
            coor[1] = currentPositionY;
            list.add(coor);
        }
        if (((currentPositionX - 1) < maxIndex) && ((currentPositionY + 1) < maxIndex) && (currentPositionX > -1) &&
                ((currentPositionY + 1) > -1) &&
                ((new FloorNode(floorMap[currentPositionX-1][currentPositionY+1],currentPositionX-1,currentPositionY+1).getObstacle() == 1)
                        || (new FloorNode(floorMap[currentPositionX-1][currentPositionY+1],currentPositionX-1,currentPositionY+1).getObstacle() == 2)
                        || (new FloorNode(floorMap[currentPositionX-1][currentPositionY+1],currentPositionX-1,currentPositionY+1).getObstacle() == 3))) {
            int[] coor = new int[2];
            coor[0] = currentPositionX - 1;
            coor[1] = currentPositionY + 1;
            list.add(coor);
        }
        if (((currentPositionX + 1) < maxIndex) && ((currentPositionY - 1) < maxIndex) && ((currentPositionX + 1) > -1) &&
                ((currentPositionY - 1) > -1) &&
                ((new FloorNode(floorMap[currentPositionX+1][currentPositionY-1],currentPositionX+1,currentPositionY-1).getObstacle() == 1)
                        || (new FloorNode(floorMap[currentPositionX+1][currentPositionY-1],currentPositionX+1,currentPositionY-1).getObstacle() == 2)
                        || (new FloorNode(floorMap[currentPositionX+1][currentPositionY-1],currentPositionX+1,currentPositionY-1).getObstacle() == 3))) {
            int[] coor = new int[2];
            coor[0] = currentPositionX + 1;
            coor[1] = currentPositionY - 1;
            list.add(coor);
        }

        return list;

    }
}

