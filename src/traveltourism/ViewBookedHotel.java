package traveltourism;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewBookedHotel extends JFrame {
    private JPanel contentPane;
    Choice c1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewBookedHotel frame = new ViewBookedHotel("GS");
                    frame.setVisible(true);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });
    }

    public ViewBookedHotel(String username) {
        setBounds(580, 220, 1300, 600);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("traveltourism/icons/icons/bookedDetails.jpg"));
        Image i3 = i1.getImage().getScaledInstance(730, 500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(510, 10, 760, 540);
        add(la1);

        JLabel lblName = new JLabel("VIEW BOOKED HOTEL DETAILS");
        lblName.setFont(new Font("Yu Mincho", Font.BOLD, 20));
        lblName.setForeground(Color.BLACK);
        lblName.setBounds(88, 11, 350, 53);
        contentPane.add(lblName);

        JLabel lb3 = new JLabel("Username :");
        lb3.setFont(new Font("Yu Mincho", Font.BOLD, 16));
        lb3.setForeground(Color.BLACK);
        lb3.setBounds(35, 70, 200, 16);
        contentPane.add(lb3);

        JLabel l1 = new JLabel();
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Yu Mincho", Font.BOLD, 18));
        l1.setBounds(271, 70, 200, 16);
        contentPane.add(l1);

        JLabel lblId = new JLabel("Name :");
        lblId.setForeground(Color.BLACK);
        lblId.setFont(new Font("Yu Mincho", Font.BOLD, 16));
        lblId.setBounds(35, 110, 200, 16);
        contentPane.add(lblId);

        JLabel l2 = new JLabel();
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Yu Mincho", Font.BOLD, 18));
        l2.setBounds(271, 110, 250, 16);
        contentPane.add(l2);

        JLabel lb2 = new JLabel("Number of Persons :");
        lb2.setFont(new Font("Yu Mincho", Font.BOLD, 16));
        lb2.setForeground(Color.BLACK);
        lb2.setBounds(35, 150, 200, 16);
        contentPane.add(lb2);

        JLabel l3 = new JLabel();
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Yu Mincho", Font.BOLD, 18));
        l3.setBounds(271, 150, 200, 16);
        contentPane.add(l3);

        JLabel lblName_1 = new JLabel("Number of Days :");
        lblName_1.setFont(new Font("Yu Mincho", Font.BOLD, 16));
        lblName_1.setForeground(Color.BLACK);
        lblName_1.setBounds(35, 190, 200, 16);
        contentPane.add(lblName_1);

        JLabel l4 = new JLabel();
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Yu Mincho", Font.BOLD, 18));
        l4.setBounds(271, 190, 200, 16);
        contentPane.add(l4);

        JLabel lblGender = new JLabel("AC / Non-AC :");
        lblGender.setFont(new Font("Yu Mincho", Font.BOLD, 16));
        lblGender.setForeground(Color.BLACK);
        lblGender.setBounds(35, 230, 200, 16);
        contentPane.add(lblGender);

        JLabel l5 = new JLabel();
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("Yu Mincho", Font.BOLD, 18));
        l5.setBounds(271, 230, 200, 16);
        contentPane.add(l5);

        JLabel lblCountry = new JLabel("Food Included (Yes/No) :");
        lblCountry.setFont(new Font("Yu Mincho", Font.BOLD, 16));
        lblCountry.setForeground(Color.BLACK);
        lblCountry.setBounds(35, 270, 200, 16);
        contentPane.add(lblCountry);

        JLabel l6 = new JLabel();
        l6.setForeground(Color.BLACK);
        l6.setFont(new Font("Yu Mincho", Font.BOLD, 18));
        l6.setBounds(271, 270, 200, 16);
        contentPane.add(l6);

        JLabel lblReserveRoomNumber = new JLabel("ID :");
        lblReserveRoomNumber.setFont(new Font("Yu Mincho", Font.BOLD, 16));
        lblReserveRoomNumber.setBounds(35, 310, 200, 16);
        lblReserveRoomNumber.setForeground(Color.BLACK);
        contentPane.add(lblReserveRoomNumber);

        JLabel l7 = new JLabel();
        l7.setForeground(Color.BLACK);
        l7.setBounds(271, 310, 200, 16);
        l7.setFont(new Font("Yu Mincho", Font.BOLD, 18));
        contentPane.add(l7);

        JLabel lblCheckInStatus = new JLabel("Number :");
        lblCheckInStatus.setFont(new Font("Yu Mincho", Font.BOLD, 16));
        lblCheckInStatus.setForeground(Color.BLACK);
        lblCheckInStatus.setBounds(35, 350, 200, 16);
        contentPane.add(lblCheckInStatus);

        JLabel l8 = new JLabel();
        l8.setForeground(Color.BLACK);
        l8.setFont(new Font("Yu Mincho", Font.BOLD, 18));
        l8.setBounds(271, 350, 200, 16);
        contentPane.add(l8);

        JLabel lblDeposite = new JLabel("Phone :");
        lblDeposite.setFont(new Font("Yu Mincho", Font.BOLD, 16));
        lblDeposite.setForeground(Color.BLACK);
        lblDeposite.setBounds(35, 390, 200, 16);
        contentPane.add(lblDeposite);

        JLabel l9 = new JLabel();
        l9.setForeground(Color.BLACK);
        l9.setFont(new Font("Yu Mincho", Font.BOLD, 18));
        l9.setBounds(271, 390, 200, 16);
        contentPane.add(l9);

        JLabel la2 = new JLabel("Cost :");
        la2.setFont(new Font("Yu Mincho", Font.BOLD, 16));
        la2.setForeground(Color.BLACK);
        la2.setBounds(35, 430, 200, 16);
        contentPane.add(la2);

        JLabel l10 = new JLabel();
        l10.setForeground(Color.BLACK);
        l10.setFont(new Font("Yu Mincho", Font.BOLD, 18));
        l10.setBounds(271, 430, 200, 16);
        contentPane.add(l10);

        Conn c = new Conn();
        try {

            ResultSet rs = c.s.executeQuery("select * from bookhotel where username = '" + username + "'");
            while (rs.next()) {
                l1.setText(rs.getString(1));
                l2.setText(rs.getString(2));
                l3.setText(rs.getString(3));
                l4.setText(rs.getString(4));
                l5.setText(rs.getString(5));
                l6.setText(rs.getString(6));
                l7.setText(rs.getString(7));
                l8.setText(rs.getString(8));
                l9.setText(rs.getString(9));
                l10.setText(rs.getString(10));

            }

            rs.close();
        } catch (SQLException e) {
        }

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        btnExit.setBounds(160, 470, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);
        setVisible(true);

        getContentPane().setBackground(Color.decode("#004C99"));

    }
}