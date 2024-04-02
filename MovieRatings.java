import java.util.*;

class Movie {
    private String title;
    private String category;
    private double rating;

    public Movie(String title, String category, double rating) {
        this.title = title;
        this.category = category;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public double getRating() {
        return rating;
    }
}

public class MovieRatings {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Animal", "R", 8.3));
        movies.add(new Movie("Dune", "PG", 8.7));
        movies.add(new Movie("HanuMan", "PG-13", 7.7));
        movies.add(new Movie("The Dark Knight", "PG-13", 8.6));
        movies.add(new Movie("The Nun", "R", 4.7));
        movies.add(new Movie("Kung Fu Panda", "PG-13", 7.3));

        Map<String, Integer> movieCounts = new HashMap<>();
        Map<String, Double> movieAverages = new HashMap<>();

        for (Movie movie : movies) {
            String category = movie.getCategory();
            int count = movieCounts.getOrDefault(category, 0);
            double totalRating = movieAverages.getOrDefault(category, 0.0) * count;
            count++;
            totalRating += movie.getRating();
            movieCounts.put(category, count);
            movieAverages.put(category, totalRating / count);
        }

        System.out.println("Movie Ratings Summary:");
        for (Map.Entry<String, Integer> entry : movieCounts.entrySet()) {
            String category = entry.getKey();
            int count = entry.getValue();
            double averageRating = movieAverages.get(category);
            System.out.println("Category: " + category + ", Number of Movies: " + count + ", Average Rating: " + averageRating);
        }
    }
}
