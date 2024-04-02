import java.util.*;

public class StudentTestScores {
    public static void main(String[] args) {
        // Sample test scores
        int[] testScores = {80,65,58,95,86,46,88,77,48};

        // Calculate average
        double sum = 0;
        for (int score : testScores) {
            sum += score;
        }
        double average = sum / testScores.length;

        // Sort test scores
        Arrays.sort(testScores);

        // Calculate number of students above, at, and below average
        int aboveAverageCount = 0, atAverageCount = 0, belowAverageCount = 0;
        for (int score : testScores) {
            if (score > average) {
                aboveAverageCount++;
            } else if (score == average) {
                atAverageCount++;
            } else {
                belowAverageCount++;
            }
        }

        // Calculate median score
        int median;
        if (testScores.length % 2 == 0) {
            median = (testScores[testScores.length / 2 - 1] + testScores[testScores.length / 2]) / 2;
        } else {
            median = testScores[testScores.length / 2];
        }

        // Display results
        System.out.println("Number of students above average: " + aboveAverageCount + ", median: " + median);
        System.out.println("Number of students at average: " + atAverageCount + ", median: " + median);
        System.out.println("Number of students below average: " + belowAverageCount + ", median: " + median);
    }
}
