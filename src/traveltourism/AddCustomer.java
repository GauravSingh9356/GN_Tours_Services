package traveltourism;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddCustomer extends JFrame implements ActionListener {
    Thread t;
    Connection conn = null;
    PreparedStatement pst = null;
    private JPanel contentPane;
    private JTextField t1, t2, t3, t4, t5, t6, t7, t8;
    JComboBox comboBox;
    JRadioButton r1, r2;
    String username;
    JButton btnAdd, btnBack;

    AddCustomer(String user) {
        this.username = user;
        setBounds(580, 220, 850, 550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("traveltourism/icons/icons/newcustomer.jpg"));
        Image i3 = i1.getImage().getScaledInstance(450, 500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(450, 40, 450, 420);
        add(l1);

        JLabel lblName = new JLabel("GN TOURS FORM");
        lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblName.setBounds(118, 11, 260, 53);
        contentPane.add(lblName);

        JLabel l3 = new JLabel("Username :");
        l3.setBounds(35, 70, 200, 14);
        contentPane.add(l3);

        t1 = new JTextField();
        t1.setBounds(271, 70, 150, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        JLabel lblId = new JLabel("ID :");
        lblId.setBounds(35, 110, 200, 14);
        contentPane.add(lblId);

        comboBox = new JComboBox(new String[] { "Passport", "Aadhar Card", "Voter Id", "Driving license" });
        comboBox.setBounds(271, 110, 150, 20);
        contentPane.add(comboBox);

        JLabel l2 = new JLabel("Number :");
        l2.setBounds(35, 150, 200, 14);
        contentPane.add(l2);

        t2 = new JTextField();
        t2.setBounds(271, 150, 150, 20);
        contentPane.add(t2);
        t2.setColumns(10);

        JLabel lblName_1 = new JLabel("Name :");
        lblName_1.setBounds(35, 190, 200, 14);
        contentPane.add(lblName_1);

        t3 = new JTextField();
        t3.setBounds(271, 190, 150, 20);
        contentPane.add(t3);
        t3.setColumns(10);

        JLabel lblGender = new JLabel("Gender :");
        lblGender.setBounds(35, 230, 200, 14);
        contentPane.add(lblGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);
        r1.setBounds(271, 230, 80, 12);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 230, 100, 12);
        add(r2);
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        JLabel lblCountry = new JLabel("Country :");
        lblCountry.setBounds(35, 270, 200, 14);
        contentPane.add(lblCountry);

        t4 = new JTextField();
        t4.setBounds(271, 270, 150, 20);
        contentPane.add(t4);
        t4.setColumns(10);

        JLabel lblReserveRoomNumber = new JLabel("Permanent Address :");
        lblReserveRoomNumber.setBounds(35, 310, 200, 14);
        contentPane.add(lblReserveRoomNumber);

        t5 = new JTextField();
        t5.setBounds(271, 310, 150, 20);
        contentPane.add(t5);
        t5.setColumns(10);

        JLabel lblCheckInStatus = new JLabel("Phone :");
        lblCheckInStatus.setBounds(35, 350, 200, 14);
        contentPane.add(lblCheckInStatus);

        t6 = new JTextField();
        t6.setBounds(271, 350, 150, 20);
        contentPane.add(t6);
        t6.setColumns(10);

        JLabel lblDeposite = new JLabel("Email :");
        lblDeposite.setBounds(35, 390, 200, 14);
        contentPane.add(lblDeposite);

        t7 = new JTextField();
        t7.setBounds(271, 390, 150, 20);
        contentPane.add(t7);
        t7.setColumns(10);

        btnAdd = new JButton("Add");
        btnAdd.setBounds(100, 430, 120, 30);
        btnAdd.setBackground(Color.BLACK);
        btnAdd.setForeground(Color.WHITE);
        contentPane.add(btnAdd);
        btnAdd.addActionListener(this);

        btnBack = new JButton("Back");

        btnBack.setBounds(260, 430, 120, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        contentPane.add(btnBack);
        btnBack.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

        try {
            Conn c = new Conn();
            String query = "select * from account where username='" + username + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                t1.setText(rs.getString("username"));
                t3.setText(rs.getString("name"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnAdd) {
            String username = t1.getText();
            String id = (String) comboBox.getSelectedItem();
            String number = t2.getText();
            String name = t3.getText();
            String radio = null;
            if (r1.isSelected()) {
                radio = "Male";
            } else {
                radio = "Female";
            }
            String country = t4.getText();
            String address = t5.getText();
            String phone = t6.getText();
            String email = t7.getText();
            
            
            String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
 
        Pattern pattern = Pattern.compile(regex);
 
    
    Matcher matcher = pattern.matcher(email);
        if(matcher.matches())
        {
             Random ran = new Random();
            int OTP = ran.nextInt(99999);
            EmailSenders sender = new EmailSenders();
            sender.setupProperties(email, OTP);
            OTP otp = new OTP(OTP, username, id, number, name, radio, country, address, phone, email);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please write correct email", "Email Validation failed", JOptionPane.INFORMATION_MESSAGE);
        }
           
            setVisible(false);

        }

        else if (ae.getSource() == btnBack) {
            setVisible(false);
            // new Dashboard();
        }
    }

    public static void main(String[] args) {
        new AddCustomer("");
    }
}
