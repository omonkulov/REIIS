public class MainClass {

    public static void main(String[] args) {
        CommercialProperty residentialProperty = new CommercialProperty(124142, "Real Estate", "2141 Apt 23", "Pitts",
                "companyState", "412-421-4545", "companyEmail", "companyPhoneNumber", 515, "agentFullName",
                "agentEmail", "agentPhoneNumber", 4543, 43535, 'R', "propertyAddress", "propertyState",
                "propertyZipCode", 2412424.242, 12214.124, 124124.124);

        System.out.println(residentialProperty.getTotalTax());
        residentialProperty.setBuildingValue(9999);
        System.out.println(residentialProperty.getTotalTax());
    }
}