package by.tsvirko.task04.service.impl;

import by.tsvirko.task04.entity.Array;
import by.tsvirko.task04.entity.JaggedArray;
import by.tsvirko.task04.service.FileReading;

import java.io.*;
import java.util.*;

public class FileJaggedArrayReadingImpl implements FileReading {
    private String filename;
    private final String FILE_PATH = "/Users/elizaveta/Downloads/10_JavaST_2020/task04/resource/";
    private final String FILE_EXT = ".txt";

    public FileJaggedArrayReadingImpl(String filename) {
        this.filename = FILE_PATH.concat(filename).concat(FILE_EXT);
    }

    /**
     * Reads array from file
     *
     * @return JaggedArray
     */
    public JaggedArray readArray() {
        int size = countLines();
        int[][] ints = new int[size][];
        try {
            FileInputStream fstream = new FileInputStream(filename);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            for (int i = 0; i < ints.length; i++) {
                strLine = br.readLine();
                String[] tokens = strLine.split(" ");
                int[] array = Arrays.stream(tokens).mapToInt(Integer::parseInt).toArray();
                ints[i] = array;
            }
            in.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return new JaggedArray(ints);
    }

    /**
     * Counts number of lines in file
     *
     * @return number of lines
     */
    private int countLines() {
        int lines = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            while (reader.readLine() != null) {
                lines++;
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Check file...");
        }
        return lines;
    }
}
