package by.tsvirko.task06.validator;

import by.tsvirko.task06.entity.Publication;

public interface Validator {
    boolean validate(Publication publication);
}