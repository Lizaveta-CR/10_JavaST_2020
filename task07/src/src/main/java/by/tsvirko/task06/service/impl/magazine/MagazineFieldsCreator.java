package by.tsvirko.task06.service.impl.magazine;

import by.tsvirko.task06.entity.Magazine;
import by.tsvirko.task06.entity.Publication;
import by.tsvirko.task06.service.PublicationFieldsCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;

public class MagazineFieldsCreator extends PublicationFieldsCreator {
    private static final Logger logger = LogManager.getLogger(MagazineFieldsCreator.class);

    /**
     * Gives Magazine fields
     *
     * @return StringBuilder-fields
     */
    @Override
    public StringBuilder getPublicationFields() {
        StringBuilder sb = new StringBuilder();

        for (Field declaredField : Publication.class.getDeclaredFields()) {
            String name = declaredField.getName();
            if (!name.equals("id") && !name.equals("serialVersionUID")) {
                sb.append(name + " ");
            }
        }

        Field[] declaredFields = new Magazine().getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            String name = declaredField.getName();
            sb.append(name + " ");
        }
        logger.debug("magazine fields were given");
        return sb;
    }
}
