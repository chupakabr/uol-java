import java.util.HashMap;
import java.util.Map;

/**
 * Created by myltik
 * Created on 8/1/13 7:52 PM
 */
public class FullAddress extends ShortAddress {

    protected final int houseNumber;
    protected final String street1;
    protected final String street2;
    protected final String city;
    protected final HashMap<String, Object> extraInfo;

    /**
     * @param firstName
     * @param lastName
     * @param phoneNumber
     * @param houseNumber
     * @param street1
     * @param street2
     * @param city
     */
    public FullAddress(String firstName, String lastName, String phoneNumber, int houseNumber,
                       String street1, String street2, String city)
    {
        super(firstName, lastName, phoneNumber);

        this.houseNumber = houseNumber;
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;

        extraInfo = new HashMap<String, Object>(4);
        extraInfo.put("House number", houseNumber);
        if (!"".equals(street1)) extraInfo.put("Street 1", street1);
        if (!"".equals(street2)) extraInfo.put("Street 2", street2);
        if (!"".equals(city)) extraInfo.put("City", city);
    }

    /**
     * @return House number
     */
    public int getHouseNumber() {
        return houseNumber;
    }

    /**
     * @return First street name
     */
    public String getStreet1() {
        return street1;
    }

    /**
     * @return Second street name
     */
    public String getStreet2() {
        return street2;
    }

    /**
     * @return City name
     */
    public String getCity() {
        return city;
    }

    @Override
    public Map<String, Object> getExtraInfo() {
        return (Map<String, Object>) extraInfo.clone();
    }
}
