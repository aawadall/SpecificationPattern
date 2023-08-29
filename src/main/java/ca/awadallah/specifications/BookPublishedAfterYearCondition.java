package ca.awadallah.specifications;

import ca.awadallah.models.Book;

public class BookPublishedAfterYearCondition implements Condition<Book>{
    private final int targetYear;

    public BookPublishedAfterYearCondition(int targetYear) {
        this.targetYear = targetYear;
    }

    @Override
    public boolean isSatisfiedBy(Book item) {
        return item.getYear() > targetYear;
    }
}
