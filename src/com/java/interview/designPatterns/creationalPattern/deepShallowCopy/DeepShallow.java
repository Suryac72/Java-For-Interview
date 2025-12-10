package com.java.interview.designPatterns.deepShallowCopy;

class Address {
    String city;

    public Address(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return city;
    }
}

class Person implements Cloneable {
    String name;
    Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // -------- SHALLOW COPY ----------
    public Person shallowCopy() {
        return new Person(this.name, this.address); // same address reference!
    }

    // -------- DEEP COPY --------------
    public Person deepCopy() {
        Address newAddress = new Address(this.address.city); // new object
        return new Person(this.name, newAddress);
    }

    @Override
    public String toString() {
        return name + " from " + address;
    }
}
public class DeepShallow {
    public static void main(String[] args) {
        Person p1 = new Person("Surya", new Address("Delhi"));

        // Shallow Copy
        Person shallow = p1.shallowCopy();

        // Deep Copy
        Person deep = p1.deepCopy();

        // Modify original person's address
        p1.address.city = "Mumbai";

        System.out.println("Original: " + p1);
        System.out.println("Shallow Copy: " + shallow);
        System.out.println("Deep Copy: " + deep);
    }
}
