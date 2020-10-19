package by.tsvirko.task06.controller.command.impl;

import by.tsvirko.task06.controller.command.Command;
import by.tsvirko.task06.service.query.QuerySortServiceController;
import by.tsvirko.task06.service.query.query_factory.QueryFactory;

import java.io.IOException;
import java.util.List;

public class SortBooks implements Command {
    @Override
    public String execute(List<String> request) {
        String response = null;
        QueryFactory factory = QueryFactory.getFactory();
        QuerySortServiceController serviceController = factory.getQuerySortServiceController();
        try {
            response = serviceController.sort(request.get(0));
        } catch (IOException e) {
            response = "Error";
            System.err.println(e.getCause());
        }
        return response;
    }
}
