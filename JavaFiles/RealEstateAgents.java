public class RealEstateAgents extends RealEstateCompanies {

    private int agentNumber;
    private String agentFullName;
    private String agentEmail;
    private String agentPhoneNumber;

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