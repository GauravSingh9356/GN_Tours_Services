package traveltourism;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckPackage extends JFrame implements ActionListener {
    String username;
    JButton b1;

    CheckPackage(String user) {
        username = user;
        setBounds(600, 250, 900, 600);
        String[] data1 = new String[] { "PLATINUM TOUR", "6 Days and 7 Nights", "Airport Assistance",
                "Half Day City Tour", "Daily Buffet", "Welcome Drinks", "Full Day 3 Island Cruise", "Speaking Guides",
                "Book Now", "SUMMER SPECIAL!", "Rs 12000/-", "package1.jpg" };
        String[] data2 = new String[] { "GOLD TOUR", "5 Days and 6 Nights", "Entrance Free Tickets",
                "Greetings at Airport", "Welcome Drinks", "Night Safari", "Full Day 3 Island Cruise",
                "Cruise with Dinner", "Book Now", "WINTER SPECIAL!", "Rs 24000/-", "package2.jpg" };

        String[] data3 = new String[] { "DIAMOND TOUR", "5 Days and 6 Nights", "Return Airfare",
                "Free Clubbing, Horse Riding,etc", "Daily Buffet", "Welcome Drinks", "Stay in 5 Star Hotel",
                "BBQ Dinner", "Book Now", "WINTER SPECIAL!", "Rs 32000/-", "package3.jpg" };

        JPanel p1 = createPackage(data1);
        JPanel p2 = createPackage(data2);
        JPanel p3 = createPackage(data3);

        JTabbedPane pane = new JTabbedPane();

        pane.addTab("Package 1", p1);
        pane.addTab("Package 2", p2);
        pane.addTab("Package 3", p3);
        add(pane, BorderLayout.CENTER);

        setVisible(true);
    }

    public JPanel createPackage(String data[]) {

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.decode("#004C99"));

        JLabel l1 = new JLabel(data[0]);
        l1.setFont(new Font("Tahoma", Font.BOLD, 30));
        l1.setForeground(Color.BLACK);
        l1.setBounds(10, 5, 300, 30);
        p1.add(l1);

        JLabel l2 = new JLabel(data[1]);
        l2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        l2.setForeground(Color.BLACK);
        l2.setBounds(30, 60, 300, 30);
        p1.add(l2);

        JLabel l3 = new JLabel(data[2]);
        l3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        l3.setForeground(Color.BLACK);
        l3.setBounds(30, 110, 300, 30);
        p1.add(l3);

        JLabel l4 = new JLabel(data[3]);
        l4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        l4.setBounds(30, 160, 300, 30);

        l4.setForeground(Color.BLACK);
        p1.add(l4);

        JLabel l5 = new JLabel(data[4]);
        l5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        l5.setForeground(Color.BLACK);
        l5.setBounds(30, 210, 300, 30);
        p1.add(l5);

        JLabel l6 = new JLabel(data[5]);
        l6.setFont(new Font("Tahoma", Font.PLAIN, 20));
        l6.setBounds(30, 260, 300, 30);
        l6.setForeground(Color.BLACK);
        p1.add(l6);

        JLabel l7 = new JLabel(data[6]);
        l7.setFont(new Font("Tahoma", Font.PLAIN, 20));
        l7.setBounds(30, 310, 300, 30);
        l7.setForeground(Color.BLACK);
        p1.add(l7);

        JLabel l8 = new JLabel(data[7]);
        l8.setFont(new Font("Tahoma", Font.PLAIN, 20));
        l8.setBounds(30, 360, 300, 30);
        l8.setForeground(Color.BLACK);
        p1.add(l8);

        b1 = new JButton(data[8]);
        b1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(30, 460, 210, 45);
        b1.addActionListener(this);
        p1.add(b1);

        JLabel l10 = new JLabel(data[9]);
        l10.setFont(new Font("Tahoma", Font.BOLD, 25));
        l10.setBounds(300, 470, 300, 30);
        l10.setForeground(Color.BLACK);
        p1.add(l10);

        JLabel l11 = new JLabel(data[10]);
        l11.setFont(new Font("Tahoma", Font.BOLD, 25));
        l11.setBounds(680, 470, 300, 30);
        l11.setForeground(Color.RED);
        p1.add(l11);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("traveltourism/icons/icons/" + data[11]));
        Image i2 = i1.getImage().getScaledInstance(500, 380, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(350, 35, 500, 380);
        p1.add(l12);
        return p1;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            System.out.println("Here");
            new BookPackage(username);
        }
    }

    public static void main(String[] args) {
        new CheckPackage("GS");
    }
}
