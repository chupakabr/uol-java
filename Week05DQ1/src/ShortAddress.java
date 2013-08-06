import java.util.Collections;
import java.util.Map;

/**
 * Created by myltik
 * Created on 8/1/13 7:52 PM
 */
public class ShortAddress implements PersonContacts {

    protected final String firstName;
    protected final String lastName;
    protected final String phoneNumber;

    /**
     * @param firstName
     * @param lastName
     * @param phoneNumber
     */
    public ShortAddress(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public Map<String, Object> getExtraInfo() {
        return Collections.EMPTY_MAP;
    }
}
