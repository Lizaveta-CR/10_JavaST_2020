package by.tsvirko.task01.service;

final class PerfectNumber {
    private PerfectNumber() {
        throw new AssertionError("Instantiating utility class.");
    }

    /**
     * Checks if number is perfect.
     *
     * @param number is user's number.
     * @return if number is perfect.
     */
    public static boolean isPerfectNumber(final int number) {
        long sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }
}
