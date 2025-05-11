package bg.tu_varna.sit.b1.f23621718.contracts.validators;

public interface Validator<T> {
    boolean validate(T value);
}
