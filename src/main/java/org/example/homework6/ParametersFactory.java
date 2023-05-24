package org.example.homework6;

import org.example.homework6.attributes.*;

import java.util.List;
import java.util.Map;

public final class ParametersFactory {

    private ParametersFactory() {
    }

    public static final Map<AttributeType, List<String>> ATTRIBUTE_TYPE_LIST_MAP = Map.of(
            AttributeType.COLOR, List.of(ColorAttributeValue.COLORS),
            AttributeType.HDD, List.of(HddAttributeValue.HDD_SIZE),
            AttributeType.OS, List.of(OsAttributeValue.OS_NAMES),
            AttributeType.RAM, List.of(RamAttributeValue.RAM_SIZE)
    );

}
