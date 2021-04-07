package traveltourism;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BookPackage extends JFrame implements ActionListener {
    Choice c1;
    JLabel l11, l12, l13, l14, l15;
    JTextField t1;
    JButton b1, b2, b3;
    String username;

    BookPackage(String user) {
        username = user;
        setBounds(600, 240, 985, 500);
        // setBackground(Color.decode("#004C99"));
        setLayout(null); // bydefault border layout

        getContentPane().setBackground(Color.decode("#004C99"));

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("traveltourism/icons/icons/booked.png"));
        Image i2 = i1.getImage().getScaledInstance(484, 438, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel l10 = new JLabel(i3);
        l10.setBounds(480, 10, 484, 438);
        add(l10);

        JLabel l1 = new JLabel("BOOK PACKAGE");
        l1.setBounds(100, 10, 200, 30);
        l1.setFont(new Font("Tahoma", Font.BOLD, 22));
        l1.setForeground(Color.BLACK);
        add(l1);

        JLabel l2 = new JLabel("Username");
        l2.setBounds(40, 70, 100, 30);
        l2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l2.setForeground(Color.BLACK);

        add(l2);

        l11 = new JLabel();
        l11.setBounds(250, 70, 200, 30);
        l11.setFont(new Font("Tahoma", Font.BOLD, 18));
        l11.setForeground(Color.BLACK);
        add(l11);

        JLabel l3 = new JLabel("Select Package");
        l3.setBounds(40, 110, 150, 30);
        l3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l3.setForeground(Color.BLACK);
        add(l3);

        c1 = new Choice();
        c1.add("Diamond Package");
        c1.add("Gold Package");
        c1.add("Platinum Package");
        c1.setBounds(250, 110, 160, 30);
        add(c1);

        JLabel l4 = new JLabel("No of Person");
        l4.setBounds(40, 150, 150, 30);
        l4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l4.setForeground(Color.BLACK);

        add(l4);

        t1 = new JTextField("1");
        t1.setBounds(250, 150, 160, 25);
        t1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        t1.setForeground(Color.RED);
        add(t1);

        JLabel l5 = new JLabel("ID: ");
        l5.setBounds(40, 190, 150, 30);
        l5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l5.setForeground(Color.BLACK);

        add(l5);

        l12 = new JLabel();
        l12.setBounds(250, 190, 200, 30);
        l12.setFont(new Font("Tahoma", Font.BOLD, 18));
        l12.setForeground(Color.BLACK);
        add(l12);

        JLabel l6 = new JLabel("Number");
        l6.setBounds(40, 230, 150, 30);
        l6.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l6.setForeground(Color.BLACK);

        add(l6);

        l13 = new JLabel();
        l13.setBounds(250, 230, 200, 30);
        l13.setFont(new Font("Tahoma", Font.BOLD, 18));
        l13.setForeground(Color.BLACK);
        add(l13);

        JLabel l7 = new JLabel("Phone");
        l7.setBounds(40, 270, 100, 30);
        l7.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l7.setForeground(Color.BLACK);

        add(l7);

        l14 = new JLabel();
        l14.setBounds(250, 270, 200, 30);
        l14.setFont(new Font("Tahoma", Font.BOLD, 18));
        l14.setForeground(Color.BLACK);
        add(l14);

        JLabel l8 = new JLabel("Total Price");
        l8.setBounds(40, 310, 100, 30);
        l8.setFont(new Font("Tahoma", Font.PLAIN, 18));

        l8.setForeground(Color.BLACK);

        add(l8);

        l15 = new JLabel();
        l15.setBounds(250, 310, 200, 30);
        l15.setFont(new Font("Tahoma", Font.BOLD, 18));
        l15.setForeground(Color.RED);
        add(l15);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '" + username + "'");
            while (rs.next()) {
                l11.setText(rs.getString("username"));
                l12.setText(rs.getString("id"));
                l13.setText(rs.getString("number"));
                l14.setText(rs.getString("phone"));

            }
        } catch (Exception e) {
        }

        b1 = new JButton("Check Price");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(60, 380, 120, 25);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Book Package");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(200, 380, 120, 25);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(340, 380, 120, 25);
        b3.addActionListener(this);
        add(b3);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String p = c1.getSelectedItem();
            int cost = 0;
            if (p.equals("Diamond Package")) {
                cost += 32000;
            } else if (p.equals("Gold Package")) {
                cost += 24000;
            } else if (p.equals("Platinum Package")) {
                cost += 12000;
            }
            String persons = t1.getText();
            int totalCost = Integer.parseInt(persons) * cost;
            l15.setText("Rs " + totalCost + "/-");
        } else if (ae.getSource() == b2) {
            try {
                Conn c = new Conn();
                String q = "insert into bookPackage values('" + l11.getText() + "', '" + c1.getSelectedItem() + "', '"
                        + t1.getText() + "', '" + l12.getText() + "', '" + l13.getText() + "', '" + l14.getText()
                        + "', '" + l15.getText() + "')";
                c.s.executeUpdate(q);
                setVisible(false);
                JOptionPane.showMessageDialog(null, "Package Booked Successfully!", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else {
            setVisible(false);

        }
    }

    public static void main(String[] args) {
        new BookPackage("Gaurav Singh");
    }
}
