package com.endava.entities;

import java.time.LocalDateTime;

public class Employee {
    private String firstName;
    private String lastName;
    private LocalDateTime date;

    public Employee(String firstName, String lastName, LocalDateTime date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Employee : " +
                "First Name - " + firstName + " " +
                "Last Name - " + lastName +
                ", Date of In - " + date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employ = (Employee) o;

        if (getFirstName() != null ? !getFirstName().equals(employ.getFirstName()) : employ.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(employ.getLastName()) : employ.getLastName() != null)
            return false;
        return getDate() != null ? getDate().equals(employ.getDate()) : employ.getDate() == null;

    }

    @Override
    public int hashCode() {
        int result = getFirstName() != null ? getFirstName().hashCode() : 0;
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        return result;
    }
}
