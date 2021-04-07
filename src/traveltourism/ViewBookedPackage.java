package traveltourism;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class ViewBookedPackage extends JFrame implements ActionListener {
    private JPanel contentPane;
    Choice c1;
    String username;
    JButton btnExit;

    ViewBookedPackage(String user) {
        username = user;
        setBounds(580, 220, 950, 460);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("traveltourism/icons/icons/mine.png"));
        Image i3 = i1.getImage().getScaledInstance(450, 393, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(450, 20, 450, 393);
        add(la1);

        JLabel lblName = new JLabel("BOOKED PACKAGE DETAILS");
        lblName.setFont(new Font("Yu Mincho", Font.BOLD, 22));
        lblName.setForeground(Color.BLACK);
        lblName.setBounds(88, 11, 350, 53);
        contentPane.add(lblName);

        JLabel lb3 = new JLabel("Username :");
        lb3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb3.setForeground(Color.BLACK);

        lb3.setBounds(35, 70, 200, 16);
        contentPane.add(lb3);

        JLabel l1 = new JLabel();
        l1.setBounds(271, 70, 200, 14);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Tahoma", Font.BOLD, 18));
        contentPane.add(l1);

        JLabel lblId = new JLabel("Package :");
         lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblId.setBounds(35, 110, 200, 16);
        lblId.setForeground(Color.BLACK);

        contentPane.add(lblId);

        JLabel l2 = new JLabel();
        l2.setBounds(271, 110, 200, 14);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Tahoma", Font.BOLD, 18));

        contentPane.add(l2);

        JLabel lb2 = new JLabel("Number of Persons :");
         lb2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb2.setBounds(35, 150, 200, 16);
        contentPane.add(lb2);
        lb2.setForeground(Color.BLACK);

        JLabel l3 = new JLabel();
        l3.setBounds(271, 150, 200, 14);
         l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Tahoma", Font.BOLD, 18));
        contentPane.add(l3);

        JLabel lblName_1 = new JLabel("ID :");
         lblName_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblName_1.setBounds(35, 190, 200, 16);
        lblName_1.setForeground(Color.BLACK);
        
        contentPane.add(lblName_1);

        JLabel l4 = new JLabel();
        l4.setBounds(271, 190, 200, 14);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Tahoma", Font.BOLD, 18));
        contentPane.add(l4);

        JLabel lblGender = new JLabel("Number :");
         lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblGender.setBounds(35, 230, 200, 16);
        lblGender.setForeground(Color.BLACK);

        contentPane.add(lblGender);

        JLabel l5 = new JLabel();
        l5.setBounds(271, 230, 200, 14);
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("Tahoma", Font.BOLD, 18));

        contentPane.add(l5);

        JLabel lblCountry = new JLabel("Phone :");
         lblCountry.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblCountry.setBounds(35, 270, 200, 16);
        lblCountry.setForeground(Color.BLACK);
        contentPane.add(lblCountry);

        JLabel l6 = new JLabel();
        l6.setBounds(271, 270, 200, 18);
        l6.setForeground(Color.BLACK);
         l6.setFont(new Font("Tahoma", Font.BOLD, 16));
        contentPane.add(l6);

        JLabel lblReserveRoomNumber = new JLabel("Price :");
         lblReserveRoomNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblReserveRoomNumber.setBounds(35, 310, 200, 16);
        lblReserveRoomNumber.setForeground(Color.BLACK);
        contentPane.add(lblReserveRoomNumber);

        JLabel l7 = new JLabel();
        l7.setBounds(271, 310, 200, 18);
        l7.setFont(new Font("Tahoma", Font.BOLD, 18));
        l7.setForeground(Color.RED);
        contentPane.add(l7);

        Conn c = new Conn();
        try {

            ResultSet rs = c.s.executeQuery("select * from bookPackage where username = '" + username + "'");
            while (rs.next()) {
                l1.setText(rs.getString(1));
                l2.setText(rs.getString(2));
                l3.setText(rs.getString(3));
                l4.setText(rs.getString(4));
                l5.setText(rs.getString(5));
                l6.setText(rs.getString(6));
                l7.setText(rs.getString(7));

            }

            rs.close();
        } catch (Exception e) {
        }

        btnExit = new JButton("Back");
        btnExit.addActionListener(this);
        btnExit.setBounds(160, 350, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(Color.decode("#004C99"));
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnExit) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ViewBookedPackage("Gaurav Singh");
    }
}
