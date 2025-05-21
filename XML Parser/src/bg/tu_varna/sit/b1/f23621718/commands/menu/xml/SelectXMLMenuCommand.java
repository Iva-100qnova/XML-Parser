package bg.tu_varna.sit.b1.f23621718.commands.menu.xml;

import bg.tu_varna.sit.b1.f23621718.commands.menu.*;
import bg.tu_varna.sit.b1.f23621718.data.traversals.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;

import java.util.*;

/**
 * Команда от менюто, която извежда стойността на атрибут по зададен ключ за даден XML елемент.
 * <p>
 * Използва {@link XMLElementTraversal#getAttribute(String, String)} за достъп до стойността
 * на атрибута, като приема два параметъра:
 * <ul>
 *     <li><b>id</b> – идентификатор на XML елемента</li>
 *     <li><b>key</b> – името на атрибута, чиято стойност се извежда</li>
 * </ul>
 */
public class SelectXMLMenuCommand extends AbstractMenuCommand {

    /**
     * Конструктор, който инициализира командата с име, описание и необходимите параметри.
     *
     * @param menu менюто, към което принадлежи командата
     */
    public SelectXMLMenuCommand(Menu menu) {
        super("select", "print the value of the <key> attribute for element <id>", menu);
        addParameter("id");
        addParameter("key");
    }

    /**
     * Изпълнява логиката по извеждане на стойността на атрибута от XML елемент.
     *
     * @param params списък от два параметъра – ID на елемента и ключ на атрибута
     */
    @Override
    protected void doWork(List<String> params) {
        log(XMLElementTraversal.getAttribute(id, key));
    }

    private String id;
    private String key;

    /**
     * Валидира параметрите и инициализира ID и ключа.
     *
     * @param params списък от два параметъра: ID и ключ
     */
    @Override
    protected void validate(List<String> params) {
        super.validate(params);
        this.id = params.getFirst();
        this.key = params.get(1);
    }
}
