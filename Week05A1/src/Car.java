import java.util.Calendar;
import java.util.Date;

/**
 * Created by myltik
 * Created on 8/6/13 6:29 PM
 */
public class Car extends AbstractVehicle {

    public static final double ENGINE_LIMIT = 1550d;
    public static final Date LIMIT_DATE;
    static {
        Calendar cal = Calendar.getInstance();
        cal.set(2001, 2, 1, 0, 0);

        LIMIT_DATE = cal.getTime();
    }

    protected final Double co2Emission; // g/km
    private Double annualRoadTaxCached = null;

    public Car(String manufacturer, String model, Date registrationDate, Double engineVolume, Double co2Emission)
            throws MissingParametersException
    {
        super(manufacturer, model, registrationDate, engineVolume);

        if (engineVolume == null) throw new MissingParametersException("Engine size must be set");
        if (co2Emission == null) throw new MissingParametersException("CO2 emission must be set");

        this.co2Emission = co2Emission;
    }

    @Override
    public Double getAnnualRoadTaxCharge() {
        if (annualRoadTaxCached == null) {
            synchronized (this) {
                if (annualRoadTaxCached == null) {
                    if (registrationDate.before(LIMIT_DATE)) {
                        if (co2Emission <= 100d) {
                            annualRoadTaxCached = 65d;
                        } else if (co2Emission <= 120d) {
                            annualRoadTaxCached = 75d;
                        } else if (co2Emission <= 150d) {
                            annualRoadTaxCached = 105d;
                        } else if (co2Emission <= 165d) {
                            annualRoadTaxCached = 125d;
                        } else if (co2Emission <= 185d) {
                            annualRoadTaxCached = 145d;
                        } else {
                            annualRoadTaxCached = 160d;
                        }
                    } else {
                        if (engineVolume > ENGINE_LIMIT) {
                            annualRoadTaxCached = 165d;
                        } else {
                            annualRoadTaxCached = 110d;
                        }
                    }
                }
            }

        }

        return annualRoadTaxCached;
    }

    @Override
    public String toString() {
        return "Car{" +
                "weight=" + manufacturer +
                ",model=" + model +
                ",registrationDate=" + registrationDate +
                ",engineVolume=" + engineVolume +
                ",co2Emission=" + co2Emission +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Car car = (Car) o;

        if (!co2Emission.equals(car.co2Emission)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + co2Emission.hashCode();
        return result;
    }
}
