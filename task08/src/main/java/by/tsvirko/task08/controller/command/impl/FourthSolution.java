package by.tsvirko.task08.controller.command.impl;

import by.tsvirko.task08.controller.command.Command;
import by.tsvirko.task08.entity.Array;
import by.tsvirko.task08.entity.exception.ArrayException;
import by.tsvirko.task08.entity.exception.MatrixException;
import by.tsvirko.task08.service.ServiceFactory;
import by.tsvirko.task08.service.exception.ServiceInitException;

import java.util.List;

public class FourthSolution implements Command {
    @Override
    public Array execute(List<String> request) {
        Array response = null;
        ServiceFactory factory = ServiceFactory.getFactory();
        try {
            factory.getMatrixInitService().init(request.get(0)
                    , Integer.parseInt(request.get(1)));
            Array compute = factory.getServiceFourth().compute(request.get(2)
                    , Integer.parseInt(request.get(3)));
            response = compute;
        } catch (MatrixException | ServiceInitException | ArrayException e) {
            e.printStackTrace();
        }
        return response;
    }
}

