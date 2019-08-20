package com.example.springbootdemo.model;

import java.util.List;

public class test {
    /**
     * id : 5
     * employees : [{"firstName":"Bill","lastName":"Gates"},{"firstName":"George","lastName":"Bush"},{"firstName":"Thomas","lastName":"Carter"}]
     */

    private int id;
    private List<EmployeesBean> employees;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<EmployeesBean> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeesBean> employees) {
        this.employees = employees;
    }

    public static class EmployeesBean {
        /**
         * firstName : Bill
         * lastName : Gates
         */

        private String firstName;
        private String lastName;

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
    }
}
