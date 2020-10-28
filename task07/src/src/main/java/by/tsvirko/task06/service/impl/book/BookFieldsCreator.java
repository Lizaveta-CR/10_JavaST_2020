package by.tsvirko.task06.service.impl.book;

import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.Publication;
import by.tsvirko.task06.service.PublicationFieldsCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;

public class BookFieldsCreator extends PublicationFieldsCreator {
    private static final Logger logger = LogManager.getLogger(BookFieldsCreator.class);

    /**
     * Gives Book fields
     *
     * @return StringBuilder-fields
     */
    @Override
    public StringBuilder getPublicationFields() {
        StringBuilder sb = new StringBuilder();

        for (Field declaredField : Publication.class.getDeclaredFields()) {
            String name = declaredField.getName();
            if (!name.equals("id")) {
                sb.append(name + " ");
            }
        }

        Field[] declaredFields = Book.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            String name = declaredField.getName();
            if (!name.equals("serialVersionUID")) {
                sb.append(name + " ");
            }
        }

        logger.debug("book fields were given");
        return sb;
    }
}
