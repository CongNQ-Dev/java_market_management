package bigproject_pro192_marketmanagement;

import bigproject_pro192_marketmanagement.DAO.CustomerManagement;
import bigproject_pro192_marketmanagement.DAO.InvoiceManagement;
import bigproject_pro192_marketmanagement.DAO.ItemManagement;
import bigproject_pro192_marketmanagement.DAO.OrderManagement;
import bigproject_pro192_marketmanagement.DTO.Customer;
import bigproject_pro192_marketmanagement.DTO.Invoice;
import bigproject_pro192_marketmanagement.DTO.Item;
import bigproject_pro192_marketmanagement.DTO.Order;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Tester {

    /**
     *
     * @author cong.nguyen
     */
    public static OrderManagement orderManagement = new OrderManagement();
    public static CustomerManagement customerManagement = new CustomerManagement();
    public static ItemManagement itemManagement = new ItemManagement();
    public static InvoiceManagement invoiceManagement = new InvoiceManagement();

    public static void main(String[] args) {
        int choice = 0;
        while (true) {
            System.out.println("====== MARKET MANAGEMENT =====");
            System.out.println("1. Order Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Item Management");
            System.out.println("4. Invoice Management");
            System.out.println("5. Exit program");
            System.out.println("==============================");

            try {
                System.out.println("Please choose: ");
                choice = new Scanner(System.in).nextInt();
                if (choice < 1 || choice > 5) {
                    throw new InputMismatchException();
                }
                switch (choice) {
                    case 1:
                        orderMgt();
                        break;
                    case 2:
                        customerMgt();
                        break;
                    case 3:
                        itemMgt();
                        break;
                    case 4:
                        invoiceMgt();
                        break;
                    case 5:
                        System.out.println("Thank you!");
                        System.exit(0);
                }
            } catch (Exception e) {
                System.err.println("Only accept from 1 to 5");
            }

        }
    }

    public static void invoiceMgt() {
        int choice = 0;
        while (true) {
            System.out.println("====== INVOICE MANAGEMENT =====");
            System.out.println("1. Find invoice by id");
            System.out.println("2. Back to menu");
            System.out.println("==============================");
            try {
                System.out.println("Please choose: ");
                choice = new Scanner(System.in).nextInt();
                if (choice < 1 || choice > 2) {
                    throw new InputMismatchException();
                }
                switch (choice) {
                    case 1:
                        findInvoiceById();
                        break;
                    case 2:
                        return;
                }
            } catch (Exception e) {
                System.err.println("Only accept from 1 to 2");
            }
        }
    }

    public static void findInvoiceById() {
        int id;
        while (true) {
            System.out.println("Please input invoice id: ");
            try {
                id = new Scanner(System.in).nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid invoice id. Must be integer.");
            }
        }
        Invoice invoice = invoiceManagement.findInvoiceById(id);
        if (invoice == null) {
            System.err.println("The invoice with the provided Id doesn't exist.");
            return;
        }
        System.out.println("==========");
        System.out.println("The invoice with order you want to find: ");
        System.out.println("Invoice Id: " + invoice.getCode());
        System.out.println("Invoice Date: "
                + new SimpleDateFormat("dd/MM/yyyy").format(invoice.getDate()));
        if (invoice.getOrder() != null) {
            System.out.println("Invoice's Order: ");
            System.out.println("----------");
            Order invoiceOrder = invoice.getOrder();
            System.out.println("Order Id: " + invoiceOrder.getId());
            System.out.println("Order Day: "
                    + new SimpleDateFormat("dd/MM/yyyy")
                            .format(invoiceOrder.getOrderDay()));
            System.out.println("Order Ship: "
                    + new SimpleDateFormat("dd/MM/yyyy")
                            .format(invoiceOrder.getShipDay()));
            System.out.println("Total Quantity: " + invoiceOrder.getTotalQuantity());
            System.out.println("----------");

        }

        System.out.println("==========");

    }

    public static void orderMgt() {
        int choice = 0;
        while (true) {
            System.out.println("====== ORDER MANAGEMENT =====");
            System.out.println("1. Add a order");
            System.out.println("2. Update order by id");
            System.out.println("3. Delete order by id");
            System.out.println("4. Find order by id");
            System.out.println("5. Add order to customer");
            System.out.println("6. Add item to order");
            System.out.println("7. Back to menu");
            System.out.println("==============================");

            try {
                System.out.println("Please choose: ");
                choice = new Scanner(System.in).nextInt();
                if (choice < 1 || choice > 7) {
                    throw new InputMismatchException();
                }
                switch (choice) {
                    case 1:
                        addOrder();
                        break;
                    case 2:
                        updateOrder();
                        break;
                    case 3:
                        deleteOrder();
                        break;
                    case 4:
                        findOrder();
                        break;
                    case 5:
                        addOrderToCustomer();
                    case 6:
                        addItemToOrder();
                    case 7:
                        return;

                }
            } catch (Exception e) {
                System.err.println("Only accept from 1 to 7");

            }

        }
    }

    public static void addOrderToItem() {
        if (orderManagement.getSize() < 1) {
            System.err.println("There is must at least 1 order to add.");
            return;
        }
        if (itemManagement.getSize() < 1) {
            System.err.println("There is must at least 1 item to add.");
            return;
        }
        int itemId;
        while (true) {
            while (true) {
                System.out.println("Please input item id: ");
                try {
                    itemId = new Scanner(System.in).nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid item id. Must be integer.");
                }
            }
            Item item = itemManagement.findItemById(itemId);
            if (item == null) {
                System.out.println("The item does not exist with id " + itemId);
                return;
            }

            List<Order> itemOrders = item.getOrders();
            int orderId;
            while (true) {
                System.out.println("Please input order id: ");
                try {
                    orderId = new Scanner(System.in).nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid order id. Must be integer.");
                }
            }
            Order order = orderManagement.findOrderById(orderId);
            if (order == null) {
                System.out.println("The order does not exist with id " + itemId);
            } else {
                boolean flag = false;
                for (int i = 0; i < itemOrders.size(); i++) {
                    if (itemOrders.get(i).getId() == orderId) {
                        System.out.println("This order is already in this item.");
                        flag = true;
                    }
                }
                if (flag == false) {
                    order.getItems().add(item);
                    if (itemOrders.add(order)) {
                        System.out.println("Successfully added this order to this item.");
                    }
                }
            }
            System.out.println("Do you want to add more order to this item? (y/n)");
            String choice = new Scanner(System.in).nextLine();
            if (choice.equalsIgnoreCase("n")) {
                return;
            }
        }
    }

    public static void addOrderToCustomer() {
        if (customerManagement.getSize() < 1) {
            System.err.println("There is must be at least 1 customer.");
            return;
        }
        if (orderManagement.getSize() < 1) {
            System.err.println("There is must be at least 1 order.");
            return;
        }
        while (true) {
            int customerId;
            while (true) {
                System.out.println("Please input customer id: ");
                try {
                    customerId = new Scanner(System.in).nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid customer id. Must be integer.");
                }
            }
            Customer customer = customerManagement.findCustomerById(customerId);
            if (customer == null) {
                System.err.println("The customer you want to add is not found.");
                return;
            }
            List<Order> customerOrders = customer.getOrders();
            while (true) {
                int orderId;
                while (true) {
                    System.out.println("Please input order id: ");
                    try {
                        orderId = new Scanner(System.in).nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid order id. Must be integer.");
                    }
                }
                Order order = orderManagement.findOrderById(orderId);
                if (order == null) {
                    System.err.println("The order you want to add is not found.");
                } else {
                    boolean flag = false;
                    for (int i = 0; i < customerOrders.size(); i++) {
                        if (customerOrders.get(i).getId() == order.getId()) {
                            System.err.println("This customer already has this order.");
                            flag = true;
                        }
                    }
                    if (flag == false) {
                        if (customerOrders.add(order)) {
                            System.out.println("Successfully added this order to the customer.");
                        }
                    }
                }
                System.out.println("Do you want to add more order to this customer? (y/n)");
                String choice = new Scanner(System.in).nextLine();
                if (choice.equalsIgnoreCase("n")) {
                    return;
                }
            }
        }

    }

    public static void addOrder() {
        while (true) {
            Order order = new Order();
            while (true) {
                System.out.println("Please input order id: ");
                try {
                    int id = new Scanner(System.in).nextInt();
                    if (id < 1 || id > Integer.MAX_VALUE) {
                        throw new InputMismatchException();
                    } else {
                        order.setId(id);
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.err.println("Id must be positive integer.");
                } catch (Exception e) {
                    System.err.println("Invalid Input!");
                }
            }

            Date orderDate = null;
            while (true) {
                System.out.println("Please input order Begin Date: ");
                String orderDateStr = new Scanner(System.in).nextLine();
                if (orderDateStr.trim().isEmpty()) {
                    System.err.println("Your input is Empty!");
                } else if (!orderDateStr.trim().isEmpty()) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    sdf.setLenient(false);
                    try {
                        orderDate = sdf.parse(orderDateStr);
                        order.setOrderDay(orderDate);
                        break;
                    } catch (ParseException e) {
                        System.err.println("Invalid date detect. Please input again.");
                    }
                }
            }

            while (true) {
                System.out.println("Please input order Ship Date: ");
                String shipDateStr = new Scanner(System.in).nextLine();
                if (shipDateStr.trim().isEmpty()) {
                    System.err.println("Your input is Empty!");
                } else if (!shipDateStr.trim().isEmpty()) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    sdf.setLenient(false);
                    try {
                        Date shipDate = sdf.parse(shipDateStr);
                        if (shipDate.before(orderDate)) {
                            throw new IllegalArgumentException();
                        }
                        order.setShipDay(shipDate);
                        break;
                    } catch (ParseException e) {
                        System.err.println("Invalid date detect. Please input again.");
                    } catch (IllegalArgumentException e) {
                        System.err.println("Ship date must after begin date.");
                    }
                }
            }

            while (true) {
                System.out.println("Please input total quantity: ");
                try {
                    int totalQuantity = new Scanner(System.in).nextInt();
                    if (totalQuantity < 1 || totalQuantity > Integer.MAX_VALUE) {
                        throw new InputMismatchException();
                    } else {
                        order.setTotalQuantity(totalQuantity);
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.err.println("Total Quantity must be positive integer.");
                } catch (Exception e) {
                    System.err.println("Invalid Input!");
                }
            }

            Invoice invoice = new Invoice();
            while (true) {
                System.out.println("Do you want to add Invoice ? (y/n): ");
                String choice = new Scanner(System.in).nextLine();
                if (choice.equalsIgnoreCase("n")) {
                    System.out.println("You chose not to add Invoice.");
                    if (orderManagement.addOrder(order)) {
                        System.out.println("Successfully added an order.");
                    } else {
                        System.err.println("The order with id " + order.getId() + " is existed.");
                    }
                    break;
                }

                int invoiceId = -1;
                while (true) {
                    try {
                        System.out.println("Please input invoice id: ");
                        invoiceId = new Scanner(System.in).nextInt();
                        if (invoiceId < 1 || invoiceId > Integer.MAX_VALUE) {
                            throw new InputMismatchException();
                        } else {
                            if (invoiceManagement.findInvoiceById(invoiceId) != null) {
                                throw new IllegalArgumentException();
                            }
                            invoice.setCode(invoiceId);
                            break;
                        }
                    } catch (IllegalArgumentException e) {
                        System.err.println("Invoice with that id is already exist. Try again.");
                    } catch (InputMismatchException e) {
                        System.err.println("Invoice Id must be positive integer.");
                    } catch (Exception e) {
                        System.err.println("Invalid Input!");
                    }
                }
                invoice.setDate(new Date());
                invoice.setOrder(order);
                order.setInvoice(invoice);

                if (invoiceManagement.addInvoice(invoice)) {
                    System.out.println("Successfully added invoice to this order.");
                }

                if (orderManagement.addOrder(order)) {
                    System.out.println("Successfully added an order.");
                } else {
                    System.err.println("The order with id " + order.getId() + " is existed.");
                }
                break;
            }

            System.out.println("Do you want to add more? (y/n)?");
            String choice = new Scanner(System.in).nextLine();
            if (choice.equalsIgnoreCase("n")) {
                return;
            }
        }
    }

    public static void updateOrder() {
        System.out.println("Please input order id: ");
        int updateId = new Scanner(System.in).nextInt();

        Order updateOrder = orderManagement.findOrderById(updateId);
        if (updateOrder == null) {
            System.err.println("The order with the provided Id doesn't exist.");
            return;
        }

        while (true) {
            System.out.println("Do you want to update Order Day? (y/n): ");
            String choice = new Scanner(System.in).nextLine();
            if (choice.equals("n") || choice.equals("N")) {
                System.out.println("You chose not to Order Day.");
                break;
            }

            Date orderDate = null;

            System.out.println("Please input Order Date: ");
            String orderDateStr = new Scanner(System.in).nextLine();
            if (orderDateStr.trim().isEmpty()) {
                System.err.println("Your input is Empty!");
            } else if (!orderDateStr.trim().isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf.setLenient(false);
                try {
                    orderDate = sdf.parse(orderDateStr);
                    updateOrder.setOrderDay(orderDate);
                    break;
                } catch (ParseException e) {
                    System.err.println("Invalid date detect. Please input again.");
                }

            }
        }

        while (true) {
            System.out.println("Do you want to update Ship Day? (y/n): ");
            String choice = new Scanner(System.in).nextLine();
            if (choice.equals("n") || choice.equals("N")) {
                System.out.println("You chose not to Ship Day.");
                break;
            }

            Date shipDate = null;
            System.out.println("Please input Ship Date: ");
            String shipDateStr = new Scanner(System.in).nextLine();
            if (shipDateStr.trim().isEmpty()) {
                System.err.println("Your input is Empty!");
            } else if (!shipDateStr.trim().isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf.setLenient(false);
                try {
                    shipDate = sdf.parse(shipDateStr);
                    updateOrder.setShipDay(shipDate);
                    break;
                } catch (ParseException e) {
                    System.err.println("Invalid date detect. Please input again.");
                }

            }
        }

        while (true) {
            System.out.println("Do you want to update total quantity? (y/n): ");
            String choice = new Scanner(System.in).nextLine();
            if (choice.equals("n") || choice.equals("N")) {
                System.out.println("You chose not to total quantity.");
                break;
            }
            System.out.println("Please input total quantity: ");
            try {
                int totalQuantity = new Scanner(System.in).nextInt();
                if (totalQuantity < 1 || totalQuantity > Integer.MAX_VALUE) {
                    throw new InputMismatchException();
                } else {
                    updateOrder.setTotalQuantity(totalQuantity);
                    break;
                }
            } catch (InputMismatchException e) {
                System.err.println("Total Quantity must be positive integer.");

            } catch (Exception e) {
                System.err.println("Invalid Input!");
            }

        }

    }

    public static void findOrder() {
        System.out.println("Please input order id: ");
        int id = new Scanner(System.in).nextInt();
        Order order = orderManagement.findOrderById(id);
        if (order == null) {
            System.err.println("The order with the provided Id doesn't exist.");
            return;
        }
        System.out.println("==========");
        System.out.println("The Order you want to find: ");
        System.out.println("Id: " + order.getId());
        System.out.println("Order Date: " + new SimpleDateFormat("dd/MM/yyyy").format(order.getOrderDay()));
        System.out.println("Ship Date: " + new SimpleDateFormat("dd/MM/yyyy").format(order.getShipDay()));
        System.out.println("Total Quantity: " + order.getTotalQuantity());
        if (order.getInvoice() != null) {
            System.out.println("-------");
            System.out.println("Invoice Id: " + order.getInvoice().getCode());
            System.out.println("Invoice Date: "
                    + new SimpleDateFormat("dd/MM/yyyy")
                            .format(order.getInvoice().getDate()));
            System.out.println("-------");
        }
        if (order.getItems().size() > 0) {
            System.out.println("Item List: ");
            for (int i = 0; i < order.getItems().size(); i++) {
                System.out.println("----------");
                Item orderItem = order.getItems().get(i);
                System.out.println("Item Id: " + orderItem.getId());
                System.out.println("Item Name: " + orderItem.getName());
                System.out.println("Item Price: " + orderItem.getPrice());
                System.out.println("Item Status: " + orderItem.getStatus());
                System.out.println("----------");
            }
        }

        System.out.println("==========");
    }

    public static void deleteOrder() {
        System.out.println("Please input order id: ");
        int id = new Scanner(System.in).nextInt();
        Order order = orderManagement.findOrderById(id);
        if (order == null) {
            System.out.println("The order with the provided Id doesn't exist.");
            return;
        }
        while (true) {
            System.out.println("Do you want to delete this order? (y/n)?");
            String choice = new Scanner(System.in).nextLine();
            if (choice.equals("n") || choice.equals("N")) {
                return;
            }
            if (orderManagement.deleteOrderById(id)) {
                customerManagement.deleteOrderFromCustomer(id);
                itemManagement.deleteOrderFromItem(id);

                System.out.println("Successfully deleted order with id " + id);
                return;
            }
        }
    }

    public static void customerMgt() {
        int choice = 0;
        while (true) {
            System.out.println("====== CUSTOMER MANAGEMENT =====");
            System.out.println("1. Add a customer");
            System.out.println("2. Update customer by id");
            System.out.println("3. Delete customer by id");
            System.out.println("4. Find customer by id");
            System.out.println("5. Add customer to order");
            System.out.println("6. Back to menu");
            System.out.println("==============================");
            try {
                System.out.println("Please choose: ");
                choice = new Scanner(System.in).nextInt();
                if (choice < 1 || choice > 6) {
                    throw new InputMismatchException();
                }
                switch (choice) {
                    case 1:
                        addCustomer();
                        break;
                    case 2:
                        updateCustomer();
                        break;
                    case 3:
                        deleteCustomer();
                        break;
                    case 4:
                        findCustomer();
                        break;
                    case 5:
                        addCustomerToOrder();
                    case 6:
                        return;

                }
            } catch (Exception e) {
                System.err.println("Only accept from 1 to 5");

            }
        }

    }

    public static void addCustomerToOrder() {
        if (customerManagement.getSize() < 1) {
            System.err.println("There is must be at least 1 customer.");
            return;
        }
        if (orderManagement.getSize() < 1) {
            System.err.println("There is must be at least 1 order.");
            return;
        }
        int orderId;
        while (true) {
            System.out.println("Please input order id: ");
            try {
                orderId = new Scanner(System.in).nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid order id. Must be integer.");
            }
        }
        Order order = orderManagement.findOrderById(orderId);
        if (order == null) {
            System.err.println("The order you want to add is not found.");
            return;
        }
        while (true) {
            if (order.getCustomer() != null) {
                System.out.println("Do you want to remove customer with id "
                        + order.getCustomer().getId() + " from this order with id "
                        + order.getId() + "(y/n) ?");
                String choice = new Scanner(System.in).nextLine();
                if (choice.equalsIgnoreCase("n")) {
                    System.out.println("You chose not add customer to order.");
                    return;
                } else if (choice.equalsIgnoreCase("y")) {
                    order.setCustomer(null);
                }
                int customerId;
                while (true) {
                    System.out.println("Please input customer id: ");
                    try {
                        customerId = new Scanner(System.in).nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid customer id. Must be integer.");
                    }
                }
                Customer customer = customerManagement.findCustomerById(customerId);
                if (customer == null) {
                    System.err.println("The customer you want to add is not found.");
                    return;
                }
                order.setCustomer(customer);
                System.out.println("Successfully added customer with id "
                        + customer.getId() + " to the order with id " + order.getId());
                return;
            }
        }
    }

    public static void addCustomer() {
        while (true) {
            Customer customer = new Customer();
            while (true) {
                System.out.println("Please input customer id: ");
                try {
                    int id = new Scanner(System.in).nextInt();
                    if (id < 1 || id > Integer.MAX_VALUE) {
                        throw new InputMismatchException();
                    } else {
                        customer.setId(id);
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.err.println("Id must be positive integer.");

                } catch (Exception e) {
                    System.err.println("Invalid Input!");
                }
            }

            while (true) {
                System.out.println("Please input customer name: ");
                String name = new Scanner(System.in).nextLine();
                if (name.trim().isEmpty()) {
                    System.err.println("Your input is Empty!");
                } else if (!name.matches("^[a-zA-Z\\s]{1,100}$")) {
                    System.err.println("Please input customer name from 1 to 100 characters"
                            + " and must in alphabet!");
                } else {
                    customer.setName(name);
                    break;
                }
            }

            while (true) {
                System.out.println("Please input customer address: ");
                String address = new Scanner(System.in).nextLine();
                if (address.trim().isEmpty()) {
                    System.err.println("Your input is Empty!");
                } else if (!address.matches("^[a-zA-Z\\s]{3,100}$")) {
                    System.err.println("Please input customer address from 3 to 100 characters"
                            + " and must in alphabet!");
                } else {
                    customer.setAddress(address);
                    break;
                }
            }
            if (customerManagement.addCustomer(customer)) {
                System.out.println("Successfully added a customer.");
            } else {
                System.out.println("The customer with id " + customer.getId() + " is existed.");
            }

            System.out.println("Do you want to add more? (y/n)?");
            String choice = new Scanner(System.in).nextLine();
            if (choice.equals("n") || choice.equals("N")) {
                return;
            }
        }
    }

    public static void deleteCustomer() {
        System.out.println("Please input customer id: ");
        int id = new Scanner(System.in).nextInt();
        Customer customer = customerManagement.findCustomerById(id);
        if (customer == null) {
            System.out.println("The customer with the provided Id doesn't exist.");
            return;
        }
        while (true) {
            System.out.println("Do you want to delete this customer? (y/n)?");
            String choice = new Scanner(System.in).nextLine();
            if (choice.equals("n") || choice.equals("N")) {
                return;
            }
            if (customerManagement.deleteCustomerById(id)) {
                System.out.println("Successfully deleted customer with id " + id);
                return;
            }
        }
    }

    public static void updateCustomer() {
        System.out.println("Please input customer id: ");
        int updateId = new Scanner(System.in).nextInt();
        Customer updateCustomer = customerManagement.findCustomerById(updateId);
        if (updateCustomer == null) {
            System.err.println("The customer with the provided Id doesn't exist.");
            return;
        }

        while (true) {
            System.out.println("Do you want to update name? (y/n): ");
            String choice = new Scanner(System.in).nextLine();
            if (choice.equals("n") || choice.equals("N")) {
                System.out.println("You chose not to update name.");
                break;
            }

            System.out.println("Please input customer name: ");
            String name = new Scanner(System.in).nextLine();
            if (name.trim().isEmpty()) {
                System.err.println("Your input is Empty!");
            } else if (!name.matches("^[a-zA-Z\\s]{1,100}$")) {
                System.err.println("Please input customer name from 1 to 100 characters"
                        + "and must in alphabet.");
            } else {
                updateCustomer.setName(name);
                break;
            }
        }

        while (true) {
            System.out.println("Do you want to update address? (y/n): ");
            String choice = new Scanner(System.in).nextLine();
            if (choice.equals("n") || choice.equals("N")) {
                System.out.println("You chose not to update address.");
                break;
            }

            System.out.println("Please input customer address: ");
            String address = new Scanner(System.in).nextLine();
            if (address.trim().isEmpty()) {
                System.err.println("Your input is Empty!");
            } else if (!address.matches("^[a-zA-Z\\s]{3,100}$")) {
                System.err.println("Please input customer address from 3 to 100 characters"
                        + "and must in alphabet.");
            } else {
                updateCustomer.setAddress(address);
                break;
            }
        }

        if (customerManagement.updateCustomerById(updateCustomer)) {
            System.out.println("Successfully updated the customer with id"
                    + updateCustomer.getId());
        } else {
            System.out.println("The customer with id " + updateCustomer.getId()
                    + " is not existed.");
        }
    }

    public static void findCustomer() {
        System.out.println("Please input customer id: ");
        int id = new Scanner(System.in).nextInt();
        Customer customer = customerManagement.findCustomerById(id);
        if (customer == null) {
            System.err.println("The customer with the provided Id doesn't exist.");
            return;
        }
        System.out.println("==========");
        System.out.println("The Customer you want to find: ");
        System.out.println("Id: " + customer.getId());
        System.out.println("Name: " + customer.getName());
        System.out.println("Address: " + customer.getAddress());
        if (customer.getOrders().size() > 0) {
            System.out.println("Order List: ");
            for (int i = 0; i < customer.getOrders().size(); i++) {
                System.out.println("----------");
                Order customerOrder = customer.getOrders().get(i);
                System.out.println("Order Id: " + customerOrder.getId());
                System.out.println("Order Day: " + customerOrder.getOrderDay());
                System.out.println("Order Ship: " + customerOrder.getShipDay());
                System.out.println("Total Quantity: " + customerOrder.getTotalQuantity());
                System.out.println("----------");
            }
        }

        System.out.println("==========");
    }

    public static void itemMgt() {
        int choice = 0;
        while (true) {
            System.out.println("====== ITEM MANAGEMENT =====");
            System.out.println("1. Add a item");
            System.out.println("2. Update item by id");
            System.out.println("3. Delete item by id");
            System.out.println("4. Find item by id");
            System.out.println("5. Add order to item");
            System.out.println("6. Back to menu");
            System.out.println("==============================");

            try {
                System.out.println("Please choose: ");
                choice = new Scanner(System.in).nextInt();
                if (choice < 1 || choice > 6) {
                    throw new InputMismatchException();
                }
                switch (choice) {
                    case 1:
                        addItem();
                        break;
                    case 2:
                        updateItem();
                        break;
                    case 3:
                        deleteItem();
                        break;
                    case 4:
                        findItem();
                        break;
                    case 5:
                        addOrderToItem();
                    case 6:
                        return;

                }
            } catch (Exception e) {
                System.err.println("Only accept from 1 to 6");

            }

        }
    }

    public static void addItemToOrder() {
        if (orderManagement.getSize() < 1) {
            System.err.println("There is must at least 1 order to add.");
            return;
        }
        if (itemManagement.getSize() < 1) {
            System.err.println("There is must at least 1 item to add.");
            return;
        }
        int orderId;
        while (true) {
            while (true) {
                System.out.println("Please input order id: ");
                try {
                    orderId = new Scanner(System.in).nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid order id. Must be integer.");
                }
            }
            Order order = orderManagement.findOrderById(orderId);
            if (order == null) {
                System.out.println("The order does not exist with id " + order);
                return;
            }

            List<Item> orderItems = order.getItems();
            int itemId;
            while (true) {
                System.out.println("Please input item id: ");
                try {
                    itemId = new Scanner(System.in).nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid item id. Must be integer.");
                }
            }
            Item item = itemManagement.findItemById(itemId);
            if (item == null) {
                System.out.println("The item does not exist with id " + itemId);
            } else {
                boolean flag = false;
                for (int i = 0; i < orderItems.size(); i++) {
                    if (orderItems.get(i).getId() == itemId) {
                        System.out.println("This item is already in this order.");
                        flag = true;
                    }
                }
                if (flag == false) {
                    item.getOrders().add(order);
                    if (orderItems.add(item)) {
                        System.out.println("Successfully added this item to this order.");
                    }
                }
            }
            System.out.println("Do you want to add more item to this order? (y/n)");
            String choice = new Scanner(System.in).nextLine();
            if (choice.equalsIgnoreCase("n")) {
                return;
            }
        }
    }

    public static void addItem() {
        Item item = new Item();
        while (true) {
            while (true) {
                System.out.println("Please input item id: ");
                try {
                    int id = new Scanner(System.in).nextInt();
                    if (id < 1 || id > Integer.MAX_VALUE) {
                        throw new InputMismatchException();
                    } else {
                        item.setId(id);
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.err.println("Id must be positive integer.");

                } catch (Exception e) {
                    System.err.println("Invalid Input!");
                }
            }

            while (true) {
                System.out.println("Please input item name: ");
                String name = new Scanner(System.in).nextLine();
                if (name.trim().isEmpty()) {
                    System.err.println("Your input is Empty!");
                } else if (!name.matches("^[a-zA-Z\\s]{1,100}$")) {
                    System.err.println("Please input item name from 1 to 100 characters"
                            + " and must in alphabet!");
                } else {
                    item.setName(name);
                    break;
                }
            }

            while (true) {
                System.out.println("Please input item price: ");
                try {
                    int id = new Scanner(System.in).nextInt();
                    if (id < 1 || id > Integer.MAX_VALUE) {
                        throw new InputMismatchException();
                    } else {
                        item.setId(id);
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.err.println("Price must be positive integer.");

                } catch (Exception e) {
                    System.err.println("Invalid Input!");
                }
            }

            while (true) {
                System.out.println("Please input item status (1/0) : ");
                int status = new Scanner(System.in).nextInt();
                if (!(status == 0 || status == 1)) {
                    System.err.println("Item status must be sold(1) or in stock(0).");
                } else {
                    item.setStatus(status);
                    break;
                }
            }

            if (itemManagement.addItem(item)) {
                System.out.println("Successfully added a item.");
            } else {
                System.out.println("The item with id " + item.getId() + " is existed.");
            }

            System.out.println("Do you want to add more? (y/n)?");
            String choice = new Scanner(System.in).nextLine();
            if (choice.equals("n") || choice.equals("N")) {
                return;
            }
        }
    }

    public static void deleteItem() {
        System.out.println("Please input item id: ");
        int id = new Scanner(System.in).nextInt();
        Item item = itemManagement.findItemById(id);
        if (item == null) {
            System.out.println("The item with the provided Id doesn't exist.");
            return;
        }
        while (true) {
            System.out.println("Do you want to delete this item? (y/n)?");
            String choice = new Scanner(System.in).nextLine();
            if (choice.equals("n") || choice.equals("N")) {
                return;
            }
            if (itemManagement.deleteItemById(id)) {
                orderManagement.deleteItemFromOrders(id);
                System.out.println("Successfully deleted item with id " + id);
                return;
            }
        }
    }

    public static void updateItem() {
        System.out.println("Please input item id: ");
        int updateId = new Scanner(System.in).nextInt();
        Item updateItem = itemManagement.findItemById(updateId);
        if (updateItem == null) {
            System.err.println("The item with the provided Id doesn't exist.");
            return;
        }

        while (true) {
            System.out.println("Do you want to update name? (y/n): ");
            String choice = new Scanner(System.in).nextLine();
            if (choice.equals("n") || choice.equals("N")) {
                System.out.println("You chose not to update name.");
                break;
            }

            System.out.println("Please input item name: ");
            String name = new Scanner(System.in).nextLine();
            if (name.trim().isEmpty()) {
                System.err.println("Your input is Empty!");
            } else if (!name.matches("^[a-zA-Z\\s]{1,100}$")) {
                System.err.println("Please input item name from 1 to 100 characters"
                        + "and must in alphabet.");
            } else {
                updateItem.setName(name);
                break;
            }
        }

        while (true) {
            System.out.println("Do you want to update item price? (y/n): ");
            String choice = new Scanner(System.in).nextLine();
            if (choice.equals("n") || choice.equals("N")) {
                System.out.println("You chose not to update item price.");
                break;
            }
            System.out.println("Please input item price: ");
            try {
                int price = new Scanner(System.in).nextInt();
                if (price < 1 || price > Integer.MAX_VALUE) {
                    throw new InputMismatchException();
                }
                updateItem.setPrice(price);
                break;
            } catch (InputMismatchException e) {
                System.err.println("Item price must be positive integer!");
            } catch (Exception e) {
                System.err.println("Invalid Input!");
            }

        }

        while (true) {
            System.out.println("Do you want to update item status (y/n) ?");
            String choice = new Scanner(System.in).nextLine();
            if (choice.equals("n") || choice.equals("N")) {
                System.out.println("You chose not to update item status.");
                break;
            } else {
                System.out.println("Please input item status (1/0): ");
                int status = new Scanner(System.in).nextInt();
                if (!(status == 1 || status == 0)) {
                    System.err.println("Pet gender must be male(M) or female(F).");
                } else {
                    updateItem.setStatus(status);
                    break;
                }
            }
        }

        if (itemManagement.updateItemById(updateItem)) {
            System.out.println("Successfully updated the customer with id"
                    + updateItem.getId());
        } else {
            System.out.println("The customer with id " + updateItem.getId()
                    + " is not existed.");
        }
    }

    public static void findItem() {
        System.out.println("Please input item id: ");
        int id = new Scanner(System.in).nextInt();
        Item item = itemManagement.findItemById(id);
        if (item == null) {
            System.err.println("The item with the provided Id doesn't exist.");
            return;
        }
        System.out.println("==========");
        System.out.println("The item you want to find: ");
        System.out.println("Id: " + item.getId());
        System.out.println("Name: " + item.getName());
        System.out.println("Price: " + item.getPrice());
        System.out.println("Status: " + item.getStatus());
        if (item.getOrders().size() > 0) {
            System.out.println("Order List: ");
            for (int i = 0; i < item.getOrders().size(); i++) {
                System.out.println("----------");
                Order customerOrder = item.getOrders().get(i);
                System.out.println("Order Id: " + customerOrder.getId());
                System.out.println("Order Day: " + customerOrder.getOrderDay());
                System.out.println("Order Ship: " + customerOrder.getShipDay());
                System.out.println("Total Quantity: " + customerOrder.getTotalQuantity());
                System.out.println("----------");
            }
        }

        System.out.println("==========");
    }

}
