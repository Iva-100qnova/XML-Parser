package bg.tu_varna.sit.b1.f23621718;

import bg.tu_varna.sit.b1.f23621718.loggers.*;
import bg.tu_varna.sit.b1.f23621718.menu.*;

public class Application {
    public static void main(String[] args) {
        var logger = new ConsoleLogger();
        new XMLParserMenu(logger).startMenu();
    }
}
