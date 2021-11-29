package com.company;

public abstract class Employee {

        private String firstName;
        private String lastName;
        private String password;

        public Employee() {

        }

        // constructor that takes only the name of the Employee
        public Employee(String firstName, String lastName) {
            this(firstName, lastName, null);
        }

        // constructor that takes name and password
        public Employee(String firstName, String lastName, String password) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.password = password;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

        public abstract void getMenu();
}
