package by.tsvirko.task06.entity.observer;

import by.tsvirko.task06.entity.Publication;
import by.tsvirko.task06.entity.observer.info.PublicationInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Librarian implements Observer {
    private static final Logger logger = LogManager.getLogger(Librarian.class);

    private String name;

    public Librarian() {
    }

    public Librarian(String name) {
        this.name = name;
    }

    /**
     * This method will be called to librarians regarding the publication modification (Action)
     *
     * @param publication
     * @param action
     */
    @Override
    public void update(Publication publication, Action action) {
        PublicationInfo instance = PublicationInfo.getInstance();
        logger.info("Librarian received publications. Counting... ");
        instance.update(publication, publication.getYear(), action);
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "name='" + name + '\'' +
                '}';
    }
}
