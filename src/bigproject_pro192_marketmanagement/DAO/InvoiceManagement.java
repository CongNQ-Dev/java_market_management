package bigproject_pro192_marketmanagement.DAO;

import bigproject_pro192_marketmanagement.DTO.Invoice;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cong.nguyen
 */
public class InvoiceManagement {

    private List<Invoice> invoices = new ArrayList<>();

    public int getSize() {
        return invoices.size();
    }

    public boolean addInvoice(Invoice invoice) {
        for (int i = 0; i < invoices.size(); i++) {
            if (findInvoiceById(invoice.getCode()) != null) {
                return false;
            }
        }
        return invoices.add(invoice);
    }

    public Invoice findInvoiceById(int id) {
        for (int i = 0; i < invoices.size(); i++) {
            if (invoices.get(i).getCode()== id) {
                return invoices.get(i);
            }
        }
        return null;
    }

    public boolean deleteInvoiceById(int id) {
        for (int i = 0; i < invoices.size(); i++) {
            if (invoices.get(i).getCode()== id) {
                invoices.remove(i);
                return true;
            }
        }
        return false;
    }

}
