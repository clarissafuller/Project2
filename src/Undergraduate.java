/**
 * Author: Clarissa Fuller
 * Date: 04-06-2026
 * Purpose: Represents an undergraduate student with a class rank
 * and determines honor society eligibility.
 */
public class Undergraduate extends Student {
    private String year;

    public Undergraduate(String name, int creditHours, double qualityPoints, String year) {
        super(name, creditHours, qualityPoints);
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    @Override
    public boolean eligibleForHonorSociety() {
        return super.eligibleForHonorSociety() &&
                (year.equalsIgnoreCase("Junior") || year.equalsIgnoreCase("Senior"));
    }

    @Override
    public String toString() {
        return String.format("%s %s", super.toString(), year.toUpperCase());
    }
}