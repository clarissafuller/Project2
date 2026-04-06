/**
 * Author: Clarissa Fuller
 * Date: 2026-04-06
 * Purpose: Reads student data from students.txt, computes the GPA threshold
 * for honor society membership, and prints eligible students.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Project2 {
    private static final String FILE_NAME = "students.txt";

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        double totalGpa = 0.0;
        int count = 0;

        try {
            File inputFile = new File(FILE_NAME);
            Scanner fileScanner = new Scanner(inputFile);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();

                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split("\\s+");

                String name = parts[0];
                int creditHours = Integer.parseInt(parts[1]);
                double qualityPoints = Double.parseDouble(parts[2]);
                String yearOrDegree = parts[3];

                Student student;

                if (yearOrDegree.equalsIgnoreCase("Freshman") ||
                        yearOrDegree.equalsIgnoreCase("Sophomore") ||
                        yearOrDegree.equalsIgnoreCase("Junior") ||
                        yearOrDegree.equalsIgnoreCase("Senior")) {
                    student = new Undergraduate(name, creditHours, qualityPoints, yearOrDegree);
                } else {
                    student = new Graduate(name, creditHours, qualityPoints, yearOrDegree);
                }

                students.add(student);
                totalGpa += student.gpa();
                count++;
            }

            fileScanner.close();

            if (count > 0) {
                double averageGpa = totalGpa / count;
                double threshold = (averageGpa + Student.getHighestPossibleGpa()) / 2.0;
                Student.setGpaThreshold(threshold);

                System.out.printf("GPA threshold for membership is %.2f%n%n", threshold);

                for (Student student : students) {
                    if (student.eligibleForHonorSociety()) {
                        System.out.println(student);
                    }
                }
            } else {
                System.out.println("No student data found.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }
}