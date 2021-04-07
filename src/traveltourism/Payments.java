package traveltourism;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Payments extends JFrame {
    String username;
    Payments(String user) {
        this.username = user;

        setLayout(null);
        setBounds(600, 220, 800, 560);
        getContentPane().setBackground(Color.decode("#004C99"));

        JLabel label = new JLabel("Stripe Payment");
        label.setFont(new Font("Raleway", Font.BOLD, 40));
        label.setForeground(Color.BLACK);
        label.setBounds(245, 20, 350, 45);
        add(label);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("traveltourism/icons/icons/stripe.png"));
        Image i8 = i7.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel l4 = new JLabel(i9);
        l4.setBounds(100, 100, 600, 300);
        add(l4);

        JButton pay = new JButton("Pay");
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new StripePY(username).setVisible(true);
            }
        });
        pay.setBounds(300, 460, 80, 40);
        add(pay);

        JButton back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        back.setBounds(410, 460, 80, 40);
        add(back);

        setVisible(true);

    }

    public static void main(String[] args) {
        new Payments("").setVisible(true);
    }

}