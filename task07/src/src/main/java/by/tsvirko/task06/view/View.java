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
        System.out.println("Let's register observer: ");
        register();
        initStorage();
    }

    public void tasksBook() {
        System.out.println("What will we do?");
        System.out.println("1. Add publication");
        System.out.println("2. Remove publication");
        System.out.println("3. Sort publications");
        System.out.println("4. Find publications");
        System.out.println("5. Update publication");
        try {
            switch (scanner.nextInt()) {
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
                case 5:
                    update();
                    tasksBook();
                default:
                    break;
            }
        } catch (InputMismatchException e) {
            logger.info("Application stopped", e.getMessage());
            return;
        }
    }

    private void update() {
        List<String> task = new ArrayList<>();
        task.add(CommandName.UPDATE.toString());
        task.add("ID");
        choosePublication();
        System.out.println("Enter publication ID: ");
        task.add(scanner.next());
        task.add(publication);
        String fields = bookFields();
        for (String field : fields.split(" ")) {
            System.out.println("Enter publication field '" + field + "'");
            String userField = scanner.next();
            task.add(userField);
        }
        controller.executeTask(task);
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
        List<String> task = new ArrayList<>();
        System.out.println("Enter find type: ");
        System.out.println("1. ID");
        System.out.println("2. Title");
        System.out.println("3. Title first letters");
        System.out.println("4. Number of pages");
        System.out.println("5. Publishing house");
        switch (scanner.nextInt()) {
            case 1:
                task.add(CommandName.FIND.toString());
                task.add("ID");
                task.add(scanner.next());
                break;
            case 2:
                task.add(CommandName.FIND.toString());
                task.add("Title");
                task.add(scanner.next());
                break;
            case 3:
                task.add(CommandName.FIND.toString());
                task.add("Titlefirstletters");
                System.out.println("Enter first titles' letters: ");
                task.add(scanner.next());
                break;
            case 4:
                task.add(CommandName.FIND.toString());
                task.add("numberofpages");
                task.add(scanner.next());
                break;
            case 5:
                task.add(CommandName.FIND.toString());
                task.add("publishinghouse");
                task.add(scanner.next());
                break;
            default:
                break;
        }
        controller.executeTask(task);
    }

    private void sort() {
        List<String> task = new ArrayList<>();
        System.out.println("Enter sort type: ");
        System.out.println("1. ID");
        System.out.println("2. Title");
        System.out.println("3. Title and number of pages");
        System.out.println("4. Number of pages");
        System.out.println("5. Publishing house");
        switch (scanner.nextInt()) {
            case 1:
                task.add(CommandName.SORT.toString());
                task.add("ID");
                task.add(scanner.next());
                break;
            case 2:
                task.add(CommandName.SORT.toString());
                task.add("Title");
                break;
            case 3:
                task.add(CommandName.SORT.toString());
                task.add("TITLENUMBEROFPAGES");
                break;
            case 4:
                task.add(CommandName.SORT.toString());
                task.add("numberofpages");
                break;
            case 5:
                task.add(CommandName.SORT.toString());
                task.add("publishinghouse");
                break;
            default:
                break;
        }
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

    private void publicationFields() {
        String taskF = CommandName.BOOK_FIELDS.toString();
        List<String> taskFields = new ArrayList<>();
        taskFields.add(taskF);
        taskFields.add(publication);
        controller.executeTask(taskFields);
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
            default:
                break;
        }
        this.publication = publication;
        return publication;
    }
}
