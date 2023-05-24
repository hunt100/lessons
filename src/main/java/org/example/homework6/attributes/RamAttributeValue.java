package org.example.homework6.attributes;

public class RamAttributeValue extends AttributeValue {

    public static final String[] RAM_SIZE = new String[]{
            "4 Gb",
            "8 Gb",
            "16 Gb",
            "32 Gb",
            "64 Gb"
    };

    public RamAttributeValue(String value) {
        super(AttributeType.RAM.toString(), value);
    }

    @Override
    public AttributeType getType() {
        return AttributeType.RAM;
    }

    public static String randomValue() {
        return getRandomElement(RAM_SIZE);
    }
}
