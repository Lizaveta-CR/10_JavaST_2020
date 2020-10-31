package by.tsvirko.task06.service.impl.magazine;

import by.tsvirko.task06.entity.Magazine;
import by.tsvirko.task06.entity.Publication;
import by.tsvirko.task06.service.PublicationCreator;
import by.tsvirko.task06.service.exception.ServiceInitException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class MagazineCreator extends PublicationCreator {
    private static final Logger logger = LogManager.getLogger(MagazineCreator.class);

    /**
     * Creates new Publication depending on users' fields
     *
     * @param fieldsUser
     * @return
     * @throws ServiceInitException
     */
    @Override
    public Publication create(List<String> fieldsUser) throws ServiceInitException {
        Publication publication = new Magazine();
        Magazine magazine = (Magazine) publication;
        try {
            magazine.setTitle(fieldsUser.get(0));
            magazine.setNumberOfPages(Integer.valueOf(fieldsUser.get(1)));
            magazine.setYear(Integer.valueOf(fieldsUser.get(2)));
            magazine.setPublishingHouse(fieldsUser.get(3));
            magazine.setCoverHeading(fieldsUser.get(4));
        } catch (NumberFormatException e) {
            logger.debug("Create magazine error", e.getMessage());
            throw new ServiceInitException("Invalid parametres");
        }
        return magazine;
    }
}
