package bg.tu_varna.sit.b1.f23621718;

import bg.tu_varna.sit.b1.f23621718.io_handlers.*;
import bg.tu_varna.sit.b1.f23621718.loggers.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;

import java.util.*;

public class Application {
    public static void main(String[] args) {

        new XMLParserMenu(new BaseIOHandler(new Scanner(System.in), new ConsoleLogger())).startMenu();
    }
}
