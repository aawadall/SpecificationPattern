package ca.awadallah;

import ca.awadallah.models.Book;
import ca.awadallah.sources.BookSource;
import ca.awadallah.specifications.*;

public class Main {
    public static void main(String[] args) {
        var bookSource = new BookSource();

        // specs
        Condition<Book> shortTitle = new LambdaCondition<>(book -> book.getTitle().length() < 10);
        // get current year
        var thisYear = java.time.Year.now().getValue();
        Condition<Book> pastTenYears = new LambdaCondition<>(book -> book.getYear() > thisYear - 10);

        Condition<Book> after2000 = new BookPublishedAfterYearCondition(1900);
        Condition<Book> startsWithT = new BookTitleStartsWithCondition("t");
        SpecificationCombiner<Book> combiner = new ConditionSpecificationCombiner();
        Condition<Book> filter = combiner.with(after2000).or(startsWithT);
        Condition<Book> recentShort = combiner.with(pastTenYears).and(shortTitle);
        while (randomBoolean()) {
            var book = bookSource.generateBook();

            if (recentShort.isSatisfiedBy(book)) {
                System.out.print("RECENT SHORT: ");
            } else {
                System.out.print("              ");
            }
            System.out.print(book.toString());

            if (filter.isSatisfiedBy(book)) {
                System.out.println(" ***");
            } else {
                System.out.println();
            }

        }

    }

    private static boolean randomBoolean() {
        var coin = Math.random();
        //System.out.println(coin);
        return coin > 0.015;
    }
}