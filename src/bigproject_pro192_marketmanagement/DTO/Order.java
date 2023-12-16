package bigproject_pro192_marketmanagement.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private int id;
    private Date orderDay;
    private Date shipDay;
    private int totalQuantity;
    private Customer customer;
    private List<Item> items;
    private Invoice invoice;

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order() {
        this.items = new ArrayList<>();
    }

    public Order(int id, Date orderDay, Date shipDay, int totalQuantity) {
        this.id = id;
        this.orderDay = orderDay;
        this.shipDay = shipDay;
        this.totalQuantity = totalQuantity;
        this.items = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderDay() {
        return orderDay;
    }

    public void setOrderDay(Date orderDay) {
        this.orderDay = orderDay;
    }

    public Date getShipDay() {
        return shipDay;
    }

    public void setShipDay(Date shipDay) {
        this.shipDay = shipDay;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

}
