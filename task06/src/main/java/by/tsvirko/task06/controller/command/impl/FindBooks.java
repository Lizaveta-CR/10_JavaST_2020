package by.tsvirko.task06.controller.command.impl;

import by.tsvirko.task06.controller.command.Command;
import by.tsvirko.task06.dao.exception.BookStorageElementException;
import by.tsvirko.task06.service.query.QueryFindServiceController;
import by.tsvirko.task06.service.query.query_factory.QueryFactory;

import java.io.IOException;
import java.util.List;

public class FindBooks implements Command {
    @Override
    public String execute(List<String> request) throws BookStorageElementException {
        String response = null;
        QueryFactory factory = QueryFactory.getFactory();
        QueryFindServiceController queryFindServiceController = factory.getQueryFindServiceController();
        try {
            response = queryFindServiceController.find(request);
        } catch (IOException e) {
            response = "Error";
            System.err.println(e.getCause());
        }
        return response;
    }
}
