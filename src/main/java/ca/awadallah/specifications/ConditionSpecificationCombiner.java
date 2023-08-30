package ca.awadallah.specifications;

import ca.awadallah.models.Book;

public class ConditionSpecificationCombiner<T> implements SpecificationCombiner<T>{

    private  Condition<T> condition;


    @Override
    public Condition<T> and(Condition<T> other) {
        return item -> condition.isSatisfiedBy(item) && other.isSatisfiedBy(item);
    }

    @Override
    public Condition<T> or(Condition<T> other) {
        return item -> condition.isSatisfiedBy(item) || other.isSatisfiedBy(item);
    }

    @Override
    public Condition<T> not() {
        return item -> !condition.isSatisfiedBy(item);
    }

    @Override
    public SpecificationCombiner<T> with(Condition<T> condition) {
        this.condition = condition;
        return this;
    }

    @Override
    public SpecificationCombiner<T> reset() {
        return new ConditionSpecificationCombiner<T>() ;
    }
}
