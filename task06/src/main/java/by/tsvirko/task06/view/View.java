package by.tsvirko.task06.view;

import by.tsvirko.task06.controller.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    private Scanner scanner = new Scanner(System.in);
    private Controller controller = new Controller();

    private void addBook() {
        String taskF = "BOOK_FIELDS";
        List<String> taskFields = new ArrayList<>();
        taskFields.add(taskF);
        String s = controller.executeTask(taskFields);
        String taskAdd = "ADD_BOOK";
        List<String> taskAddBook = new ArrayList<>();
        taskAddBook.add(taskAdd);
        for (String field : s.split(" ")) {
            System.out.println("Enter book field '" + field + "'");
            String userField = scanner.next();
            taskAddBook.add(userField);
        }
        controller.executeTask(taskAddBook);
    }

    public static void main(String[] args) {
        new View().addBook();
    }
}
