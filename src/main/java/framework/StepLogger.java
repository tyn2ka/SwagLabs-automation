package framework;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.Objects;

public final class StepLogger {
    private static Logger logger;
    private static final Level loggerLevel = Level.DEBUG;


    public StepLogger() {}

    public static Logger getLogger() {
        if (Objects.isNull(logger)) {
            logger = Logger.getLogger("Global");
            logger.setLevel(loggerLevel);
        }

        return logger;
    }

}
