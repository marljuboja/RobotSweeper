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
        scanSurroundings();
    }

    //Returns battery charge level of robot
    public int getCharge(){
        return charge;
    }
    
    //Returns amount of dirt stored in robot
    public int getDirtLevel(){
        return dirt;
    }

    public FloorNode learnTile(int x, int y) throws IllegalArgumentException{
        if (x < 0 || x >= assignedFloorPlan[0].length || y < 0 || y >= assignedFloorPlan.length){
            throw new IllegalArgumentException("Argument(s) out of bounds for give floor map");
        }
        learnedFloorPlan[x][y] = new FloorNode(assignedFloorPlan[y][x], x, y);
        return learnedFloorPlan[x][y];
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
    public FloorNode getCurrentTile(){
        return learnedFloorPlan[posX][posY];
    }

    //Observes tile north of current position
    //Returns observations as FloorNode
    public FloorNode lookNorth(){
        if (posY <= 0){
            return null;
        }
        else{
            return learnTile(posX, posY-1);
        }
    }

    //Observes tile east of current position
    //Returns observations as FloorNode
    public FloorNode lookEast(){
        if (posX >= 9){
            return null;
        }
        else{
            return learnTile(posX+1, posY);
        }

    }

    //Observes tile south of current position
    //Returns observations as FloorNode
    public FloorNode lookSouth(){
        if (posY >= 9){
            return null;
        }
        else{
            return learnTile(posX, posY+1);
        }
    }

    //Observes tile west of current position
    //Returns observations as FloorNode
    public FloorNode lookWest(){
        if (posX <= 0){
            return null;
        }
        else{
            return learnTile(posX-1, posY);
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
        int obst;
        switch (direction.toLowerCase()) {
            case "up":
                obst = lookNorth().getObstacle();
                if (getCurrentTile().getWall("north") || obst%2 == 1 || getCurrentTile().getDoor("north") == 2){
                    System.out.println("Cannot move north from current position");
                }
                else{
                    posY--;
                    toReturn = 1;
                }
                scanSurroundings();
                return toReturn;
            case "down":
                obst = lookSouth().getObstacle();
                if (getCurrentTile().getWall("south") || obst%2 == 1 || getCurrentTile().getDoor("south") == 2){
                    System.out.println("Cannot move south from current position");
                }
                else{
                    posY++;
                    toReturn = 1;
                }
                scanSurroundings();
                return toReturn;
            case "left":
                obst = lookWest().getObstacle();
                if (getCurrentTile().getWall("west") || obst%2 == 1 || getCurrentTile().getDoor("west") == 2){
                    System.out.println("Cannot move west from current position");
                }
                else{
                    posX--;
                    toReturn = 1;
                }
                scanSurroundings();
                return toReturn;
            case "right":
                obst = lookEast().getObstacle();
                if (getCurrentTile().getWall("east") || obst%2 == 1 || getCurrentTile().getDoor("east") == 2){
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

    public void printLearnedMap(){
        for(int y = 0; y < learnedFloorPlan.length; y++){
            for (int x = 0; x < learnedFloorPlan[y].length; x++){
                if (learnedFloorPlan[x][y] == null)
                    System.out.print("X / X; ");
                else
                    System.out.print(learnedFloorPlan[x][y].toString());
            }
            System.out.println();
        }
    }
}
