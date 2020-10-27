package by.tsvirko.task06.service;

import by.tsvirko.task06.entity.Publication;
import by.tsvirko.task06.service.exception.ServiceInitException;

import java.util.List;

public abstract class PublicationCreator {
    public abstract Publication create(List<String> bookFieldsUser) throws ServiceInitException;
}
