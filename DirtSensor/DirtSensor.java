public class DirtSensor {
    private String[][] floorPlan;

    public DirtSensor(String[][] floorPlan) {
        this.floorPlan = floorPlan;
    }

    public boolean detectDirt(int x, int y) {
        char lastChar = floorPlan[x][y].charAt(floorPlan[x][y].length() - 1);
        System.out.println("Checking dirt at (" + x + ", " + y + "): " + lastChar);  // Debug output
        return lastChar != '0';
    }

    public void cleanDirt(int x, int y) {
        if (detectDirt(x, y)) {
            StringBuilder sb = new StringBuilder(floorPlan[x][y]);
            sb.setCharAt(sb.length() - 1, '0');
            floorPlan[x][y] = sb.toString();
            System.out.println("Cleaning dirt at (" + x + ", " + y + ")");  // Debug output
        }
    }
}
