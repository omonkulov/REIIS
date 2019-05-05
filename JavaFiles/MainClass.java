/*
 * Author   Sardorbek Omonkulov
 * Date     05/03/2019 
 * Purpose  Real Estate Inquiry Information System: System to manage and view commercial and residential properties along with other details
 *          This program uses GUI (Java Swing) to take inputs and let the user interact with it. This program includes inheritance concepts and etc.
 *          The property types splits into two classes. One is ResidentialProperty sub class and the second is CommercialProperty sub class.
 * 
 * Classes: 
 *          GUIMainJFrame       - This class contains the main JFrame, which includes the lists, search and buttons
 *          GUIInfoJPanel       - This class contains the panel which contains JTextFields and some buttons. Allows the user to view, edit and add objects.
 *          RealEstateCompanies - Super class which includes the information of Real Estate company
 *          RealEstateAgents    - Sub class of RealEstateCompanies, additionally contains Agent's information
 *          MultiliestProperties- Sub class of RealEstateAgents, additionally contains Generic properties information
 *          CommercialProperty  - Sub class of MultiliestProperties, overrides some methods and contains static tax rates 
 *          ResidentialProperty - Sub class of MultiliestProperties, overrides some methods and contains static tax rates
 *          GerRandom           - This class read the text files in txtFiles directory and selectes random information (Address, phone number, name and etc..)
 * 
 * Directory:
 *          txtFiles            - This directory includes text files with random generated informations (Address, phone number, name and etc..). 
 *          imgs                - Contains images that are randomly selected when viewing an object
 * 
 * Note:    
 *          Sometimes(not always) when you run the program, it will either will not load all the generated objects or spits error in the command line on first launch.
 *          It has to do something with the Swing apparently. Only fix to this was to re-run it.
 *          
 *          This course was very educational and the most orginized one I have ever seen. Thank you for you hard work Dr.Grant.
 *          Plus this was my biggest project so far, it was a fun ride.
 * 
 *          Thank you once more!
 */
public class MainClass {
    public static void main(String[] args) {
        // Number of properties to generate from the beginning
        int residentialProperties = 4;
        int commercialProperties = 4;

        // Creates GUI
        GUIMainJFrame frame = new GUIMainJFrame();

        // Generates Residential Property from text files
        frame.generateResidentialProperty(residentialProperties);
        // Generates Commercial Property from text files;
        frame.generateCommercialProperty(commercialProperties);

    }

}