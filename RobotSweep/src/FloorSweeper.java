public class FloorSweeper {

    //learnedFloorPlan is the floor plan that the robot learns as it moves
    String[][] learnedFloorPlan;
    //assignedFloorPlan is the complete floor plan given to the robot to navigate
    //!!!!!!!!!!!!!!!
    //THE ROBOT CANNOT SEARCH THIS FLOOR PLAN EXCEPT FOR ITS IMMEDIATE SURROUNDINGS!!
    //!!!!!!!!!!!!!!!!!
    final String[][] assignedFloorPlan;
    //charge is the robot's remaining battery
    int charge;
    //dirtCapacity is how much dirt the robot is currently holding
    int dirt;
    //dirtCapacity is the maximum dirt the robot can hold
    final int dirtCapacity;

    public FloorSweeper(String[][] floorplan){
        learnedFloorPlan = new String[10][10];
        assignedFloorPlan = floorplan;
        dirtCapacity = 50;
    }
    
}
