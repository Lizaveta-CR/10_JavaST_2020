package by.tsvirko.task08.entity.state;

public class StateFabric {
    private static StateFabric state = new StateFabric();

    private StartState startState = new StartState();
    private StopState stopState = new StopState();

    public static StateFabric getState() {
        return state;
    }

    public StartState getStartState() {
        return startState;
    }

    public StopState getStopState() {
        return stopState;
    }
}
