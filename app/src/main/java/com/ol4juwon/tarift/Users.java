package com.ol4juwon.tarift;

public class Users {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String uid;
    private int accountBalance;





    public String getUid() {
        return uid;
    }
    public Users(String email, String firstName, String lastName, String password, String uid, int accountBalance) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.uid = uid;
        this.accountBalance = accountBalance;
    }
//
//    public Users(String email, String firstName, String lastName, String password, String uid) {
//        this.email = email;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.password = password;
//        this.uid = uid;
//    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public Users(String email, String firstName, String lastName, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users() {}

    public Users(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }
}
