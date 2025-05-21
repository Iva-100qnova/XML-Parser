package bg.tu_varna.sit.b1.f23621718.validators;

import bg.tu_varna.sit.b1.f23621718.contracts.validators.Validator;

/**
 * Валидатор за текстово съдържание в XML документи.
 * <p>
 * Целта на този валидатор е да провери дали даден низ съдържа невалидни елементи,
 * които наподобяват XML тагове с валидни имена.
 * Ако текстът съдържа подстринг с форма &lt;име&gt;, където "име" е валидно XML име,
 * тогава текстът се счита за невалиден.
 */
public class XMLTextValidator implements Validator<String> {

    /**
     * Проверява дали подаденият текст е валиден XML текст.
     *
     * @param text текстът за валидиране
     * @return {@code true}, ако текстът не съдържа валидни XML тагове; {@code false} в противен случай
     */
    @Override
    public boolean validate(String text) {
        if (text == null) {
            return false;
        }

        var nameValidator = new XMLNameValidator();

        int len = text.length();
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == '<') {
                int close = text.indexOf('>', i + 1);
                if (close == -1) {
                    break;
                }
                String inner = text.substring(i + 1, close);
                if (nameValidator.validate(inner)) {
                    return false;
                }
            }
        }
        return true;
    }
}
