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
public class Item {

    private int id;
    private String name;
    private int price;
    private int status;
    private List<Order> orders;

    public Item() {
        this.orders = new ArrayList<>();
    }

    public Item(int id, String name, int price, int status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}
