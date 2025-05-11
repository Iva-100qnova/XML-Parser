package bg.tu_varna.sit.b1.f23621718.contracts.io_handlers;

import bg.tu_varna.sit.b1.f23621718.contracts.loggers.*;

import java.util.*;

public interface IOHandler extends Logger {
    Scanner getReader();

    Logger getLogger();
}
