package ca.awadallah.specifications;

import ca.awadallah.models.Book;

public class BookTitleStartsWithCondition implements Condition<Book>{
    private final String titleBeginning;

    public BookTitleStartsWithCondition(String titleBeginning) {
        this.titleBeginning = titleBeginning;
    }

    @Override
    public boolean isSatisfiedBy(Book book) {
        return book.getTitle().startsWith(this.titleBeginning);
    }
}
