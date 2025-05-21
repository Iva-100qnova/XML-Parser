package bg.tu_varna.sit.b1.f23621718.io_handlers;

import bg.tu_varna.sit.b1.f23621718.contracts.io_handlers.*;
import bg.tu_varna.sit.b1.f23621718.contracts.loggers.*;
import bg.tu_varna.sit.b1.f23621718.loggers.*;

import java.util.*;

/**
 * Основен клас за обработка на входно-изходни операции в приложението.
 * <p>
 * Осигурява достъп до входен поток от тип {@link Scanner} и логика за извеждане на съобщения чрез {@link Logger}.
 */
public class BaseIOHandler implements IOHandler {

    private Scanner reader;
    private Logger logger;

    /**
     * Конструктор за създаване на IO обработчик с конкретен входен поток и логер.
     *
     * @param reader обект от тип {@link Scanner}, използван за четене от вход
     * @param logger обект от тип {@link Logger}, използван за логване на съобщения
     */
    public BaseIOHandler(Scanner reader, Logger logger) {
        this.reader = reader;
        this.logger = logger;
    }

    /**
     * Връща текущия входен поток (Scanner).
     *
     * @return {@link Scanner} за четене на потребителски вход
     */
    @Override
    public Scanner getReader() {
        return reader;
    }

    /**
     * Връща логера, използван за извеждане на съобщения.
     *
     * @return {@link Logger}, който обработва логовете
     */
    @Override
    public Logger getLogger() {
        return logger;
    }

    /**
     * Извежда съобщение чрез предоставения {@link Logger}.
     *
     * @param message текстът, който трябва да се логне
     */
    @Override
    public void log(String message) {
        this.logger.log(message);
    }
}
