package bg.tu_varna.sit.b1.f23621718.validators;


import bg.tu_varna.sit.b1.f23621718.contracts.validators.Validator;

public class XMLTextValidator implements Validator<String> {
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
