/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigproject_pro192_marketmanagement.DTO;

import java.util.Date;

/**
 *
 * @author cong.nguyen
 */
public class Invoice {

    private int code;
    private Date date;
    private Order order;
    
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Invoice(int code, Date date) {
        this.code = code;
        this.date = date;
    }


    public Invoice() {
     
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
