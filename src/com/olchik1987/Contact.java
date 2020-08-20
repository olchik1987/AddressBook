package com.olchik1987;

public class Contact {
    // Имя
    private String name;
    //Фамилия
    private String lastName;
    //Телефон
    private long phoneNumber;
    //Адрес
    private Address address;
    //Имейл
    private String email;

    public Contact(){
    }

    public Contact(String name){
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email)  {
        this.email = email;
    }
}
