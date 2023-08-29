package ca.awadallah;

import ca.awadallah.models.Book;
import ca.awadallah.sources.BookSource;
import ca.awadallah.specifications.*;

public class Main {
    public static void main(String[] args) {
        var bookSource = new BookSource();

        // specs
        Condition<Book> after2000 = new BookPublishedAfterYearCondition(1900);
        Condition<Book> startsWithT = new BookTitleStartsWithCondition("t");
        SpecificationCombiner<Book> combiner = new ConditionSpecificationCombiner();
        Condition<Book> filter = combiner.with(after2000).or(startsWithT);

        while (randomBoolean()) {
            var book = bookSource.generateBook();

            System.out.print(book.toString());

            if (filter.isSatisfiedBy(book)) {
                System.out.println(" ***");
            } else {
                System.out.println();
            }
            // sleep for 1 second
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    private static boolean randomBoolean() {
        var coin = Math.random();
        //System.out.println(coin);
        return coin > 0.05;
    }
}