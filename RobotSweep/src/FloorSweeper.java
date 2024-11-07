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
    private final double MIN_ALLOWED_CHARGE = 25;
    //Maximum battery charge
    private final double MAX_ALLOWED_CHARGE = 250;

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
        charge = MAX_ALLOWED_CHARGE;
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
        charge = MAX_ALLOWED_CHARGE;
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

    /**
     * 
     * @return FloorNode at current Position
     */
    public FloorNode getCurrentTile(){
        return learnedFloorPlan[posX][posY];
    }

    /**
     * 
     * @return FloorNode directly north of current location
     */
    public FloorNode lookNorth(){
        if (posY <= 0){
            return null;
        }
        else{
            return learnTile(posX, posY-1);
        }
    }

    /**
     * 
     * @return FloorNode directly east of current location
     */
    public FloorNode lookEast(){
        if (posX >= 9){
            return null;
        }
        else{
            return learnTile(posX+1, posY);
        }

    }

    /**
     * 
     * @return FloorNode directly south of current location
     */
    public FloorNode lookSouth(){
        if (posY >= 9){
            return null;
        }
        else{
            return learnTile(posX, posY+1);
        }
    }

    /**
     * 
     * @return FloorNode directly west of current location
     */
    public FloorNode lookWest(){
        if (posX <= 0){
            return null;
        }
        else{
            return learnTile(posX-1, posY);
        }
    }
    
    /**
     * Cleans current tile
     */
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

    /**
     * Begins algorithm to locate nearest charging station and return to it.
     * Recharges battery once charging station is reached.
     * Once recharged, moves back to where it left off.
     */
    public void returnToStation(){
        FloorNode lastVisited = getCurrentTile();
        FloorNode closestStation = getClosestChargingStation();
        if (moveTo(closestStation) == 1){
            charge = MAX_ALLOWED_CHARGE;
        }
        moveTo(lastVisited);
    }

    /**
     * Getter function for charging station fewest spaces away from current location.
     * Does not factor for walls, obstacles, etc.
     * @return FloorNode containing closest charging station
     */
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

    /**
     * Moves along outermost boundaries of floorplan, cleaning along the way, starting from NW corner (0,0).
     * After making one round trip, calls cleanRemainder()
     * @return 1 if successful
     */
    public int beginSweep(){
        int toReturn = 0;
        boolean flip = false;
        // Move to northwest corner
        while (posX != 0){
            while(checkAndMove("west") == 0){
                if (flip){ checkAndMove("south"); }
                else{
                    if (checkAndMove("north") == 0){ flip = true; }
                }
            }
            flip = false;
            cleanTile();
        }
        while (posY != 0){
            while(checkAndMove("north") == 0){
                if (flip){ checkAndMove("east"); }
                else{
                    if (checkAndMove("west") == 0){ flip = true; }
                }
            }
            flip = false;
        }
        // Move to NE
        while (posX != 9){
            while(checkAndMove("east") == 0){
                if (flip){ checkAndMove("north"); }
                else{
                    if (checkAndMove("south") == 0){ flip = true; }
                }
            }
            flip = false;
        }
        // Move to SE
        while (posY != 9){
            while(checkAndMove("south") == 0){
                if (flip){ checkAndMove("east"); }
                else{
                    if (checkAndMove("west") == 0){ flip = true; }
                }
            }
            flip = false;
        }
        // Move to SW
        while (posX != 0){
            while(checkAndMove("west") == 0){
                if (flip){ checkAndMove("south"); }
                else{
                    if (checkAndMove("north") == 0){ flip = true; }
                }
            }
            flip = false;
        }
        // Move to NW
        while (posY != 0){
            while(checkAndMove("north") == 0){
                if (flip){ checkAndMove("west"); }
                else{
                    if (checkAndMove("east") == 0){ flip = true; }
                }
            }
            flip = false;
        }
        cleanRemainder();
        return 1;
    }

    /**
     * Scans learned memory for remaining FloorNodes with dirt,
     * moves to its position and cleans it.
     * @return 1 when all known tiles are clean.
     */
    private int cleanRemainder(){
        boolean jobDone = false;
        FloorNode unclean = getCurrentTile();
        while (!jobDone){
            jobDone = true;
            for (int x = 0; x < 9; x++){
                for (int y = 0; y < 9; y++){
                    if (learnedFloorPlan[x][y].getDirt() > 0){
                        if ((unclean.posX() + unclean.posY()) > (learnedFloorPlan[x][y].posX() + learnedFloorPlan[x][y].posY())){
                            unclean = learnedFloorPlan[x][y];
                        };
                        jobDone = false;
                        moveTo(unclean);
                        cleanTile();
                    }
                }
            }
        }
        return 1;
    }

    /**
     * Moves to a passed FloorNode.
     * @param destination FloorNode to move to
     * @return 1 if move is successful
     */
    private int moveTo(FloorNode destination){
        boolean flip = false;
        while (!getCurrentTile().equals(destination)){
            // Move east
            if (getCurrentTile().posX() < destination.posX()){
                while(checkAndMove("east") == 0){
                    if (flip){ checkAndMove("south"); }
                    else{
                        if (checkAndMove("north") == 0){ flip = true; }
                    }
                }
                flip = false;
            }
            // Move west
            else if (getCurrentTile().posX() > destination.posX()){
                while(checkAndMove("west") == 0){
                    if (flip){ checkAndMove("south"); }
                    else{
                        if (checkAndMove("north") == 0){ flip = true; }
                    }
                }
                flip = false;
            }
            // Move south
            if (getCurrentTile().posY() < destination.posY()){
                while(checkAndMove("south") == 0){
                    if (flip){ checkAndMove("west"); }
                    else{
                        if (checkAndMove("east") == 0){ flip = true; }
                    }
                }
                flip = false;
            }
            // Move north
            else if (getCurrentTile().posY() > destination.posY()){
                while(checkAndMove("north") == 0){
                    if (flip){ checkAndMove("west"); }
                    else{
                        if (checkAndMove("east") == 0){ flip = true; }
                    }
                }
                flip = false;
            }
        }
        return 1;
    }

    /**
     * Checks direction of arg to see if movement possible
     * @param direction "north"/"south"/"east"/"west"
     * @return 1 on successful move, 0 on unsuccessful move
     * @throws IllegalArgumentException
     */
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
                    if (getCurrentTile().getDirt() > 0 && charge > MIN_ALLOWED_CHARGE){ cleanTile(); }
                    scanSurroundings();
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
                    if (getCurrentTile().getDirt() > 0 && charge > MIN_ALLOWED_CHARGE){ cleanTile(); }
                    scanSurroundings();
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
                    if (getCurrentTile().getDirt() > 0 && charge > MIN_ALLOWED_CHARGE){ cleanTile(); }
                    scanSurroundings();
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
                    if (getCurrentTile().getDirt() > 0 && charge > MIN_ALLOWED_CHARGE){ cleanTile(); }
                    scanSurroundings();
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
