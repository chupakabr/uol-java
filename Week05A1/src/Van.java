import java.util.Date;

/**
 * Created by myltik
 * Created on 8/6/13 6:29 PM
 */
public class Van extends AbstractVehicle {

    public static final double WEIGHT_LIMIT = 3500d; // kg

    protected final Double weight; // kg
    private Double annualRoadTaxCached = null;

    public Van(String manufacturer, String model, Date registrationDate, Double weight)
            throws MissingParametersException
    {
        super(manufacturer, model, registrationDate);

        if (weight == null) throw new MissingParametersException("Weight must be set");

        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }

    @Override
    public Double getAnnualRoadTaxCharge() {
        if (annualRoadTaxCached == null) {
            synchronized (this) {
                if (annualRoadTaxCached == null) {
                    if (weight < WEIGHT_LIMIT) {
                        annualRoadTaxCached = 165d;
                    } else {
                        annualRoadTaxCached = 190d;
                    }
                }
            }
        }

        return annualRoadTaxCached;
    }

    @Override
    public String toString() {
        return "Van{" +
                "weight=" + manufacturer +
                ",model=" + model +
                ",registrationDate=" + registrationDate +
                ",engineVolume=" + engineVolume +
                ",weight=" + weight +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Van van = (Van) o;

        if (!weight.equals(van.weight)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + weight.hashCode();
        return result;
    }
}
