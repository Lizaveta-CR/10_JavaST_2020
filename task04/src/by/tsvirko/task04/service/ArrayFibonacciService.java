package by.tsvirko.task04.service;

import by.tsvirko.task04.entity.Array;
import by.tsvirko.task04.entity.ArraysWrapper;
import by.tsvirko.task04.exceptions.ArrayException;

import java.util.ArrayList;
import java.util.List;

public class ArrayFibonacciService {
    /**
     * Function to check if the number is in Fibonacci or not
     *
     * @param wrapper - given array
     * @return List<Integer> - list if Fibonacci numbers
     */
    public List<Integer> findFibNumbers(ArraysWrapper wrapper) throws ArrayException {
        List<Integer> fibNumbers = new ArrayList<>();
        Array array = (Array) wrapper;
        int count = 0;
        for (int i = 0; i < array.getLength(); i++) {
            if (isPerfectSquare(5 * array.getElement(i) * array.getElement(i) + 4)
                    || isPerfectSquare(5 * array.getElement(i) * array.getElement(i) - 4)) {
                fibNumbers.add(array.getElement(i));
                count++;
            }
        }
        return fibNumbers;
    }

    /**
     * Function to check number is a perfect square or not
     *
     * @param num
     * @return true, if number if perfect square, false - if it's not
     */
    private boolean isPerfectSquare(int num) {
        int n = (int) (Math.sqrt(num));
        return (n * n == num);
    }
}
