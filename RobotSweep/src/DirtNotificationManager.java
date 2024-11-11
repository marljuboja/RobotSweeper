public class DirtNotificationManager {
    private final DirtContainer dirtContainer;
    private boolean notificationSent;
    private boolean isAtChargingStation;
    private Position lastCleaningPosition;

    // States to track the dirt container status
    public enum ContainerStatus {
        EMPTY,
        PARTIALLY_FULL,
        FULL,
        AWAITING_EMPTY
    }

    // Store position information
    private static class Position {
        int x, y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    public DirtNotificationManager(DirtContainer dirtContainer) {
        this.dirtContainer = dirtContainer;
        this.notificationSent = false;
        this.isAtChargingStation = false;
    }

    // Check container status and send notifications if needed
    public ContainerStatus checkContainerStatus() {
        if (!dirtContainer.isCleaningActive() && isAtChargingStation) {
            return ContainerStatus.AWAITING_EMPTY;
        }

        if (dirtContainer.isFull() && !notificationSent) {
            sendFullNotification();
            return ContainerStatus.FULL;
        } else if (dirtContainer.getCurrentDirtLevel() > 0) {
            return ContainerStatus.PARTIALLY_FULL;
        }

        return ContainerStatus.EMPTY;
    }

    // Send notification when container is full
    public void sendFullNotification() {
        if (!notificationSent && dirtContainer.isFull()) {
            String message = formatFullNotification();
            System.out.println(message);
            notificationSent = true;
        }
    }

    // Format the notification message
    private String formatFullNotification() {
        return String.format("""
            🚨 DIRT CONTAINER ALERT 🚨
            Status: FULL (%d/%d units)
            Action Required: Please empty the dirt container
            Location: Robot is returning to charging station
            Next Steps: 
            1. Wait for robot to reach charging station
            2. Empty the container
            3. Robot will resume cleaning automatically
            """, dirtContainer.getCurrentDirtLevel(), 50);
    }

    // Called when robot reaches charging station
    public void arriveAtChargingStation(int x, int y) {
        isAtChargingStation = true;
        if (dirtContainer.isFull()) {
            lastCleaningPosition = new Position(x, y);
            System.out.println("Robot at charging station - Please empty dirt container");
            sendEmptyReminderNotification();
        }
    }

    // Send reminder to empty container
    private void sendEmptyReminderNotification() {
        System.out.println("""
            📢 REMINDER
            The dirt container needs to be emptied before cleaning can resume.
            Please empty the container now.
            """);
    }

    // Handle container emptying
    public void handleContainerEmpty() {
        if (isAtChargingStation && dirtContainer.isFull()) {
            dirtContainer.emptyContainer();
            notificationSent = false;
            System.out.println("""
                ✅ CONTAINER EMPTIED
                Status: Container has been emptied successfully
                Next: Robot will resume cleaning from last position
                """);

            if (lastCleaningPosition != null) {
                System.out.println("Resuming cleaning from position: " + lastCleaningPosition);
            }
        } else {
            System.out.println("ERROR: Robot must be at charging station to empty container");
        }
    }

    // Called when robot leaves charging station
    public void leaveChargingStation() {
        isAtChargingStation = false;
    }

    // Get the last cleaning position
    public int[] getLastCleaningPosition() {
        if (lastCleaningPosition != null) {
            return new int[]{lastCleaningPosition.x, lastCleaningPosition.y};
        }
        return null;
    }

    // Reset notification status
    public void resetNotification() {
        notificationSent = false;
    }

    // Check if robot is at charging station
    public boolean isAtChargingStation() {
        return isAtChargingStation;
    }
}