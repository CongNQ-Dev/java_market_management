package bigproject_pro192_marketmanagement.DAO;

import bigproject_pro192_marketmanagement.DTO.Customer;
import bigproject_pro192_marketmanagement.DTO.Order;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cong.nguyen
 */
public class CustomerManagement {

    private List<Customer> customers = new ArrayList<>();

    public int getSize() {
        return customers.size();
    }

    public boolean addCustomer(Customer c) {
        for (int i = 0; i < customers.size(); i++) {
            if (findCustomerById(c.getId()) != null) {
                return false;
            }
        }
        return customers.add(c);
    }

    public Customer findCustomerById(int id) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == id) {
                return customers.get(i);
            }
        }
        return null;
    }

    public boolean updateCustomerById(Customer c) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == c.getId()) {
                customers.set(i, c);
            }
            return true;
        }
        return false;
    }

    public boolean deleteCustomerById(int id) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == id) {
                customers.remove(i);
            }
            return true;
        }
        return false;
    }

    public boolean addOrderToCustomer(Order o, Customer c) {
        List<Order> orders = c.getOrders();
        for (int i = 0; i < orders.size(); i++) {
            Order orderOfCustomer = orders.get(i);
            if (o.getId() == (orderOfCustomer.getId())) {
                return false;
            }
        }
        return orders.add(o);
    }

    public void deleteOrderFromCustomer(int id) {
        for (int i = 0; i < customers.size(); i++) {
            List<Order> orderOfCustomer= customers.get(i).getOrders();
            for (int j = 0; j < orderOfCustomer.size(); j++) {
                if (orderOfCustomer.get(i).getId()==id) {
                    orderOfCustomer.remove(j);
                }
            }
        }
    }
}
