package by.tsvirko.task06.entity.observer.info;

import by.tsvirko.task06.entity.observer.Action;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BookInfo {
    private static final Logger logger = LogManager.getLogger(BookInfo.class);

    private static BookInfo instance;
    //stores year as key and number of books as a value
    private Map<Integer, Integer> yearCountMapBook = new HashMap<>();

    public void update(int year, Action action) {
        Optional<Integer> count = Optional.ofNullable(yearCountMapBook.get(year));
        switch (action) {
            case ADD:
                if (count.isPresent()) {
                    yearCountMapBook.replace(year, count.get().intValue(), count.get().intValue() + 1);
                } else {
                    yearCountMapBook.put(year, 1);
                }
                break;
            case REMOVE:
                yearCountMapBook.replace(year, count.get().intValue(), count.get().intValue() - 1);
                break;
        }
        for (Map.Entry<Integer, Integer> entry : yearCountMapBook.entrySet()) {
            logger.info("Book info: " + " year=" + entry.getKey() + " count=" + entry.getValue());
        }
    }

    public static BookInfo getInstance() {
        return (instance == null) ? instance = new BookInfo() : instance;
    }
}
