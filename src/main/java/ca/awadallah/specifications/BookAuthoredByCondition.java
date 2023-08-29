package ca.awadallah.specifications;

import ca.awadallah.models.Book;

public class BookAuthoredByCondition implements Condition<Book> {
    private final String author;

    public BookAuthoredByCondition(String author) {
        this.author = author;
    }

    @Override
    public boolean isSatisfiedBy(Book book) {
        return book.getAuthor().equals(this.author);
    }
}
