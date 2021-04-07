package traveltourism;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Logins extends JFrame implements ActionListener {
    JButton b1;
    JButton b2;
    JButton b3;
    JTextField t1;
    JPasswordField t2;

    Logins() {
        setLayout(null); // bydefault we have grid layout
        getContentPane().setBackground(Color.WHITE);
        setBounds(500, 300, 900, 440);

        JPanel p1 = new JPanel(); // it is same as div in web pages
        // p1.setBackground(Color.decode("#004C99"));
        p1.setBounds(0, 0, 450, 400);
        p1.setLayout(null);

        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("traveltourism/icons/icons/img2.jpg"));

        Image i1 = I1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i1);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 0, 400, 400);

        p1.add(l1);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);

        JLabel l2 = new JLabel("Username");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        l2.setBounds(85, 20, 100, 25);
        p2.add(l2);

        t1 = new JTextField();
        t1.setBounds(85, 60, 300, 25);
        t1.setBorder(BorderFactory.createEmptyBorder());
        t1.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
        p2.add(t1);

        JLabel l3 = new JLabel("Password");
        l3.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        l3.setForeground(Color.WHITE);
        l3.setBounds(85, 105, 100, 25);
        p2.add(l3);

        t2 = new JPasswordField();
        t2.setBounds(85, 145, 300, 25);
        t2.setBorder(BorderFactory.createEmptyBorder());
        t2.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
        p2.add(t2);

        b1 = new JButton("Login");
        b1.setBounds(85, 190, 143, 30);
        b1.setBackground(Color.decode("#004C99"));
        b1.setForeground(Color.WHITE);
        b1.setBorder(BorderFactory.createEmptyBorder());
        b1.addActionListener(this);
        p2.add(b1);

        b2 = new JButton("SignUp");
        b2.setBounds(243, 190, 143, 30);
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.decode("#004C99"));
        b2.setBorder(new LineBorder(Color.decode("#004C99")));
        b2.addActionListener(this);
        p2.add(b2);

        b3 = new JButton("Forget Password");
        b3.setBounds(155, 240, 150, 30);
        b3.setBackground(Color.WHITE);
        b3.setForeground(Color.RED);
        b3.setBorder(new LineBorder(Color.RED));
        b3.addActionListener(this);
        p2.add(b3);

        // JLabel l4 = new JLabel("Trouble in Login");
        // l4.setBounds(315, 240, 100, 30);
        // p2.add(l4);
        p2.setBackground(Color.BLACK);

        add(p1);
        add(p2);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String args[]) {
        new Logins();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b2) {
            this.setVisible(false);
            new SignUp();

        } else if (e.getSource() == b3) {
            this.setVisible(false);
            new ForgetPassword();
        } else {
            String username = t1.getText();
            String password = t2.getText();
            Encrypt encrypt = new Encrypt();
            password = encrypt.encrypt(password);
            Conn c = new Conn();
            String sql = "select * from account where username='" + username + "' AND password='" + password + "'";
            try {
                ResultSet rs = c.s.executeQuery(sql); // fetching so executeQuery
                if (rs.next()) {

                    setVisible(false);
                    new Loading(username);
                } else {
                    JOptionPane.showMessageDialog(null, "User Not Found! Please recheck username or password..",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception error) {
                System.out.println(error.getMessage());
            }
        }
    }

}
