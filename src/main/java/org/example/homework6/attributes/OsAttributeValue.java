package org.example.homework6.attributes;

public class OsAttributeValue extends AttributeValue {

    public static final String[] OS_NAMES = new String[]{
            "None",
            "Windows",
            "MacOS",
            "Linux"
    };

    public OsAttributeValue(String value) {
        super(AttributeType.OS.toString(), value);
    }

    @Override
    public AttributeType getType() {
        return AttributeType.OS;
    }

    public static String randomValue() {
        return getRandomElement(OS_NAMES);
    }

}
