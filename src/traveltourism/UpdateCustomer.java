package traveltourism;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class UpdateCustomer extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10;
    String username;
     JComboBox comboBox;
      JRadioButton r1, r2;
    JButton btnUpdate, btnBack;

    UpdateCustomer(String user) {
        username = user;
        setBounds(580, 220, 850, 550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("traveltourism/icons/icons/update.png"));
        Image i3 = i1.getImage().getScaledInstance(200, 320, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(520, 80, 200, 320);
        add(l1);

        JLabel lblName = new JLabel("UPDATE CUSTOMER DETAILS");
        lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblName.setBounds(118, 11, 300, 53);
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
       // comboBox.setColumns(10);

        JLabel l2 = new JLabel("Number :");
        l2.setBounds(35, 150, 200, 14);
        contentPane.add(l2);

        t3 = new JTextField();
        t3.setBounds(271, 150, 150, 20);
        contentPane.add(t3);
        t3.setColumns(10);

        JLabel lblName_1 = new JLabel("Name :");
        lblName_1.setBounds(35, 190, 200, 14);
        contentPane.add(lblName_1);

        t4 = new JTextField();
        t4.setBounds(271, 190, 150, 20);
        contentPane.add(t4);
        t4.setColumns(10);

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

        t6 = new JTextField();
        t6.setBounds(271, 270, 150, 20);
        contentPane.add(t6);
        t6.setColumns(10);

        JLabel lblReserveRoomNumber = new JLabel("Permanent Address :");
        lblReserveRoomNumber.setBounds(35, 310, 200, 14);
        contentPane.add(lblReserveRoomNumber);

        t7 = new JTextField();
        t7.setBounds(271, 310, 150, 20);
        contentPane.add(t7);
        t7.setColumns(10);

        JLabel lblCheckInStatus = new JLabel("Phone :");
        lblCheckInStatus.setBounds(35, 350, 200, 14);
        contentPane.add(lblCheckInStatus);

        t8 = new JTextField();
        t8.setBounds(271, 350, 150, 20);
        contentPane.add(t8);
        t8.setColumns(10);

        JLabel lblDeposite = new JLabel("Email :");
        lblDeposite.setBounds(35, 390, 200, 14);
        contentPane.add(lblDeposite);

        t9 = new JTextField();
        t9.setBounds(271, 390, 150, 20);
        contentPane.add(t9);
        t9.setColumns(10);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(100, 430, 120, 30);
        btnUpdate.setBackground(Color.BLACK);
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.addActionListener(this);
        contentPane.add(btnUpdate);

        btnBack = new JButton("Back");
        btnBack.setBounds(260, 430, 120, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        btnBack.addActionListener(this);
        contentPane.add(btnBack);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

        try {
            Conn c = new Conn();
            String query = "select * from customer where username='" + username + "'"+"ORDER By username";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                t1.setText(rs.getString(1));  
                        comboBox.setSelectedItem(rs.getString(2));
                        t3.setText(rs.getString(3));  
                        t4.setText(rs.getString(4));
                        if(rs.getString(5).equals("Male"))
                        {
                            r1.setSelected(true);
                        }
                        else{
                            r2.setSelected(true);
                        }
                       // t5.setText(rs.getString(5));  
                        t6.setText(rs.getString(6));
                        t7.setText(rs.getString(7));  
                        t8.setText(rs.getString(8));
                        t9.setText(rs.getString(9));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == btnUpdate) {
            String id = (String) comboBox.getSelectedItem();
            String number = t3.getText();
            String name = t4.getText();
            String radio = null;
            if (r1.isSelected()) {
                radio = "Male";
            } else {
                radio = "Female";
            }
            String country = t6.getText();
            String address = t7.getText();
            String phone = t8.getText();
            String email = t9.getText();

            String query =  "update customer set id = '"+id+"', number = '"+number+"', name = '"+name+"', gender = '"+radio+"', country = '"+country+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"'"+ "where username='" + username+ "'";
                        
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Update Successfull!", "Success", JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);

            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        } else if (ae.getSource() == btnBack) {
            setVisible(false);
            // new Dashboard();
        }
    }

    public static void main(String[] args) {
        new UpdateCustomer("Gaurav Singh");
    }
}
