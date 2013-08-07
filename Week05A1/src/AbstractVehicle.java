import java.util.Date;

/**
 * Created by myltik
 * Created on 8/6/13 6:28 PM
 */
abstract public class AbstractVehicle implements Vehicle {

    protected final String manufacturer;
    protected final String model;
    protected final Date registrationDate;
    protected final Double engineVolume; // cc

    protected AbstractVehicle(String manufacturer, String model, Date registrationDate)
            throws MissingParametersException
    {
        this(manufacturer, model, registrationDate, null);
    }

    protected AbstractVehicle(String manufacturer, String model, Date registrationDate, Double engineVolume)
            throws MissingParametersException
    {
        if (manufacturer == null || manufacturer.isEmpty()) throw new MissingParametersException("Manufacturer must be set");
        if (model == null || model.isEmpty()) throw new MissingParametersException("Model must be set");
        if (registrationDate == null) throw new MissingParametersException("Registration date must be set");

        this.manufacturer = manufacturer;
        this.model = model;
        this.registrationDate = registrationDate;
        this.engineVolume = engineVolume;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public Date getRegistrationDate() {
        return registrationDate;
    }

    @Override
    public Double getEngineVolume() {
        return engineVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractVehicle)) return false;

        AbstractVehicle that = (AbstractVehicle) o;

        if (engineVolume != null ? !engineVolume.equals(that.engineVolume) : that.engineVolume != null) return false;
        if (!manufacturer.equals(that.manufacturer)) return false;
        if (!model.equals(that.model)) return false;
        if (!registrationDate.equals(that.registrationDate)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = manufacturer.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + registrationDate.hashCode();
        result = 31 * result + (engineVolume != null ? engineVolume.hashCode() : 0);
        return result;
    }
}
