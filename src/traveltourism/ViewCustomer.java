package traveltourism;

import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewCustomer extends JFrame implements ActionListener {
    String username;
    JButton btnBack;
    JPanel contentPane;
    JLabel l3a, lblIda, l2a, lblName_1a, lblGendera, lblCountrya, lblReserveRoomNumbera, lblCheckInStatusa,
            lblDepositea;

    ViewCustomer(String user) {
        username = user;
        setBounds(500, 220, 1200, 680);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("traveltourism/icons/icons/viewall.jpg"));
        Image i3 = i1.getImage().getScaledInstance(626, 201, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(200, 370, 626, 201);
        add(l1);

        JLabel l3 = new JLabel("Username :");
        l3.setBounds(20, 20, 200, 14);
        contentPane.add(l3);

        l3a = new JLabel();
        l3a.setBounds(230, 20, 200, 14);
        contentPane.add(l3a);

        JLabel lblId = new JLabel("ID :");
        lblId.setBounds(20, 60, 200, 14);
        contentPane.add(lblId);

        lblIda = new JLabel();
        lblIda.setBounds(230, 60, 200, 14);
        contentPane.add(lblIda);

        JLabel l2 = new JLabel("Number :");
        l2.setBounds(20, 100, 200, 14);
        contentPane.add(l2);

        l2a = new JLabel();
        l2a.setBounds(230, 100, 200, 14);
        contentPane.add(l2a);

        JLabel lblName_1 = new JLabel("Name :");
        lblName_1.setBounds(20, 140, 200, 14);
        contentPane.add(lblName_1);

        lblName_1a = new JLabel();
        lblName_1a.setBounds(230, 140, 200, 14);
        contentPane.add(lblName_1a);

        JLabel lblGender = new JLabel("Gender :");
        lblGender.setBounds(20, 180, 200, 14);
        contentPane.add(lblGender);

        lblGendera = new JLabel();
        lblGendera.setBounds(230, 180, 200, 14);
        contentPane.add(lblGendera);

        JLabel lblCountry = new JLabel("Country :");
        lblCountry.setBounds(500, 20, 200, 14);
        contentPane.add(lblCountry);

        lblCountrya = new JLabel();
        lblCountrya.setBounds(710, 20, 200, 14);
        contentPane.add(lblCountrya);

        JLabel lblReserveRoomNumber = new JLabel("Permanent Address :");
        lblReserveRoomNumber.setBounds(500, 60, 200, 14);
        contentPane.add(lblReserveRoomNumber);

        lblReserveRoomNumbera = new JLabel();
        lblReserveRoomNumbera.setBounds(710, 60, 200, 14);
        contentPane.add(lblReserveRoomNumbera);

        JLabel lblCheckInStatus = new JLabel("Phone :");
        lblCheckInStatus.setBounds(500, 100, 200, 14);
        contentPane.add(lblCheckInStatus);

        lblCheckInStatusa = new JLabel();
        lblCheckInStatusa.setBounds(710, 100, 200, 14);
        contentPane.add(lblCheckInStatusa);

        JLabel lblDeposite = new JLabel("Email :");
        lblDeposite.setBounds(500, 140, 200, 14);
        contentPane.add(lblDeposite);

        lblDepositea = new JLabel();
        lblDepositea.setBounds(710, 140, 200, 14);
        contentPane.add(lblDepositea);

        btnBack = new JButton("Back");
        btnBack.setBounds(430, 300, 120, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        btnBack.addActionListener(this);
        contentPane.add(btnBack);

        try {
            Conn c = new Conn();
            String query = "select * from customer where username='" + username + "'";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {

                l3a.setText(rs.getString("username"));
                lblIda.setText(rs.getString("id"));
                l2a.setText(rs.getString("number"));
                lblName_1a.setText(rs.getString("name"));
                lblGendera.setText(rs.getString("gender"));
                lblCountrya.setText(rs.getString("country"));
                lblReserveRoomNumbera.setText(rs.getString("address"));
                lblCheckInStatusa.setText(rs.getString("phone"));
                lblDepositea.setText(rs.getString("email"));
                // System.out.println(lblDepositea.getText());
                // System.out.println("Here");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnBack) {
            setVisible(false);
            // new Dashboard();
        }
    }

    public static void main(String[] args) {
        new ViewCustomer("Gaurav Singh");
    }
}
