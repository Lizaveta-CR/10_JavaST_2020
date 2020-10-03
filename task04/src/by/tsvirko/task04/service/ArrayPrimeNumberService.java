package by.tsvirko.task04.service;

import by.tsvirko.task04.entity.Array;
import by.tsvirko.task04.entity.ArraysWrapper;
import by.tsvirko.task04.exceptions.ArrayException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ArrayPrimeNumberService {
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
