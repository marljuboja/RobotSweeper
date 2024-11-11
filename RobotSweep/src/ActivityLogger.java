import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class ActivityLogger {
    private BufferedWriter writer;

    // Constructor to initialize the logger with a file path
    public ActivityLogger(String filePath) {
        try {
            writer = new BufferedWriter(new FileWriter(filePath,false));
        } catch (IOException e) {
            System.err.println("Error initializing logger: " + e.getMessage());
        }
    }

    // Method to log sensor checks
    public void logSensorCheck(int x, int y, String checkType, String result) {
        String logEntry = String.format("%s - Sensor Check at (%d, %d): %s - %s%n",
                new Date(), x, y, checkType, result);
        writeLog(logEntry);
    }

    // Method to log movements
    public void logMovement(int startX, int startY, int endX, int endY, String direction) {
        String logEntry = String.format("%s - Moved %s from (%d, %d) to (%d, %d)%n",
                new Date(), direction, startX, startY, endX, endY);
        writeLog(logEntry);
    }

    // Method to log cleaning activity
    public void logCleaning(int x, int y, int dirtCleaned) {
        String logEntry = String.format("%s - Cleaned %d units of dirt at (%d, %d)%n",
                new Date(), dirtCleaned, x, y);
        writeLog(logEntry);
    }

    // Method to log power consumption
    public void logPowerUsage(double powerRemaining) {
        String logEntry = String.format("%s - Power remaining: %.2f units%n",
                new Date(), powerRemaining);
        writeLog(logEntry);
    }

    // Method to log custom events
    public void logEvent(String action) {
        String logEntry = String.format("%s - %s%n", new Date(), action);
        writeLog(logEntry);
    }

    // Helper method to write to log file
    private void writeLog(String logEntry) {
        try {
            writer.write(logEntry);
            writer.flush();
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }

    // Method to close the logger and clean up resources
    public void close() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            System.err.println("Error closing the logger: " + e.getMessage());
        }
    }
}