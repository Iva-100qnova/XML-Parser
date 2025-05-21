package bg.tu_varna.sit.b1.f23621718.models;

import java.util.List;

/**
 * Абстрактен клас, който представлява съдържание в XML структура.
 * Може да бъде както елемент, така и текстов възел.
 * Предоставя метод за достъп до децата (под-възлите) на този възел.
 */
public abstract class XMLContent {

    /**
     * Връща списък с децата (под-възлите) на този XML възел.
     *
     * @return списък от XMLContent, представляващ децата на текущия възел
     */
    public abstract List<XMLContent> getChildren();

    /**
     * Връща низово представяне на този XML възел заедно с неговите деца,
     * като добавя табулации за по-добра четливост на вложените нива.
     *
     * @return низ, който представя дървовидната структура на XML съдържанието
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (var child : getChildren()) {
            sb.append("\t").append(child.toString().replaceAll("\n", "\n\t")).append("\n");
        }
        return sb.toString();
    }
}

