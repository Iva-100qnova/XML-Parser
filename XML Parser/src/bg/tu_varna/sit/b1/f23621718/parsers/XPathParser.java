package bg.tu_varna.sit.b1.f23621718.parsers;

import bg.tu_varna.sit.b1.f23621718.commands.xpath.*;
import bg.tu_varna.sit.b1.f23621718.contracts.commands.*;
import bg.tu_varna.sit.b1.f23621718.contracts.parsers.Parser;
import bg.tu_varna.sit.b1.f23621718.exceptions.*;

import java.util.*;

public class XPathParser implements Parser<List<XPathCommand>> {

    @Override
    public List<XPathCommand> parse(String xpath) {
        List<XPathCommand> commands = new ArrayList<>();
        if (xpath == null || xpath.isEmpty()) {
            return commands;
        }
        String expr = xpath;
        while (expr.startsWith("/")) expr = expr.substring(1);
        while (expr.endsWith("/")) expr = expr.substring(0, expr.length() - 1);

        String[] steps = expr.split("/");
        boolean isFirst = true;
        for (String step : steps) {
            parseStep(step, commands, isFirst);
            isFirst = false;
        }
        return commands;
    }

    private static void parseStep(String step, List<XPathCommand> commands, boolean isFirst) {
        int compOpen = step.indexOf('(');
        int compClose = step.lastIndexOf(')');
        if (compOpen > 0 && compClose == step.length() - 1) {
            String elem = step.substring(0, compOpen);
            String inside = step.substring(compOpen + 1, compClose);
            if (inside.contains("=\"") && inside.endsWith("\"")) {
                int eq = inside.indexOf("=\"");
                String key = inside.substring(0, eq);
                String val = inside.substring(eq + 2, inside.length() - 1);
                commands.add(isFirst ? new FindAllCommand(elem) : new ChildCommand(elem));
                commands.add(new ComparisonFilterCommand(key, val));
                return;
            }
        }

        int attrOpen = step.indexOf("(@");
        if (attrOpen >= 0 && step.endsWith(")")) {
            String before = step.substring(0, attrOpen);
            String attr = step.substring(attrOpen + 2, step.length() - 1);
            parseStep(before, commands, isFirst);
            commands.add(new AttributeCommand(attr));
            return;
        }

        int predOpen = step.indexOf('[');
        int predClose = step.lastIndexOf(']');
        if (predOpen >= 0 && predClose > predOpen) {
            String elem = step.substring(0, predOpen);
            String inside = step.substring(predOpen + 1, predClose);
            try {
                int idx = Integer.parseInt(inside);
                commands.add(isFirst ? new FindAllCommand(elem) : new ChildCommand(elem));
                commands.add(new IndexFilterCommand(idx));
                return;
            } catch (NumberFormatException e) {
                throw new InvalidXMLPathException("Could not parse index: " + inside);
            }
        }

        // Plain element navigation
        commands.add(isFirst ? new FindAllCommand(step) : new ChildCommand(step));
    }
}
