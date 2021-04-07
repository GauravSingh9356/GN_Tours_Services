package traveltourism;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

public class SignUp extends JFrame implements ActionListener {
    JButton b1;
    JButton b2;
    JTextField t1, t2, t3, t4, t5;
    Choice c1;

    SignUp() {
        setBounds(600, 250, 900, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JPanel p1 = new JPanel();

        p1.setBounds(0, 20, 500, 450);
        p1.setLayout(null);
        add(p1);

        JLabel l1 = new JLabel("Username");
        l1.setBounds(50, 30, 100, 25);
        l1.setFont(new Font("Tahoma", Font.BOLD, 17));
        l1.setForeground(Color.BLACK);
        p1.add(l1);

        t1 = new JTextField();
        t1.setBounds(160, 30, 200, 25);
        t1.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t1);

        JLabel l2 = new JLabel("Name");
        l2.setBounds(50, 70, 100, 25);
        l2.setFont(new Font("Tahoma", Font.BOLD, 17));
        l2.setForeground(Color.BLACK);
        p1.add(l2);

        t2 = new JTextField();
        t2.setBounds(160, 70, 200, 25);
        t2.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t2);

        JLabel l3 = new JLabel("Password");
        l3.setBounds(50, 110, 100, 25);
        l3.setFont(new Font("Tahoma", Font.BOLD, 17));
        l3.setForeground(Color.BLACK);
        p1.add(l3);

        t3 = new JTextField();
        t3.setBounds(160, 110, 200, 25);
        t3.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t3);

        JLabel l4 = new JLabel("Question");
        l4.setBounds(50, 150, 100, 25);
        l4.setFont(new Font("Tahoma", Font.BOLD, 17));
        l4.setForeground(Color.BLACK);
        p1.add(l4);

        c1 = new Choice();
        c1.add("JS Or Py?");
        c1.add("Your nickName?");
        c1.add("Your Lucky number?");
        c1.add("Your favourite food?");
        c1.setBounds(160, 150, 200, 30);
        p1.add(c1);

        JLabel l5 = new JLabel("Answer");
        l5.setBounds(50, 190, 100, 25);
        l5.setFont(new Font("Tahoma", Font.BOLD, 17));
        l5.setForeground(Color.BLACK);
        p1.add(l5);

        t4 = new JTextField();
        t4.setBounds(160, 190, 200, 25);
        t4.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t4);

        JLabel l6 = new JLabel("Ph. Number");
        l6.setBounds(50, 230, 100, 25);
        l6.setFont(new Font("Tahoma", Font.BOLD, 17));
        l6.setForeground(Color.BLACK);
        p1.add(l6);

        t5 = new JTextField();
        t5.setBounds(160, 230, 200, 25);
        t5.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t5);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("traveltourism/icons/icons/signupimage.png"));
        Image i2 = i1.getImage().getScaledInstance(275, 275, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l7 = new JLabel(i3);
        l7.setBounds(580, 50, 250, 275);
        // p2.add(l6);
        // p2.setBounds(0, 0, 500, 400);
        // p2.setLayout(null);
        add(l7);

        // Craete button
        b1 = new JButton("Create");
        b1.setBounds(145, 275, 100, 30);
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.decode("#004C99"));
        b1.setBorder(new LineBorder(Color.BLACK));
        b1.addActionListener(this);
        p1.add(b1);

        // Back Button
        b2 = new JButton("Back");
        b2.setBounds(270, 275, 110, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        p1.add(b2);
        setVisible(true);

        JPanel p2 = new JPanel();
        p2.setBounds(30, 0, 450, 325);
        p2.setBackground(Color.decode("#004C99"));
        p1.add(p2);

        add(p1);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String username = t1.getText();
            String name = t2.getText();
            String password = t3.getText();
            Encrypt encrypt = new Encrypt();
            password = encrypt.encrypt(password);
            String security = c1.getSelectedItem();
            String answer = t4.getText();

            System.out.println(username);

            String query = "insert into account values('" + username + "', '" + name + "', '" + password + "', '"
                    + security + "', '" + answer + "')";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query); //saving the data in database so executeUpdate Command
                JOptionPane.showMessageDialog(null, "Account Created Successfully!"); // first arument is messag type
                                                                                      // like warning, etc
                this.setVisible(false);
                new Logins();
            } catch (Exception error) {
                System.out.println(error.getMessage());
            }
        }
        if (e.getSource() == b2) {
            new Logins();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new SignUp();
    }
}
