package by.tsvirko.task04.service;

import by.tsvirko.task04.entity.Array;
import by.tsvirko.task04.entity.ArraysWrapper;
import by.tsvirko.task04.exceptions.ArrayException;
import by.tsvirko.task04.exceptions.EmptyResultException;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class NumbersWithThreeDifferentDigitsService {
    /**
     * Finds numbers with three different digits
     *
     * @param arraysWrapper
     * @return List<Integer> - list of numbers with three different digits
     * @throws ParseException,EmptyResultException
     */
    public List<Integer> findNumbersWithThreeDifferentDigits(ArraysWrapper arraysWrapper) throws ParseException, EmptyResultException, ArrayException {
        Array array = (Array) arraysWrapper;
        String number;
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < array.getLength(); i++) {
            number = String.valueOf(array.getElement(i));
            if (number.length() == 3 && number.charAt(0) != number.charAt(1)
                    && number.charAt(1) != number.charAt(2)
                    && number.charAt(0) != number.charAt(2)) {
                result.add(array.getElement(i));
            }
        }
        if (result.isEmpty()) {
            throw new EmptyResultException();
        }
        return result;
    }
}
