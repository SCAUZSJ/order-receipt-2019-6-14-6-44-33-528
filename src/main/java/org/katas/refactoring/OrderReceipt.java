package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    public static final double SALES_TAX_RATE = .10;
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        printHeaders(output);
        printDetails(output);
        double totSalesTx = 0d;
        double tot = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            printLineItem(output, lineItem);
            double salesTax = getSalesTax(lineItem);
            totSalesTx += salesTax;
            tot += getTot(lineItem, salesTax);
        }
        printStateTax(output, totSalesTx);
        printTotalAmount(output, tot);
        return output.toString();
    }

    private double getTot(LineItem lineItem, double salesTax) {
        return lineItem.totalAmount() + salesTax;
    }

    private double getSalesTax(LineItem lineItem) {
        return lineItem.totalAmount() * SALES_TAX_RATE;
    }

    private void printLineItem(StringBuilder output, LineItem lineItem) {
        output.append(lineItem.getDescription())
        .append('\t')
        .append(lineItem.getPrice())
        .append('\t')
        .append(lineItem.getQuantity())
        .append('\t')
        .append(lineItem.totalAmount())
        .append('\n');
    }

    private void printTotalAmount(StringBuilder output, double tot) {
        output.append("Total Amount").append('\t').append(tot);
    }

    private void printStateTax(StringBuilder output, double totSalesTx) {
        output.append("Sales Tax").append('\t').append(totSalesTx);
    }

    private void printDetails(StringBuilder output) {
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
    }

    private void printHeaders(StringBuilder output) {
        output.append("======Printing Orders======\n");
    }
}