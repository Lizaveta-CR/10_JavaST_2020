package by.tsvirko.task06.entity.observer;

import by.tsvirko.task06.entity.Publication;
/**
 * This interface handles adding, deleting and updating all observers
 */
public interface Subject {
    void register(Observer o);

    void unregister(Observer o);

    void notifyAllObservers(Publication publication, String mess);
}
