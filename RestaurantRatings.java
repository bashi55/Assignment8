import java.util.*;

public class RestaurantRatings {
    public static void main(String[] args) {
        // Sample restaurant ratings
        int[] ratings = {3, 6, 8, 5, 9, 7, 4, 10, 2, 8, 7, 6};

        // Define rating ranges
        int[][] ratingRanges = {{1, 5}, {6, 10}};

        // Initialize count and sum arrays for each rating range
        int[] counts = new int[ratingRanges.length];
        int[] sums = new int[ratingRanges.length];

        // Calculate counts and sums for each rating range
        for (int rating : ratings) {
            for (int i = 0; i < ratingRanges.length; i++) {
                if (rating >= ratingRanges[i][0] && rating <= ratingRanges[i][1]) {
                    counts[i]++;
                    sums[i] += rating;
                    break;
                }
            }
        }

        // Calculate average rating for each range and display results
        for (int i = 0; i < ratingRanges.length; i++) {
            int lowerBound = ratingRanges[i][0];
            int upperBound = ratingRanges[i][1];
            int count = counts[i];
            double average = count == 0 ? 0 : (double) sums[i] / count;
            System.out.println("Number of restaurants rated between " + lowerBound + " and " + upperBound + ": " + count);
            System.out.println("Average rating for this range: " + average);
        }
    }
}
