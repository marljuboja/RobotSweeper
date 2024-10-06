public class Main {
    public static void main(String[] args) {
        FloorPlan.getFloorPlan();

        //System.out.println("First point in array" + FloorPlan.floorPlan[0][0]);
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                System.out.println(FloorPlan.floorPlan[i][j]);
            }
        }
    }
}