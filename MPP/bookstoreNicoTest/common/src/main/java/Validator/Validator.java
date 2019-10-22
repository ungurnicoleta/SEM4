package Validator;

public interface Validator<T> {
    public void validate(T entity) throws ValidatorException;
}
