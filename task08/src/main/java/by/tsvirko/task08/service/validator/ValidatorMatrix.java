package by.tsvirko.task08.service.validator;

public class ValidatorMatrix {
    private final int N1 = 2;
    private final int N2 = 20;

    public boolean validate(int n) {
        return (n < N2) && (n > N1);
    }
}
