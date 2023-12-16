package bigproject_pro192_marketmanagement.DAO;

import bigproject_pro192_marketmanagement.DTO.Customer;
import bigproject_pro192_marketmanagement.DTO.Invoice;
import bigproject_pro192_marketmanagement.DTO.Item;
import bigproject_pro192_marketmanagement.DTO.Order;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cong.nguyen
 */
public class OrderManagement {

    private List<Order> orders = new ArrayList<>();

    public int getSize() {
        return orders.size();
    }

    public boolean addOrder(Order s) {
        for (int i = 0; i < orders.size(); i++) {
            if (findOrderById(s.getId()) != null) {
                return false;
            }
        }
        return orders.add(s);
    }

    public Order findOrderById(int id) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == id) {
                return orders.get(i);
            }
        }
        return null;
    }

    public boolean deleteOrderById(int id) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == id) {
                orders.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean updateOrderById(Order o) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == o.getId()) {
                orders.set(i, o);
            }
            return true;
        }
        return false;
    }

    public void addCustomerToOrder(Customer c, Order o) {
        o.setCustomer(c);
    }

    public boolean addItemToOrder(Item item, Order o) {
        List<Item> items = o.getItems();
        for (int i = 0; i < items.size(); i++) {
            Item currentItemInOrder = items.get(i);
            if (item.getId() == (currentItemInOrder.getId())) {
                return false;
            }
        }
        return items.add(item);
    }

    public void deleteItemFromOrders(int id) {
        for (int i = 0; i < orders.size(); i++) {
            List<Item> itemsInOrder = orders.get(i).getItems();
            for (int j = 0; j < itemsInOrder.size(); j++) {
                if (itemsInOrder.get(i).getId() == id) {
                    itemsInOrder.remove(j);
                }
            }
        }
    }
    
    public void addInvoiceToOrder(Order o, Invoice i) {
         o.setInvoice(i);
    }

}
