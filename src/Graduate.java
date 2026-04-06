/**
 * Author: Clarissa Fuller
 * Date: 04-06-2026
 * Purpose: Represents a graduate student with a degree sought
 * and determines honor society eligibility.
 */
public class Graduate extends Student {
    private String degreeSought;

    public Graduate(String name, int creditHours, double qualityPoints, String degreeSought) {
        super(name, creditHours, qualityPoints);
        this.degreeSought = degreeSought;
    }

    public String getDegreeSought() {
        return degreeSought;
    }

    @Override
    public boolean eligibleForHonorSociety() {
        return super.eligibleForHonorSociety() &&
                degreeSought.equalsIgnoreCase("Masters");
    }

    @Override
    public String toString() {
        return String.format("%s %s", super.toString(), degreeSought.toUpperCase());
    }
}