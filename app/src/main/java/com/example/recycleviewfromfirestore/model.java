package com.example.recycleviewfromfirestore;

public class model {

    public model(){}

    public model(String firstName, String lastName, long age) {
        FirstName = firstName;
        LastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    String FirstName, LastName;
    long age;

}
