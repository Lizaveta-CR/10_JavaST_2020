package by.tsvirko.task06.entity.observer;

import by.tsvirko.task06.entity.Publication;

/**
 * The Observers update method is called when the Subject changes
 */
public interface Observer {
    void update(Publication publication, String message);
}
