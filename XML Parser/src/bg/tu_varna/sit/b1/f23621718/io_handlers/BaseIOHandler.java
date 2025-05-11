package bg.tu_varna.sit.b1.f23621718.io_handlers;

import bg.tu_varna.sit.b1.f23621718.contracts.io_handlers.*;
import bg.tu_varna.sit.b1.f23621718.contracts.loggers.*;
import bg.tu_varna.sit.b1.f23621718.loggers.*;

import java.util.*;

public class BaseIOHandler implements IOHandler {

    private Scanner reader;
    private Logger logger;

    public BaseIOHandler(Scanner reader, Logger logger) {
        this.reader = reader;
        this.logger = logger;
    }

    @Override
    public Scanner getReader() {
        return reader;
    }

    @Override
    public Logger getLogger() {
        return logger;
    }

    @Override
    public void log(String message) {
        this.logger.log(message);
    }
}
