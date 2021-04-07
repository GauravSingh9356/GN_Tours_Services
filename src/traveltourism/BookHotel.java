/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traveltourism;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BookHotel extends JFrame implements ActionListener {
    Choice c1, c2, c3;
    JTextField t1, t2;
    JLabel l21, l23, l24, l22, l25;
    JButton b1, b2, b3;

    BookHotel(String username) {
        setBounds(550, 240, 1100, 600);
        getContentPane().setBackground(Color.decode("#004C99"));
        setLayout(null);

        JLabel l1 = new JLabel("Book Hotel");
        l1.setFont(new Font("Tahoma", Font.BOLD, 24));
        l1.setForeground(Color.BLACK);
        l1.setBounds(140, 14, 300, 30);
        add(l1);

        JLabel l2 = new JLabel("Username : ");
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setForeground(Color.BLACK);
        l2.setBounds(20, 70, 100, 50);
        add(l2);

        l21 = new JLabel();
        l21.setBounds(250, 70, 100, 30);
        l21.setFont(new Font("Tahoma", Font.BOLD, 16));
        l21.setForeground(Color.BLACK);
        add(l21);

        JLabel l3 = new JLabel("Select Hotel: ");
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setForeground(Color.BLACK);
        l3.setBounds(20, 110, 100, 50);
        add(l3);

        c1 = new Choice();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while (rs.next()) {
                c1.add(rs.getString("name"));
            }
        } catch (Exception e) {
        }

        c1.setBounds(250, 120, 200, 30);
        add(c1);

        JLabel l4 = new JLabel("Total Person");
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setForeground(Color.BLACK);
        l4.setBounds(20, 150, 100, 50);
        add(l4);

        t1 = new JTextField();
        t1.setBounds(250, 158, 140, 25);
        add(t1);

        JLabel l5 = new JLabel("No of Days");
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setForeground(Color.BLACK);
        l5.setBounds(20, 190, 100, 50);
        add(l5);

        t2 = new JTextField();
        t2.setBounds(250, 197, 140, 25);
        add(t2);

        JLabel l6 = new JLabel("AC/Non-AC");
        l6.setFont(new Font("Tahoma", Font.BOLD, 14));
        l6.setForeground(Color.BLACK);
        l6.setBounds(20, 226, 100, 50);
        add(l6);

        c2 = new Choice();
        c2.add("Yes");
        c2.add("NO");
        c2.setBounds(250, 230, 140, 30);
        add(c2);

        JLabel l7 = new JLabel("Food Included");
        l7.setFont(new Font("Tahoma", Font.BOLD, 14));
        l7.setForeground(Color.BLACK);
        l7.setBounds(20, 270, 100, 50);
        add(l7);

        c3 = new Choice();
        c3.add("Yes");
        c3.add("NO");
        c3.setBounds(250, 270, 140, 30);
        add(c3);

        JLabel l8 = new JLabel("ID: ");
        l8.setFont(new Font("Tahoma", Font.BOLD, 14));
        l8.setForeground(Color.BLACK);
        l8.setBounds(20, 310, 100, 50);
        add(l8);

        l22 = new JLabel();
        l22.setBounds(250, 310, 140, 30);
        l22.setFont(new Font("Tahoma", Font.BOLD, 16));
        l22.setForeground(Color.BLACK);
        add(l22);

        JLabel l9 = new JLabel("Number: ");
        l9.setFont(new Font("Tahoma", Font.BOLD, 14));
        l9.setForeground(Color.BLACK);
        l9.setBounds(20, 350, 100, 50);
        add(l9);

        l23 = new JLabel();
        l23.setBounds(250, 350, 140, 30);
        l23.setFont(new Font("Tahoma", Font.BOLD, 16));
        l23.setForeground(Color.BLACK);
        add(l23);

        JLabel l10 = new JLabel("Phone: ");
        l10.setForeground(Color.BLACK);
        l10.setFont(new Font("Tahoma", Font.BOLD, 14));
        l10.setBounds(20, 390, 100, 50);
        add(l10);

        l24 = new JLabel();
        l24.setBounds(250, 390, 140, 30);
        l24.setFont(new Font("Tahoma", Font.BOLD, 16));
        l24.setForeground(Color.BLACK);
        add(l24);

        JLabel l11 = new JLabel("Total Price: ");
        l11.setFont(new Font("Tahoma", Font.BOLD, 14));
        l11.setForeground(Color.BLACK);
        l11.setBounds(20, 430, 100, 30);
        add(l11);

        l25 = new JLabel();
        l25.setBounds(250, 430, 140, 30);
        l25.setForeground(Color.RED);
        l25.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(l25);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username ='" + username + "'");
            while (rs.next()) {
                l21.setText(rs.getString("username"));
                l22.setText(rs.getString("id"));
                l23.setText(rs.getString("number"));
                l24.setText(rs.getString("phone"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        b1 = new JButton("Check Price");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(50, 490, 120, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Book");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(200, 490, 120, 30);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(350, 490, 120, 30);
        b3.addActionListener(this);
        add(b3);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("traveltourism/icons/icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(500, 50, 600, 400);
        add(l12);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where name ='" + c1.getSelectedItem() + "'");
                while (rs.next()) {
                    int cost = Integer.parseInt(rs.getString("cost_per_day"));
                    int food = Integer.parseInt(rs.getString("food_charges"));
                    int ac = Integer.parseInt(rs.getString("ac_charges"));

                    int persons = Integer.parseInt(t1.getText());
                    int days = Integer.parseInt(t2.getText());

                    String ac_choice = c2.getSelectedItem();
                    String food_choice = c3.getSelectedItem();

                    if (persons * days > 0) {
                        int total = 0;
                        total += ac_choice.equals("Yes") ? ac : 0;
                        total += food_choice.equals("Yes") ? food : 0;
                        total += cost;
                        total = total * persons * days;
                        l25.setText("" + total);
                    } else {
                        l25.setText("Please enter a valid number");
                    }
                }
            } catch (Exception e) {
            }

        } else if (ae.getSource() == b2) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookHotel values('" + l21.getText() + "','" + c1.getSelectedItem()
                        + "','" + t1.getText() + "','" + t2.getText() + "','" + c2.getSelectedItem() + "','"
                        + c3.getSelectedItem() + "', '" + l22.getText() + "','" + l23.getText() + "','" + l24.getText()
                        + "','" + l25.getText() + "')");
                JOptionPane.showMessageDialog(null, "Hotel Booked SuccessFully!");

                this.setVisible(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
            }

        } else if (ae.getSource() == b3) {
            this.setVisible(false);
        }
    }

    public static void main(String args[]) {
        new BookHotel("GS");
    }

}