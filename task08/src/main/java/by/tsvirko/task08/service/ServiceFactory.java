package by.tsvirko.task08.service;

public class ServiceFactory {
    private static ServiceFactory factory = new ServiceFactory();
    private InitService matrixInitService = new MatrixInitServiceImpl();
    private SolutionService solutionService = new SolutionService();

    public static ServiceFactory getFactory() {
        return factory;
    }

    public InitService getMatrixInitService() {
        return matrixInitService;
    }

    public SolutionService getSolutionService() {
        return solutionService;
    }
}
