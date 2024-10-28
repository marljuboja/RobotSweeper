// Function that calculates power consumption of robot from moving between different tile types.
public class MovementPowerCalculator{
    // Power requirements for different surface types
    private static final double BARE_FLOOR_POWER = 1.0;
    private static final double LOW_PILE_POWER = 2.0;
    private static final double HIGH_PILE_POWER = 3.0;

    /**
     * Calculates power required to move between tiles based on their surface types
     * @param fromTileType surface type of starting tile (0: bare floor, 1: low-pile carpet, 2: high-pile carpet)
     * @param toTileType surface type of destination tile (0: bare floor, 1: low-pile carpet, 2: high-pile carpet)
     * @return power units required for movement
     */
    public static double calculateMovementPower(int fromTileType, int toTileType) {
        double fromPower = getPowerRequirement(fromTileType);
        double toPower = getPowerRequirement(toTileType);

        // Average of the two surface power requirements
        return (fromPower + toPower) / 2.0;
    }

    /**
     * Gets power requirement for a specific surface type
     * @param tileType surface type (0: bare floor, 1: low-pile carpet, 2: high-pile carpet)
     * @return power units required for that surface
     */
    private static double getPowerRequirement(int tileType) {
        switch (tileType) {
            case 0: return BARE_FLOOR_POWER;  // Bare floor
            case 1: return LOW_PILE_POWER;    // Low-pile carpet
            case 2: return HIGH_PILE_POWER;   // High-pile carpet
            default: throw new IllegalArgumentException("Invalid tile type: " + tileType);
        }
    }
}