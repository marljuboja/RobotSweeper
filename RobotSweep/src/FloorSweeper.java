import java.util.ArrayList;

public class FloorSweeper {

    //The floor plan that the robot learns as it moves
    private FloorNode[][] learnedFloorPlan;

    //The complete floor plan given to the robot to navigate
    //!!!!!!!!!!!!!!!
    //THE ROBOT CANNOT SEARCH THIS FLOOR PLAN EXCEPT FOR ITS IMMEDIATE SURROUNDINGS!!
    //DO NOT CHANGE THE ASSIGNED FLOORPLAN
    //!!!!!!!!!!!!!!!!!
    private final String[][] assignedFloorPlan;

    //Robot's remaining battery
    private int charge;

    //How much dirt the robot is currently holding
    private int dirt;

    //The maximum dirt the robot can hold
    private final int DIRT_CAPACITY = 50;

    //Threshold at which Robot will be forced to return to charging station
    private final int MIN_ALLOWED_CHARGE = 15;

    //Robot's x and y positions, respectively
    private int posX;
    private int posY;

    //True if returning to charging station, false if cleaning
    private boolean returning;

    //Constructor for robot
    //Takes floorplan and stores locally, but only accesses entries immediately surrounding its current position
    public FloorSweeper(String[][] floorplan){
        learnedFloorPlan = new FloorNode[10][10];
        assignedFloorPlan = floorplan;
        charge = 100;
        //Add starting tile to learned floormap
        learnedFloorPlan[posX][posY] = new FloorNode(assignedFloorPlan[posX][posY], posX, posY);
        returning = false;
    }

    //Returns battery charge level of robot
    public int getCharge(){
        return charge;
    }
    
    //Returns amount of dirt stored in robot
    public int getDirtLevel(){
        return dirt;
    }

    //Observes tiles in cardinal directions relative to current position
    //Useful for quickly mapping to memory after moving
    public void scanSurroundings(){
        lookNorth();
        lookSouth();
        lookEast();
        lookWest();
    }

    //Returns FloorNode at current position
    public FloorNode currentPosition(){
        return learnedFloorPlan[posX][posY];
    }

    //Observes tile north of current position
    //Returns observations as FloorNode
    public FloorNode lookNorth(){
        if (posY <= 0){
            return null;
        }
        else{
            FloorNode temp = new FloorNode(assignedFloorPlan[posX][posY-1], posX, posY-1);
            learnedFloorPlan[posX][posY-1] = temp;
            return temp;
        }
    }

    //Observes tile east of current position
    //Returns observations as FloorNode
    public FloorNode lookEast(){
        if (posX >= 9){
            return null;
        }
        else{
            FloorNode temp = new FloorNode(assignedFloorPlan[posX+1][posY], posX+1, posY);
            learnedFloorPlan[posX+1][posY] = temp;
            return temp;
        }

    }

    //Observes tile south of current position
    //Returns observations as FloorNode
    public FloorNode lookSouth(){
        if (posY >= 9){
            return null;
        }
        else{
            FloorNode temp = new FloorNode(assignedFloorPlan[posX][posY+1], posX, posY+1);
            learnedFloorPlan[posX][posY+1] = temp;
            return temp;
        }
    }

    //Observes tile west of current position
    //Returns observations as FloorNode
    public FloorNode lookWest(){
        if (posX <= 0){
            return null;
        }
        else{
            FloorNode temp = new FloorNode(assignedFloorPlan[posX-1][posY], posX-1, posY);
            learnedFloorPlan[posX-1][posY] = temp;
            return temp;
        }
    }
    
    //Currently cleaning a tile reduces battery by 1, regardless of floor type
    //Change this as soon as possible
    //Will work as long as charge is available, ideally change so that cleaning stops before not enough charge left to return to CS
    public void cleanTile(){
        int currentDirt = learnedFloorPlan[posX][posY].getDirt();
        while(currentDirt > 0 && getDirtLevel() < DIRT_CAPACITY && getCharge() > 0){
            currentDirt = learnedFloorPlan[posX][posY].cleanDirt();
            dirt++;
            charge--;
        }
    }

    public void returnToStation(){
        FloorNode closestStation = getClosestChargingStation();
        while(posX != closestStation.posX() && posY != closestStation.posY()){
            //TODO
            //Requires movement functions to be implemented
        }

    }

    private FloorNode getClosestChargingStation(){
        ArrayList<FloorNode> foundStations = new ArrayList<FloorNode>();
        for(int x = 0; x < learnedFloorPlan.length; x++){
            for(int y = 0; y < learnedFloorPlan[x].length; y++){
                if (learnedFloorPlan[x][y] != null && learnedFloorPlan[x][y].getChargingStation()){
                    foundStations.add(learnedFloorPlan[x][y]);
                }
            }
        }
        FloorNode closest = foundStations.get(0);
        int distance = closest.posX() + closest.posY();
        for(FloorNode station: foundStations){
            if (station.posX() + station.posY() < distance){
                distance = station.posX() + station.posY();
                closest = station;
            }
        }
        return closest;
    }

    //Checks direction of arg to see if movement possible
    //If yes, moves 1 tile in that direction and returns 1
    //If no, stays in current position and returns 0
    public int checkAndMove(String direction) throws IllegalArgumentException{
        int toReturn = 0;
        switch (direction.toLowerCase()) {
            case "up":
                if (currentPosition().getWall("north") || lookNorth().getObstacle() != 0){
                    System.out.println("Cannot move north from current position");
                }
                else{
                    posY--;
                    toReturn = 1;
                }
                scanSurroundings();
                return toReturn;
            case "down":
                if (currentPosition().getWall("south") || lookSouth().getObstacle() != 0){
                    System.out.println("Cannot move south from current position");
                }
                else{
                    posY++;
                    toReturn = 1;
                }
                scanSurroundings();
                return toReturn;
            case "left":
                if (currentPosition().getWall("west") || lookWest().getObstacle() != 0){
                    System.out.println("Cannot move west from current position");
                }
                else{
                    posX--;
                    toReturn = 1;
                }
                scanSurroundings();
                return toReturn;
            case "right":
                if (currentPosition().getWall("east") || lookEast().getObstacle() != 0){
                    System.out.println("Cannot move east from current position");
                }
                else{
                    posX++;
                    toReturn = 1;
                }
                scanSurroundings();
                return toReturn;
            default:
                throw new IllegalArgumentException("" + direction + " is not a valid direction.");
        }
    }
}
