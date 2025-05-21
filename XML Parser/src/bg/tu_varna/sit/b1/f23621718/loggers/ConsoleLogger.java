package bg.tu_varna.sit.b1.f23621718.loggers;

import bg.tu_varna.sit.b1.f23621718.contracts.loggers.Logger;

/**
 * Имплементация на Logger, която извежда лог съобщения на конзолата.
 */
public class ConsoleLogger implements Logger {

    /**
     * Извежда дадено съобщение на конзолата.
     *
     * @param message съобщението за логване
     */
    @Override
    public void log(String message) {
        System.out.print(message);
    }
}
