package bg.tu_varna.sit.b1.f23621718.models;

import java.util.List;

public abstract class XMLContent {
    public abstract List<XMLContent> getChildren();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (var child : getChildren()) {
            sb.append("\t").append(child.toString().replaceAll("\n", "\n\t")).append("\n");
        }
        return sb.toString();
    }
}
