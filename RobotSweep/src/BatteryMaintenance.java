public class BatteryMaintenance {
    //Robot drains the appropriate amount of power when cleaning or moving depending on terrain (bare floor, low-pile, or high-pile)
    //
    //Robot makes sure that it stays above a certain threshold of battery power available while cleaning
    //
    //If the power drops below a certain point, the robot stops cleaning and heads back to its charging station to recharge.
    //
    //After recharging at the charging station, it resumes cleaning.

    public final int maxBattery = 50;
    public static int currentBatteryLevel = 250;
    static String[][] floorMap = FloorPlan.getFloorPlan();
    public BatteryMaintenance () {}

    public void run() {}

    //MovementPowerCalculator = how much power moving
    public int[] startBatteryMaintenance (int[] start, int[] dest) {
        int typeStart = new FloorNode(floorMap[start[0]][start[1]],start[0],start[1]).getFloorType();
        int typeDest = new FloorNode(floorMap[dest[0]][dest[1]],dest[0],dest[1]).getFloorType();

        double movePower = MovementPowerCalculator.calculateMovementPower(typeStart, typeDest);
        //double cleanPower = MovementPowerCalculator.getPowerRequirement(typeDest);

        double totalPower = movePower + cleanPower;

        if (isEnoughBattery(totalPower)) {
            return dest;
        }
        else {
            int[] chargeSt = goesToCS();
            return chargeSt;
        }

    }

    //

    /**
     * Looks for charging station within two tiles away from current position
     * @author Marina Ljuboja
     * @return boolean
     */
    public boolean isEnoughBattery (double totalPower) {
        double power = currentBatteryLevel - totalPower;

        if (power >= 50) {
            return true;
        }
        else {
            return false;
        }
    }

    public int[] goesToCS() {
        int[] locCS = new int[2];
        

        return locCS;
    }

    public void isAtCS() {
        currentBatteryLevel = 250;
    }

    public void isDoneCharging () {
        //TODO resumes movement and cleaning
    }

}
