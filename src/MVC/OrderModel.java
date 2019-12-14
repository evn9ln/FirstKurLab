package MVC;


import Info.Order;
import SaveService.FileView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Alexey B
 * @version 1.4.2
 *
 * This class is a part of MVC, that realize actions with lis of the Orders
 *
 */

public class OrderModel implements Serializable {

    private static List<Order> runtime = new ArrayList<Order>();

    /**
     * getter for List of the Orders
     * @return List
     */
    public List<Order> getRuntime() {
        return runtime;
    }

    /**
     * Standart constructor
     */
    public OrderModel() {}

    /**
     * Constructor that takes FileView object and gets List of the Orders from that
     * @param fileView that contains List of the Orders
     */
    public OrderModel(FileView fileView) {
        runtime = fileView.getOrderList();
    }

    /**
     * Method takes Order object and use list method to add
     * @param forAdd Order object
     */

    public void add(Order forAdd) {
        runtime.add(forAdd);
    }

    /**
     * Method that realize object by id and returns his index in list
     * @param id uuid object
     * @return index
     */
    public int searchById(UUID id) {
        for (int i = 0 ; i < runtime.size(); i++) {
            if (runtime.get(i).getIdOrder() == id)  {
                return i;
            }
        }
        return 0;
    }
    /**
     * Method takes id if element, use searching method and return object from list
     * @param id uuid object
     * @return Order object
     */
    public Order get(UUID id) {
        return runtime.get(this.searchById(id));
    }


    /**
     * Method takes new Order object and id, search element and update him
     * @param forChange new Order object to update
     * @param id uuid object
     */
    public void set(Order forChange, UUID id)  {
        runtime.set(this.searchById(id), forChange);
    }

    /**
     * Method takes id element, search his index and remove it from list
     * @param id uuid object
     */
    public void remove(UUID id) {
        runtime.remove(this.searchById(id));
    }

    /**
     * Method use clear method for list
     */
    public void clear() {
        runtime.clear();
    }

    /**
     * Method realizes the conversion object in string
     * @return string
     */
    @Override
    public String toString() {
        String result = "Orders:\n";
        for (Order c: runtime) {
            result += c.toString();
        }
        return result;
    }


    /**
     * Method return TRUE if count of element in list > 0
     * FALSE if <=0
     * @return boolean
     */
    public boolean isEmpty() {
        return runtime.size() <= 0;
    }

    /**
     * getter for number of the Order by id
     * @param id uuid object
     * @return integer - order number
     */
    public int getNumById(UUID id) {
        return runtime.get(this.searchById(id)).getNum();
    }

    /**
     * Method checks is free number of the order
     * @param num integer to check
     * @return true if there is same number in the list
     * else false
     */
    public boolean numCheck(int num) {
        for (int i = 0; i < runtime.size(); i++) {
            if (runtime.get(i).getNum() == num) return true;
        }
        return false;
    }
}
