/*
 * Author   Sardorbek Omonkulov
 * Date     05/03/2019 
 * Purpose  Object class to keep information about Residential Property, this class will also calculate the taxes.
 */
public class ResidentialProperty extends MultilistProperties {
    private final double LOCAL_RATE = 0.0435;
    private final double COUNTY_RATE = 0.07251;
    private final double SCHOOL_TAX = 0.2790;

    private double totalPropertyValue;
    private double localTax;
    private double countyTax;
    private double schoolTax;
    private double totalTax;

    /**
     * Creating empty Object
     */
    public ResidentialProperty() {
        super();
        this.totalPropertyValue = 0;
        this.localTax = 0;
        this.countyTax = 0;
        this.schoolTax = 0;
        this.totalTax = 0;
        initPropertyvalue(0, 0);
        upDateInfo();
    }

    /**
     * Method overload: Creating object with limited information
     * 
     * @param companyName
     * @param companyNumber
     * @param agentFullName
     * @param agentNumber
     * @param agentPhoneNumber
     * @param propertyNumber
     * @param parcelNumber
     * @param propertyType
     * @param propertyAddress
     * @param propertyCity
     * @param propertyState
     * @param propertyZipCode
     * @param askingPrice
     * @param buildingValue
     * @param landValue
     */
    public ResidentialProperty(String companyName, int companyNumber, String agentFullName, int agentNumber,
            String agentPhoneNumber, int propertyNumber, int parcelNumber, char propertyType, String propertyAddress,
            String propertyCity, String propertyState, String propertyZipCode, double askingPrice, double buildingValue,
            double landValue) {

        super(companyNumber, companyName, "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", agentNumber, agentFullName, "N/A",
                agentPhoneNumber, propertyNumber, parcelNumber, propertyType, propertyAddress, propertyCity,
                propertyState, propertyZipCode, askingPrice, landValue, buildingValue);
        initPropertyvalue(landValue, buildingValue);
        upDateInfo();
    }

    /**
     * Method overload: Creating object with all the details
     * 
     * @param companyNumber
     * @param companyName
     * @param companyAddress
     * @param companyCity
     * @param companyState
     * @param companyZipCode
     * @param companyEmail
     * @param companyPhoneNumber
     * @param agentNumber
     * @param agentFullName
     * @param agentEmail
     * @param agentPhoneNumber
     * @param propertyNumber
     * @param parcelNumber
     * @param propertyType
     * @param propertyAddress
     * @param propertyCity
     * @param propertyState
     * @param propertyZipCode
     * @param askingPrice
     * @param landValue
     * @param buildingValue
     */
    public ResidentialProperty(int companyNumber, String companyName, String companyAddress, String companyCity,
            String companyState, String companyZipCode, String companyEmail, String companyPhoneNumber, int agentNumber,
            String agentFullName, String agentEmail, String agentPhoneNumber, int propertyNumber, int parcelNumber,
            char propertyType, String propertyAddress, String propertyCity, String propertyState,
            String propertyZipCode, double askingPrice, double landValue, double buildingValue) {

        super(companyNumber, companyName, companyAddress, companyCity, companyState, companyZipCode, companyEmail,
                companyPhoneNumber, agentNumber, agentFullName, agentEmail, agentPhoneNumber, propertyNumber,
                parcelNumber, propertyType, propertyAddress, propertyCity, propertyState, propertyZipCode, askingPrice,
                landValue, buildingValue);

        initPropertyvalue(landValue, buildingValue);
        upDateInfo();

    }

    public double getLocalTax() {
        return ((int) (this.localTax * 100.0)) / 100.0;
    }

    public double getCountyTax() {
        return ((int) (this.countyTax * 100.0)) / 100.0;
    }

    public double getSchoolTax() {
        return ((int) (this.schoolTax * 100.0)) / 100.0;
    }

    public double getTotalTax() {
        return ((int) (this.totalTax * 100.0)) / 100.0;
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