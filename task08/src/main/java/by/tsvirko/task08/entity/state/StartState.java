package by.tsvirko.task08.entity.state;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StartState implements State {
    private static final Logger logger = LogManager.getLogger(StartState.class);

    @Override
    public void action(Context context) {
        context.setState(this);
        logger.info("Matrix item in started state");
    }
}
