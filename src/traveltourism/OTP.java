package traveltourism;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OTP extends JFrame implements ActionListener {
    JTextField t1;
    JButton b1;
    int OTP;
    String username = null, id = null, number = null, name = null, radio = null, country = null, address = null,
            phone = null, email = null;

    OTP(int OTP, String username, String id, String number, String name, String radio, String country, String address,
            String phone, String email) {
        this.OTP = OTP;
        this.username = username;
        this.id = id;
        this.number = number;
        this.name = name;
        this.radio = radio;
        this.country = country;
        this.address = address;
        this.phone = phone;
        this.email = email;
        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 800, 800);
        p1.setLayout(null);
        add(p1);
        JLabel l1 = new JLabel("We have Send OTP code to your email. Please Verify it!");
        l1.setFont(new Font("Tahoma", Font.BOLD, 24));
        l1.setForeground(Color.green);
        l1.setBounds(60, 45, 700, 30);
        p1.add(l1);

        t1 = new JTextField("");
        t1.setBounds(280, 120, 200, 30);
        p1.add(t1);

        b1 = new JButton("Verify");
        b1.setBounds(320, 190, 120, 35);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        p1.add(b1);
        b1.addActionListener(this);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("traveltourism/icons/icons/otp.jpg"));
        Image i3 = i1.getImage().getScaledInstance(625, 445, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l2 = new JLabel(i2);
        l2.setBounds(50, 240, 700, 445);
        p1.add(l2);

        JLabel l3 = new JLabel("GN Tours and Services");
        l3.setFont(new Font("Tahoma", Font.BOLD, 28));
        l3.setForeground(Color.BLACK);
        l3.setBounds(240, 700, 700, 35);
        p1.add(l3);

        setBounds(580, 220, 800, 800);
        setLayout(null);
        setVisible(true);
        p1.setBackground(Color.decode("#004C99"));
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String text = t1.getText();
            int otp = Integer.parseInt(text);
            if (!(OTP == otp)) {
                JOptionPane.showMessageDialog(null, "OTP code is wrong! Please recheck the code and Try Again.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Verified!", "Success", JOptionPane.INFORMATION_MESSAGE);
                String query = "insert into customer values('" + username + "','" + id + "','" + number + "','" + name
                        + "','" + radio + "','" + country + "','" + address + "','" + phone + "','" + email + "')";
                try {
                    Conn c = new Conn();
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Registration Successfull!", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    ConfirmationEmail emailSender = new ConfirmationEmail();
                     emailSender.setupProperties(email);
                    setVisible(false);
                   

                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }

            }
        }
    }

    public static void main(String args[]) {
        new OTP(12345, "a", "b", "c", "d", "e", "f", "g", "v", "b");
    }
}
