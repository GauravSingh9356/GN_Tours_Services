/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traveltourism;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.border.EmptyBorder;

public class ForgetPassword extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JTextField t1, t2, t3, t4, t5;
	private JButton b1, b2, b3;

	ForgetPassword() {

		setBounds(500, 200, 850, 400);
		contentPane = new JPanel();
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);

		JLabel l1 = new JLabel("Username");
		l1.setFont(new Font("Tahoma", Font.BOLD, 13));
		l1.setForeground(Color.WHITE);
		l1.setBounds(109, 83, 87, 29);
		contentPane.add(l1);

		JLabel l2 = new JLabel("Name");
		l2.setFont(new Font("Tahoma", Font.BOLD, 13));
		l2.setForeground(Color.WHITE);
		l2.setBounds(109, 122, 75, 21);
		contentPane.add(l2);

		JLabel l3 = new JLabel("Your Security Question");
		l3.setFont(new Font("Tahoma", Font.BOLD, 13));
		l3.setForeground(Color.WHITE);
		l3.setBounds(109, 154, 156, 27);
		contentPane.add(l3);

		JLabel l4 = new JLabel("Answer");
		l4.setFont(new Font("Tahoma", Font.BOLD, 13));
		l4.setForeground(Color.WHITE);
		l4.setBounds(109, 192, 104, 21);
		contentPane.add(l4);

		JLabel l5 = new JLabel("Password");
		l5.setFont(new Font("Tahoma", Font.BOLD, 13));
		l5.setForeground(Color.WHITE);
		l5.setBounds(109, 224, 104, 21);
		contentPane.add(l5);

		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.BOLD, 13));
		t1.setForeground(new Color(105, 105, 105));
		t1.setBounds(277, 88, 139, 20);
		contentPane.add(t1);
		t1.setColumns(10);

		t2 = new JTextField();
		t2.setEditable(false);
		t2.setFont(new Font("Tahoma", Font.BOLD, 13));
		t2.setForeground(new Color(165, 42, 42));
		t2.setColumns(10);
		t2.setBounds(277, 123, 139, 20);
		contentPane.add(t2);

		t3 = new JTextField();
		t3.setEditable(false);
		t3.setFont(new Font("Tahoma", Font.BOLD, 12));
		t3.setForeground(new Color(72, 61, 139));
		t3.setColumns(10);
		t3.setBounds(277, 161, 221, 20);
		contentPane.add(t3);

		t4 = new JTextField();
		t4.setFont(new Font("Tahoma", Font.BOLD, 13));
		t4.setForeground(new Color(205, 92, 92));
		t4.setEditable(false);
		t4.setColumns(10);
		t4.setBounds(277, 193, 139, 20);
		contentPane.add(t4);

		t5 = new JTextField();
		t5.setEditable(false);
		t5.setFont(new Font("Tahoma", Font.BOLD, 13));
		t5.setForeground(new Color(50, 205, 50));
		t5.setColumns(10);
		t5.setBounds(277, 225, 139, 20);
		contentPane.add(t5);

		ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("traveltourism/icons/icons/forgotpassword.jpg"));
		Image i1 = c1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i1);

		JLabel l6 = new JLabel(i2);
		l6.setBounds(590, 70, 200, 200);
		add(l6);

		b1 = new JButton("Search");
		b1.addActionListener(this);
		b1.setFont(new Font("Tahoma", Font.BOLD, 12));
		b1.setBounds(428, 83, 80, 29);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		contentPane.add(b1);

		b2 = new JButton("Retrieve");
		b2.addActionListener(this);
		b2.setFont(new Font("Tahoma", Font.BOLD, 12));
		b2.setBounds(426, 188, 90, 29);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setEnabled(false);
		contentPane.add(b2);

		b3 = new JButton("Back");
		b3.addActionListener(this);
		b3.setFont(new Font("Tahoma", Font.BOLD, 13));
		b3.setBounds(233, 270, 101, 29);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		contentPane.add(b3);

		JPanel panel = new JPanel();
		panel.setBounds(47, 45, 508, 281);
		panel.setBackground(Color.decode("#004C99"));
		contentPane.add(panel);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			Conn c = new Conn();
			if (e.getSource() == b1) {
				String sql = "select * from account where username='" + t1.getText() + "'"; // making query first
				ResultSet rs = c.s.executeQuery(sql); // sql pacvkage class to get the sql table result
				while (rs.next()) {
					t2.setText(rs.getString("name"));
					t3.setText(rs.getString("security"));
				}
				t4.setEditable(true);
				b2.setEnabled(true);
			}
			if (e.getSource() == b2) {
				String sql = "select * from account where username='" + t1.getText() + "'"; // making query first
				ResultSet rs = c.s.executeQuery(sql); // sql pacvkage class to get the sql table result
				// System.out.println("Worked here");

				String userAnswer = t4.getText();
				// System.out.println(userAnswer);
				if (!userAnswer.isEmpty()) {
					String actualAnswer = "", password = "";

					while (rs.next()) {
						actualAnswer = rs.getString("answer");
						password = rs.getString("password");
					}

					if (actualAnswer.equals(userAnswer)) {
						Encrypt encrypt = new Encrypt();
						password = encrypt.decrypt(password);
						t5.setText(password);
					} else {
						JOptionPane.showMessageDialog(null, "Security Answer did not match!", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please fill the answer!", "Message",
							JOptionPane.WARNING_MESSAGE);
				}
			}
			if (e.getSource() == b3) {
				this.setVisible(false);
				new Logins();
			}
		} catch (Exception error) {
			System.out.print(error.getMessage());
		}
	}

	public static void main(String args[]) {
		new ForgetPassword();
	}
}
