package bg.tu_varna.sit.b1.f23621718.parsers;

import bg.tu_varna.sit.b1.f23621718.contracts.parsers.*;
import bg.tu_varna.sit.b1.f23621718.exceptions.menu.*;

import java.util.*;

/**
 * Клас, който парсва низ от входни параметри и ги разделя на отделни параметри.
 * Поддържа параметри с и без кавички. Параметри в кавички се третират като един цял.
 */
public class ParameterParser implements Parser<List<String>> {

    /**
     * Парсва подадения низ и връща списък с параметрите.
     * Параметрите могат да са разделени с интервали или да са заградени в двойни кавички.
     *
     * @param input входният низ с параметри
     * @return списък с отделните параметри
     * @throws InvalidInputException ако има отворена кавичка без затваряща
     */
    @Override
    public List<String> parse(String input) {
        List<String> params = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            switch (c) {
                case '"':
                    if(sb.length() != 0)
                    {
                        sb.append(c);
                        continue;
                    }
                    var nextQuoteIndex = input.indexOf('"', i + 1);
                    if (nextQuoteIndex == -1)
                        throw new InvalidInputException("Invalid parameter input. Quote has no matching closing quote");
                    params.add(input.substring(i+1, nextQuoteIndex));
                    sb.setLength(0);
                    i = nextQuoteIndex + 1;
                    break;
                case ' ':
                    if (!sb.isEmpty())
                        params.add(sb.toString());
                    sb.setLength(0);
                    break;
                default:
                    sb.append(c);
            }
        }

        if (!sb.isEmpty())
            params.add(sb.toString());

        return params;
    }
}
