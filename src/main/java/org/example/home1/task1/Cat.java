package org.example.home1.task1;

public class Cat {

    private String name;

    private int age;

    private Owner owner;

    //region getters/setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    //endregion

    public void greet() {
        if (owner != null) {
            System.out.printf("Meow! My name is %s. I am %d years old. My owner - %s", name, age, owner.getName());
        } else {
            System.out.printf("Meow! My name is %s. I am %d years old.", name, age);
        }
    }
}
