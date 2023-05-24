package org.example.homework6;

import org.example.homework6.attributes.*;
import org.example.homework6.filter.SimpleLaptopFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Laptop> laptops = fillLaptops(10);
        System.out.println("ORIGINAL LAPTOPS:");
        laptops.forEach(System.out::println);
        System.out.println("-------------------------------------------------------------------------------------------");
        SimpleLaptopFilter.SimpleLaptopFilterBuilder filterBuilder = SimpleLaptopFilter.builder();
        while (true) {
            System.out.println("Get operation: 1 - Add filter\n2 - Show result");
            int op = Integer.parseInt(scanner.nextLine());
            if (op == 1) {
                System.out.println("Get criteria: 1 - RAM\n2 - HDD size\n3 - OS type\n4 - Color\n\n");
                op = Integer.parseInt(scanner.nextLine());
                AttributeType type = getAttributeType(op);
                System.out.println("Available values:");
                List<String> typeValues = ParametersFactory.ATTRIBUTE_TYPE_LIST_MAP.get(type);
                System.out.println(typeValues);
                String preferredValue = scanner.nextLine();
                addFilterCriteria(filterBuilder, type, preferredValue);
            } else if (op == 2) {
                System.out.println("Final result:");
                SimpleLaptopFilter finishFilter = filterBuilder.build();
                laptops.stream()
                        .filter(finishFilter.getPredicate())
                        .toList()
                        .forEach(System.out::println);
                break;
            } else {
                throw new RuntimeException("Unknown value!");
            }
        }
    }

    private static List<Laptop> fillLaptops(int size) {
        List<Laptop> laptops = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            laptops.add(Laptop.builder()
                    .name("Laptop#" + i)
                    .attributeValue(new ColorAttributeValue(ColorAttributeValue.randomValue()))
                    .attributeValue(new RamAttributeValue(RamAttributeValue.randomValue()))
                    .attributeValue(new OsAttributeValue(OsAttributeValue.randomValue()))
                    .attributeValue(new HddAttributeValue(HddAttributeValue.randomValue()))
                    .build());
        }
        return laptops;
    }

    private static AttributeType getAttributeType(int i) {
        return switch (i) {
            case 1 -> AttributeType.RAM;
            case 2 -> AttributeType.HDD;
            case 3 -> AttributeType.OS;
            case 4 -> AttributeType.COLOR;
            default -> throw new RuntimeException("Unknown operation");
        };
    }

    private static void addFilterCriteria(SimpleLaptopFilter.SimpleLaptopFilterBuilder filterBuilder, AttributeType type, String addValue) {
        switch (type) {
            case COLOR -> filterBuilder.color(addValue);
            case OS -> filterBuilder.os(addValue);
            case RAM -> filterBuilder.ram(addValue);
            case HDD -> filterBuilder.hdd(addValue);
        }
    }
}
