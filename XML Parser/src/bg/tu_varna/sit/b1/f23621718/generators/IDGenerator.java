package bg.tu_varna.sit.b1.f23621718.generators;

import bg.tu_varna.sit.b1.f23621718.contracts.generators.*;

/**
 * Генератор за произволни идентификатори (ID), използващ букви и цифри.
 * <p>
 * Идентификаторът се състои от произволна последователност от символи с предварително зададена дължина.
 * Символите се избират от набор от главни и малки латински букви и цифри.
 */
public class IDGenerator implements Generator<String> {

    /**
     * Дължина на генерирания идентификатор.
     */
    private int size;

    /**
     * Набор от символи, използвани за създаване на идентификатори.
     */
    public static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789";

    /**
     * Конструктор, който задава дължината на идентификаторите.
     *
     * @param size брой символи в идентификатора
     */
    public IDGenerator(int size) {
        this.size = size;
    }

    /**
     * Връща текущата дължина на генерираните идентификатори.
     *
     * @return дължина на идентификатора
     */
    public int getSize() {
        return size;
    }

    /**
     * Задава нова дължина за генерираните идентификатори.
     *
     * @param size нова дължина
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Генерира нов произволен идентификатор със зададената дължина.
     *
     * @return генериран ID от тип {@link String}
     */
    @Override
    public String generate() {
        StringBuilder s = new StringBuilder(size);

        for (int i = 0; i < size; i++) {
            int ch = (int) (CHARACTERS.length() * Math.random());
            s.append(CHARACTERS.charAt(ch));
        }

        return s.toString();
    }
}
