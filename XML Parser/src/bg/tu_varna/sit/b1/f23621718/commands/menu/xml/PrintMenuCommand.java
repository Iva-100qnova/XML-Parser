package bg.tu_varna.sit.b1.f23621718.commands.menu.xml;

import bg.tu_varna.sit.b1.f23621718.commands.menu.*;
import bg.tu_varna.sit.b1.f23621718.data.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;

import java.util.*;

/**
 * Команда от менюто, която отпечатва текущото XML съдържание.
 * <p>
 * Използва {@link XMLRoot#getRootElement()} за достъп до кореновия XML елемент
 * и отпечатва неговото съдържание чрез метода {@code toString()}.
 */
public class PrintMenuCommand extends AbstractMenuCommand {

    /**
     * Конструктор, който инициализира командата с име, описание и меню.
     *
     * @param menu менюто, към което принадлежи командата
     */
    public PrintMenuCommand(Menu menu) {
        super("print", "print the XML content", menu);
    }

    /**
     * Извежда съдържанието на кореновия XML елемент в текстов вид.
     *
     * @param params не се използват параметри за тази команда
     */
    @Override
    protected void doWork(List<String> params) {
        log(XMLRoot.getRootElement().toString());
    }
}
