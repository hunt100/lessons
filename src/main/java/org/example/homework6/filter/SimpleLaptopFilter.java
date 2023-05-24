package org.example.homework6.filter;

import lombok.Getter;
import org.example.homework6.Laptop;
import org.example.homework6.attributes.AttributeType;

import java.util.function.Predicate;

@Getter
public class SimpleLaptopFilter {

    public Predicate<Laptop> predicate;

    SimpleLaptopFilter(Predicate<Laptop> predicate) {
        this.predicate = predicate;
    }

    public static SimpleLaptopFilterBuilder builder() {
        return new SimpleLaptopFilterBuilder();
    }

    public static class SimpleLaptopFilterBuilder {
        private Predicate<Laptop> color;
        private Predicate<Laptop> hdd;
        private Predicate<Laptop> os;
        private Predicate<Laptop> ram;

        SimpleLaptopFilterBuilder() {
        }

        public SimpleLaptopFilterBuilder color(String value) {
            Predicate<Laptop> newPredicate = laptop -> laptop.getAttributeValues().stream()
                    .anyMatch(attributeValue -> AttributeType.COLOR == attributeValue.getType() && attributeValue.getValue().equals(value));
            if (color == null) {
                this.color = newPredicate;
            }
            this.color = this.color.or(newPredicate);
            return this;
        }

        public SimpleLaptopFilterBuilder hdd(String value) {
            Predicate<Laptop> newPredicate = laptop -> laptop.getAttributeValues().stream()
                    .anyMatch(attributeValue -> AttributeType.HDD == attributeValue.getType() && attributeValue.getValue().equals(value));
            if (hdd == null) {
                this.hdd = newPredicate;
            }
            this.hdd = this.hdd.or(newPredicate);
            return this;
        }

        public SimpleLaptopFilterBuilder os(String value) {
            Predicate<Laptop> newPredicate = laptop -> laptop.getAttributeValues().stream()
                    .anyMatch(attributeValue -> AttributeType.OS == attributeValue.getType() && attributeValue.getValue().equals(value));
            if (os == null) {
                this.os = newPredicate;
            }
            this.os = this.os.or(newPredicate);
            return this;
        }

        public SimpleLaptopFilterBuilder ram(String value) {
            Predicate<Laptop> newPredicate = laptop -> laptop.getAttributeValues().stream()
                    .anyMatch(attributeValue -> AttributeType.RAM == attributeValue.getType() && attributeValue.getValue().equals(value));
            if (ram == null) {
                this.ram = newPredicate;
            }
            this.ram = this.ram.or(newPredicate);
            return this;
        }

        public SimpleLaptopFilter build() {
            Predicate<Laptop> finalPredicate = laptop -> true;
            if (color != null) {
                finalPredicate = finalPredicate.and(color);
            }
            if (hdd != null) {
                finalPredicate = finalPredicate.and(hdd);
            }
            if (os != null) {
                finalPredicate = finalPredicate.and(os);
            }
            if (ram != null) {
                finalPredicate = finalPredicate.and(ram);
            }

            return new SimpleLaptopFilter(finalPredicate);
        }
    }
}
