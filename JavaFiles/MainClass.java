import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {

        ArrayList<CommercialProperty> commercialPropertyList = new ArrayList<CommercialProperty>();
        commercialPropertyList.add(new CommercialProperty());
        commercialPropertyList.add(new CommercialProperty());

        ArrayList<ResidentialProperty> residentialPropertyList = new ArrayList<ResidentialProperty>();
        residentialPropertyList.add(new ResidentialProperty());
        residentialPropertyList.add(new ResidentialProperty());
        residentialPropertyList.add(new ResidentialProperty());
        residentialPropertyList.add(new ResidentialProperty());
        residentialPropertyList.add(new ResidentialProperty());
        residentialPropertyList.add(new ResidentialProperty());
        residentialPropertyList.add(new ResidentialProperty());
        residentialPropertyList.add(new ResidentialProperty());
        residentialPropertyList.add(new ResidentialProperty());

        GUISearchJFrame frame = new GUISearchJFrame(residentialPropertyList, commercialPropertyList);
    }
}