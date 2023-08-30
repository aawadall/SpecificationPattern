package ca.awadallah;

import ca.awadallah.models.Book;
import ca.awadallah.sources.BookSource;
import ca.awadallah.specifications.*;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        var bookSource = new BookSource();

        // specs
        Condition<Book> shortTitle = new LambdaCondition<>(book -> book.getTitle().length() < 10);
        // get current year
        var thisYear = java.time.Year.now().getValue();
        Condition<Book> pastTenYears = new LambdaCondition<>(book -> book.getYear() > thisYear - 10);

        Condition<Book> before2000 = new LambdaCondition<>(book -> book.getYear() < 2000);
        Condition<Book> titleStartsWith = new LambdaCondition<>(book -> book.getTitle().contains("t") || book.getTitle().contains("u") || book.getTitle().startsWith("i"));
        SpecificationCombiner<Book> combiner = new ConditionSpecificationCombiner<>();
        Condition<Book> cat1 = combiner.with(before2000).and(titleStartsWith);

        Condition<Book> cat2 = combiner.reset().with(pastTenYears).and(shortTitle);

        var books = bookSource.generateBooks(33);

        var cat1Books = filter(books, cat1);
        var cat2Books = filter(books, cat2);

        System.out.println("Category 1 books:");
        System.out.println("====================================");
        cat1Books.forEach(System.out::println);

        System.out.println();
        System.out.println("Category 2 books:");
        System.out.println("====================================");
        cat2Books.forEach(System.out::println);
    }

    private static boolean randomBoolean() {
        var coin = Math.random();
        //System.out.println(coin);
        return coin > 0.015;
    }

    private static <T> List<T> filter(List<T> items, Condition<T> condition) {
        return items.stream().filter(condition::isSatisfiedBy).collect(Collectors.toList());
    }
}