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
    public BatteryMaintenance () {}

    public boolean isEnoughBattery () {
        if (currentBatteryLevel >= 50) {
            return true;
        }
        else {
            return false;
        }
    }

    public void goesToCS() {}

    public void isDoneCharging () {}

}
