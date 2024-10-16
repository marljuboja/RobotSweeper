public class FloorSweeper {

    //learnedFloorPlan is the floor plan that the robot learns as it moves
    FloorNode[][] learnedFloorPlan;
    //assignedFloorPlan is the complete floor plan given to the robot to navigate
    //!!!!!!!!!!!!!!!
    //THE ROBOT CANNOT SEARCH THIS FLOOR PLAN EXCEPT FOR ITS IMMEDIATE SURROUNDINGS!!
    //!!!!!!!!!!!!!!!!!
    final String[][] assignedFloorPlan;
    //charge is the robot's remaining battery
    private int charge;
    //dirtCapacity is how much dirt the robot is currently holding
    private int dirt;
    //dirtCapacity is the maximum dirt the robot can hold
    final int dirtCapacity;
    //posX and posY are the robots x and y positions, respectively
    //
    private int posX;
    private int posY;

    //Constructor for robot
    //Takes floorplan and stores locally, but only accesses entries immediately surrounding its current position
    public FloorSweeper(String[][] floorplan){
        learnedFloorPlan = new FloorNode[10][10];
        assignedFloorPlan = floorplan;
        dirtCapacity = 50;
        charge = 100;
        //Add starting tile to learned floormap
        learnedFloorPlan[posX][posY] = new FloorNode(assignedFloorPlan[posX][posY]);
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

    //Observes tile north of current position
    //Returns observations as FloorNode
    public FloorNode lookNorth(){
        if (posY <= 0){
            return null;
        }
        else{
            FloorNode temp = new FloorNode(assignedFloorPlan[posX][posY-1]);
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
            FloorNode temp = new FloorNode(assignedFloorPlan[posX+1][posY]);
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
            FloorNode temp = new FloorNode(assignedFloorPlan[posX][posY+1]);
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
            FloorNode temp = new FloorNode(assignedFloorPlan[posX-1][posY]);
            learnedFloorPlan[posX-1][posY] = temp;
            return temp;
        }
    }
    
    //Currently cleaning a tile reduces battery by 1, regardless of floor type
    //Change this as soon as possible
    //Will work as long as charge is available, ideally change so that cleaning stops before not enough charge left to return to CS
    public void cleanTile(){
        int currentDirt = learnedFloorPlan[posX][posY].getDirt();
        while(currentDirt > 0 && getDirtLevel() < dirtCapacity && getCharge() > 0){
            currentDirt = learnedFloorPlan[posX][posY].cleanDirt();
            dirt++;
            charge--;
        }
    }
}
