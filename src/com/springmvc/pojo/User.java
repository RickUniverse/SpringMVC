package com.springmvc.pojo;

/**
 * @author lijichen
 * @date 2020/11/21 - 18:43
 */
public class User {
    private Integer id;
    private String name;
    private String password;

    private Address address;

    public User() {
    }

    public User(Integer id, String name, String password, Address address) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.address = address;
    }

    public User(String name, String password, Address address) {
        this.name = name;
        this.password = password;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", address=" + address +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
