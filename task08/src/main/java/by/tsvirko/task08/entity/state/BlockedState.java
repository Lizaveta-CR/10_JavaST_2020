package by.tsvirko.task08.entity.state;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BlockedState implements State {
    private static final Logger logger = LogManager.getLogger(BlockedState.class);


    @Override
    public void action(Context context) {
        context.setState(this);
        logger.info("Matrix item in blocked state");
    }
}
