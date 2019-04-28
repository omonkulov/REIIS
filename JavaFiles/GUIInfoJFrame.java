import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * GUIInfoJFrame
 */
public class GUIInfoJFrame extends JPanel {
    private static final long serialVersionUID = 1L;

    /* Private Variables */
    private boolean isEdit;
    /* Fields */
    private JTextField companyName;
    private JTextField companyNumber;
    private JTextField agentName;
    private JTextField agentNumber;
    private JTextField agentPhoneNumber;
    private JTextField propertyListNumber;
    private JTextField parcelNumber;
    private JLabel propertyType;
    private JTextField propertyAddress;
    private JTextField propertyCity;
    private JTextField propertyState;
    private JTextField propertyZipCode;
    private JTextField askingPrice;
    private JTextField buildingValue;
    private JTextField landValue;
    private JLabel localTax;
    private JLabel countyTax;
    private JLabel schoolTax;
    private JLabel totalTax;

    /* Labels */
    private JLabel companyNameLbl;
    private JLabel companyNumberLbl;
    private JLabel agentNameLbl;
    private JLabel agentNumberLbl;
    private JLabel agentPhoneNumberLbl;
    private JLabel propertyListNumberLbl;
    private JLabel parcelNumberLbl;
    private JLabel propertyTypeLbl;
    private JLabel propertyAddressLbl;
    private JLabel propertyCityLbl;
    private JLabel propertyStateLbl;
    private JLabel propertyZipCodeLbl;
    private JLabel askingPriceLbl;
    private JLabel buildingValueLbl;
    private JLabel landValueLbl;
    private JLabel localTaxLbl;
    private JLabel countyTaxLbl;
    private JLabel schoolTaxLbl;
    private JLabel totalTaxLbl;

    /* Buttons Panel */
    private JButton saveInfo;
    private JButton addInfo;
    private JButton cancle;
    private JButton closeINfo;

    /* Panels */
    private JPanel companyPanel;
    private JPanel agentPanel;
    private JPanel propertyPanel;
    private JPanel valuePanel;
    private JPanel taxesPanel;
    private JPanel imgPanel;
    private JPanel buttonsPanel;

    /* img */
    private BufferedImage image;
    private JLabel imgLabel;

    /* Listener */
    private ButtonActionListener buttonListener;

    /* Parent Frame */
    private GUISearchJFrame parentFrame;

    /* Misc */
    private int addingPropertyType; // 0: Residential 1:Commercial
    private CommercialProperty tempCommercialObject;
    private ResidentialProperty tempResidentialProperty;

