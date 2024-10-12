public class Main {
    public static void main(String[] args) {
        FloorPlan.getFloorPlan();

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                System.out.print(FloorPlan.floorPlan[i][j] + " ");
                //System.out.print(FloorPlan.floorPlan[i][j].substring(0,1));
            }
            System.out.println();
        }

        int[] arr = DetectChargeStation.detectCS(1,9);
        System.out.println(" " + arr[0] + ", " + arr[1]);
    }
}