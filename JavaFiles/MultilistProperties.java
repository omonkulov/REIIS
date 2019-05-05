/*
 * Author   Sardorbek Omonkulov
 * Date     05/03/2019 
 * Purpose  MultiliestProperties- Sub class of RealEstateAgents, additionally contains Generic property information and abstract methods to calculate the taxes
 */
public abstract class MultilistProperties extends RealEstateAgents {
    private int propertyNumber;
    private int parcelNumber;
    private char propertyType;
    private String propertyCity;
    private String propertyAddress;
    private String propertyState;
    private String propertyZipCode;
    private double askingPrice;
    private double landValue;
    private double buildingValue;

    /**
     * Create an empty property
     */
    public MultilistProperties() {
        super();
        this.propertyNumber = -1;
        this.parcelNumber = 0;
        this.propertyType = '?';
        this.propertyAddress = "N/A";
        this.propertyState = "N/A";
        this.propertyZipCode = "N/A";
        this.askingPrice = 0.00;
        this.landValue = 0.00;
        this.buildingValue = 0.00;
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
    public MultilistProperties(int companyNumber, String companyName, String companyAddress, String companyCity,
            String companyState, String companyZipCode, String companyEmail, String companyPhoneNumber, int agentNumber,
            String agentFullName, String agentEmail, String agentPhoneNumber, int propertyNumber, int parcelNumber,
            char propertyType, String propertyAddress, String propertyCity, String propertyState,
            String propertyZipCode, double askingPrice, double landValue, double buildingValue) {

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
        this.propertyCity = propertyCity;
    }

    /**
     * initializes & calculates the propertyValue
     */
    public abstract void initPropertyvalue(double landValue, double buildingValue);

    /**
     * initializes & calculates the local taxes
     */
    public abstract void initLocalTax();

    /**
     * initializes & calculates the school property taxs
     */
    public abstract void initSchoolPropertyTax();

    /**
     * initializes & calculates the total taxs
     */
    public abstract void initTotalTax();

    /**
     * initializes & calculates the county taxes
     */
    public abstract void initCountyTax();

    /**
     * Recalculates the taxes, this is just for scalibilty.
     */
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

    /**
     * @return the propertyCity
     */
    public String getPropertyCity() {
        return propertyCity;
    }

    /**
     * @param propertyCity the propertyCity to set
     */
    public void setPropertyCity(String propertyCity) {
        this.propertyCity = propertyCity;
    }

}