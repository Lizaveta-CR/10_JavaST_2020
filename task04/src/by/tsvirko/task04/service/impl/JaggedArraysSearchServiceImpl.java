package by.tsvirko.task04.service.impl;

import by.tsvirko.task04.entity.Array;
import by.tsvirko.task04.entity.ArraysWrapper;
import by.tsvirko.task04.entity.JaggedArray;
import by.tsvirko.task04.service.ArraySearchService;
import by.tsvirko.task04.service.impl.ArraysSearchServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JaggedArraysSearchServiceImpl extends ArraysSearchServiceImpl implements ArraySearchService {
    @Override
    public int findMax(ArraysWrapper wrapper) {
        JaggedArray jaggedArray = (JaggedArray) wrapper;
        List<Array> arrayList = jaggedArray.getArrayList();
        List<Integer> maximums = new ArrayList<>();
        for (Array array : arrayList) {
            int max = super.findMax(array);
            maximums.add(max);
        }
        return Collections.max(maximums);
    }

    @Override
    public int findMin(ArraysWrapper wrapper) {
        JaggedArray jaggedArray = (JaggedArray) wrapper;
        List<Array> arrayList = jaggedArray.getArrayList();
        List<Integer> minimums = new ArrayList<>();
        for (Array array : arrayList) {
            int max = super.findMin(array);
            minimums.add(max);
        }
        return Collections.min(minimums);
    }
}

