package by.tsvirko.task06.entity.observer;

import by.tsvirko.task06.entity.Publication;
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
     * This method will be called to librarians regarding the publication modification
     *
     * @param publication
     * @param message
     */
    @Override
    public void update(Publication publication, String message) {
        logger.info(name + " has received " + publication + " action " + message);
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "name='" + name + '\'' +
                '}';
    }
}
