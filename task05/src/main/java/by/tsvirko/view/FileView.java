package main.java.by.tsvirko.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileView {
    private final String FILE = "2";
    private Scanner scanner = new Scanner(System.in);

    List<String> task1File() {
        List<String> list = new ArrayList<>();
        list.add(FILE);
        System.out.println("Enter file name:");
        list.add(scanner.next());
        System.out.println("Enter index:");
        list.add(scanner.next());
        System.out.println("Enter symbol:");
        list.add(scanner.next());
        return list;
    }

}