    public GUIInfoJFrame(GUISearchJFrame parent) {
        this.parentFrame = parent;
        companyName = new JTextField();
        companyNumber = new JTextField();
        agentName = new JTextField();
        agentNumber = new JTextField();
        agentPhoneNumber = new JTextField();
        propertyListNumber = new JTextField();
        parcelNumber = new JTextField();
        propertyType = new JLabel();
        propertyAddress = new JTextField();
        propertyCity = new JTextField();
        propertyState = new JTextField();
        propertyZipCode = new JTextField();
        askingPrice = new JTextField();
        buildingValue = new JTextField();
        landValue = new JTextField();
        localTax = new JLabel();
        countyTax = new JLabel();
        schoolTax = new JLabel();
        totalTax = new JLabel();

        companyNameLbl = new JLabel("Company Name:");
        companyNumberLbl = new JLabel("Company Number:");
        agentNameLbl = new JLabel("Agent Name:");
        agentNumberLbl = new JLabel("Agent Number:");
        agentPhoneNumberLbl = new JLabel("Agent Phone:");
        propertyListNumberLbl = new JLabel("Property Number:");
        parcelNumberLbl = new JLabel("Parcel Number:");
        propertyTypeLbl = new JLabel("Property Type:");
        propertyAddressLbl = new JLabel("Property Address:");
        propertyCityLbl = new JLabel("Property City:");
        propertyStateLbl = new JLabel("Property State:");
        propertyZipCodeLbl = new JLabel("Propterty Zip:");
        askingPriceLbl = new JLabel("Asking Price:");
        buildingValueLbl = new JLabel("Building Value:");
        landValueLbl = new JLabel("Land Value:");
        localTaxLbl = new JLabel("Local Tax:");
        countyTaxLbl = new JLabel("County Tax:");
        schoolTaxLbl = new JLabel("School Tax:");
        totalTaxLbl = new JLabel("Total Tax:");

        saveInfo = new JButton("Save");
        closeINfo = new JButton("Close");
        addInfo = new JButton("Add");
        cancle = new JButton("Cancel");

        buttonListener = new ButtonActionListener();
        saveInfo.addActionListener(buttonListener);
        closeINfo.addActionListener(buttonListener);
        addInfo.addActionListener(buttonListener);
        cancle.addActionListener(buttonListener);

        /* Company */
        companyPanel = new JPanel();
        companyPanel.setBorder(BorderFactory.createTitledBorder("Company"));
        companyPanel.setLayout(new GridLayout(2, 2, 5, 5));
        companyPanel.add(companyNameLbl);
        companyPanel.add(companyName);
        companyPanel.add(companyNumberLbl);
        companyPanel.add(companyNumber);

        /* Agent */
        agentPanel = new JPanel();
        agentPanel.setLayout(new GridLayout(3, 2, 0, 5));
        agentPanel.setBorder(BorderFactory.createTitledBorder("Agent"));
        agentPanel.add(agentNameLbl);
        agentPanel.add(agentName);
        agentPanel.add(agentNumberLbl);
        agentPanel.add(agentNumber);
        agentPanel.add(agentPhoneNumberLbl);
        agentPanel.add(agentPhoneNumber);

        /* Property */
        propertyPanel = new JPanel();
        propertyPanel.setLayout(new GridLayout(7, 2, 10, 10));
        propertyPanel.setBorder(BorderFactory.createTitledBorder("Property"));
        propertyPanel.add(propertyListNumberLbl);
        propertyPanel.add(propertyListNumber);
        propertyPanel.add(parcelNumberLbl);
        propertyPanel.add(parcelNumber);
        propertyPanel.add(propertyTypeLbl);
        propertyPanel.add(propertyType);
        propertyPanel.add(propertyAddressLbl);
        propertyPanel.add(propertyAddress);
        propertyPanel.add(propertyCityLbl);
        propertyPanel.add(propertyCity);
        propertyPanel.add(propertyStateLbl);
        propertyPanel.add(propertyState);
        propertyPanel.add(propertyZipCodeLbl);
        propertyPanel.add(propertyZipCode);

        /* Value & Price */
        valuePanel = new JPanel();
        valuePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        valuePanel.setLayout(new GridLayout(3, 2, 0, 5));
        valuePanel.add(askingPriceLbl);
        valuePanel.add(askingPrice);
        valuePanel.add(buildingValueLbl);
        valuePanel.add(buildingValue);
        valuePanel.add(landValueLbl);
        valuePanel.add(landValue);

        /* Taxes */
        taxesPanel = new JPanel();
        taxesPanel.setLayout(new GridLayout(4, 2, 0, 5));
        taxesPanel.setBorder(BorderFactory.createTitledBorder("Taxes"));
        taxesPanel.add(localTaxLbl);
        taxesPanel.add(localTax);
        taxesPanel.add(countyTaxLbl);
        taxesPanel.add(countyTax);
        taxesPanel.add(schoolTaxLbl);
        taxesPanel.add(schoolTax);
        taxesPanel.add(totalTaxLbl);
        taxesPanel.add(totalTax);

        /* Buttons Panel */
        buttonsPanel = new JPanel();
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonsPanel.add(cancle);
        buttonsPanel.add(addInfo);
        buttonsPanel.add(closeINfo);
        buttonsPanel.add(saveInfo);

        /* Image */
        imgPanel = new JPanel();
        imgLabel = new JLabel(new ImageIcon("imgs/" + getRandomNumber() + ".jpg"));
        imgLabel.setSize(new Dimension(40, 40));
        imgPanel.add(imgLabel);

        /* Putting it all together */
        setBorder(new EmptyBorder(15, 15, 15, 15));
        setLayout(new GridBagLayout());
        addComp(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.BOTH, companyPanel);
        addComp(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.BOTH, agentPanel);
        addComp(0, 1, 2, 3, 0.0, 0.0, GridBagConstraints.BOTH, propertyPanel);
        addComp(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.BOTH, valuePanel);
        addComp(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.BOTH, taxesPanel);
        addComp(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.BOTH, imgPanel);
        addComp(0, 5, 5, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL, buttonsPanel);

    }

