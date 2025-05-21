package bg.tu_varna.sit.b1.f23621718.contracts.menu;

/**
 * Интерфейс, дефиниращ операции, свързани с управление на път до файл в меню.
 * <p>
 * Използва се за поддържане и манипулиране на текущо отворения файл.
 */
public interface FileMenu {

    /**
     * Връща текущия път до отворения файл.
     *
     * @return Пътят до файла като {@link String}, или {@code null}, ако няма отворен файл.
     */
    String getFilePath();

    /**
     * Задава пътя до текущия файл.
     *
     * @param file Новият път до файла като {@link String}.
     */
    void setFilePath(String file);
}