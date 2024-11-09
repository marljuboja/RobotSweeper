public class CleanFloorTest {
    
    public static void main(String[] args){

        FloorSweeper sweeper = new FloorSweeper(FloorPlan.getFloorPlan2(),0,9);
        sweeper.printLearnedMap();
        sweeper.beginSweep();
        sweeper.printLearnedMap();
    }
}
