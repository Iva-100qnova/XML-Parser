package bg.tu_varna.sit.b1.f23621718.contracts.commands;

import java.util.*;

/**
 * Интерфейс, дефиниращ командa с параметри.
 *
 * <p>Наследява базовия интерфейс {@link Command} и добавя методи за работа
 * с параметри, които могат да бъдат зададени на командата.</p>
 */
public interface ParamsCommand extends Command {

    /**
     * Връща списък с параметрите на командата.
     *
     * @return {@code List<String>} със зададените параметри.
     */
    List<String> getParameters();

    /**
     * Връща параметрите като единен низ, подходящ за визуализиране.
     *
     * @return {@code String} с формат: " <param1> <param2> ..." или празен низ, ако няма параметри.
     */
    String getParametersAsString();

    /**
     * Добавя параметър към командата.
     *
     * @param parameter Параметърът, който ще бъде добавен.
     */
    void addParameter(String parameter);
}
