package Info;

/**
 * @author Alexey B, Nikita K
 * @version 1.0
 * This is one of the info classes, that contains information about orderer
 *
 */

//TESTTESTETTETSETSTEST
public class Orderer {
    private String name, address, phoneNumber;

    /**
     * Constructor that takes all field and create object
     * @param name
     * @param phoneNumber
     * @param address
     */
    public Orderer(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    /**
     * Getter field phone number
     * @return string
     */

    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *
     * Setter for field phoneNumber
     * @param phoneNumber string
     */

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter field that contains address
     * @return string address
     */

    public String getAddress() {
        return address;
    }

    /**
     *
     * Setter for field  address
     * @param address string
     */

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Getter field  name of an orderer
     * @return string
     */

    public String getName() {
        return name;
    }

    /**
     *
     * Setter for field name
     * @param name string
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method realizes the conversion object in string
     * @return string
     */
    @Override
    public String toString() {
        return "Orderer:\n\tName - " + name + "\n\tAddress - " + address + "\n\tPhone number - " + phoneNumber;
    }
}
