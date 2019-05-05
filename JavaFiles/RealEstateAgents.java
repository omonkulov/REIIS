/*
 * Author   Sardorbek Omonkulov
 * Date     05/03/2019 
 * Purpose  Sub class of RealEstateCompanies, additionally contains Agent's information such as agent number, full name, email and phone number
 */
public class RealEstateAgents extends RealEstateCompanies {

    // Agent's information
    private int agentNumber;
    private String agentFullName;
    private String agentEmail;
    private String agentPhoneNumber;

    /**
     * Constructor to create an empty oobject
     */
    public RealEstateAgents() {
        super();
        this.agentNumber = -1;
        this.agentFullName = "N/A";
        this.agentEmail = "N/A";
        this.agentPhoneNumber = "N/A";
    }

    /**
     * Overload constructor to create an object with full details
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
     */
    public RealEstateAgents(int companyNumber, String companyName, String companyAddress, String companyCity,
            String companyState, String companyZipCode, String companyEmail, String companyPhoneNumber, int agentNumber,
            String agentFullName, String agentEmail, String agentPhoneNumber) {

        super(companyNumber, companyName, companyAddress, companyCity, companyState, companyZipCode, companyEmail,
                companyPhoneNumber);

        this.agentNumber = agentNumber;
        this.agentFullName = agentFullName;
        this.agentEmail = agentEmail;
        this.agentPhoneNumber = agentPhoneNumber;
    }

    /**
     * @return the agentNumber
     */
    public int getAgentNumber() {
        return agentNumber;
    }

    /**
     * @param agentNumber the agentNumber to set
     */
    public void setAgentNumber(int agentNumber) {
        this.agentNumber = agentNumber;
    }

    /**
     * @return the agentFullName
     */
    public String getAgentFullName() {
        return agentFullName;
    }

    /**
     * @param agentFullName the agentFullName to set
     */
    public void setAgentFullName(String agentFullName) {
        this.agentFullName = agentFullName;
    }

    /**
     * @return the agentEmail
     */
    public String getAgentEmail() {
        return agentEmail;
    }

    /**
     * @param agentEmail the agentEmail to set
     */
    public void setAgentEmail(String agentEmail) {
        this.agentEmail = agentEmail;
    }

    /**
     * @return the agentPhoneNumber
     */
    public String getAgentPhoneNumber() {
        return agentPhoneNumber;
    }

    /**
     * @param agentPhoneNumber the agentPhoneNumber to set
     */
    public void setAgentPhoneNumber(String agentPhoneNumber) {
        this.agentPhoneNumber = agentPhoneNumber;
    }

}