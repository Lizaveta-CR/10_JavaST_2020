package by.tsvirko.task08.entity.state;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StopState implements State {
    private static final Logger logger = LogManager.getLogger(StopState.class);


    @Override
    public void action(Context context) {
        context.setState(this);
        logger.info("Matrix item in stopped state");
    }
}
