package by.tsvirko.task01.service;

public class PerfectNumber {
    private long number;

    public PerfectNumber(long number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number can't be <=0");
        } else {
            this.number = number;
        }
    }

    /**
     * Checks if number is perfect.
     *
     * @param number is user's number.
     * @return boolean value: 'true' if number is perfect, else - 'false'
     */
    public boolean isPerfectNumber(final long number) {
        long result = 1;
        long i = 2;
        while (i * i <= number) {
            if (number % i == 0) {
                result += i;
                result += number / i;
            }
            i++;
        }
        if (i * i == number) {
            result -= i;
        }
        return result == number;
    }
}
