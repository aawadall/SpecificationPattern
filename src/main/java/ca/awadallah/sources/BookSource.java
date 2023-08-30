package ca.awadallah.sources;

import ca.awadallah.models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BookSource {
    private static int maxBookTitleLength = 10;
    private static int maxAuthorNameLength = 10;

    private static int originYear = 1900;
    private static int divergenceYear = 100;
    private final Random random;
    public BookSource() {
        this.random = new Random();
    }

    /**
     * Generate a random book
     * @return a book
     */
    public Book generateBook() {
        return new Book(randomTitle(), randomAuthor(), randomYear());
    }

    private String randomTitle() {
        return randomString(maxBookTitleLength);
    }

    private String randomString(int upperBound) {
        // generate random string
        var randomTitle = new StringBuilder();

        int length = random.nextInt(upperBound) + 1;
        for (int i = 0; i < length; i++) {
            randomTitle.append( (char) (random.nextInt(25) + 'a'));
        }
        return randomTitle.toString();
    }

    private String randomAuthor() {
        return randomString(maxAuthorNameLength);
    }

    private int randomYear() {
        return  (int)random.nextGaussian(originYear, divergenceYear);
    }

    /**
     * Generate random books
     * @param count number of books to generate
     * @return list of books
     */
    public List<Book> generateBooks(int count) {
        var books = new ArrayList<Book>();
        for (int i = 0; i < count; i++) {
            books.add(generateBook());
        }
        return books;
    }
}
