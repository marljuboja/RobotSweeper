// Implementation of robot sensing the type of tile present.
public class TileSensor {

    private String[][] floorPlan;

    // Constructor
    public TileSensor(String[][] floorPlan) {
        this.floorPlan = floorPlan;
    }

    // Method to detect the surface type of the given position
    public SurfaceType detectSurface(int x, int y) {
        if (x < 0 || x >= floorPlan.length || y < 0 || y >= floorPlan[x].length) {
            throw new IllegalArgumentException("Position out of the floor plan bounds");
        }
        String tileData = floorPlan[x][y];
        return SurfaceType.fromNumericCode(Character.getNumericValue(tileData.charAt(0)));
    }
}
// Enum to represent different types of surfaces
enum SurfaceType {
    BARE_FLOOR(0, 1), // Bare floor (e.g. wood, linoleum, etc.), requires 1 unit of charge
    LOW_PILE_CARPET(1, 2), // Low-pile carpet, requires 2 units of charge
    HIGH_PILE_CARPET(2, 3); // High-pile carpet, requires 3 units of charge

    private final int numericCode;
    private final int powerRequirement;

    SurfaceType(int numericCode, int powerRequirement) {
        this.numericCode = numericCode;
        this.powerRequirement = powerRequirement;
    }

    public int getPowerRequirement() {
        return this.powerRequirement;
    }

    // Static method to convert numeric code to SurfaceType
    public static SurfaceType fromNumericCode(int numericCode) {
        for (SurfaceType surface : SurfaceType.values()) {
            if (surface.numericCode == numericCode) {
                return surface;
            }
        }
        throw new IllegalArgumentException("Unknown numeric code for surface type");
    }
}