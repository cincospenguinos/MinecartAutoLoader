package usa.cincospenguinos.minecart_storage;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Why does the java.util.logging.Logger logger suck so much ass? No info(), warn(), or err()?
 * It's easy to add and makes life so much better.
 */
public class BetterLogger {
    private Logger _logger;

    BetterLogger(Logger logger) {
        _logger = logger;
    }

    public void info(String msg) {
        log(Level.INFO, msg);
    }

    public void warn(String msg) {
        log(Level.WARNING, msg);
    }

    public void err(String msg) {
        log(Level.SEVERE, msg);
    }

    public void log(Level level, String msg) {
        _logger.log(level, msg);
    }
}
