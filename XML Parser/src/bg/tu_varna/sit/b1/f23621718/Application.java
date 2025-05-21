package bg.tu_varna.sit.b1.f23621718;

import bg.tu_varna.sit.b1.f23621718.io_handlers.*;
import bg.tu_varna.sit.b1.f23621718.loggers.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;

import java.util.*;

/**
 * Основен клас на приложението, който стартира менюто за XML парсинг.
 * Създава IOHandler за вход от конзолата и логване на съобщения.
 */
public class Application {

    /**
     * Главен метод, който стартира програмата.
     * Създава ново XMLParserMenu с IOHandler и стартира менюто.
     *
     * @param args аргументи на командния ред (не се използват)
     */
    public static void main(String[] args) {
        new XMLParserMenu(new BaseIOHandler(new Scanner(System.in), new ConsoleLogger())).startMenu();
    }
}