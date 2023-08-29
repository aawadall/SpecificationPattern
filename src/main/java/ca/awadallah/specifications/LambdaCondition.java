package ca.awadallah.specifications;

import java.util.function.Predicate;

/**
 * A Generic Condition that can be used to create a Specification
 * @param <T> The type of the item to be tested
 */
public class LambdaCondition<T> implements Condition<T> {
    private final Predicate<T> predicate;

    /**
     * Create a new LambdaCondition
     * @param predicate The predicate to be used to test the item
     */
    public LambdaCondition(Predicate<T> predicate) {
        this.predicate = predicate;
    }

    @Override
    public boolean isSatisfiedBy(T item) {
        return this.predicate.test(item);
    }
}
