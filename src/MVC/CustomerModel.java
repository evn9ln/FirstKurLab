package MVC;

import Info.Customer;
import SaveService.FileView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Alexey B
 * @version 1.4.2
 *
 * This class is a part of MVC, that realize actions with lis of the Customers
 *
 */

public class CustomerModel implements Serializable {
    private static List<Customer> runtime = new ArrayList<Customer>();

    /**
     * Standart constructor
     */
    public CustomerModel() {}

    /**
     * Constructor that takes FilewView object and gets List of the Customers from that
     * @param fileView that contains List of the Customers
     */
    public CustomerModel(FileView fileView) {
        runtime = fileView.getCustomerList();
    }

    /**
     * getter for List of the Customers
     * @return List
     */
    public List<Customer> getRuntime() {
        return runtime;
    }

    /**
     * Method that realize object by id and returns his index in list
     * @param id uuid object
     * @return index
     */
    private int searchById(UUID id) {
        for (int i = 0; i < runtime.size(); i++) {
            if (runtime.get(i).getIdCustomer() == id) {
                return i;
            }
        }
        return 0;
    }

    /**
     * Method takes Customer object and use list method to add
     * @param forAdd Customer object
     */
    public void add(Customer forAdd) {
        runtime.add(forAdd);
    }

    /**
     * Method takes id if element, use searching method and return object from list
     * @param id uuid object
     * @return Customer object
     */
    public Customer get(UUID id) {
        return runtime.get(this.searchById(id));
    }

    /**
     * Method takes new Customer object and id, search element and update him
     * @param forChange new customer object to update
     * @param id uuid object
     */
    public void set(Customer forChange, UUID id) {
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
        String result = "Costumers:\n";
        for (Customer c: runtime) {
            result += c.toString();
            result+="\n";
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
        return runtime.get(searchById(id)).getNumOrder();
    }

    /**
     * getter for index in list by order number
     * @param num number of order
     * @return integer index in list
     */
    public int getIndexByNum(int num) {
        for(int i = 0; i < runtime.size(); i++) {
            if (num == runtime.get(i).getNumOrder()) return i;
        }
        return -1;
    }

}
