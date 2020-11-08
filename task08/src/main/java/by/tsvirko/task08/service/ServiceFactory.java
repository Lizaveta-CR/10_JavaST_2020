package by.tsvirko.task08.service;

import by.tsvirko.task08.service.firstService.SolutionService;
import by.tsvirko.task08.service.fourthSolution.SolutionServiceFourth;
import by.tsvirko.task08.service.thirdService.SolutionServiceThird;

public class ServiceFactory {
    private static ServiceFactory factory = new ServiceFactory();
    private InitService matrixInitService = new MatrixInitServiceImpl();
    private SolutionService solutionService = new SolutionService();
    private SolutionServiceThird serviceThird = new SolutionServiceThird();
    private SolutionServiceFourth serviceFourth = new SolutionServiceFourth();

    public static ServiceFactory getFactory() {
        return factory;
    }

    public InitService getMatrixInitService() {
        return matrixInitService;
    }

    public SolutionService getSolutionService() {
        return solutionService;
    }

    public SolutionServiceFourth getServiceFourth() {
        return serviceFourth;
    }

    public SolutionServiceThird getServiceThird() {
        return serviceThird;
    }
}
