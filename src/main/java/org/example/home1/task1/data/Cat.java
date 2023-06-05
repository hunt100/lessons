package org.example.home1.task1.data;

public class Cat extends Animal {

    private String breed;

    private Owner owner;

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void greet() {
        if (owner != null) {
            System.out.printf("Meow! My name is %s. I am %d years old. My owner - %s", getName(), getAge(), owner.getName());
        } else {
            System.out.printf("Meow! My name is %s. I am %d years old.", getName(), getAge());
        }
    }

    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE;
    }
}
