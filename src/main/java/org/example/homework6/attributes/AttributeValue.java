package org.example.homework6.attributes;

import lombok.*;

import java.util.Random;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class AttributeValue {

    private String name;

    private String value;

    public abstract AttributeType getType();

    protected static String getRandomElement(String...elements) {
        var random = new Random();
        return elements[random.nextInt(elements.length)];
    }
}
