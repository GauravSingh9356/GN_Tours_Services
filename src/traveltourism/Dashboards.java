package traveltourism;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Dashboards extends JFrame implements ActionListener {
    String username;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19;

    Dashboards(String user) {
        username = user;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0, 1950, 140);
        p1.setBackground(Color.BLACK);
        add(p1);

        /*
         * JPanel p2 = new JPanel(); p2.setLayout(null); p2.setBounds(0, 60, 300, 1000);
         * //p2.setBackground(Color.BLACK); add(p2);
         */

        // background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("traveltourism/icons/icons/dash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 140, 1950, 1000);
        add(l1);

        // logo

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("traveltourism/icons/icons/logo.jpg"));
        Image i5 = i4.getImage().getScaledInstance(100, 170, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l2 = new JLabel(i6);

        l2.setBounds(690, 0, 120, 150);
        p1.add(l2);

        // Welcome Text
        JLabel l4 = new JLabel("Welcome " + username);
        l4.setFont(new Font("Courier New Italic", Font.BOLD, 35));
        l4.setForeground(Color.WHITE);
        l4.setBounds(20, 10, 500, 120);
        p1.add(l4);

        b16 = new JButton("logout");
        b16.setFont(new Font("Courier New Italic", Font.BOLD, 35));
        b16.setForeground(Color.WHITE);
        b16.setBackground(Color.BLACK);
        b16.setBounds(1640, 10, 250, 120);
        b16.setBorder(BorderFactory.createEmptyBorder());
        b16.setContentAreaFilled(false);
        b16.setBorderPainted(false);
        b16.setRolloverEnabled(false);
        b16.setFocusable(false);
        b16.addActionListener(this);
        p1.add(b16);

        // Home Text
        JLabel l3 = new JLabel("GN Tours and Services");
        l3.setFont(new Font("Tahoma", Font.BOLD, 40));
        l3.setForeground(Color.WHITE);
        l3.setBounds(800, 10, 500, 120);
        p1.add(l3);

        JPanel p3 = new JPanel();
        p3.setBounds(1600, 225, 300, 1000);
        // p3.setBackground(Color.BLACK);
        p3.setLayout(null);

        // adding buttons

        b1 = new JButton("Registration");
        b1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.setBounds(0, 0, 300, 45);
        b1.addActionListener(this);
        p3.add(b1);

        b2 = new JButton("Update Details");
        b2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(0, 45, 300, 45);
        b2.addActionListener(this);
        p3.add(b2);

        b3 = new JButton("View Details");
        b3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b3.setBackground(Color.BLUE);
        b3.setForeground(Color.WHITE);
        b3.setBounds(0, 85, 300, 45);
        b3.addActionListener(this);
        p3.add(b3);

        b5 = new JButton("Check Package");
        b5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setBounds(0, 125, 300, 45);
        b5.addActionListener(this);
        p3.add(b5);

        b6 = new JButton("Book Package");
        b6.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b6.setBackground(Color.BLUE);
        b6.setForeground(Color.WHITE);
        b6.setBounds(0, 165, 300, 45);
        b6.addActionListener(this);
        p3.add(b6);

        b7 = new JButton("View Package");
        b7.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        b7.setBounds(0, 205, 300, 45);
        b7.addActionListener(this);
        p3.add(b7);

        b8 = new JButton("View Hotels");
        b8.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b8.setBackground(Color.BLUE);
        b8.setForeground(Color.WHITE);
        b8.addActionListener(this);
        b8.setBounds(0, 245, 300, 45);
        p3.add(b8);

        b9 = new JButton("Book Hotel");
        b9.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b9.setBackground(Color.BLACK);
        b9.setForeground(Color.WHITE);
        b9.addActionListener(this);
        b9.setBounds(0, 285, 300, 45);
        p3.add(b9);

        b10 = new JButton("View Booked Hotel");
        b10.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b10.setBackground(Color.BLUE);
        b10.setForeground(Color.WHITE);
        b10.addActionListener(this);
        b10.setBounds(0, 325, 300, 45);
        p3.add(b10);

        b11 = new JButton("Destination");
        b11.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b11.setBackground(Color.BLACK);
        b11.setForeground(Color.WHITE);
        b11.setBounds(0, 365, 300, 45);
        b11.addActionListener(this);
        p3.add(b11);

        b12 = new JButton("Payment");
        b12.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b12.setBackground(Color.BLUE);
        b12.setForeground(Color.WHITE);
        b12.setBounds(0, 405, 300, 45);
        b12.addActionListener(this);

        p3.add(b12);

        b13 = new JButton("Calculator");
        b13.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b13.setBackground(Color.BLACK);
        b13.setForeground(Color.WHITE);
        b13.setBounds(0, 445, 300, 45);
        b13.addActionListener(this);
        p3.add(b13);

        b14 = new JButton("Notepad");
        b14.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b14.setBackground(Color.BLUE);
        b14.setForeground(Color.WHITE);
        b14.setBounds(0, 485, 300, 45);
        b14.addActionListener(this);
        p3.add(b14);

        b15 = new JButton("About Us");
        b15.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b15.setBackground(Color.BLACK);
        b15.setForeground(Color.WHITE);
        b15.addActionListener(this);
        b15.setBounds(0, 525, 300, 45);
        p3.add(b15);

        b17 = new JButton("Chat Us!");
        b17.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b17.setBackground(Color.BLUE);
        b17.setForeground(Color.WHITE);
        b17.addActionListener(this);
        b17.setBounds(0, 565, 300, 45);
        p3.add(b17);

        b18 = new JButton("Review Us!");
        b18.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b18.setBackground(Color.BLACK);
        b18.setForeground(Color.WHITE);
        b18.addActionListener(this);
        b18.setBounds(0, 605, 300, 45);
        p3.add(b18);

        b19 = new JButton("About Team!");
        b19.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b19.setBackground(Color.BLUE);
        b19.setForeground(Color.WHITE);
        b19.addActionListener(this);
        b19.setBounds(0, 645, 300, 45);
        p3.add(b19);

        add(p3);
        add(p1);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            new AddCustomer(username);
        }
        if (ae.getSource() == b2) {
            new UpdateCustomer(username);
        }
        if (ae.getSource() == b3) {
            new ViewCustomer(username);
        }
        if (ae.getSource() == b5) {
            try {
                new CheckPackage(username);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        if (ae.getSource() == b6) {
            new BookPackage(username);
        }
        if (ae.getSource() == b7) {
            new ViewBookedPackage(username);
        }
        if (ae.getSource() == b8) {
            new CheckHotels();
        }
        if (ae.getSource() == b9) {
            new BookHotel(username);
        }
        if (ae.getSource() == b10) {
            new ViewBookedHotel(username);
        }
        if (ae.getSource() == b11) {
            new Destinations();
        }
        if (ae.getSource() == b12) {
            new Payments(username);
        }
        if (ae.getSource() == b16) {
            int result = JOptionPane.showConfirmDialog(null, "Sure? You want to logout?", "Message",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            // yes option value is 0 no option value is 1
            if (result == 0) {
                setVisible(false);
                JOptionPane.showMessageDialog(null, "Thanks for using our services. Hope to see you soon!", "Message",
                        JOptionPane.INFORMATION_MESSAGE);
                new Logins();
            }
        }
        if (ae.getSource() == b15) {
            new About();
        }
        if (ae.getSource() == b17) {
            new ChatBot(username);
        }
        if (ae.getSource() == b18) {
            new Review();
        }
        if (ae.getSource() == b19) {
            new AboutDev();
        }
        if (ae.getSource() == b13)
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
            }
        else if (ae.getSource() == b14)
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
            }
    }

    public static void main(String[] args) {
        new Dashboards("GS");
    }
}