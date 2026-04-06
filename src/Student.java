/**
 * Author: Clarissa Fuller
 * Date: 04-06-2026
 * Purpose: Defines a Student with name, credit hours, quality points,
 * and shared GPA threshold logic for honor society eligibility.
 */
public class Student {
    private String name;
    private int creditHours;
    private double qualityPoints;

    private static double gpaThreshold;
    private static final double HIGHEST_POSSIBLE_GPA = 4.0;

    public Student(String name, int creditHours, double qualityPoints) {
        this.name = name;
        this.creditHours = creditHours;
        this.qualityPoints = qualityPoints;
    }

    public String getName() {
        return name;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public double getQualityPoints() {
        return qualityPoints;
    }

    public double gpa() {
        return qualityPoints / creditHours;
    }

    public boolean eligibleForHonorSociety() {
        return gpa() >= gpaThreshold;
    }

    public static void setGpaThreshold(double threshold) {
        gpaThreshold = threshold;
    }

    public static double getGpaThreshold() {
        return gpaThreshold;
    }

    public static double getHighestPossibleGpa() {
        return HIGHEST_POSSIBLE_GPA;
    }

    @Override
    public String toString() {
        return String.format("Name: %s GPA %.2f", name, gpa());
    }
}