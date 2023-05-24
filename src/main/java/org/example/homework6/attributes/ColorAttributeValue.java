package org.example.homework6.attributes;

public class ColorAttributeValue extends AttributeValue {

    public static final String[] COLORS = new String[]{
            "RED",
            "BLUE",
            "GREEN",
            "WHITE",
            "BLACK"
    };

    public ColorAttributeValue(String value) {
        super(AttributeType.COLOR.toString(), value);
    }

    @Override
    public AttributeType getType() {
        return AttributeType.COLOR;
    }

    public static String randomValue() {
        return getRandomElement(COLORS);
    }

}
