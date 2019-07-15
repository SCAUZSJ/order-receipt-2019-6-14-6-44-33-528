package org.katas.refactoring;

import java.util.List;

public class Order {
    String customerName;
    String customerAddress;
    List<LineItem> LineItems;

    public Order(String customerName, String customerAddress, List<LineItem> LineItems) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.LineItems = LineItems;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public List<LineItem> getLineItems() {
        return LineItems;
    }
}
