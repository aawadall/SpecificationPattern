package ca.awadallah.specifications;

public interface Condition<T> {
    boolean isSatisfiedBy(T item);
}
