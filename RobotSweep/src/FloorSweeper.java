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
    private double charge;

    //The maximum dirt the robot can hold
    private DirtContainer dirt;

    //Threshold at which Robot will be forced to return to charging station
    private final double MIN_ALLOWED_CHARGE = 15;

    //Robot's x and y positions, respectively
    private int posX;
    private int posY;

    //True if returning to charging station, false if cleaning
    private boolean returning;

    //Constructor for robot
    /**Initialize robot at 0/0
     * @deprecated use FloorSweeper(String[][] floorplan, int x, int y)
     * @param floorplan 2D String array containing floor plan to traverse
     */
    public FloorSweeper(String[][] floorplan){
        learnedFloorPlan = new FloorNode[10][10];
        assignedFloorPlan = floorplan;
        charge = 100;
        //Add starting tile to learned floormap
        learnedFloorPlan[posX][posY] = new FloorNode(assignedFloorPlan[posX][posY], posX, posY);
        returning = false;
        dirt = new DirtContainer();
        scanSurroundings();
    }

    /**Initialize robot at x/y coordinates (99% of the time should point to charging station)
     * @param floorplan 2D String array containing floor plan to traverse
     * @param x X-coordinate to start at
     * @param y Y-coordinate to start at
     */
    public FloorSweeper(String[][] floorplan, int x, int y){
        learnedFloorPlan = new FloorNode[10][10];
        assignedFloorPlan = floorplan;
        charge = 100;
        posX = x;
        posY = y;
        //Add starting tile to learned floormap
        learnedFloorPlan[posX][posY] = new FloorNode(assignedFloorPlan[posX][posY], posX, posY);
        returning = false;
        dirt = new DirtContainer();
        scanSurroundings();
    }

    //Returns battery charge level of robot
    public double getCharge(){
        return charge;
    }

    private FloorNode learnTile(int x, int y) throws IllegalArgumentException{
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

    //Observes tile north of current position and adds to learned floor map
    //Returns observations as FloorNode
    public FloorNode lookNorth(){
        if (posY <= 0){
            return null;
        }
        else{
            return learnTile(posX, posY-1);
        }
    }

    //Observes tile east of current position and adds to learned floor map
    //Returns observations as FloorNode
    public FloorNode lookEast(){
        if (posX >= 9){
            return null;
        }
        else{
            return learnTile(posX+1, posY);
        }

    }

    //Observes tile south of current position and adds to learned floor map
    //Returns observations as FloorNode
    public FloorNode lookSouth(){
        if (posY >= 9){
            return null;
        }
        else{
            return learnTile(posX, posY+1);
        }
    }

    //Observes tile west of current position and adds to learned floor map
    //Returns observations as FloorNode
    public FloorNode lookWest(){
        if (posX <= 0){
            return null;
        }
        else{
            return learnTile(posX-1, posY);
        }
    }
    
    //Will work as long as charge is available, ideally change so that cleaning stops before not enough charge left to return to CS
    public void cleanTile(){
        FloorNode currentTile = learnedFloorPlan[posX][posY];
        while(!returning && currentTile.getDirt() > 0){
            currentTile.cleanDirt();
            dirt.addDirt();
            charge = charge-(currentTile.getFloorType()+1);
            updateLevels();
        }
    }

    // Run this method after changing dirt/battery to check if returning thresholds are met
    private void updateLevels(){
        if (dirt.isFull() || charge < MIN_ALLOWED_CHARGE){
            returning = true;
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
        int obst;
        switch (direction.toLowerCase()) {
            // Move North
            case "up":
                if (lookNorth() == null){
                    System.out.println("Cannot move " + direction +": Out of Bounds");
                    return 0;
                }
                obst = lookNorth().getObstacle();
                if (getCurrentTile().getWall("north") || obst%2 == 1 || getCurrentTile().getDoor("north") == 2){
                    System.out.println("Cannot move north from current position");
                    return 0;
                }
                else{
                    posY--;
                    depleteChargeMovement(lookNorth().getFloorType());
                    return 1;
                }
            // Move South
            case "down":
                if (lookSouth() == null){
                    System.out.println("Cannot move " + direction +": Out of Bounds");
                    return 0;
                }
                obst = lookSouth().getObstacle();
                if (getCurrentTile().getWall("south") || obst%2 == 1 || getCurrentTile().getDoor("south") == 2){
                    System.out.println("Cannot move south from current position");
                    return 0;
                }
                else{
                    posY++;
                    depleteChargeMovement(lookSouth().getFloorType());
                    return 1;
                }
            // Move West
            case "left":
                if(lookWest() == null){
                    System.out.println("Cannot move " + direction + ": Out of Bounds");
                    return 0;
                }
                obst = lookWest().getObstacle();
                if (getCurrentTile().getWall("west") || obst%2 == 1 || getCurrentTile().getDoor("west") == 2){
                    System.out.println("Cannot move west from current position");
                    return 0;
                }
                else{
                    posX--;
                    depleteChargeMovement(lookWest().getFloorType());
                    return 1;
                }
            // Move East
            case "right":
                if (lookEast() == null){
                    System.out.println("Cannot move " + direction + ": Out of Bounds");
                    return 0;
                }
                obst = lookEast().getObstacle();
                if (getCurrentTile().getWall("east") || obst%2 == 1 || getCurrentTile().getDoor("east") == 2){
                    System.out.println("Cannot move east from current position");
                    return 0;
                }
                else{
                    posX++;
                    depleteChargeMovement(lookEast().getFloorType());
                    return 1;
                }
            // Move Weast
            default:
                throw new IllegalArgumentException("" + direction + " is not a valid direction.");
        }
    }

    // Depletes charge based on terrain traversed
    private void depleteChargeMovement(int destFloorType){
        charge = charge - MovementPowerCalculator.calculateMovementPower(getCurrentTile().getFloorType(), destFloorType);
        scanSurroundings();
        updateLevels();
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
