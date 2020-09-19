package by.tsvirko.task01.service;

//TODO: classname convention
public final class PerfectNumber {
    private PerfectNumber() {
        throw new AssertionError("Instantiating utility class.");
    }

    /**
     * Checks if number is perfect.
     *
     * @param number is user's number.
     * @return boolean value: 'true' if number is perfect, else - 'false'
     * @throws IllegalArgumentException if  user's number is 0
     */
    public static boolean isPerfectNumber(final int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number can not negative or 0!");
        }
        long sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }
}
