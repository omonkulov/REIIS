/**
 * CommercialProperty
 */
public class CommercialProperty extends MultilistProperties {
    private final double LOCAL_RATE = 0.0435;
    private final double COUNTY_RATE = 0.07251;
    private final double SCHOOL_TAX = 0.2790;

    private double totalPropertyValue;
    private double localTax;
    private double countyTax;
    private double schoolTax;
    private double totalTax;

    public CommercialProperty(int companyNumber, String companyName, String companyAddress, String companyCity,
            String companyState, String companyZipCode, String companyEmail, String companyPhoneNumber, int agentNumber,
            String agentFullName, String agentEmail, String agentPhoneNumber, int propertyNumber, int parcelNumber,
            char propertyType, String propertyAddress, String propertyState, String propertyZipCode, double askingPrice,
            double landValue, double buildingValue) {

        super(companyNumber, companyName, companyAddress, companyCity, companyState, companyZipCode, companyEmail,
                companyPhoneNumber, agentNumber, agentFullName, agentEmail, agentPhoneNumber, propertyNumber,
                parcelNumber, propertyType, propertyAddress, propertyState, propertyZipCode, askingPrice, landValue,
                buildingValue);

        initPropertyvalue(landValue, buildingValue);
        initLocalTax();
        initSchoolPropertyTax();
        initCountyTax();
        initTotalTax();

    }

    public double getLocalTax() {
        return this.localTax;
    }

    public double getCountyTax() {
        return this.countyTax;
    }

    public double getSchoolTax() {
        return this.schoolTax;
    }

    public double getTotalTax() {
        return this.totalTax;
    }

    @Override
    void initPropertyvalue(double landValue, double buildingValue) {
        this.totalPropertyValue = landValue + buildingValue;
    }

    @Override
    void initLocalTax() {
        this.localTax = LOCAL_RATE * this.totalPropertyValue;
    }

    @Override
    void initSchoolPropertyTax() {
        this.schoolTax = SCHOOL_TAX * this.totalPropertyValue;
    }

    @Override
    void initCountyTax() {
        this.countyTax = COUNTY_RATE * this.totalPropertyValue;
    }

    @Override
    void initTotalTax() {
        this.totalTax = this.schoolTax + this.countyTax + this.localTax;
    }
}