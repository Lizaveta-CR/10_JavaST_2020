package by.tsvirko.task08.service;

import by.tsvirko.task08.entity.Matrix;
import by.tsvirko.task08.entity.exception.MatrixException;
import by.tsvirko.task08.repository.MatrixRepository;
import by.tsvirko.task08.repository.MatrixRepositoryImpl;
import by.tsvirko.task08.service.exception.ServiceInitException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class MatrixInitServiceImpl implements InitService {
    private static final Logger logger = LogManager.getLogger(MatrixInitServiceImpl.class);
    private MatrixRepository repository = new MatrixRepositoryImpl();

    /**
     * Method to read matrix from file
     *
     * @param fileName
     * @param n1       - boundary
     * @param n2       - boundary
     * @return Matrix
     * @throws MatrixException
     * @throws ServiceInitException
     */
    @Override
    public Matrix init(String fileName, int n1, int n2) throws MatrixException, ServiceInitException {
        if (!new Validator().validate(n1, n2)) {
            throw new ServiceInitException("Wrong parameters");
        }
        URI uri = null;
        try {
            uri = ClassLoader.getSystemResource("data").toURI();
        } catch (URISyntaxException e) {
            logger.info("no such uri", e.getMessage());
        }
        String mainPath = Paths.get(uri).toString();
        Path path = Paths.get(mainPath, fileName);
        Scanner input = null;
        try {
            input = new Scanner(new BufferedReader(new FileReader(String.valueOf(path))));
        } catch (FileNotFoundException e) {
            logger.info("No such file exception");
            throw new ServiceInitException("No such file");
        }
        int rows = 0;

        if (n1 > n2) {
            rows = n2 + (int) (Math.random() * ((n1 - n2) + 1));
        } else if (n1 < n2) {
            rows = n1 + (int) (Math.random() * ((n2 - n1) + 1));
        } else {
            rows = n1;
        }

        int columns = rows;
        Matrix matrix = new Matrix();
        try {
            try {
                for (int i = 0; i < rows; i++) {
                    String[] line = input.nextLine().trim().split(" ");
                    for (int j = 0; j < columns; j++) {
                        matrix.setElement(i, j, Integer.parseInt(line[j]));
                    }
                }
            } catch (NoSuchElementException e) {
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ServiceInitException("Too big input values");
        }
        repository.add(matrix);
        return matrix;
    }

    public static void main(String[] args) throws MatrixException, ServiceInitException {
        MatrixInitServiceImpl matrixInitService = new MatrixInitServiceImpl();
        Matrix init = matrixInitService.init("matrix.txt", 6, 6);
        System.out.println(init.getElement(1, 0));
        System.out.println(init);
    }
}
