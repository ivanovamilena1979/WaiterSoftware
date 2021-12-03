package company;

import java.io.IOException;

public abstract class Employee {

        public String userName;
        private String password;

        public Employee() {

        }

        // constructor that takes only the name of the Employee
        public Employee(String userName) {
            this(userName,  null);
        }

        // constructor that takes name and password
        public Employee(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }

        public String getUserName() {
            return userName;
        }

        public void setFirstName(String userName) {
            this.userName = userName;
        }


    public void setLastName(String lastName) {
        this.userName = lastName;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

        public abstract void getMenu() throws IOException;
}
