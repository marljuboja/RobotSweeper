public class BatteryMaintenance {
    
    public static final int maxBattery = 50;
    public static double currentBatteryLevel = 250.0;
    static String[][] floorMap = FloorPlan.getFloorPlan();
    static int flag = -1;
    public BatteryMaintenance () {}

    /**
     * Checks to see how much battery is required to move and if it needs to go to the charging station
     * @author Marina Ljuboja
     * @return boolean
     */
    public static boolean startBatteryMaintenance (int[] start, int[] dest) {
        int typeStart = new FloorNode(floorMap[start[0]][start[1]],start[0],start[1]).getFloorType();
        int typeDest = new FloorNode(floorMap[dest[0]][dest[1]],dest[0],dest[1]).getFloorType();
        double cleanPower = 0.0;

        double movePower = MovementPowerCalculator.calculateMovementPower(typeStart, typeDest);

        if (flag == -1) {
            cleanPower = MovementPowerCalculator.getPowerRequirement(typeDest);
        }

        double totalPower = movePower + cleanPower;

        if ((isEnoughBattery(totalPower)) && (flag == -1)) {
            currentBatteryLevel = currentBatteryLevel - totalPower;
            return true;
        }
        //////// keeps moving charging station without cleaning
        else if (flag == 0) {
            currentBatteryLevel = currentBatteryLevel - totalPower;
            return true;
        }
        else {
            flag = 0;
            ////////// needs to be recharged once at station
            //isAtCS();
            return false;
        }

    }


    /**
     * Checks current battery amount to see if there is enough to move to the next tile
     * @author Marina Ljuboja
     * @return boolean
     */
    public static boolean isEnoughBattery (double totalPower) {
        double power = currentBatteryLevel - totalPower;

        if (power >= 50) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Once at the charging station it updates battery level to full
     * @author Marina Ljuboja
     * @return boolean
     */
    public static void isAtCS() {
        currentBatteryLevel = 250.0;
        flag = -1;
    }


}
