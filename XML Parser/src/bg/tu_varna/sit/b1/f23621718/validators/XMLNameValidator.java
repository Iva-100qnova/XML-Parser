package bg.tu_varna.sit.b1.f23621718.validators;

import bg.tu_varna.sit.b1.f23621718.contracts.validators.Validator;

/**
 * Валидатор за имена на XML елементи и атрибути.
 * <p>
 * Проверява дали дадено име не съдържа невалидни символи според базовите правила
 * за допустими символи в XML тагове и атрибути.
 */
public class XMLNameValidator implements Validator<String> {

    /**
     * Списък с невалидни символи, които не трябва да се съдържат в името.
     */
    public static final String INVALID_CHARACTERS = "\t\n\r\f\u000B !\"#$%&'()*+,./:;<=>?@[\\]^_`{|}~";

    /**
     * Проверява дали даден низ е валидно XML име.
     * <p>
     * Валидно е, ако не е {@code null} и не съдържа нито един от символите
     * в {@link #INVALID_CHARACTERS}.
     *
     * @param value низът, който ще се валидира
     * @return {@code true}, ако низът е валидно XML име; {@code false} в противен случай
     */
    @Override
    public boolean validate(String value) {
        if (value == null) {
            return false;
        }

        for (int i = 0; i < value.length(); i++) {
            if (INVALID_CHARACTERS.indexOf(value.charAt(i)) >= 0) {
                return false;
            }
        }
        return true;
    }
}
