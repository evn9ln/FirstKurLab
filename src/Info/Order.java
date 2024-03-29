package Info;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.UUID;

/**
 * @author Alexey B
 * @version 1.4.2
 *
 * This is one of the info classes, that contains information about order
 *
 */

public class Order implements Serializable {
    private int num;
    private double orderSum;
    private Calendar date;
    private Customer customer;
    private UUID idOrder;

    SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, d MMMM yyyy", Locale.ENGLISH);

    /**
     * Constructor that takes all field and create object
     * @param num order number
     * @param customer customer
     * @param date the day month and year of order
     * @param orderSum cost
     */

    public Order(int num, Customer customer, Calendar date, double orderSum) {
        idOrder = UUID.randomUUID();
        this.num = num;
        this.customer = customer;
        this.date = date;
        this.orderSum = orderSum;
    }

    /**
     * getter for id field of Order object
     * @return uuid
     */
    public UUID getIdOrder() {
        return idOrder;
    }

    /**
     * Getter field date
     *
     * @return string date of an order
     */

    public Calendar getDate() {
        return date;
    }

    /**
     * Setter for field date
     *
     * @param date string
     */

    public void setDate(Calendar date) {
        this.date = date;
    }

    /**
     * Getter field orderer
     *
     * @return object of orderer class
     */

    public Customer getCustomer() {
        return customer;
    }

    /**
     * Setter for field customer
     *
     * @param customer customer
     */

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Getter field sum of an order
     *
     * @return double value sum
     */

    public double getOrderSum() {
        return orderSum;
    }

    /**
     * Setter for field orderSum
     *
     * @param orderSum double
     */

    public void setOrderSum(double orderSum) {
        this.orderSum = orderSum;
    }

    /**
     * Getter field number of an order
     *
     * @return int value num
     */

    public int getNum() {
        return num;
    }

    /**
     * Setter for field num of an order
     *
     * @param num int
     */

    public void setNum(int num) {
        this.num = num;
    }


    /**
     * Method realizes the conversion object in string
     *
     * @return string
     */
    @Override
    public String toString() {
        return "\tNumber - " + num + "\n\tCostumer:\n" + customer.toString() + "\nDate - " + dateFormat.format(date.getTime()) + "\nTotal price in dollars - " + orderSum + "\n" + "ID = " + idOrder + "\n";
    }

}
