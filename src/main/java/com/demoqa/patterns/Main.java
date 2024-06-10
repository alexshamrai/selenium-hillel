package com.demoqa.patterns;

public class Main {

    public static void main(String[] args) {
        Employee john = new Employee.Builder("John", "Lennon", 1245)
                .yearOfBirth(1940)
                .registrationAddress("Liverpool")
                .build();

        System.out.println(john);
    }
}
