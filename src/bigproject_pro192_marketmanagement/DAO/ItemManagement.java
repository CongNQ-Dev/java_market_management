/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigproject_pro192_marketmanagement.DAO;

import bigproject_pro192_marketmanagement.DTO.Item;
import bigproject_pro192_marketmanagement.DTO.Order;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cong.nguyen
 */
public class ItemManagement {

    private List<Item> items = new ArrayList<>();

    public int getSize() {
        return items.size();
    }

    public boolean addItem(Item c) {
        for (int i = 0; i < items.size(); i++) {
            if (findItemById(c.getId()) != null) {
                return false;
            }
        }
        return items.add(c);
    }

    public Item findItemById(int id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                return items.get(i);
            }
        }
        return null;
    }

    public boolean updateItemById(Item c) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == c.getId()) {
                items.set(i, c);
            }
            return true;
        }
        return false;
    }

    public boolean deleteItemById(int id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                items.remove(i);
            }
            return true;
        }
        return false;
    }

    public boolean addOrderToItem(Order o, Item item ) {
        List<Order> orders = item.getOrders();
        for (int i = 0; i < orders.size(); i++) {
            Order currentOrderInItem = orders.get(i);
            if (o.getId() == (currentOrderInItem.getId())) {
                return false;
            }
        }
        return items.add(item);
    }

    public void deleteOrderFromItem(int id) {
        for (int i = 0; i < items.size(); i++) {
            List<Order> ordersInItem = items.get(i).getOrders();
            for (int j = 0; j < ordersInItem.size(); j++) {
                if (ordersInItem.get(i).getId() == id) {
                    ordersInItem.remove(j);
                }
            }
        }
    }
}
