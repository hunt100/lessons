package org.example.homework6;

import lombok.*;
import org.example.homework6.attributes.AttributeValue;

import java.util.Set;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Laptop {

    private final UUID id = UUID.randomUUID();

    private String name;

    @Singular
    private Set<AttributeValue> attributeValues;

}
