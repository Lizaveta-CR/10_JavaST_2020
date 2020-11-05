package by.tsvirko.task08.service.validator;

public class ValidatorThread {
    private final int M1 = 1;
    private final int M2 = 19;

    public boolean validate(int m) {
        return (m < M2) && (m > M1);
    }
}
