import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * GUISearchJFrame
 */
public class GUISearchJFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField searchTextField;
    private JButton searchButton;

    private JPanel searchPanel;
    private JPanel parentPanel;
    private JPanel resultsPanel;
    private JPanel listPanel;
    private JPanel buttonsPanel;

    private JList<String> searchResultList;
    private JList<String> jList;
    private String[] tempArray;

    private JButton exitButton;
    private JButton addButton;
    private JButton editButton;
    private JButton infoButton;
    private JLabel selectedLable;

    private ButtonListener listener;

    private GUIInfoJFrame infoPanel;

    private ResidentialProperty residProperty;
    private CommercialProperty commerProperty;

    private ArrayList<ResidentialProperty> residPropList;
    private ArrayList<CommercialProperty> commerPropList;

    public DefaultListModel<String> model;

    public enum SelectedPropertyType {
        RESIDENTIAL, COMMERCIAL, NONE
    }

    public enum SelectedOption {
        ADD, EDIT, INFO, NONE
    }

    public SelectedPropertyType selectedPropertyType;
    public SelectedOption selectedOption;

    public GUISearchJFrame(ArrayList<ResidentialProperty> residPropList, ArrayList<CommercialProperty> commerPropList) {
        this.residPropList = residPropList;
        this.commerPropList = commerPropList;
        model = new DefaultListModel<String>();
        residProperty = residPropList.get(0);// used for temp when passing to GUIINFO
        commerProperty = commerPropList.get(0);// used for temp when passing to GUIINFO
        listener = new ButtonListener();

        /* Frame prefrences */
        setTitle("Search Avaible Info");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Seach panel */
        searchPanel = new JPanel();
        searchPanel.setBorder(BorderFactory.createTitledBorder("Search"));
        searchTextField = new JTextField();
        searchTextField.setPreferredSize(new Dimension(200, 28));

        searchButton = new JButton("Search");
        searchPanel.add(searchTextField);
        searchPanel.add(searchButton);

        /* Results */
        searchResultList = new JList<String>();
        resultsPanel = new JPanel();
        resultsPanel.setBorder(BorderFactory.createTitledBorder("Results"));
        resultsPanel.add(searchResultList);

        /* List panel */
        updateJlist(residPropList, commerPropList);
        jList = new JList<String>(model);
        jList.setVisibleRowCount(18);

        JListListener jListener = new JListListener();
        jList.addListSelectionListener(jListener);
        JScrollPane sp = new JScrollPane(jList);
        listPanel = new JPanel();
        listPanel.add(sp);
        listPanel.setBorder(BorderFactory.createTitledBorder("Objects"));

        /* Buttons panel */
        buttonsPanel = new JPanel(new GridBagLayout());
        buttonsPanel.setBorder(BorderFactory.createTitledBorder("Options"));
        exitButton = new JButton("Exit");
        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        infoButton = new JButton("Info");

        buttonsPanel.add(exitButton);
        buttonsPanel.add(addButton);
        buttonsPanel.add(editButton);
        buttonsPanel.add(infoButton);

        /* Adding listener to Buttons */
        exitButton.addActionListener(listener);
        editButton.addActionListener(listener);
        infoButton.addActionListener(listener);
        addButton.addActionListener(listener);
        searchButton.addActionListener(listener);

        /* Adding components */
        parentPanel = new JPanel(new GridBagLayout());
        parentPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        selectedLable = new JLabel("Selected: XXXXXX");
        addComp(parentPanel, selectedLable, 1, 5, 2, 1, GridBagConstraints.HORIZONTAL, 0, 0);
        addComp(parentPanel, searchPanel, 2, 2, 2, 1, GridBagConstraints.HORIZONTAL, 0, 0);
        addComp(parentPanel, resultsPanel, 2, 3, 2, 1, GridBagConstraints.BOTH, 0, 0);
        addComp(parentPanel, listPanel, 4, 1, 2, 4, GridBagConstraints.BOTH, 0, 0);
        addComp(parentPanel, buttonsPanel, 4, 5, 4, 1, GridBagConstraints.HORIZONTAL, 0, 0);

        add(parentPanel);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JSeparator(JSeparator.HORIZONTAL));
        infoPanel = new GUIInfoJFrame(this);
        add(infoPanel);

        infoPanel.setVisible(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        /* Etc */
        selectedPropertyType = SelectedPropertyType.NONE;
        selectedOption = SelectedOption.NONE;
    }

    private void addComp(JPanel panel, JComponent comp, int x, int y, int gWidth, int gHeight, int fill, double weightx,
            double weighty) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = gWidth;
        gbc.gridheight = gHeight;
        gbc.fill = fill;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        panel.add(comp, gbc);
    }

    public void updateJlist(ArrayList<ResidentialProperty> resPropList, ArrayList<CommercialProperty> comPropList) {
        String temp = " : ";
        model.clear();
        for (int i = 0; i < resPropList.size(); i++) {
            temp = (i > 9) ? ": " : " : "; // simply to allign numbers, 1/2
            model.addElement(i + temp + "Company: " + resPropList.get(i).getAgentFullName() + " Agent:"
                    + resPropList.get(i).getAgentFullName());
        }
        for (int i = 0; i < comPropList.size(); i++) {
            model.addElement((i + resPropList.size()) + temp + "Company: " + resPropList.get(i).getCompanyName()
                    + " Agent:" + resPropList.get(i).getAgentFullName());
        }
        // try {

        System.out.println(model);
        // } catch (NullPointerException e) {
        // // TODO: handle exception
        // }
    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String temp = e.getActionCommand();
            temp = temp.toLowerCase();

            switch (temp) {
            case "add":
                disableAllButtons(true);
                selectedOption = SelectedOption.ADD;
                JDialog.setDefaultLookAndFeelDecorated(true);
                String[] jOptions = { "Commercial", "Residential", "Cancel" };
                int response = JOptionPane.showOptionDialog(null, "Please choose the type of property you want to add:",
                        "Property Options", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, jOptions,
                        null);

                switch (response) {
                case 0: // Commercial: 0
                    infoPanel.add(0);
                    break;
                case 1: // Residential: 1
                    infoPanel.add(1);
                    break;
                default:
                    disableAllButtons(false);
                    break;
                }
                break;
            case "info":
                selectedOption = SelectedOption.INFO;
                if (selectedPropertyType == SelectedPropertyType.RESIDENTIAL) {
                    infoPanel.info(residPropList.get(jList.getSelectedIndex()));
                } else if (selectedPropertyType == SelectedPropertyType.COMMERCIAL) {
                    infoPanel.info(commerPropList.get(jList.getSelectedIndex() - residPropList.size()));
                } else {
                    selectedLable.setText("Please select one of \nthe items in objects");
                    selectedOption = SelectedOption.NONE;
                }
                pack();
                break;
            case "exit":
                selectedOption = SelectedOption.NONE;
                break;
            case "edit":
                selectedOption = SelectedOption.EDIT;
                break;
            case "search":
                break;
            default:
                System.out.println("Error in GUISearchJFrame: classButtonListener");
                break;
            }
            pack();
        }
    }

    // This allows the JListner to swipe through objects while in Info mode
    class JListListener implements ListSelectionListener {

        boolean once = true;

        @Override
        public void valueChanged(ListSelectionEvent arg0) {
            // Jlist listiner detects two clicks at a time: mouse_down & mouse_up. This
            // statement allows one call at a time.
            once = (once) ? false : true;
            disableAllButtons(false);
            int index = jList.getSelectedIndex();

            if (index < residPropList.size() && once) {
                selectedPropertyType = SelectedPropertyType.RESIDENTIAL;
            } else if (index < residPropList.size() + commerPropList.size() && once) {
                selectedPropertyType = SelectedPropertyType.COMMERCIAL;
            }

            if (selectedOption == SelectedOption.INFO && once) {
                if (selectedPropertyType == SelectedPropertyType.RESIDENTIAL) {
                    infoPanel.info(residPropList.get(index));
                } else if (selectedPropertyType == SelectedPropertyType.COMMERCIAL) {
                    infoPanel.info(commerPropList.get(index - residPropList.size()));
                }
                infoPanel.setRandomImage();
                infoPanel.setVisible(true);

            } else if (once) {
                infoPanel.setVisible(false);
            }
            pack();
            selectedLable
                    .setText(": " + index + " " + selectedPropertyType.toString() + " \n " + selectedOption.toString());
        }

    }

    public void addCommercialObject(CommercialProperty c) {
        commerPropList.add(c);
        System.out.println(c.getAgentFullName());
        updateJlist(residPropList, commerPropList);
        jList.updateUI();

    }

    public void addResidentialObject(ResidentialProperty r) {
        residPropList.add(r);
        System.out.println(r.getAgentFullName());
        updateJlist(residPropList, commerPropList);
    }

    public void disableAllButtons(boolean b) {
        addButton.setEnabled(!b);
        exitButton.setEnabled(!b);
        infoButton.setEnabled(!b);
        editButton.setEnabled(!b);
    }

    public void updateList() {
        jList.setModel(model);
        ;
    }

}