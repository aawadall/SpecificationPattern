package ca.awadallah.specifications;

public interface SpecificationCombiner<T> {
    Condition<T> and(Condition<T> other);
    Condition<T> or(Condition<T> other);
    Condition<T> not();
    SpecificationCombiner<T> with(Condition<T> condition);
}
