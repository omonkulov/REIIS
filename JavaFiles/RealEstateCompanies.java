
/*
 * Author   Sardorbek Omonkulov
 * Date     05/03/2019 
 * Purpose  Super class which includes the information of Real Estate company.
 */
public class RealEstateCompanies {
    // Company's infomation
    private int companyNumber;
    private String companyName;
    private String companyAddress;
    private String companyCity;
    private String companyState;
    private String companyZipCode;
    private String companyEmail;

    // Constructor to create an empty object
    public RealEstateCompanies() {
        this.companyNumber = -1;
        this.companyName = "N/A";
        this.companyAddress = "N/A";
        this.companyCity = "N/A";
        this.companyState = "N/A";
        this.companyZipCode = "N/A";
        this.companyEmail = "N/A";
    }

    /**
     * Overload to create an object will all the detials
     * 
     * @param companyNumber
     * @param companyName
     * @param companyAddress
     * @param companyCity
     * @param companyState
     * @param companyZipCode
     * @param companyEmail
     * @param companyPhoneNumber
     */
    public RealEstateCompanies(int companyNumber, String companyName, String companyAddress, String companyCity,
            String companyState, String companyZipCode, String companyEmail, String companyPhoneNumber) {
        this.companyNumber = companyNumber;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyCity = companyCity;
        this.companyState = companyState;
        this.companyZipCode = companyZipCode;
        this.companyEmail = companyEmail;
    }

    /**
     * @return the companyNumber
     */
    public int getCompanyNumber() {
        return companyNumber;
    }

    /**
     * @param companyNumber the companyNumber to set
     */
    public void setCompanyNumber(int companyNumber) {
        this.companyNumber = companyNumber;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return the companyAddress
     */
    public String getcompanyAddress() {
        return companyAddress;
    }

    /**
     * @param companyAddress the companyAddress to set
     */
    public void setcompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    /**
     * @return the companyCity
     */
    public String getcompanyCity() {
        return companyCity;
    }

    /**
     * @param companyCity the companyCity to set
     */
    public void setcompanyCity(String companyCity) {
        this.companyCity = companyCity;
    }

    /**
     * @return the companyState
     */
    public String getcompanyState() {
        return companyState;
    }

    /**
     * @param companyState the companyState to set
     */
    public void setcompanyState(String companyState) {
        this.companyState = companyState;
    }

    /**
     * @return the companyZipCode
     */
    public String getcompanyZipCode() {
        return companyZipCode;
    }

    /**
     * @param companyZipCode the companyZipCode to set
     */
    public void setcompanyZipCode(String companyZipCode) {
        this.companyZipCode = companyZipCode;
    }

    /**
     * @return the companyEmail
     */
    public String getCompanyEmail() {
        return companyEmail;
    }

    /**
     * @param companyEmail the companyEmail to set
     */
    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

}