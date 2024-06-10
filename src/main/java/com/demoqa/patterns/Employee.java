package com.demoqa.patterns;

public class Employee {

    private final String firstName;
    private final String secondName;
    private final int yearOfBirth;
    private final long employeeId;
    private final String registrationAddress;

    public Employee(Builder builder) {
        this.firstName = builder.firstName;
        this.secondName = builder.secondName;
        this.yearOfBirth = builder.yearOfBirth;
        this.employeeId = builder.employeeId;
        this.registrationAddress = builder.registrationAddress;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", employeeId=" + employeeId +
                ", registrationAddress='" + registrationAddress + '\'' +
                '}';
    }

    public static class Builder {

        private final String firstName;
        private final String secondName;
        private final long employeeId;

        private int yearOfBirth;
        private String registrationAddress;

        public Builder(String firstName, String secondName, long employeeId) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.employeeId = employeeId;
        }

        public Builder registrationAddress(String val) {
            this.registrationAddress = val;
            return this;
        }

        public Builder yearOfBirth(int val) {
            this.yearOfBirth = val;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}
