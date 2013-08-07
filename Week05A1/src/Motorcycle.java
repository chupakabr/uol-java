import java.util.Date;

/**
 * Created by myltik
 * Created on 8/6/13 6:29 PM
 */
public class Motorcycle extends AbstractVehicle {

    private Double annualRoadTaxCached = null;

    public Motorcycle(String manufacturer, String model, Date registrationDate, Double engineVolume)
            throws MissingParametersException
    {
        super(manufacturer, model, registrationDate, engineVolume);

        if (engineVolume == null) throw new MissingParametersException("Engine size must be set");
    }

    @Override
    public Double getAnnualRoadTaxCharge() {
        if (annualRoadTaxCached == null) {
            synchronized (this) {
                if (annualRoadTaxCached == null) {
                    if (engineVolume <= 150d) {
                        annualRoadTaxCached = 15d;
                    } else if (engineVolume <= 400d) {
                        annualRoadTaxCached = 30d;
                    } else if (engineVolume <= 600d) {
                        annualRoadTaxCached = 45d;
                    } else {
                        annualRoadTaxCached = 60d;
                    }
                }
            }
        }

        return annualRoadTaxCached;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "weight=" + manufacturer +
                ",model=" + model +
                ",registrationDate=" + registrationDate +
                ",engineVolume=" + engineVolume +
                "}";
    }
}
