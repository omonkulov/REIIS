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

    // TODO: Overload the constructors!
    public CommercialProperty() {
        super();
        this.totalPropertyValue = 0;
        this.localTax = 0;
        this.countyTax = 0;
        this.schoolTax = 0;
        this.totalTax = 0;
    }

    public CommercialProperty(String companyName, int companyNumber, String agentFullName, int agentNumber,
            String agentPhoneNumber, int propertyNumber, int parcelNumber, char propertyType, String propertyAddress,
            String propertyCity, String propertyState, String propertyZipCode, double askingPrice, double buildingValue,
            double landValue) {

        super(companyNumber, companyName, "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", agentNumber, agentFullName, "N/A",
                agentPhoneNumber, propertyNumber, parcelNumber, propertyType, propertyAddress, propertyCity,
                propertyState, propertyZipCode, askingPrice, landValue, buildingValue);
    }

    public CommercialProperty(int companyNumber, String companyName, String companyAddress, String companyCity,
            String companyState, String companyZipCode, String companyEmail, String companyPhoneNumber, int agentNumber,
            String agentFullName, String agentEmail, String agentPhoneNumber, int propertyNumber, int parcelNumber,
            char propertyType, String propertyAddress, String propertyCity, String propertyState,
            String propertyZipCode, double askingPrice, double landValue, double buildingValue) {

        super(companyNumber, companyName, companyAddress, companyCity, companyState, companyZipCode, companyEmail,
                companyPhoneNumber, agentNumber, agentFullName, agentEmail, agentPhoneNumber, propertyNumber,
                parcelNumber, propertyType, propertyAddress, propertyCity, propertyState, propertyZipCode, askingPrice,
                landValue, buildingValue);

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
    public void initPropertyvalue(double landValue, double buildingValue) {
        this.totalPropertyValue = landValue + buildingValue;
    }

    @Override
    public void initLocalTax() {
        this.localTax = LOCAL_RATE * this.totalPropertyValue;
    }

    @Override
    public void initSchoolPropertyTax() {
        this.schoolTax = SCHOOL_TAX * this.totalPropertyValue;
    }

    @Override
    public void initCountyTax() {
        this.countyTax = COUNTY_RATE * this.totalPropertyValue;
    }

    @Override
    public void initTotalTax() {
        this.totalTax = this.schoolTax + this.countyTax + this.localTax;
    }

    @Override
    public void upDateInfo() {
        initPropertyvalue(this.getBuildingValue(), this.getLandValue());
        initLocalTax();
        initSchoolPropertyTax();
        initCountyTax();
        initTotalTax();
    }
}