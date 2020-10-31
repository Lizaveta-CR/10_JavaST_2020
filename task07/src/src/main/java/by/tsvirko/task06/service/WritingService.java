package by.tsvirko.task06.service;


import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.Publication;

import java.io.IOException;

public interface WritingService {
    void writeResult(Publication publication, String fileName) throws IOException;
}
