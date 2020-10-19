package by.tsvirko.task06.view;

import by.tsvirko.task06.controller.Controller;
import by.tsvirko.task06.controller.command.CommandName;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    private Scanner scanner = new Scanner(System.in);
    private Controller controller = new Controller();

    public void tasks() {
        System.out.println("What will we do?");
        System.out.println("1. Add book");
        System.out.println("2. Remove book");
        switch (scanner.nextInt()) {
            case 1:
                addBook();
                tasks();
            case 2:
                removeBook();
                tasks();
            default:
                break;
        }
    }

    private void initStorage() {
        String task = CommandName.INIT_STORAGE.toString();
        List<String> taskFields = new ArrayList<>();
        taskFields.add(task);
        System.out.println("Library will be opened soon...");
        controller.executeTask(taskFields);
    }

    private void addBook() {
        String fields = bookFields();
        String taskAdd = CommandName.ADD_BOOK.toString();
        List<String> taskAddBook = new ArrayList<>();
        taskAddBook.add(taskAdd);
        for (String field : fields.split(" ")) {
            System.out.println("Enter book field '" + field + "'");
            String userField = scanner.next();
            taskAddBook.add(userField);
        }
        controller.executeTask(taskAddBook);
    }

    private void removeBook() {
        String fields = bookFields();

        String task = CommandName.REMOVE_BOOK.toString();
        List<String> taskFields = new ArrayList<>();
        taskFields.add(task);

        for (String field : fields.split(" ")) {
            System.out.println("Enter book field '" + field + "'");
            String userField = scanner.next();
            taskFields.add(userField);
        }
        controller.executeTask(taskFields);
    }

    private String bookFields() {
        String taskF = CommandName.BOOK_FIELDS.toString();
        List<String> taskFields = new ArrayList<>();
        taskFields.add(taskF);
        return controller.executeTask(taskFields);
    }

    public static void main(String[] args) {
        View view = new View();
        view.initStorage();
        view.tasks();
    }
}
