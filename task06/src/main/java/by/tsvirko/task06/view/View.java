package by.tsvirko.task06.view;

import by.tsvirko.task06.controller.Controller;
import by.tsvirko.task06.controller.command.CommandName;

import java.util.*;

public class View {
    private Scanner scanner = new Scanner(System.in);
    private Controller controller = new Controller();

    public void tasks() {
        System.out.println("What will we do?");
        System.out.println("1. Add book");
        System.out.println("2. Remove book");
        System.out.println("3. Sort books");
        System.out.println("4. Find books");
        try {
            switch (scanner.nextInt()) {
                case 1:
                    addBook();
                    tasks();
                case 2:
                    removeBook();
                    tasks();
                case 3:
                    sort();
                    tasks();
                case 4:
                    find();
                    tasks();
                default:
                    break;
            }
        } catch (InputMismatchException e) {
            return;
        }
    }

    private void find() {
        String s = bookFields();
        System.out.println("Enter find type: ");
        Map<Integer, String> finds = new HashMap<>();
        int fieldIndex = 0;
        for (String field : s.split(" ")) {
            finds.put(fieldIndex, field);
            System.out.println(fieldIndex + " - " + field);
            fieldIndex++;
        }
        List<String> task = new ArrayList<>();
        task.add(CommandName.FIND.toString());
        task.add(finds.get(scanner.nextInt()));
        System.out.println("Enter what book do you want to find: ");
        task.add(scanner.next());
        controller.executeTask(task);
    }

    private void sort() {
        String s = bookFields();
        System.out.println("Enter sort type: ");
        Map<Integer, String> sorts = new HashMap<>();
        int fieldIndex = 0;
        for (String field : s.split(" ")) {
            sorts.put(fieldIndex, field);
            System.out.println(fieldIndex + " - " + field);
            fieldIndex++;
        }
        List<String> task = new ArrayList<>();
        task.add(CommandName.SORT.toString());
        task.add(sorts.get(scanner.nextInt()));
        controller.executeTask(task);
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
