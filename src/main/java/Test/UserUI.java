package Test;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

public class UserUI extends JFrame
{
    ArrayList<String> cities;
    User user;
    Login login;
    private JTextField IDFindText;
    private JRadioButton comprehensiveChoice;
    private ButtonGroup buttonGroup1;
    private JTextField capText;
    private JButton changeButton;
    private JLabel leveLabel;
    private JCheckBox optionCheck;
    private JComboBox<String> comboList;
    private JTextField levelText;
    private JTextField cityText;
    private JTextField expiryDateText;
    private JTextField dayText;
    private JButton delBut;
    private JButton findBut;
    private JTextField idText;
    private JTextField claimText;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel22;
    private JLabel jLabel23;
    private JLabel jLabel24;
    private JLabel jLabel25;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JMenu jMenu1;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JTabbedPane jTabbedPane1;
    private JTextField manuFacturingText;
    private JTextField modelFilterText;
    private JTextField modelText;
    private JTextField monthText;
    private JTextField nameText;
    private JLabel driverLabel;
    private JTextField driverText;
    private JTextField passwordText;
    private JRadioButton partyChoice;
    private JTextArea policyArea;
    private JTextField policyIDText;
    private JTable policyTable;
    private JTable policyTable1;
    private JPopupMenu policyTablePopUp;
    private JTextField policyUsernameText;
    private JTextField priceText;
    private JCheckBox sort;
    private JTextField streetField;
    private JTextField streetText;
    private JTextField suburbText;
    private JComboBox<String> typeText;
    private JButton updateButton;
    private JTextField usernameText;
    private JTextField yearText;

