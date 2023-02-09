package Test;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Login extends JFrame {
    InsuranceCompany insuranceCompany;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JPasswordField passText;
    private JTextField userText;

    public Login() {
        this.insuranceCompany = new InsuranceCompany();
        this.test();
        this.initComponents();
    }

    public void test() {
        insuranceCompany = new InsuranceCompany("HoomanCompany", "admin", "dpit121", 12);
        Car brand1 = new Car("Porsche Panamera", carType.HATCH, 2021, 353000);
        Car brand2 = new Car("Tesla Model 3", carType.LUX, 2022, 77000);
        Car brand3 = new Car("Toyota Supra", carType.SED, 2019, 125000);
        Car brand4 = new Car("Aston Martin DBX", carType.SUV, 2010, 456999);

        // create the address objects
        Address address1 = new Address(12, "Killian St", "Alexander Heights", "Perth");
        Address address2 = new Address(24, "Willam St", "RingWood", "Melbourne");
        Address address3 = new Address(48, "Brightmore St", "Cremorne", "Sydney");

        // create MyDate objects
        MyDate ExpiryDate1 = new MyDate(2024, 2, 12);
        MyDate ExpiryDate2 = new MyDate(2024, 3, 13);
        MyDate ExpiryDate3 = new MyDate(2024, 4, 14);

        // create 1 user that was based on lab2 requirement--> creating more user for lab3,assignment1
        User user1 = new User("Justin", 1101, address1, "justin01");
        User user2 = new User("Henry", 1102, address2, "henry01");
        User user3 = new User("Shawn", 1103, address3, "shawn01");

        // create ThirdPartyPolicy & ComprehensivePolicy objects
        ThirdPartyPolicy TPP1 = new ThirdPartyPolicy("Evan Wan", 1, brand1, 6, ExpiryDate1, "Be careful with this car!");
        ThirdPartyPolicy TPP2 = new ThirdPartyPolicy("Andrew Her", 3, brand3, 4, ExpiryDate3, "Drive or die");
        ThirdPartyPolicy TPP3 = new ThirdPartyPolicy("William Har ", 137, brand2, 1, ExpiryDate2, "Good");
        ComprehensivePolicy CP1 = new ComprehensivePolicy("Peter Pan", 2, brand4, 1, ExpiryDate2, 29, 7);
        ComprehensivePolicy CP2 = new ComprehensivePolicy("David Jones", 4, brand4, 2, ExpiryDate3, 30, 6);
        ComprehensivePolicy CP3 = new ComprehensivePolicy("Zoe Lol", 110, brand3, 5, ExpiryDate1, 26, 12);

// add user
        insuranceCompany.addUser(user1);
        insuranceCompany.addUser(user2);
        insuranceCompany.addUser(user3);

        //add policy
        insuranceCompany.addPolicy(user1.getUserID(), TPP1);
        insuranceCompany.addPolicy(user1.getUserID(), TPP2);
        insuranceCompany.addPolicy(user1.getUserID(), TPP3);
        insuranceCompany.addPolicy(user1.getUserID(), CP2);
        insuranceCompany.addPolicy(user1.getUserID(), CP3);
        insuranceCompany.addPolicy(user2.getUserID(), TPP1);
        insuranceCompany.addPolicy(user2.getUserID(), TPP2);
        insuranceCompany.addPolicy(user2.getUserID(), TPP3);
        insuranceCompany.addPolicy(user2.getUserID(), CP1);
        insuranceCompany.addPolicy(user2.getUserID(), CP2);
        insuranceCompany.addPolicy(user3.getUserID(), TPP1);
        insuranceCompany.addPolicy(user3.getUserID(),TPP2);
        insuranceCompany.addPolicy(user3.getUserID(),TPP3);
        insuranceCompany.addPolicy(user3.getUserID(),CP1);
        insuranceCompany.addPolicy(user3.getUserID(),CP2);
        insuranceCompany.addPolicy(user3.getUserID(),CP3);

        insuranceCompany.createThirdPartyPolicy(user1.getUserID(), "Ecas", 12, brand1, 2, ExpiryDate3, "EEEE");
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.userText = new JTextField();
        this.jButton1 = new JButton();
        this.passText = new JPasswordField();
        this.jMenuBar1 = new JMenuBar();
        this.jMenu1 = new JMenu();
        this.jMenuItem1 = new JMenuItem();
        this.jMenuItem2 = new JMenuItem();
        this.jMenu2 = new JMenu();
        this.setDefaultCloseOperation(3);
        this.jLabel1.setFont(new Font("Tahoma", 0, 18));
        this.jLabel1.setText("Username");
        this.jLabel2.setFont(new Font("Tahoma", 0, 18));
        this.jLabel2.setText("Password");
        this.userText.setFont(new Font("Tahoma", 1, 18));
        this.jButton1.setFont(new Font("Tahoma", 1, 18));
        this.jButton1.setForeground(new Color(255, 102, 102));
        this.jButton1.setText("Login");
        this.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Login.this.jButton1ActionPerformed(evt);
            }
        });
        this.passText.setFont(new Font("Tahoma", 1, 18));
        this.passText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Login.this.passTextActionPerformed(evt);
            }
        });
        this.jMenu1.setText("File");
        this.jMenu1.setFont(new Font("Segoe UI", 1, 18));
        this.jMenuItem1.setFont(new Font("Segoe UI", 1, 18));
        this.jMenuItem1.setText("Load");
        this.jMenuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    Login.this.jMenuItem1ActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        this.jMenu1.add(this.jMenuItem1);
        this.jMenuItem2.setFont(new Font("Segoe UI", 1, 18));
        this.jMenuItem2.setText("Save");
        this.jMenuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    Login.this.jMenuItem2ActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        this.jMenu1.add(this.jMenuItem2);
        this.jMenuBar1.add(this.jMenu1);
        this.jMenu2.setText("User List");
        this.jMenu2.setFont(new Font("Segoe UI", 1, 18));
        this.jMenu2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                Login.this.jMenu2MouseClicked(evt);
            }
        });
        this.jMenuBar1.add(this.jMenu2);
        this.setJMenuBar(this.jMenuBar1);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(142, 142, 142).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jButton1).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1, -2, 110, -2).addComponent(this.jLabel2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.userText).addComponent(this.passText, -1, 125, 32767)))).addContainerGap(298, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(114, 114, 114).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1, -2, 29, -2).addComponent(this.userText, -2, -1, -2)).addGap(29, 29, 29).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.passText, -2, -1, -2)).addGap(34, 34, 34).addComponent(this.jButton1).addContainerGap(126, 32767)));
        this.pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        this.login();
    }

    private void passTextActionPerformed(ActionEvent evt) {
        this.login();
    }

    private void jMenuItem1ActionPerformed(ActionEvent evt) throws IOException {
        if (insuranceCompany.load("InsuranceCompany2.ser"))
        {
            JOptionPane.showMessageDialog(null, "Company Loaded");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Load Failed!\nNo Company Data Found.");
        }
    }

    private void jMenuItem2ActionPerformed(final ActionEvent evt) throws IOException {
        if (insuranceCompany.save("InsuranceCompany2.ser"))
        {
            JOptionPane.showMessageDialog(null, "Company Saved");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Save Failed.");
        }
    }

    private void jMenu2MouseClicked(final MouseEvent evt) {
        String output = "";
        for (User user : this.insuranceCompany.getUsers().values()) {
            output = output + "username: " + user.getName() + " pass: " + user.getPassword() + "\n";
        }
        output += "\nAdmin\nUN: " + insuranceCompany.getAdminUsername() +"     PW: " + insuranceCompany.getAdminPassword();
        JOptionPane.showMessageDialog(this, output);
    }

    public void login() {
        User user = this.insuranceCompany.validateUser(this.userText.getText(), this.passText.getText());
        boolean admin = this.insuranceCompany.validateAdmin(this.userText.getText(), this.passText.getText());
        this.passText.setText("");
        if (user != null) {
             ArrayList<String> cities = this.insuranceCompany.populateDistinctCityNames();
             UserUI userUI = new UserUI(user, this, cities);
            userUI.setVisible(true);
            this.setVisible(false);
        }  else if (admin == true) {
            passText.setText("");
            ArrayList<String> cities = insuranceCompany.populateDistinctCityNames();
            AdminUI adminUI = new AdminUI(insuranceCompany, this, cities);
            adminUI.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Username or password is wrong");
        }
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex2) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex2);
        }
        catch (IllegalAccessException ex3) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex3);
        }
        catch (UnsupportedLookAndFeelException ex4) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex4);
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}
