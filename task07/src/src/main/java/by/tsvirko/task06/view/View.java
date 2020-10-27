package by.tsvirko.task06.view;

import by.tsvirko.task06.controller.Controller;
import by.tsvirko.task06.controller.command.CommandName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class View {
    private static final Logger logger = LogManager.getLogger(View.class);
    private Scanner scanner = new Scanner(System.in);
    private Controller controller = new Controller();
    private String publication;

    public View() {
        initStorage();
    }

    public void tasksBook() {
        System.out.println("What will we do?");
        System.out.println("0.Register observer");
        System.out.println("1. Add publication");
        System.out.println("2. Remove publication");
        System.out.println("3. Sort books");
        System.out.println("4. Find books");
        try {
            switch (scanner.nextInt()) {
                case 0:
                    register();
                    tasksBook();
                case 1:
                    addPublication();
                    tasksBook();
                case 2:
                    removePublication();
                    tasksBook();
                case 3:
                    sort();
                    tasksBook();
                case 4:
                    find();
                    tasksBook();
                default:
                    break;
            }
        } catch (InputMismatchException e) {
            logger.info("Application stopped", e.getMessage());
            return;
        }
    }

    private void register() {
        List<String> task = new ArrayList<>();
        task.add(CommandName.OBSERVER.toString());
        String observer = null;
        System.out.println("1.Librarian");
        switch (scanner.nextInt()) {
            case 1:
                observer = "LIBRARIAN";
                break;
        }
        task.add(observer);
        System.out.println("Enter name: ");
        task.add(scanner.next());
        controller.executeTask(task);
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

    private void addPublication() {
        String fields = bookFields();
        String taskAdd = CommandName.ADD_BOOK.toString();
        List<String> taskAddBook = new ArrayList<>();
        taskAddBook.add(taskAdd);
        taskAddBook.add(publication);
        for (String field : fields.split(" ")) {
            System.out.println("Enter publication field '" + field + "'");
            String userField = scanner.next();
            taskAddBook.add(userField);
        }
        controller.executeTask(taskAddBook);
    }

    private void removePublication() {
        String fields = bookFields();

        String task = CommandName.REMOVE_BOOK.toString();
        List<String> taskFields = new ArrayList<>();
        taskFields.add(task);
        taskFields.add(publication);

        for (String field : fields.split(" ")) {
            System.out.println("Enter publication field '" + field + "'");
            String userField = scanner.next();
            taskFields.add(userField);
        }
        controller.executeTask(taskFields);
    }

    private String bookFields() {
        String publication = choosePublication();
        String taskF = CommandName.BOOK_FIELDS.toString();
        List<String> taskFields = new ArrayList<>();
        taskFields.add(taskF);
        taskFields.add(publication);
        return controller.executeTask(taskFields);
    }

    private String choosePublication() {
        String publication = null;
        System.out.println("1.Book\n2.Magazine");
        switch (scanner.nextInt()) {
            case 1:
                publication = "BOOK";
                break;
            case 2:
                publication = "MAGAZINE";
                break;
        }
        this.publication = publication;
        return publication;
    }
}