    public UserUI(final User user, final Login login, final ArrayList<String> cities) {
        this.user = user;
        this.login = login;
        this.cities = cities;
        this.initComponents();
    }
    private void initComponents() {
//GOOD_1_END
        this.buttonGroup1 = new ButtonGroup();
        this.policyTablePopUp = new JPopupMenu();
        this.jMenuItem1 = new JMenuItem();
        this.jMenuItem2 = new JMenuItem();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jLabel7 = new JLabel();
        this.jLabel8 = new JLabel();
        this.jLabel9 = new JLabel();
        this.idText = new JTextField();
        this.cityText = new JTextField();
        this.nameText = new JTextField();
        this.usernameText = new JTextField();
        this.streetField = new JTextField();
        this.passwordText = new JTextField();
        this.streetText = new JTextField();
        this.suburbText = new JTextField();
        this.optionCheck = new JCheckBox();
        this.comboList = new JComboBox<String>();
        this.changeButton = new JButton();
        this.jPanel2 = new JPanel();
        this.jLabel10 = new JLabel();
        this.jLabel11 = new JLabel();
        this.jLabel12 = new JLabel();
        this.jLabel13 = new JLabel();
        this.jLabel14 = new JLabel();
        this.jLabel15 = new JLabel();
        this.jLabel16 = new JLabel();
        this.jLabel17 = new JLabel();
        this.jLabel18 = new JLabel();
        this.jLabel19 = new JLabel();
        this.jLabel20 = new JLabel();
        this.jLabel21 = new JLabel();
        this.jLabel22 = new JLabel();
        this.leveLabel = new JLabel();
        this.driverLabel = new JLabel();
        this.policyUsernameText = new JTextField();
        this.policyIDText = new JTextField();
        this.levelText = new JTextField();
        this.manuFacturingText = new JTextField();
        this.priceText = new JTextField();
        this.claimText = new JTextField();
        this.modelText = new JTextField();
        this.typeText = new JComboBox<String>();
        this.monthText = new JTextField();
        this.yearText = new JTextField();
        this.driverText = new JTextField();
        this.dayText = new JTextField();
        this.capText = new JTextField();
        this.partyChoice = new JRadioButton();
        this.comprehensiveChoice = new JRadioButton();
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        this.jPanel5 = new JPanel();
        this.findBut = new JButton();
        this.jScrollPane2 = new JScrollPane();
        this.policyArea = new JTextArea();
        this.IDFindText = new JTextField();
        this.jLabel23 = new JLabel();
        this.jPanel3 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.policyTable = new JTable();
        this.updateButton = new JButton();
        this.delBut = new JButton();
        this.jPanel4 = new JPanel();
        this.jScrollPane3 = new JScrollPane();
        this.policyTable1 = new JTable();
        this.modelFilterText = new JTextField();
        this.jLabel24 = new JLabel();
        this.jLabel25 = new JLabel();
        this.expiryDateText = new JTextField();
        this.jButton3 = new JButton();
        this.sort = new JCheckBox();
        this.jMenuBar1 = new JMenuBar();
        this.jMenu1 = new JMenu();
        this.jMenuItem1.setText("Delete");
        this.jMenuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                UserUI.this.jMenuItem1ActionPerformed(evt);
            }
        });
        this.policyTablePopUp.add(this.jMenuItem1);
        this.jMenuItem2.setText("Update");
        this.jMenuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                UserUI.this.jMenuItem2ActionPerformed(evt);
            }
        });
        this.policyTablePopUp.add(this.jMenuItem2);
        this.setDefaultCloseOperation(3);
        this.jTabbedPane1.setForeground(new Color(255, 0, 102));
        this.jTabbedPane1.setFont(new Font("Tahoma", 1, 18));
        this.jTabbedPane1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(final ChangeEvent evt) {
                UserUI.this.jTabbedPane1StateChanged(evt);
            }
        });
        this.jTabbedPane1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(final FocusEvent evt) {
                UserUI.this.jTabbedPane1FocusGained(evt);
            }
        });
        this.jLabel1.setFont(new Font("Tahoma", 0, 18));
        this.jLabel1.setText("User ID");
        this.jLabel2.setFont(new Font("Tahoma", 0, 18));
        this.jLabel2.setText("Name");
        this.jLabel3.setFont(new Font("Tahoma", 0, 18));
        this.jLabel3.setText("Username");
        this.jLabel4.setFont(new Font("Tahoma", 0, 18));
        this.jLabel4.setText("Password");
        this.jLabel5.setFont(new Font("Tahoma", 0, 18));
        this.jLabel5.setText("Address Information");
        this.jLabel6.setFont(new Font("Tahoma", 0, 18));
        this.jLabel6.setText("Street Number");
        this.jLabel7.setFont(new Font("Tahoma", 0, 18));
        this.jLabel7.setText("Street");
        this.jLabel8.setFont(new Font("Tahoma", 0, 18));
        this.jLabel8.setText("Suburb");
        this.jLabel9.setFont(new Font("Tahoma", 0, 18));
        this.jLabel9.setText("City");
        this.idText.setEditable(false);
        this.idText.setFont(new Font("Tahoma", 0, 18));
        this.idText.setEnabled(false);
        this.cityText.setFont(new Font("Tahoma", 0, 18));
        this.cityText.setEnabled(false);
        this.nameText.setFont(new Font("Tahoma", 0, 18));
        this.usernameText.setEditable(false);
        this.usernameText.setFont(new Font("Tahoma", 0, 18));
        this.usernameText.setEnabled(false);
        this.streetField.setFont(new Font("Tahoma", 0, 18));
        this.passwordText.setFont(new Font("Tahoma", 0, 18));
        this.streetText.setFont(new Font("Tahoma", 0, 18));
        this.suburbText.setFont(new Font("Tahoma", 0, 18));
        this.optionCheck.setFont(new Font("Tahoma", 0, 18));
        this.optionCheck.setText("New City");
        this.optionCheck.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(final ItemEvent evt) {
                UserUI.this.cityChoiceItemStateChanged(evt);
            }
        });
