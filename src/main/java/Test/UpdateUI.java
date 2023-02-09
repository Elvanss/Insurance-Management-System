package Test;


import javax.swing.*;

public class UpdateUI extends JFrame
{
    InsurancePolicy policy;
    UserUI userUI;
    private JRadioButton ComprehensiveChoice;
    private JTextField capText;
    private JLabel leveLabel;
    private JTextField levelText;
    private JTextField dayText;
    private JTextField claimText;
    private JButton jButton1;
    private JButton jButton2;
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
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel22;
    private JTextField manufacturingText;
    private JTextField modelText;
    private JTextField monthText;
    private JLabel driverAgeLabel;
    private JTextField driverAgeText;
    private JRadioButton ThirdChoise;
    private JTextField policyIDText;
    private JTextField policyUsernameText;
    private JTextField priceText;
    private JComboBox<String> typeText;
    private JTextField yearText;

    public UpdateUI(final InsurancePolicy policy, UserUI UI) {
        this.policy = policy;
        this.userUI = UI;
      //  this.initComponents();
        this.policyIDText.setText(policy.getId() + "");
        this.policyUsernameText.setText(policy.policyHolderName);
        this.modelText.setText(policy.getCarModel());
        this.manufacturingText.setText(policy.car.getManufacturingYear() + "");
        this.priceText.setText(policy.getCar() + "");
        this.claimText.setText(policy.numberOfClaims + "");
        this.typeText.setSelectedItem(policy.car.getType().toString());
        this.dayText.setText(policy.getExpiryDate().getDay() + "");
        this.monthText.setText(policy.getExpiryDate().getMonth() + "");
        this.yearText.setText(policy.getExpiryDate().getYear() + "");
        if (policy instanceof ThirdPartyPolicy) {
            this.ThirdChoise.setSelected(true);
            this.ComprehensiveChoice.setSelected(false);
            this.leveLabel.setText("City");
            this.levelText.setText(((ThirdPartyPolicy)policy).comment);
            this.driverAgeText.setText("");
            this.driverAgeLabel.setVisible(false);
            this.driverAgeText.setVisible(false);
        }
        else {
            this.ThirdChoise.setSelected(false);
            this.ComprehensiveChoice.setSelected(true);
            this.leveLabel.setText("ABN");
            this.levelText.setText(((ComprehensivePolicy)policy).level + "");
            this.driverAgeText.setText(((ComprehensivePolicy)policy).driverAge + "");
            this.driverAgeLabel.setVisible(true);
            this.driverAgeText.setVisible(true);
        }
    }
//
//    private void initComponents() {
//        this.jLabel10 = new JLabel();
//        this.jLabel11 = new JLabel();
//        this.jLabel12 = new JLabel();
//        this.jLabel13 = new JLabel();
//        this.jLabel14 = new JLabel();
//        this.jLabel15 = new JLabel();
//        this.jLabel16 = new JLabel();
//        this.jLabel17 = new JLabel();
//        this.jLabel18 = new JLabel();
//        this.jLabel19 = new JLabel();
//        this.jLabel20 = new JLabel();
//        this.jLabel21 = new JLabel();
//        this.jLabel22 = new JLabel();
//        this.leveLabel = new JLabel();
//        this.driverAgeLabel = new JLabel();
//        this.policyUsernameText = new JTextField();
//        this.policyIDText = new JTextField();
//        this.levelText = new JTextField();
//        this.manufacturingText = new JTextField();
//        this.priceText = new JTextField();
//        this.claimText = new JTextField();
//        this.modelText = new JTextField();
//        this.typeText = new JComboBox<String>();
//        this.monthText = new JTextField();
//        this.yearText = new JTextField();
//        this.driverAgeText = new JTextField();
//        this.dayText = new JTextField();
//        this.capText = new JTextField();
//        this.ThirdChoise = new JRadioButton();
//        this.ComprehensiveChoice = new JRadioButton();
//        this.jButton1 = new JButton();
//        this.jButton2 = new JButton();
//        this.setDefaultCloseOperation(3);
//        this.jLabel10.setFont(new Font("Tahoma", 0, 18));
//        this.jLabel10.setText("Username");
//        this.jLabel11.setFont(new Font("Tahoma", 0, 18));
//        this.jLabel11.setText("Policy ID");
//        this.jLabel12.setFont(new Font("Tahoma", 0, 18));
//        this.jLabel12.setText("Manufacturing Year");
//        this.jLabel14.setFont(new Font("Tahoma", 0, 18));
//        this.jLabel14.setText("Model");
//        this.jLabel15.setFont(new Font("Tahoma", 0, 18));
//        this.jLabel15.setText("Car Type");
//        this.jLabel16.setFont(new Font("Tahoma", 0, 18));
//        this.jLabel16.setText("Number Of Claims");
//        this.jLabel17.setFont(new Font("Tahoma", 0, 18));
//        this.jLabel17.setText("Price");
//        this.jLabel18.setFont(new Font("Tahoma", 0, 18));
//        this.jLabel18.setText("Month");
//        this.jLabel20.setFont(new Font("Tahoma", 0, 18));
//        this.jLabel20.setText("Expiry Date");
//        this.jLabel21.setFont(new Font("Tahoma", 0, 18));
//        this.jLabel21.setText("Day");
//        this.jLabel22.setFont(new Font("Tahoma", 0, 18));
//        this.jLabel22.setText("Year");
//        this.leveLabel.setFont(new Font("Tahoma", 0, 18));
//        this.leveLabel.setHorizontalAlignment(4);
//        this.leveLabel.setText("Comment");
//        this.driverAgeLabel.setFont(new Font("Tahoma", 0, 18));
//        this.driverAgeLabel.setText("Driver Age");
//        this.policyUsernameText.setFont(new Font("Tahoma", 0, 18));
//        this.policyIDText.setFont(new Font("Tahoma", 0, 18));
//        this.policyIDText.setEnabled(false);
//        this.levelText.setFont(new Font("Tahoma", 0, 18));
//        this.levelText.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(final ActionEvent evt) {
//                UpdateUI.this.cityOrABNTextActionPerformed(evt);
//            }
//        });
//        this.manufacturingText.setFont(new Font("Tahoma", 0, 18));
//        this.priceText.setFont(new Font("Tahoma", 0, 18));
//        this.claimText.setFont(new Font("Tahoma", 0, 18));
//        this.modelText.setFont(new Font("Tahoma", 0, 18));
//        this.typeText.setFont(new Font("Tahoma", 0, 18));
//        this.typeText.setModel(new DefaultComboBoxModel<String>(new String[] { "IOS", "Android", "Windows" }));
//        this.monthText.setFont(new Font("Tahoma", 0, 18));
//        this.yearText.setFont(new Font("Tahoma", 0, 18));
//        this.driverAgeText.setFont(new Font("Tahoma", 0, 18));
//        this.dayText.setFont(new Font("Tahoma", 0, 18));
//        this.capText.setFont(new Font("Tahoma", 0, 18));
//        this.ThirdChoise.setFont(new Font("Tahoma", 0, 18));
//        this.ThirdChoise.setSelected(true);
//        this.ThirdChoise.setText("Third Party Policy");
//        this.ThirdChoise.setEnabled(false);
//        this.ThirdChoise.addChangeListener(new ChangeListener() {
//            @Override
//            public void stateChanged(final ChangeEvent evt) {
//                UpdateUI.this.personalChoiseStateChanged(evt);
//            }
//        });
//        this.ComprehensiveChoice.setFont(new Font("Tahoma", 0, 18));
//        this.ComprehensiveChoice.setText("Comprehensive Policy");
//        this.ComprehensiveChoice.setEnabled(false);
//        this.jButton1.setFont(new Font("Tahoma", 1, 18));
//        this.jButton1.setForeground(new Color(255, 51, 51));
//        this.jButton1.setText("UPDATE");
//        this.jButton1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(final ActionEvent evt) {
//                UpdateUI.this.jButton1ActionPerformed(evt);
//            }
//        });
//        this.jButton2.setFont(new Font("Tahoma", 1, 18));
//        this.jButton2.setForeground(new Color(255, 51, 51));
//        this.jButton2.setText("CLEAR");
//        this.jButton2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(final ActionEvent evt) {
//                UpdateUI.this.jButton2ActionPerformed(evt);
//            }
//        });
//        final GroupLayout layout = new GroupLayout(this.getContentPane());
//        this.getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(61, 61, 61).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel19).addComponent(this.jLabel16).addComponent(this.jLabel20)).addGroup(layout.createSequentialGroup().addGap(48, 48, 48).addComponent(this.ThirdChoise).addGap(18, 18, 18).addComponent(this.ComprehensiveChoice))).addGap(265, 265, 265)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel11).addComponent(this.jLabel13).addComponent(this.jLabel10)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(310, 310, 310).addComponent(this.jButton2, -1, -1, 32767)).addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton1, -2, 118, -2))).addGap(98, 98, 98)))).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel15).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(144, 144, 144).addComponent(this.jLabel14)).addGroup(layout.createSequentialGroup().addGap(35, 35, 35).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel22).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.driverAgeLabel).addGroup(layout.createSequentialGroup().addGap(109, 109, 109).addComponent(this.jLabel18)).addComponent(this.leveLabel, GroupLayout.Alignment.TRAILING, -2, 44, -2))))).addComponent(this.jLabel12).addComponent(this.jLabel17)).addGap(21, 21, 21)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel21).addGap(20, 20, 20))).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.manufacturingText, GroupLayout.Alignment.TRAILING, -1, 164, 32767).addComponent(this.priceText, GroupLayout.Alignment.TRAILING).addComponent(this.capText, GroupLayout.Alignment.TRAILING).addComponent(this.claimText, GroupLayout.Alignment.TRAILING).addComponent(this.dayText).addComponent(this.monthText).addComponent(this.policyIDText).addComponent(this.yearText).addComponent(this.levelText).addComponent(this.driverAgeText).addComponent(this.typeText, 0, 164, 32767).addComponent(this.policyUsernameText).addComponent(this.modelText, GroupLayout.Alignment.TRAILING)).addGap(98, 314, 32767)));
//        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.ComprehensiveChoice).addComponent(this.ThirdChoise)).addGap(21, 21, 21).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel11).addComponent(this.policyIDText, -2, -1, -2).addComponent(this.jButton2)).addGap(9, 9, 9).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.policyUsernameText, -2, -1, -2).addComponent(this.jLabel10)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel13)).addComponent(this.jButton1)).addGap(4, 4, 4).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.modelText, -2, -1, -2).addComponent(this.jLabel14)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel15, -2, 28, -2).addComponent(this.typeText, -2, 28, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel12).addComponent(this.manufacturingText, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel17).addComponent(this.priceText, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel16).addComponent(this.claimText, -2, -1, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.capText, -2, -1, -2).addComponent(this.jLabel19)).addGap(18, 18, 18).addComponent(this.jLabel20).addGap(13, 13, 13).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel21).addComponent(this.dayText, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel18).addComponent(this.monthText, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel22).addComponent(this.yearText, -2, -1, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.levelText, -2, -1, -2).addComponent(this.leveLabel)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.driverAgeLabel, -2, 33, -2).addComponent(this.driverAgeText, -2, -1, -2)).addContainerGap(172, 32767)));
//        this.pack();
//    }
//
//    private void cityOrABNTextActionPerformed(final ActionEvent evt) {
//    }
//
//    private void personalChoiseStateChanged(final ChangeEvent evt) {
//        if (this.ThirdChoise.isSelected()) {
//            this.driverAgeLabel.setVisible(false);
//            this.driverAgeText.setVisible(false);
//            this.leveLabel.setText("Comment");
//        }
//        else {
//            this.driverAgeLabel.setVisible(true);
//            this.driverAgeText.setVisible(true);
//            this.leveLabel.setText("Level");
//        }
//    }
//
//    private void jButton1ActionPerformed(final ActionEvent evt) {
//        try {
//            final String policyHolderName = this.policyUsernameText.getText();
//            final String model = this.modelText.getText();
//            carType type = carType.valueOf(this.typeText.getSelectedItem().toString());
//            final int size = Integer.parseInt(this.manufacturingText.getText());
//            final double price = Double.parseDouble(this.priceText.getText());
//            final int numberOfClaims = Integer.parseInt(this.claimText.getText());
//            final int day = Integer.parseInt(this.dayText.getText());
//            final int month = Integer.parseInt(this.monthText.getText());
//            final int year = Integer.parseInt(this.yearText.getText());
//            final MyDate date = new MyDate(year, month, day);
//            final Car newCar = new Car(model, type, size, price);
//            this.policy.policyHolderName = policyHolderName;
//            this.policy.expiryDate = date;
//            this.policy.car = newCar;
//            this.policy.numberOfClaims = numberOfClaims;
//            if (this.ThirdChoise.isSelected()) {
//                final String comment = this.levelText.getText();
//                ((ThirdPartyPolicy)this.policy).comment = comment;
//            }
//            else {
//                final int level = Integer.parseInt(this.levelText.getText());
//                final int driverAge = Integer.parseInt(this.driverAgeText.getText());
//                ((ComprehensivePolicy)this.policy).driverAge = driverAge;
//                ((ComprehensivePolicy)this.policy).level = level;
//            }
//            JOptionPane.showMessageDialog(this, "Policy has been updated");
//            this.userUI.fillTable();
//            this.dispose();
//        }
//        catch (Exception e) {
//            JOptionPane.showMessageDialog(this, e);
//        }
//    }
//
//    private void jButton2ActionPerformed(final ActionEvent evt) {
//        this.policyIDText.setText("");
//        this.policyUsernameText.setText("");
//        this.modelText.setText("");
//        this.manufacturingText.setText("");
//        this.priceText.setText("");
//        this.claimText.setText("");
//        this.capText.setText("");
//        this.dayText.setText("");
//        this.monthText.setText("");
//        this.yearText.setText("");
//        this.levelText.setText("");
//        this.driverAgeText.setText("");
//    }
}
