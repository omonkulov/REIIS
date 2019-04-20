public abstract class MultilistProperties extends RealEstateAgents {
    private int propertyNumber;
    private int parcelNumber;
    private char propertyType;
    private String propertyAddress;
    private String propertyState;
    private String propertyZipCode;
    private double askingPrice;
    private double landValue;
    private double buildingValue;

    public MultilistProperties(int companyNumber, String companyName, String companyAddress, String companyCity,
            String companyState, String companyZipCode, String companyEmail, String companyPhoneNumber, int agentNumber,
            String agentFullName, String agentEmail, String agentPhoneNumber, int propertyNumber, int parcelNumber,
            char propertyType, String propertyAddress, String propertyState, String propertyZipCode, double askingPrice,
            double landValue, double buildingValue) {

        super(companyNumber, companyName, companyAddress, companyCity, companyState, zipCode, companyEmail,
                companyPhoneNumber, agentNumber, agentFullName, agentEmail, agentPhoneNumber);

        this.propertyNumber = propertyNumber;
        this.parcelNumber = parcelNumber;
        this.propertyType = propertyType;
        this.propertyAddress = propertyAddress;
        this.propertyState = propertyState;
        this.propertyZipCode = propertyZipCode;
        this.askingPrice = askingPrice;
        this.landValue = landValue;
        this.buildingValue = buildingValue;
    }

    abstract void initPropertyvalue();

    abstract void initLocalTax();

    abstract void initSchoolPropertyTax();

    abstract void initTotalTax();

    abstract void initCountyTax();
}