//GOOD_1_END
        this.comboList.setFont(new Font("Tahoma", 0, 18));
        this.changeButton.setFont(new Font("Tahoma", 0, 18));
        this.changeButton.setForeground(new Color(255, 51, 51));
        this.changeButton.setText("Change");
        this.changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                UserUI.this.changeButtonActionPerformed(evt);
            }
        });
        
        final GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(21, 21, 21).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel5).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel9).addComponent(this.jLabel8).addComponent(this.jLabel7).addComponent(this.jLabel6))).addGap(25, 25, 25).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.streetText, -2, 112, -2).addComponent(this.streetField, -2, 112, -2).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.changeButton).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.comboList, 0, -1, 32767).addComponent(this.suburbText, -1, 112, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.cityText, -2, 112, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.optionCheck)))).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel4).addComponent(this.jLabel3).addComponent(this.jLabel2).addComponent(this.jLabel1, -2, 108, -2)).addGap(29, 29, 29).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.idText, -2, 112, -2).addComponent(this.nameText, -2, 112, -2).addComponent(this.usernameText, -2, 112, -2).addComponent(this.passwordText, -2, 112, -2)))).addContainerGap(1158, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(38, 38, 38).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1, -2, 29, -2).addComponent(this.idText)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.nameText)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.usernameText)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.passwordText)).addGap(18, 18, 18).addComponent(this.jLabel5).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel6).addComponent(this.streetField)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel7).addComponent(this.streetText)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel8).addComponent(this.suburbText)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel9).addComponent(this.cityText).addComponent(this.optionCheck).addComponent(this.comboList, -2, -1, -2)).addGap(33, 33, 33).addComponent(this.changeButton).addContainerGap(321, 32767)));
        this.jTabbedPane1.addTab("Edit Personal Data", this.jPanel1);
        this.jLabel10.setFont(new Font("Tahoma", 0, 18));
        this.jLabel10.setText("     Username");
        this.jLabel11.setFont(new Font("Tahoma", 0, 18));
        this.jLabel11.setText("    Policy ID");
        this.jLabel12.setFont(new Font("Tahoma", 0, 18));
        this.jLabel12.setText("Manufacturing Year");
        this.jLabel14.setFont(new Font("Tahoma", 0, 18));
        this.jLabel14.setText("Model");
        this.jLabel15.setFont(new Font("Tahoma", 0, 18));
        this.jLabel15.setText("Car Type");
        this.jLabel16.setFont(new Font("Tahoma", 0, 18));
        this.jLabel16.setText("Number Of Claims ");
        this.jLabel17.setFont(new Font("Tahoma", 0, 18));
        this.jLabel17.setText("Price");
        this.jLabel18.setFont(new Font("Tahoma", 0, 18));
        this.jLabel18.setText("Month");
        this.jLabel20.setFont(new Font("Tahoma", 0, 18));
        this.jLabel20.setText("Expiry Date");
        this.jLabel21.setFont(new Font("Tahoma", 0, 18));
        this.jLabel21.setText("Day");
        this.jLabel22.setFont(new Font("Tahoma", 0, 18));
        this.jLabel22.setText("Year");
        this.leveLabel.setFont(new Font("Tahoma", 0, 18));
        this.leveLabel.setHorizontalAlignment(4);
        this.leveLabel.setText("Comment");
        this.driverLabel.setFont(new Font("Tahoma", 0, 18));
        this.driverLabel.setText("             Driver Age");
        this.policyUsernameText.setFont(new Font("Tahoma", 0, 18));
        this.policyIDText.setFont(new Font("Tahoma", 0, 18));
        this.levelText.setFont(new Font("Tahoma", 0, 18));
        this.manuFacturingText.setFont(new Font("Tahoma", 0, 18));
        this.priceText.setFont(new Font("Tahoma", 0, 18));
        this.claimText.setFont(new Font("Tahoma", 0, 18));
        this.modelText.setFont(new Font("Tahoma", 0, 18));
        this.typeText.setFont(new Font("Tahoma", 0, 18));
        this.typeText.setModel(new DefaultComboBoxModel<String>(new String[] { "SUV", "SED", "LUX", "HATCH" }));
        this.monthText.setFont(new Font("Tahoma", 0, 18));
        this.yearText.setFont(new Font("Tahoma", 0, 18));
        this.driverText.setFont(new Font("Tahoma", 0, 18));
        this.dayText.setFont(new Font("Tahoma", 0, 18));
        this.capText.setFont(new Font("Tahoma", 0, 18));
        this.buttonGroup1.add(this.partyChoice);
        this.partyChoice.setFont(new Font("Tahoma", 0, 18));
        this.partyChoice.setSelected(true);
        this.partyChoice.setText("Third Party Policy");
        this.partyChoice.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(final ChangeEvent evt) {
                UserUI.this.personalChoiseStateChanged(evt);
            }
        });
        this.buttonGroup1.add(this.comprehensiveChoice);
        this.comprehensiveChoice.setFont(new Font("Tahoma", 0, 18));
        this.comprehensiveChoice.setText("Comprehensive Policy");
        this.jButton1.setFont(new Font("Tahoma", 1, 18));
        this.jButton1.setForeground(new Color(255, 51, 51));
        this.jButton1.setText("ADD");
        this.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                UserUI.this.jButton1ActionPerformed(evt);
            }
        });
        this.jButton2.setFont(new Font("Tahoma", 1, 18));
        this.jButton2.setForeground(new Color(255, 51, 51));
        this.jButton2.setText("CLEAR");
        this.jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                UserUI.this.jButton2ActionPerformed(evt);
            }
        });
        final GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(61, 61, 61).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel19).addComponent(this.jLabel16).addComponent(this.jLabel20)).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel11).addComponent(this.jLabel13).addComponent(this.jLabel10)).addGroup(jPanel2Layout.createSequentialGroup().addGap(48, 48, 48).addComponent(this.partyChoice).addGap(18, 18, 18).addComponent(this.comprehensiveChoice)))).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel15).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(144, 144, 144).addComponent(this.jLabel14)).addGroup(jPanel2Layout.createSequentialGroup().addGap(35, 35, 35).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel22).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.driverLabel).addGroup(jPanel2Layout.createSequentialGroup().addGap(109, 109, 109).addComponent(this.jLabel18)).addComponent(this.leveLabel, GroupLayout.Alignment.TRAILING, -2, 44, -2))))).addComponent(this.jLabel12).addComponent(this.jLabel17)).addGap(21, 21, 21)).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.jLabel21).addGap(20, 20, 20))).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.manuFacturingText, GroupLayout.Alignment.TRAILING, -1, 164, 32767).addComponent(this.priceText, GroupLayout.Alignment.TRAILING).addComponent(this.capText, GroupLayout.Alignment.TRAILING).addComponent(this.claimText, GroupLayout.Alignment.TRAILING).addComponent(this.dayText).addComponent(this.monthText).addComponent(this.policyIDText).addComponent(this.yearText).addComponent(this.levelText).addComponent(this.driverText).addComponent(this.typeText, 0, 164, 32767).addComponent(this.policyUsernameText).addComponent(this.modelText, GroupLayout.Alignment.TRAILING).addComponent(this.jButton1, -1, -1, 32767)))).addGap(106, 106, 106).addComponent(this.jButton2, -2, 101, -2).addContainerGap(1106, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(12, 12, 12).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.partyChoice).addComponent(this.comprehensiveChoice)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel11).addComponent(this.policyIDText, -2, -1, -2).addComponent(this.jButton2)).addGap(9, 9, 9).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.policyUsernameText, -2, -1, -2).addComponent(this.jLabel10)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel13).addGap(4, 4, 4).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.modelText, -2, -1, -2).addComponent(this.jLabel14)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel15, -2, 28, -2).addComponent(this.typeText, -2, 28, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel12).addComponent(this.manuFacturingText, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel17).addComponent(this.priceText, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel16).addComponent(this.claimText, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.capText, -2, -1, -2).addComponent(this.jLabel19)).addGap(18, 18, 18).addComponent(this.jLabel20).addGap(13, 13, 13).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel21).addComponent(this.dayText, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel18).addComponent(this.monthText, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel22).addComponent(this.yearText, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.levelText, -2, -1, -2).addComponent(this.leveLabel)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.driverLabel, -2, 33, -2).addComponent(this.driverText, -2, -1, -2)).addGap(26, 26, 26).addComponent(this.jButton1).addContainerGap(105, 32767)));
        this.jTabbedPane1.addTab("Add Policy", this.jPanel2);
        this.findBut.setFont(new Font("Tahoma", 0, 18));
        this.findBut.setForeground(new Color(255, 0, 51));
        this.findBut.setText("FIND");
        this.findBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                UserUI.this.findButActionPerformed(evt);
            }
        });
        this.policyArea.setBackground(new Color(153, 255, 51));
        this.policyArea.setColumns(20);
        this.policyArea.setFont(new Font("Arial Black", 0, 18));
        this.policyArea.setRows(5);
        this.jScrollPane2.setViewportView(this.policyArea);
        this.IDFindText.setFont(new Font("Tahoma", 0, 18));
        this.jLabel23.setFont(new Font("Tahoma", 0, 18));
        this.jLabel23.setText("Policy ID");
        final GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(46, 46, 46).addComponent(this.jLabel23).addGap(18, 18, 18).addComponent(this.IDFindText, -2, 138, -2).addGap(20, 20, 20).addComponent(this.findBut, -2, 85, -2).addContainerGap(1343, 32767)).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2).addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(30, 30, 30).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.findBut).addComponent(this.IDFindText, -2, -1, -2).addComponent(this.jLabel23, -2, 31, -2)).addGap(56, 56, 56).addComponent(this.jScrollPane2, -2, 518, -2).addContainerGap(161, 32767)));
        this.jTabbedPane1.addTab("Find a Policy", this.jPanel5);
        this.policyTable.setFont(new Font("Tahoma", 0, 18));
        this.policyTable.setModel(new DefaultTableModel(new Object[][] { new Object[0], new Object[0], new Object[0], new Object[0] }, new String[0]));
        this.policyTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(final MouseEvent evt) {
                UserUI.this.policyTableMousePressed(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.policyTable);
        this.updateButton.setFont(new Font("Tahoma", 1, 18));
        this.updateButton.setForeground(new Color(255, 0, 51));
        this.updateButton.setText("UPDATE");
        this.updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                UserUI.this.updateButActionPerformed(evt);
            }
        });
        this.delBut.setFont(new Font("Tahoma", 1, 18));
        this.delBut.setForeground(new Color(255, 0, 51));
        this.delBut.setText("DELETE");
        this.delBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                UserUI.this.delButActionPerformed(evt);
            }
        });
        final GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 1708, 32767).addGroup(jPanel3Layout.createSequentialGroup().addGap(268, 268, 268).addComponent(this.updateButton).addContainerGap(-1, 32767)).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(143, 143, 143).addComponent(this.delBut).addContainerGap(1464, 32767))));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 444, -2).addGap(37, 37, 37).addComponent(this.updateButton).addGap(0, 284, 32767)).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap(482, 32767).addComponent(this.delBut).addGap(283, 283, 283))));
        this.jTabbedPane1.addTab("Policies Information", this.jPanel3);
        this.policyTable1.setFont(new Font("Tahoma", 0, 18));
        this.policyTable1.setModel(new DefaultTableModel(new Object[][] { new Object[0], new Object[0], new Object[0], new Object[0] }, new String[0]));
        this.jScrollPane3.setViewportView(this.policyTable1);
        this.modelFilterText.setFont(new Font("Tahoma", 0, 18));
        this.modelFilterText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent evt) {
                UserUI.this.modelFilterTextKeyReleased(evt);
            }
        });
        this.jLabel24.setFont(new Font("Tahoma", 0, 18));
        this.jLabel24.setText("Car Model");
        this.jLabel25.setFont(new Font("Tahoma", 0, 18));
        this.jLabel25.setText("Expiry Date");
        this.expiryDateText.setFont(new Font("Tahoma", 0, 18));
        this.jButton3.setFont(new Font("Tahoma", 0, 18));
        this.jButton3.setText("Filter By Date");
        this.jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                UserUI.this.jButton3ActionPerformed(evt);
            }
        });
        this.sort.setFont(new Font("Tahoma", 0, 18));
        this.sort.setText("Sort by Username");
        this.sort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                UserUI.this.sortActionPerformed(evt);
            }
        });
        final GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane3, -1, 1708, 32767).addGroup(jPanel4Layout.createSequentialGroup().addGap(44, 44, 44).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jLabel25).addGap(29, 29, 29).addComponent(this.expiryDateText, -2, 136, -2)).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jLabel24).addGap(29, 29, 29).addComponent(this.modelFilterText, -2, 136, -2))).addGap(30, 30, 30).addComponent(this.jButton3).addGap(204, 204, 204).addComponent(this.sort).addContainerGap(-1, 32767)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jScrollPane3, -2, 512, -2).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(33, 33, 33).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel24).addComponent(this.modelFilterText, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel25).addComponent(this.expiryDateText, -2, -1, -2).addComponent(this.jButton3))).addGroup(jPanel4Layout.createSequentialGroup().addGap(73, 73, 73).addComponent(this.sort))).addContainerGap(174, 32767)));
        this.jTabbedPane1.addTab("Filter policies", this.jPanel4);
        this.jMenu1.setText("Logout");
        this.jMenu1.setFont(new Font("Segoe UI", 1, 18));
        this.jMenu1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(final MouseEvent evt) {
                UserUI.this.jMenu1MousePressed(evt);
            }
        });
        this.jMenuBar1.add(this.jMenu1);
        this.setJMenuBar(this.jMenuBar1);
        final GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1).addGap(97, 97, 97)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, 0).addComponent(this.jTabbedPane1, -2, 832, -2).addContainerGap(-1, 32767)));
        this.pack();
    }

    private void jTabbedPane1StateChanged(final ChangeEvent evt) {
        this.policyArea.setText("");
        this.idText.setText(this.user.getUserID() + "");
        this.nameText.setText(this.user.getName());
        this.usernameText.setText(this.user.getName());
        this.passwordText.setText(this.user.getPassword());
        this.streetField.setText(this.user.getAddress().getStreetNum() + "");
        this.streetText.setText(this.user.getAddress().getStreet());
        this.suburbText.setText(this.user.getAddress().getSuburb());
        this.comboList.setModel(new DefaultComboBoxModel<String>(this.cities.toArray(new String[0])));
        this.comboList.setSelectedItem(this.user.getCity());
        this.cityText.setText(this.user.getCity());
        if (this.partyChoice.isSelected()) {
            this.driverLabel.setVisible(false);
            this.driverText.setVisible(false);
            this.leveLabel.setText("City");
        }
        else {
            this.driverLabel.setVisible(true);
            this.driverText.setVisible(true);
            this.leveLabel.setText("Level");
        }
        this.policyTable.setComponentPopupMenu(this.policyTablePopUp);
        this.fillTable();
        this.fillTable1();
    }

    private void cityChoiceItemStateChanged(final ItemEvent evt) {
        if (this.optionCheck.isSelected()) {
            this.comboList.setEnabled(false);
            this.cityText.setEnabled(true);
        }
        else {
            this.comboList.setEnabled(true);
            this.cityText.setEnabled(false);
        }
    }

    private void changeButtonActionPerformed(final ActionEvent evt) {
        try {
            this.user.setName(this.nameText.getText());
            this.user.setPassword(this.passwordText.getText());
            this.user.getAddress().setStreetNum(Integer.parseInt(this.streetField.getText()));
            this.user.getAddress().setStreet(this.streetText.getText());
            this.user.getAddress().setSuburb(this.suburbText.getText());
            if (this.optionCheck.isSelected()) {
                this.user.getAddress().setCity(this.cityText.getText());
                this.cities.add(this.cityText.getText());
                this.comboList.setModel(new DefaultComboBoxModel<String>(this.cities.toArray(new String[0])));
                this.comboList.setSelectedItem(this.cityText.getText());
            }
            else {
                this.user.getAddress().setCity((String)this.comboList.getSelectedItem());
                this.cityText.setText(this.user.getCity());
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    private void personalChoiseStateChanged(final ChangeEvent evt) {
        if (this.partyChoice.isSelected()) {
            this.driverLabel.setVisible(false);
            this.driverText.setVisible(false);
            this.leveLabel.setText("Comment");
        }
        else {
            this.driverLabel.setVisible(true);
            this.driverText.setVisible(true);
            this.leveLabel.setText("Level");
        }
    }

    private void jButton1ActionPerformed(final ActionEvent evt) {
        try {
             int id = Integer.parseInt(this.policyIDText.getText());
             String policyHoldername = this.policyUsernameText.getText();
             String model = this.modelText.getText();
             carType type = carType.valueOf(this.typeText.getSelectedItem().toString());
             int numberOfClaims = Integer.parseInt(this.manuFacturingText.getText());
             double price = Double.parseDouble(this.priceText.getText());
             int day = Integer.parseInt(this.dayText.getText());
             int month = Integer.parseInt(this.monthText.getText());
             int year = Integer.parseInt(this.yearText.getText());
             MyDate date = new MyDate(year, month, day);
             Car car = new Car(model, type, numberOfClaims, price);
             InsurancePolicy policy;
            if (this.partyChoice.isSelected()) {
                String comment = this.levelText.getText();
                policy = new ThirdPartyPolicy(policyHoldername, id, car, numberOfClaims, date, comment);
            }
            else {
                int driverAge = Integer.parseInt(this.driverText.getText());
                int level = Integer.parseInt(this.levelText.getText());
                policy = new ComprehensivePolicy(policyHoldername, id, car, numberOfClaims, date, driverAge, level);
            }
            if (this.user.addPolicy(policy)) {
                JOptionPane.showMessageDialog(this, "Policy has been added");
                this.policyIDText.setText("");
                this.policyUsernameText.setText("");
                this.modelText.setText("");
                this.manuFacturingText.setText("");
                this.priceText.setText("");
                this.claimText.setText("");
                this.capText.setText("");
                this.dayText.setText("");
                this.monthText.setText("");
                this.yearText.setText("");
                this.levelText.setText("");
                this.driverText.setText("");
            }
            else {
                JOptionPane.showMessageDialog(this, "Policy can not be added");
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    private void jButton2ActionPerformed(final ActionEvent evt) {
        this.policyIDText.setText("");
        this.policyUsernameText.setText("");
        this.modelText.setText("");
        this.manuFacturingText.setText("");
        this.priceText.setText("");
        this.claimText.setText("");
        this.capText.setText("");
        this.dayText.setText("");
        this.monthText.setText("");
        this.yearText.setText("");
        this.levelText.setText("");
        this.driverText.setText("");
    }

    private void findButActionPerformed(final ActionEvent evt) {
        try {
            final InsurancePolicy policy = this.user.findPolicy(Integer.parseInt(this.IDFindText.getText()));
            if (policy != null) {
                this.policyArea.append(policy.toString() + "\n");
            }
            else {
                this.policyArea.append("Policy with ID= " + this.IDFindText.getText() + " has not been found \n");
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    private void delButActionPerformed(final ActionEvent evt) {
        final int ind = this.policyTable.getSelectedRow();
        if (ind >= 0) {
            this.user.getPolicies().remove(ind);
            this.fillTable();
        }
    }

    private void updateButActionPerformed(final ActionEvent evt) {
        final int check = this.policyTable.getSelectedRow();
        if (check >= 0) {
            final UpdateUI updateUI = new UpdateUI(this.user.getPolicies().get(check), this);
            updateUI.setVisible(true);
        }
    }

    private void jTabbedPane1FocusGained(final FocusEvent evt) {
        this.fillTable1();
    }

    private void jButton3ActionPerformed(final ActionEvent evt) {
        this.fillTable1();
    }

    private void sortActionPerformed(final ActionEvent evt) {
        this.fillTable1();
    }

    private void modelFilterTextKeyReleased(final KeyEvent evt) {
        this.fillTable1();
    }

    private void policyTableMousePressed(final MouseEvent evt) {
    }

    private void jMenuItem1ActionPerformed(final ActionEvent evt) {
        final int ind = this.policyTable.getSelectedRow();
        if (ind >= 0) {
            this.user.getPolicies().remove(ind);
            this.fillTable();
        }
    }

    private void jMenuItem2ActionPerformed(final ActionEvent evt) {
        final int ind = this.policyTable.getSelectedRow();
        if (ind >= 0) {
            final UpdateUI updateUI = new UpdateUI(this.user.getPolicies().get(ind), this);
            updateUI.setVisible(true);
        }
    }

    private void jMenu1MousePressed(final MouseEvent evt) {
        this.dispose();
        this.login.setVisible(true);
    }

    public void fillTable() {
        final String[] header = { "Policy ID", "Policy Holder Name", "Model", "Car Type", "Manufacturing Year", "Car Price", "NumberOfClaims", "AutoID(optional)", "Expiry Date", "Comment", "Level", "Driver Age", "Premium Payment" };
        final DefaultTableModel model = new DefaultTableModel(header, 0);
        this.policyTable.setModel(model);
        for (InsurancePolicy policy : this.user.getPolicies().values()) {
            final String[] row = { policy.getId() + "", policy.policyHolderName, policy.getCarModel(), policy.car.getType().toString(), policy.car.getManufacturingYear() + "", policy.car.getPrice() + "", policy.numberOfClaims + "", policy.autoID() + "", policy.getExpiryDate().toString(), null, null, null, null };
            if (policy instanceof ThirdPartyPolicy) {
                row[9] = ((ThirdPartyPolicy)policy).comment;
                row[11] = (row[10] = "NA");
            }
            else {
                row[9] = "NA";
                row[10] = ((ComprehensivePolicy)policy).driverAge + "";
                row[11] = ((ComprehensivePolicy)policy).level + "";
            }
            row[12] = String.format("$%.0f", policy.calcPremium(10));
            model.addRow(row);
        }
    }

    public void fillTable1() {
        ArrayList<InsurancePolicy> policies = new ArrayList<InsurancePolicy>();
        for (final InsurancePolicy policy : this.user.getPolicies().values()) {
            policies.add(policy);
        }
        try {
            if (!this.modelFilterText.getText().isEmpty()) {
                policies = InsurancePolicy.filterByCarModel(policies, this.modelFilterText.getText());
            }
            if (!this.expiryDateText.getText().isEmpty()) {
                final String[] fields = this.expiryDateText.getText().split("/");
                final int year = Integer.parseInt(fields[0]);
                final int month = Integer.parseInt(fields[1]);
                final int day = Integer.parseInt(fields[2]);
                final MyDate date = new MyDate(year, month, day);
                policies = InsurancePolicy.filterByExpiryDate(policies, date);
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        if (this.sort.isSelected()) {
            Collections.sort(policies);
        }
        final String[] header = { "Policy ID", "Policy Holder Name", "Model", "Car Type", "Manufacturing Year", "Car price", "Number Of Claims","AutoID(Optional)", "Expiry Date", "Comment", "Level", "Driver Age", "Premium Payment" };
        final DefaultTableModel model = new DefaultTableModel(header, 0);
        this.policyTable1.setModel(model);
        for (InsurancePolicy policy : policies) {
            final String[] row = { policy.getId() + "", policy.policyHolderName, policy.getCarModel(), policy.car.getType().toString(), policy.car.getManufacturingYear() + "", policy.car.getPrice() + "", policy.numberOfClaims + "", policy.count + "", policy.getExpiryDate().toString(), null, null, null, null };
            if (policy instanceof ThirdPartyPolicy) {
                row[9] = ((ThirdPartyPolicy)policy).comment;
                row[11] = (row[10] = "NA");
            }
            else {
                row[9] = "NA";
                row[10] = ((ComprehensivePolicy)policy).driverAge + "";
                row[11] = ((ComprehensivePolicy)policy).level + "";
            }
            row[12] = String.format("$%.2f", policy.calcPremium(10));
            model.addRow(row);
        }
    }
}

