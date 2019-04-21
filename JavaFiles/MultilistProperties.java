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

        super(companyNumber, companyName, companyAddress, companyCity, companyState, companyZipCode, companyEmail,
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

    public abstract void initPropertyvalue(double landValue, double buildingValue);

    public abstract void initLocalTax();

    public abstract void initSchoolPropertyTax();

    public abstract void initTotalTax();

    public abstract void initCountyTax();

    public abstract void upDateInfo();

    /**
     * @return the propertyNumber
     */
    public int getPropertyNumber() {
        return propertyNumber;
    }

    /**
     * @param propertyNumber the propertyNumber to set
     */
    public void setPropertyNumber(int propertyNumber) {
        this.propertyNumber = propertyNumber;
        upDateInfo();
    }

    /**
     * @return the parcelNumber
     */
    public int getParcelNumber() {
        return parcelNumber;
    }

    /**
     * @param parcelNumber the parcelNumber to set
     */
    public void setParcelNumber(int parcelNumber) {
        this.parcelNumber = parcelNumber;
    }

    /**
     * @return the propertyType
     */
    public char getPropertyType() {
        return propertyType;
    }

    /**
     * @param propertyType the propertyType to set
     */
    public void setPropertyType(char propertyType) {
        this.propertyType = propertyType;
    }

    /**
     * @return the propertyAddress
     */
    public String getPropertyAddress() {
        return propertyAddress;
    }

    /**
     * @param propertyAddress the propertyAddress to set
     */
    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    /**
     * @return the propertyState
     */
    public String getPropertyState() {
        return propertyState;
    }

    /**
     * @param propertyState the propertyState to set
     */
    public void setPropertyState(String propertyState) {
        this.propertyState = propertyState;
    }

    /**
     * @return the propertyZipCode
     */
    public String getPropertyZipCode() {
        return propertyZipCode;
    }

    /**
     * @param propertyZipCode the propertyZipCode to set
     */
    public void setPropertyZipCode(String propertyZipCode) {
        this.propertyZipCode = propertyZipCode;
    }

    /**
     * @return the askingPrice
     */
    public double getAskingPrice() {
        return askingPrice;
    }

    /**
     * @param askingPrice the askingPrice to set
     */
    public void setAskingPrice(double askingPrice) {
        this.askingPrice = askingPrice;
    }

    /**
     * @return the landValue
     */
    public double getLandValue() {
        return landValue;
    }

    /**
     * @param landValue the landValue to set
     */
    public void setLandValue(double landValue) {
        this.landValue = landValue;
        upDateInfo();
    }

    /**
     * @return the buildingValue
     */
    public double getBuildingValue() {
        return buildingValue;
    }

    /**
     * @param buildingValue the buildingValue to set
     */
    public void setBuildingValue(double buildingValue) {
        this.buildingValue = buildingValue;
        upDateInfo();
    }

}