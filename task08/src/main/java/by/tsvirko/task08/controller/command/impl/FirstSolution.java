package by.tsvirko.task08.controller.command.impl;

import by.tsvirko.task08.controller.command.Command;
import by.tsvirko.task08.entity.exception.ArrayException;
import by.tsvirko.task08.entity.exception.MatrixException;
import by.tsvirko.task08.service.ServiceFactory;
import by.tsvirko.task08.service.exception.ServiceInitException;

import java.util.List;

public class FirstSolution implements Command {
    @Override
    public String execute(List<String> request) {
        String response = null;
        ServiceFactory factory = ServiceFactory.getFactory();
        try {
            factory.getMatrixInitService().init(request.get(0)
                    , Integer.parseInt(request.get(1)));
            factory.getSolutionService().compute(request.get(2)
                    , Integer.parseInt(request.get(3)));
            response = "success";
        } catch (MatrixException | ServiceInitException | ArrayException e) {
            response = "fail";
            e.printStackTrace();
        }
        return response;
    }
}
