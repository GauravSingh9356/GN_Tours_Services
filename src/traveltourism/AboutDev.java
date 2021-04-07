package traveltourism;

import java.awt.event.*;
import java.net.URL;
import java.awt.*;
import javax.swing.*;

public class AboutDev extends JFrame implements ActionListener {
    JButton b1, b2;

    AboutDev() {
        setLayout(null);

        JLabel l3 = new JLabel("Team Members");
        l3.setBounds(650, 20, 360, 50);
        l3.setFont(new Font("Tahoma", Font.BOLD, 40));
        l3.setForeground(Color.BLACK);
        add(l3);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("traveltourism/icons/icons/gs.jpeg"));
        Image i3 = i1.getImage().getScaledInstance(705, 791, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(50, 95, 705, 791);
        add(l1);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("traveltourism/icons/icons/guru.jpeg"));
        Image i5 = i4.getImage().getScaledInstance(705, 791, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l2 = new JLabel(i6);
        l2.setBounds(780, 95, 705, 791);
        add(l2);

        b1 = new JButton("Gaurav Singh");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(300, 900, 150, 40);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Nitish Singh");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(1100, 900, 150, 40);
        b2.addActionListener(this);
        add(b2);

        setTitle("Devs");
        setBounds(300, 30, 1550, 1000);
        getContentPane().setBackground(Color.decode("#004C99"));

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            setVisible(false);
            try {
                Desktop.getDesktop().browse(new URL("https://www.linkedin.com/in/gauravsingh9356/").toURI());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (ae.getSource() == b2) {
            setVisible(false);
            try {
                Desktop.getDesktop()
                        .browse(new URL("https://www.linkedin.com/in/nitish-kumar-singh-b8b61a1b8").toURI());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new AboutDev();
    }
}