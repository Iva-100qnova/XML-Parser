package bg.tu_varna.sit.b1.f23621718.validators;


import bg.tu_varna.sit.b1.f23621718.contracts.validators.Validator;

public class XMLNameValidator implements Validator<String> {
    public static final String INVALID_CHARACTERS = "\t\n\r\f\u000B !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

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
