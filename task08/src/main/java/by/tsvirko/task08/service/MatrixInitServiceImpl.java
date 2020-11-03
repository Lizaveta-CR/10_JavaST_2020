package by.tsvirko.task08.service;

import by.tsvirko.task08.entity.Matrix;
import by.tsvirko.task08.entity.exception.MatrixException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MatrixInitServiceImpl implements MatrixInitService {
    private static final Logger logger = LogManager.getLogger(MatrixInitServiceImpl.class);

    @Override
    public Matrix init(String fileName) throws MatrixException {
        URI uri = null;
        try {
            uri = ClassLoader.getSystemResource("data").toURI();
        } catch (URISyntaxException e) {
            logger.info("no such uri", e.getMessage());
        }
        String mainPath = Paths.get(uri).toString();
        Path path = Paths.get(mainPath, fileName);
        List<List<Integer>> list = new ArrayList<>();
        Scanner input = null;
        try {
            input = new Scanner(new File(String.valueOf(path)));
        } catch (FileNotFoundException e) {
            logger.info("No such file exception");
//            throw new ServiceInitException()
        }
        while (input.hasNextLine()) {
            List<Integer> row = createRow(input.nextLine());
            list.add(row);
        }

        int rows = list.size();
        int columns = list.get(0).size();
        Matrix matrix = new Matrix(rows, columns);
        for (int i = 0; i < matrix.getVerticalSize(); i++) {
            for (int j = 0; j < matrix.getHorizontalSize(); j++) {
                int value = list.get(i).get(j);
                matrix.setElement(i, j, value);
            }
        }
        return matrix;
    }

    private static List<Integer> createRow(String line) {
        List<Integer> elements = new ArrayList<>();
        String[] strings = line.split(" ");
        for (int i = 0; i < strings.length; i++) {
            String trim = strings[i].trim();
            elements.add(i, Integer.parseInt(trim));
        }
        return elements;
    }
}
