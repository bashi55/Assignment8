import java.util.*;

class Book {
    private String title;
    private int rating;

    public Book(String title, int rating) {
        this.title = title;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public int getRating() {
        return rating;
    }
}

public class BookReviews {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Harry Potter and the Sorcerer's Stone", 5));
        books.add(new Book("The Doomsday Archives: The Wandering Hour", 5));
        books.add(new Book("The Getaway List", 3));
        books.add(new Book(" Only the Beautiful", 5));
        books.add(new Book("The Catcher in the Rye", 2));
        books.add(new Book("Brave New World", 4));

        int[] ratingRanges = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] ratingsCount = new int[11]; // Index 0 is not used

        int positiveCount = 0, neutralCount = 0, negativeCount = 0;

        for (Book book : books) {
            int rating = book.getRating();
            ratingsCount[rating]++;
            if (rating >= 7) {
                positiveCount++;
            } else if (rating >= 4) {
                neutralCount++;
            } else {
                negativeCount++;
            }
        }

        System.out.println("Book Reviews Summary:");
        for (int i = 0; i < ratingRanges.length - 1; i++) {
            int lowerBound = ratingRanges[i];
            int upperBound = ratingRanges[i + 1] - 1;
            int count = ratingsCount[lowerBound];
            for (int j = lowerBound + 1; j <= upperBound; j++) {
                count += ratingsCount[j];
            }
            System.out.println("Books with ratings between " + lowerBound + " and " + upperBound + ": " + count);
        }
        System.out.println("Positive Reviews: " + positiveCount);
        System.out.println("Neutral Reviews: " + neutralCount);
        System.out.println("Negative Reviews: " + negativeCount);
    }
}
