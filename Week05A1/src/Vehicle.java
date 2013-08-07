import java.util.Date;

/**
 * Created by myltik
 * Created on 8/6/13 6:28 PM
 */
public interface Vehicle {

    /**
     * @return Vehicle's manufacturer name
     */
    String getManufacturer();

    /**
     * @return Vehicle's model name
     */
    String getModel();

    /**
     * @return Vehicle's registration date
     */
    Date getRegistrationDate();

    /**
     * @return Vehicle's engine volume
     */
    Double getEngineVolume();

    /**
     * @return Vehicle's annual road tax charge in GBP
     */
    Double getAnnualRoadTaxCharge();

}
