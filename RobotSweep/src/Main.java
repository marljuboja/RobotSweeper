import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        FloorPlan.getFloorPlan();

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                System.out.print("@ " + i + "/" + j + ": " + FloorPlan.floorPlan[i][j] + " ");
            }
            System.out.println();
        }

        int[] arr;

        arr = DetectChargeStation.detectCS(9,3);

        //arr = DetectStairs.detectStair(9,3);

        System.out.println(arr[0] + ", " + arr[1]);

        /*ArrayList<int[]> list = DetectObstacle.detectObs(2,4);
        for (int[] a : list) {
            System.out.println(a[0] + ", " + a[1]);
        }*/
    }
}