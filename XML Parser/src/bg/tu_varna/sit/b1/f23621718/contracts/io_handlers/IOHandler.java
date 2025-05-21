package bg.tu_varna.sit.b1.f23621718.contracts.io_handlers;

import bg.tu_varna.sit.b1.f23621718.contracts.loggers.*;

import java.util.*;

/**
 * Интерфейс, дефиниращ входно-изходен обработчик, който предоставя механизми за четене от вход и логване на съобщения.
 * <p>
 * Разширява {@link Logger}, което позволява използването на методи за логване директно от IOHandler.
 */
public interface IOHandler extends Logger {

    /**
     * Връща {@link Scanner} обект, използван за четене от входен поток (обикновено стандартен вход).
     *
     * @return {@code Scanner} за четене на входни данни.
     */
    Scanner getReader();

    /**
     * Връща {@link Logger} обект, който може да се използва за логване на съобщения.
     *
     * @return {@code Logger} за логване.
     */
    Logger getLogger();
}
