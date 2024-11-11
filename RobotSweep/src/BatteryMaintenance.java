public class BatteryMaintenance {
    
    public static final double minBattery = 50.0;
    public static double maxBatteryLevel = 250.0;
    public static double currentBatteryLevel = 250.0;
    static String[][] floorMap = FloorPlan.getFloorPlan();
    // if flag is -1 then robot is cleaning, if 0 then it is only moving
    static int flag = -1;
    public static FloorSweeper floorS;
    public final static int maxIndex = 10;
    public BatteryMaintenance () {
        floorS = new FloorSweeper(floorMap);
    }

    /**
     * Checks to see how much battery is required to move and if it needs to go to the charging station
     * @author Marina Ljuboja
     * @return boolean
     */
    public static void startBatteryMaintenance (int fromTileType, int toTileType, boolean isDirtFull,
                                                boolean isCleanRemainder) {

        double cleanPower = 0.0;

        double movePower = MovementPowerCalculator.calculateMovementPower(fromTileType, toTileType);

        if (fromTileType >= 3 || fromTileType < 0) {
            throw new IndexOutOfBoundsException("parameters for BatteryMaintenance.startBatteryMaintenace are not good");
        }

        if (toTileType >= 3 || toTileType < 0) {
            throw new IndexOutOfBoundsException("parameters for BatteryMaintenance.startBatteryMaintenace are not good");
        }

        if (isDirtFull == true) {
            flag = 0;
        }

        if(isCleanRemainder == true) {
            movePower = 0;
        }

        if ((flag == -1) || (isCleanRemainder == true)) {
            cleanPower = MovementPowerCalculator.calculateMovementPower(fromTileType, toTileType);
        }

        double totalPower = movePower + cleanPower;

        if ((isEnoughBattery(totalPower)) && (flag == -1)) {
            currentBatteryLevel = currentBatteryLevel - totalPower;
        }
        //////// keeps moving charging station without cleaning
        else if (flag == 0) {
            currentBatteryLevel = currentBatteryLevel - totalPower;
        }
        else {
            flag = 0;
            ////////// needs to be recharged once at station
            //This is called in FloorSweeper instead of here:
            //floorS.returnToStation();
            //isAtCS();
        }

    }

    /**
     * Checks current battery amount to see if there is enough to move to the next tile
     * @author Marina Ljuboja
     * @return boolean
     */
    public static boolean isEnoughBattery (double totalPower) {
        double power = currentBatteryLevel - totalPower;

        if (totalPower >= maxBatteryLevel || totalPower < 0) {
            throw new IllegalArgumentException("parameters for BatteryMaintenance.startBatteryMaintenace are not good");
        }

        if (power > minBattery) {
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
