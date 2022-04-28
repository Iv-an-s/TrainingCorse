package com.geekbrains.isemenov.trainingCorse.lesson1.task1;

public class Person {
    private final String firstName;
    private final String lastName;
    private final String middleName;
    private final String country;
    private final String address;
    private final String phone;
    private final int age;
    private final String gender;

    public static class Builder {
        //обязательные параметры:
        private final String firstName;
        private final String lastName;
        private final String gender;
        //необязательные параметры:
        private String middleName = "";
        private String country = "";
        private String address = "";
        private String phone = "";
        private int age = 0;

        public Builder(String firstName, String lastName, String gender) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.gender = gender;
        }

        public Builder middleName(String val) {
            middleName = val;
            return this;
        }

        public Builder country(String val) {
            country = val;
            return this;
        }

        public Builder address(String val) {
            address = val;
            return this;
        }

        public Builder age(int val) {
            age = val;
            return this;
        }

        public Builder phone(String val) {
            phone = val;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    private Person(Builder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        middleName = builder.middleName;
        country = builder.country;
        address = builder.address;
        phone = builder.phone;
        age = builder.age;
        gender = builder.gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
