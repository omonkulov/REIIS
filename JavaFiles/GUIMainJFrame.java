
/*
 * Author   Sardorbek Omonkulov
 * Date     05/03/2019 
 * Purpose  This is the main Jframe. This panel allows user to interact with the buttons and manage objects. 
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GUIMainJFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    // JList Sizes
    private static int JLIST_CELL_SIZE = 340;
    private static int RESULTSLIST_CELL_SIZE = 340;

    private JTextField searchTextField;

    // JPanels
    private JPanel searchPanel;
    private JPanel parentPanel;
    private JPanel resultsPanel;
    private JPanel listPanel;
    private JPanel buttonsPanel;

    // Buttons
    private JButton exitButton;
    private JButton addButton;
    private JButton editButton;
    private JButton infoButton;
    private JButton searchButton;
    public JButton deleteButton; // hide this button so it won't cause problems

    // Misc
    private GUIInfoJPanel infoPanel;
    private GetRandom getRandom;
    private JLabel selectedLable;
    private ButtonListener listener;
    private JListListener jListener;

    // List
    private ArrayList<ResidentialProperty> residPropList;
    private ArrayList<CommercialProperty> commerPropList;
    public DefaultListModel<String> model;
    public DefaultListModel<String> resultsModel;
    private JList<String> searchResultList;
    private JList<String> jList;

    // Enums to keep track of selected buttons and type of property
    public enum SelectedPropertyType {
        RESIDENTIAL, COMMERCIAL, NONE
    }

    public enum SelectedOption {
        ADD, EDIT, INFO, NONE
    }

    public SelectedPropertyType selectedPropertyType;
    public SelectedOption selectedOption;

    public GUIMainJFrame() {
        this.residPropList = new ArrayList<ResidentialProperty>();
        this.commerPropList = new ArrayList<CommercialProperty>();
        model = new DefaultListModel<String>(); // This allows to dynamically change items in the JList
        resultsModel = new DefaultListModel<String>(); // This allows to dynamically change items in the JList
        listener = new ButtonListener();
        getRandom = new GetRandom();

        /* Frame prefrences */
        setTitle("Search Avaible Info");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Seach panel */
        searchPanel = new JPanel();
        searchPanel.setBorder(BorderFactory.createTitledBorder("Search by Address"));
        searchTextField = new JTextField();
        searchTextField.setPreferredSize(new Dimension(200, 28));
        searchButton = new JButton("Search");
        searchPanel.add(searchTextField);
        searchPanel.add(searchButton);

        /* Results */
        searchResultList = new JList<String>(resultsModel);
        searchResultList.setFixedCellWidth(RESULTSLIST_CELL_SIZE);
        // searchResultList.setEnabled(false);
        searchResultList.setBackground(this.getBackground());
        searchResultList.setForeground(Color.BLACK);
        resultsPanel = new JPanel();
        resultsPanel.setBorder(BorderFactory.createTitledBorder("Results"));
        resultsPanel.add(searchResultList);

        /* List panel */
        updateJlist(residPropList, commerPropList);
        jList = new JList<String>(model);
        jList.setSize(500, 600);
        jList.setVisibleRowCount(18);
        jList.setFixedCellWidth(JLIST_CELL_SIZE);
        jListener = new JListListener();
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
        deleteButton = new JButton("Delete");

        buttonsPanel.add(exitButton);
        buttonsPanel.add(deleteButton);
        buttonsPanel.add(addButton);
        buttonsPanel.add(editButton);
        buttonsPanel.add(infoButton);

        /* Adding listener to Buttons */
        exitButton.addActionListener(listener);
        editButton.addActionListener(listener);
        infoButton.addActionListener(listener);
        addButton.addActionListener(listener);
        searchButton.addActionListener(listener);
        deleteButton.addActionListener(listener);

        /* Adding components */
        parentPanel = new JPanel(new GridBagLayout());
        parentPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        selectedLable = new JLabel("Selected: XXXXXX");
        addComponent(parentPanel, selectedLable, 1, 5, 2, 1, GridBagConstraints.HORIZONTAL, 0, 0);
        addComponent(parentPanel, searchPanel, 2, 2, 2, 1, GridBagConstraints.HORIZONTAL, 0, 0);
        addComponent(parentPanel, resultsPanel, 2, 3, 2, 1, GridBagConstraints.BOTH, 0, 0);
        addComponent(parentPanel, listPanel, 4, 1, 2, 4, GridBagConstraints.BOTH, 0, 0);
        addComponent(parentPanel, buttonsPanel, 4, 5, 4, 1, GridBagConstraints.HORIZONTAL, 0, 0);

        /* Adding Parent panel to the Jframe */
        add(parentPanel);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JSeparator(JSeparator.HORIZONTAL));
        infoPanel = new GUIInfoJPanel(this);
        add(infoPanel);

        /* Setting up everything */
        infoPanel.setVisible(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        /* Etc */
        selectedPropertyType = SelectedPropertyType.NONE;
        selectedOption = SelectedOption.NONE;
    }

    /**
     * This helps to add component in GridBagLayout.
     * 
     * @param panel
     * @param comp
     * @param x
     * @param y
     * @param gWidth
     * @param gHeight
     * @param fill
     * @param weightx
     * @param weighty
     */
    private void addComponent(JPanel panel, JComponent comp, int x, int y, int gWidth, int gHeight, int fill,
            double weightx, double weighty) {
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

    /**
     * This method takes both properties and adds them into the DefaultListModel,
     * which is then used in JList to list items stored in DefaultListModel.
     * 
     * @param resPropList
     * @param comPropList
     */
    public void updateJlist(ArrayList<ResidentialProperty> resPropList, ArrayList<CommercialProperty> comPropList) {
        String indent = " : ";
        model.clear();
        for (int i = 0; i < resPropList.size(); i++) {
            indent = (i > 9) ? ": " : "  : "; // simply to allign numbers, 1/2
            model.addElement(i + indent + " " + resPropList.get(i).getPropertyAddress());
        }
        for (int i = 0; i < comPropList.size(); i++) {
            indent = ((i + resPropList.size()) > 9) ? ": " : "  : ";
            model.addElement(((i + resPropList.size())) + indent + " " + comPropList.get(i).getPropertyAddress());
        }
        pack();
    }

    public void updateResultList(ArrayList<String> s) {
        resultsModel.clear();
        for (String a : s) {
            resultsModel.addElement(a);
        }
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
                deleteButton.setEnabled(false);
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
                dispose();
                System.exit(0);
                break;
            case "edit":
                disableAllButtons(true);
                selectedOption = SelectedOption.EDIT;
                if (selectedPropertyType == SelectedPropertyType.RESIDENTIAL) {
                    infoPanel.edit(residPropList.get(jList.getSelectedIndex()));
                } else if (selectedPropertyType == SelectedPropertyType.COMMERCIAL) {
                    infoPanel.edit(commerPropList.get(jList.getSelectedIndex() - residPropList.size()));
                } else {
                    selectedLable.setText("Please select one of \nthe items in objects");
                    selectedOption = SelectedOption.NONE;
                }
                pack();
                break;
            case "search":
                updateResultList(search(searchTextField.getText()));
                pack();
                break;
            case "delete":
                infoPanel.setVisible(false);
                if (selectedPropertyType == SelectedPropertyType.NONE)
                    selectedLable.setText("Please select one of \nthe items in objects");
                else if (selectedPropertyType == SelectedPropertyType.RESIDENTIAL) {
                    residPropList.remove(jList.getSelectedIndex());
                } else if (selectedPropertyType == SelectedPropertyType.COMMERCIAL) {
                    commerPropList.remove(jList.getSelectedIndex() - residPropList.size());
                }
                updateJlist(residPropList, commerPropList);
                selectedPropertyType = SelectedPropertyType.NONE;
                break;
            default:
                System.out.println("Error in GUIMainJFrame: classButtonListener");
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
            if (selectedOption == SelectedOption.INFO) {
                deleteButton.setEnabled(false);
            }
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
            selectedLable.setText("Selected: " + index + "      Type: " + selectedPropertyType.toString());
            pack();
        }

    }

    public void addCommercialObject(CommercialProperty c) {
        commerPropList.add(c);
        updateJlist(residPropList, commerPropList);
        int lastIndex = residPropList.size() + commerPropList.size() - 1;
        jList.setSelectedIndex(lastIndex); // adding to last one, so select the
        jList.ensureIndexIsVisible(lastIndex);
        jListener.valueChanged(null);
        infoButton.doClick();
    }

    public void addResidentialObject(ResidentialProperty r) {
        residPropList.add(r);
        updateJlist(residPropList, commerPropList);
        int lastIndex = residPropList.size() - 1;
        jList.setSelectedIndex(lastIndex);
        jList.ensureIndexIsVisible(lastIndex);
        jListener.valueChanged(null);
        infoButton.doClick();
    }

    public void editCommericalObject(CommercialProperty c) {
        int selectedIndex = jList.getSelectedIndex();
        commerPropList.set(selectedIndex - residPropList.size(), c);
        updateJlist(residPropList, commerPropList);
        jList.setSelectedIndex(selectedIndex);
        jListener.valueChanged(null);
        infoButton.doClick();
        pack();
    }

    public void editResidentialObject(ResidentialProperty r) {
        int selectedIndex = jList.getSelectedIndex();
        residPropList.set(selectedIndex, r);
        updateJlist(residPropList, commerPropList);
        jList.setSelectedIndex(selectedIndex);
        jListener.valueChanged(null);
        infoButton.doClick();
        pack();
    }

    public void disableAllButtons(boolean b) {
        addButton.setEnabled(!b);
        exitButton.setEnabled(!b);
        infoButton.setEnabled(!b);
        editButton.setEnabled(!b);
        deleteButton.setEnabled(!b);
    }

    public void updateList() {
        jList.setModel(model);

    }

    public ArrayList<String> search(String search) {
        search = formatString(search);
        String value;
        String original;
        ArrayList<String> results = new ArrayList<String>();
        if (search.isBlank() || search.isEmpty()) {
            results.add("Nothing Found!");
            return results;
        }
        for (int i = 0; i < residPropList.size(); i++) {
            value = residPropList.get(i).getPropertyAddress();
            original = value;
            value = formatString(value);
            if (value.contains(search)) {
                results.add("#" + i + ": " + original);
            }
        }
        for (int i = 0; i < commerPropList.size(); i++) {
            value = commerPropList.get(i).getPropertyAddress();
            original = value;
            value = formatString(value);
            if (value.contains(search)) {
                results.add("#" + (i + residPropList.size()) + ": " + original);
            }
        }
        if (results.isEmpty()) {
            results.add("Nothing Found!");
            return results;
        }
        return results;
    }

    public String formatString(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("\\s", "");
        return s;
    }

    public void generateResidentialProperty(int amount) {
        for (int i = 0; i <= amount; i++) {
            residPropList.add(new ResidentialProperty(getRandom.companyName(), getRandom.randInt(0, 1000),
                    getRandom.name(), getRandom.randInt(0, 1000), getRandom.phoneNumber(), getRandom.randInt(0, 1000),
                    getRandom.randInt(0, 1000), 'C', getRandom.adress(), "Pittsbrugh", "PA", "15420",
                    getRandom.randDouble(50000, 70000), getRandom.randDouble(60000, 180000),
                    getRandom.randDouble(60000, 42)));
        }
        updateJlist(residPropList, commerPropList);
    }

    public void generateCommercialProperty(int amount) {
        for (int i = 0; i < amount; i++) {
            commerPropList.add(new CommercialProperty(getRandom.companyName(), getRandom.randInt(0, 1000),
                    getRandom.name(), getRandom.randInt(0, 1000), getRandom.phoneNumber(), getRandom.randInt(0, 1000),
                    getRandom.randInt(0, 1000), 'C', getRandom.adress(), "Pittsbrugh", "PA", "15420",
                    getRandom.randDouble(50000, 70000), getRandom.randDouble(60000, 180000),
                    getRandom.randDouble(60000, 42)));
        }
        updateJlist(residPropList, commerPropList);

    }

}