    private void addComp(int x, int y, int gWidth, int gHeight, double weightx, double weighty, int fill, JPanel comp) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = gWidth;
        gbc.gridheight = gHeight;
        gbc.fill = fill;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        add(comp, gbc);
    }

    public void setTextEditable(boolean i) {
        companyName.setEditable(i);
        companyNumber.setEditable(i);
        agentName.setEditable(i);
        agentNumber.setEditable(i);
        agentPhoneNumber.setEditable(i);
        propertyListNumber.setEditable(i);
        parcelNumber.setEditable(i);
        propertyAddress.setEditable(i);
        propertyCity.setEditable(i);
        propertyState.setEditable(i);
        propertyZipCode.setEditable(i);
        askingPrice.setEditable(i);
        buildingValue.setEditable(i);
        landValue.setEditable(i);
    }

    public void setRandomImage() {
        String path = "imgs/" + getRandomNumber() + ".jpg";
        System.out.println(path);
        imgLabel.setIcon(new ImageIcon(path));
    }

    public int getRandomNumber() {
        Random generator = new Random(System.currentTimeMillis());
        return generator.nextInt(100) % 100 / 10 + 1;
    }

    public void displayInfoButtons(boolean close, boolean add, boolean save, boolean cancel) {
        closeINfo.setVisible(close);
        addInfo.setVisible(add);
        saveInfo.setVisible(save);
        cancle.setVisible(cancel);
    }

    public void add(int type) {
        setVisible(true);
        setTextEditable(true);
        clearTxtFields();
        displayInfoButtons(false, true, false, true);
        addingPropertyType = type;
    }

    public void edit() {

    }

    public void close() {
        setVisible(false);

    }

    public void info(ResidentialProperty residential) {
        setVisible(true);
        updateInfo(residential);
        setTextEditable(false);
        displayInfoButtons(true, false, false, false);
    }

    public void info(CommercialProperty commercial) {
        setVisible(true);
        updateInfo(commercial);
        setTextEditable(false);
        displayInfoButtons(true, false, false, false);
    }

    public ResidentialProperty createResidentialObject() {
        return new ResidentialProperty(emptyToNA(companyName.getText()),
                Integer.parseInt(emptyToNA(companyNumber.getText())), emptyToNA(agentName.getText()),
                Integer.parseInt(emptyToNA(agentNumber.getText())), emptyToNA(agentPhoneNumber.getText()),
                Integer.parseInt(emptyToNA(propertyListNumber.getText())),
                Integer.parseInt(emptyToNA(parcelNumber.getText())), 'R', emptyToNA(propertyAddress.getText()),
                emptyToNA(propertyCity.getText()), emptyToNA(propertyState.getText()),
                emptyToNA(propertyZipCode.getText()), Double.parseDouble(emptyToNA(askingPrice.getText())),
                Double.parseDouble(emptyToNA(buildingValue.getText())),
                Double.parseDouble(emptyToNA(landValue.getText())));
    }

    public CommercialProperty createCommercialObject() {
        return new CommercialProperty(emptyToNA(companyName.getText()),
                Integer.parseInt(emptyToNA(companyNumber.getText())), emptyToNA(agentName.getText()),
                Integer.parseInt(emptyToNA(agentNumber.getText())), emptyToNA(agentPhoneNumber.getText()),
                Integer.parseInt(emptyToNA(propertyListNumber.getText())),
                Integer.parseInt(emptyToNA(parcelNumber.getText())), 'R', emptyToNA(propertyAddress.getText()),
                emptyToNA(propertyCity.getText()), emptyToNA(propertyState.getText()),
                emptyToNA(propertyZipCode.getText()), Double.parseDouble(emptyToNA(askingPrice.getText())),
                Double.parseDouble(emptyToNA(buildingValue.getText())),
                Double.parseDouble(emptyToNA(landValue.getText())));
    }

    // Replaces empty string with N/A
    public String emptyToNA(String s) {
        if (s.replaceAll("\\s+", "").equalsIgnoreCase("")) {
            return "0";
        }
        return s;
    }

    public void updateInfo(ResidentialProperty residential) {
        companyName.setText(residential.getCompanyName());
        companyNumber.setText(residential.getCompanyNumber() + "");
        agentName.setText(residential.getAgentFullName());
        agentNumber.setText(residential.getAgentNumber() + "");
        agentPhoneNumber.setText(residential.getAgentPhoneNumber());
        propertyListNumber.setText(residential.getPropertyNumber() + "");
        parcelNumber.setText(residential.getParcelNumber() + "");
        propertyType.setText("R - Residential");
        propertyAddress.setText(residential.getPropertyAddress());
        propertyCity.setText(residential.getPropertyCity());
        propertyState.setText(residential.getPropertyState());
        propertyZipCode.setText(residential.getPropertyZipCode());
        askingPrice.setText(residential.getAskingPrice() + "");
        buildingValue.setText(residential.getBuildingValue() + "");
        landValue.setText(residential.getLandValue() + "");
        localTax.setText(residential.getLocalTax() + "");
        countyTax.setText(residential.getCountyTax() + "");
        schoolTax.setText(residential.getSchoolTax() + "");
        totalTax.setText(residential.getTotalTax() + "");
    }

    public void updateInfo(CommercialProperty commercial) {
        companyName.setText(commercial.getCompanyName());
        companyNumber.setText(commercial.getCompanyNumber() + "");
        agentName.setText(commercial.getAgentFullName());
        agentNumber.setText(commercial.getAgentNumber() + "");
        agentPhoneNumber.setText(commercial.getAgentPhoneNumber());
        propertyListNumber.setText(commercial.getPropertyNumber() + "");
        parcelNumber.setText(commercial.getParcelNumber() + "");
        propertyType.setText("C - Commercial");
        propertyAddress.setText(commercial.getPropertyAddress());
        propertyCity.setText(commercial.getPropertyCity());
        propertyState.setText(commercial.getPropertyState());
        propertyZipCode.setText(commercial.getPropertyZipCode());
        askingPrice.setText(commercial.getAskingPrice() + "");
        buildingValue.setText(commercial.getBuildingValue() + "");
        landValue.setText(commercial.getLandValue() + "");
        localTax.setText(commercial.getLocalTax() + "");
        countyTax.setText(commercial.getCountyTax() + "");
        schoolTax.setText(commercial.getSchoolTax() + "");
        totalTax.setText(commercial.getTotalTax() + "");
    }

    public void clearTxtFields() {
        companyName.setText("");
        companyNumber.setText("");
        agentName.setText("");
        agentNumber.setText("");
        agentPhoneNumber.setText("");
        propertyListNumber.setText("");
        parcelNumber.setText("");
        propertyAddress.setText("");
        propertyCity.setText("");
        propertyState.setText("");
        propertyZipCode.setText("");
        askingPrice.setText("");
        buildingValue.setText("");
        landValue.setText("");
    }

    class ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String temp = e.getActionCommand();
            temp = temp.toLowerCase();

            switch (temp) {
            case "add":
                if (addingPropertyType == 1) { // 1: Commercial
                    parentFrame.addCommercialObject(createCommercialObject());
                } else { // 0 residential
                    parentFrame.addResidentialObject(createResidentialObject());
                }
                clearTxtFields();
                parentFrame.disableAllButtons(false);
                break;
            case "save":
                break;
            case "close":
                setVisible(false);
                parentFrame.selectedOption = GUISearchJFrame.SelectedOption.NONE; // None
                setVisible(false);
                break;
            case "cancel":
                setVisible(false);
                clearTxtFields();
                parentFrame.disableAllButtons(false);
                break;
            default:
                System.out.println(temp + " : Can't find such a button, did you touch something?");
                break;
            }

            parentFrame.pack();
        }
    }

}