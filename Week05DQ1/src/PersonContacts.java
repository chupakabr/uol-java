import java.util.Map;

/**
 * Created by myltik
 * Created on 8/1/13 7:54 PM
 */
public interface PersonContacts {

    /**
     * @return First name of a contact
     */
    String getFirstName();

    /**
     * @return Last name of a contact
     */
    String getLastName();

    /**
     * @return Phone number of a contact
     */
    String getPhoneNumber();

    /**
     * @return Extra information about a contact
     */
    Map<String, Object> getExtraInfo();

}
