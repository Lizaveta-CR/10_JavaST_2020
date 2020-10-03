package by.tsvirko.task04.service;

import by.tsvirko.task04.entity.Array;
import by.tsvirko.task04.entity.ArraysWrapper;
import by.tsvirko.task04.exceptions.ArrayException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ArrayPrimeNumberService {
    /**
     * Method finds prime numbers in given Array
     *
     * @param wrapper - input Array
     * @return List<Integer> - list of prime numbers
     * @throws ArrayException
     */
    public List<Integer> findPrimeNumbersInArray(ArraysWrapper wrapper) throws ArrayException {
        Array array = (Array) wrapper;
        List<Integer> primes = new ArrayList<>();
        for (int i = 0; i < array.getLength(); i++) {
            int element = array.getElement(i);
            if (isPrime(element)) {
                primes.add(element);
            }
        }
        return primes;
    }

    /**
     * Method checks if given number if prime
     *
     * @param number - given number
     * @return boolean value - if number is prime- true, else-false
     */
    boolean isPrime(int number) {
        if (number <= 2)
            return false;
        else
            return (number % 2) != 0
                    &&
                    IntStream.rangeClosed(3, (int) Math.sqrt(number))
                            .filter(n -> n % 2 != 0)
                            .noneMatch(n -> (number % n == 0));
    }
}
