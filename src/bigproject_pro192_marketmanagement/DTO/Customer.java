/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigproject_pro192_marketmanagement.DTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cong.nguyen
 */
public class Customer {

    private int id;
    private String name;
    private String address;
    private List<Order> orders;

    public Customer() {
        this.orders = new ArrayList<>();
    }

    public Customer(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.orders = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}
