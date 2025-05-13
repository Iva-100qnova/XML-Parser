package bg.tu_varna.sit.b1.f23621718.generators;

import bg.tu_varna.sit.b1.f23621718.contracts.generators.*;

public class IDGenerator implements Generator<String> {
    private int size;
    public static String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789";

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public IDGenerator(int size) {
        this.size = size;
    }

    @Override
    public String generate() {

        StringBuilder s = new StringBuilder(size);

        for (int i = 0; i < size; i++) {
            int ch = (int) (CHARACTERS.length() * Math.random());
            s.append(CHARACTERS.charAt(ch));
        }

        return s.toString();
    }
}
