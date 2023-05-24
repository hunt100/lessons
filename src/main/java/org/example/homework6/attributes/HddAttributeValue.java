package org.example.homework6.attributes;

public class HddAttributeValue extends AttributeValue {

    public static final String[] HDD_SIZE = new String[]{
            "1000 Gb",
            "2000 Gb",
            "4000 Gb",
            "8000 Gb",
            "16000 Gb"
    };

    public HddAttributeValue(String value) {
        super(AttributeType.HDD.toString(), value);
    }

    @Override
    public AttributeType getType() {
        return AttributeType.HDD;
    }

    public static String randomValue() {
        return getRandomElement(HDD_SIZE);
    }

}
