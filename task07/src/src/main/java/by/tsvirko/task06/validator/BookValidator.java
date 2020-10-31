package by.tsvirko.task06.validator;

import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.Publication;

public class BookValidator implements Validator {
    private final int CURRENT_YEAR = 2020;

    public boolean validate(Publication publication) {
        Book book = (Book) publication;
        return checkPages(book.getNumberOfPages()) && checkYear(book.getYear());
    }

    private boolean checkYear(int yearOfPublishing) {
        return yearOfPublishing > 0 && yearOfPublishing <= CURRENT_YEAR;
    }

    private boolean checkPages(int pages) {
        return pages > 0;
    }
}
