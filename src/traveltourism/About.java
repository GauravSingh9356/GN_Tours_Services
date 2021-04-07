package traveltourism;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class About extends JFrame implements ActionListener {
    String s = "\t\t           About Us         \n  " + "\nThe objective of the GN Tours and Services "
            + "project is to develop a system that automates the processes "
            + "and activities of a travel and the purpose is to design a "
            + "system using which one can perform all operations related to " + "traveling.\n\n"
            + "This application will help in accessing the information related "
            + "to the travel to the particular destination with great ease. ";
    JButton b1, b2;

    About() {
        setBounds(800, 240, 1000, 550);
        getContentPane().setBackground(Color.decode("#004C99"));
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("traveltourism/icons/icons/about.png"));
        Image i2 = i1.getImage().getScaledInstance(484, 438, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel l2 = new JLabel(i3);
        l2.setBounds(500, 50, 484, 438);
        add(l2);

        JLabel l1 = new JLabel("GN Tours and Services");
        l1.setBounds(320, 2, 400, 80);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Tahoma", Font.BOLD, 28));

        TextArea t1 = new TextArea(s, 10, 40, Scrollbar.VERTICAL);
        t1.setEditable(false);
        t1.setBounds(20, 100, 450, 300);
        t1.setFont(new Font("Thoma", Font.PLAIN, 18));
        add(t1);
        add(l1);

        b1 = new JButton("Gaurav Singh");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(80, 420, 150, 25);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Nitish Singh");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(260, 420, 150, 25);
        b2.addActionListener(this);
        add(b2);

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
        new About();
    }
}
