package traveltourism;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.google.gson.*;
import java.util.HashMap;
import java.util.Map;
import com.stripe.exception.StripeException;
import com.stripe.Stripe;

import com.stripe.model.Customer;
import com.stripe.model.Token;
import com.stripe.param.CustomerRetrieveParams;

public class StripePY extends JFrame {
    JTextField username, email, year, month, cvv, number;

    StripePY(String user) {
        setLayout(null);
        JLabel l4 = new JLabel("Payment Gateway: STRIPE");
        l4.setForeground(Color.BLACK);
        l4.setBounds(50, 20, 400, 34);
        l4.setFont(new Font("Tahoma", Font.BOLD, 28));
        add(l4);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("traveltourism/icons/icons/stripeY.png"));
        Image i8 = i7.getImage().getScaledInstance(600, 408, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel l5 = new JLabel(i9);
        l5.setBounds(460, 25, 600, 408);
        add(l5);

        JLabel l3 = new JLabel("Username :");
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Tahoma", Font.BOLD, 18));
        l3.setBounds(65, 100, 200, 14);
        add(l3);

        username = new JTextField(user);
        username.setBounds(271, 100, 150, 20);
        add(username);
        username.setColumns(10);

        JLabel lblemail = new JLabel("Email :");
        lblemail.setForeground(Color.BLACK);
        lblemail.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblemail.setBounds(65, 140, 150, 14);
        add(lblemail);

        email = new JTextField();
        email.setBounds(271, 140, 150, 20);
        add(email);

        JLabel l2 = new JLabel("Card Number :");
        l2.setFont(new Font("Tahoma", Font.BOLD, 18));
        l2.setForeground(Color.BLACK);
        l2.setBounds(65, 180, 200, 14);
        add(l2);

        number = new JTextField();
        number.setBounds(271, 180, 150, 20);
        add(number);
        number.setColumns(10);

        JLabel lblName_1 = new JLabel("Expire Year:");
        lblName_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblName_1.setForeground(Color.BLACK);
        lblName_1.setBounds(65, 220, 200, 20);
        add(lblName_1);

        year = new JTextField();
        year.setBounds(271, 220, 150, 20);
        add(year);
        year.setColumns(10);

        JLabel lblName_2 = new JLabel("Expire Month:");
        lblName_2.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblName_2.setForeground(Color.BLACK);
        lblName_2.setBounds(65, 260, 200, 20);
        add(lblName_2);

        month = new JTextField();
        month.setBounds(271, 260, 150, 20);
        add(month);
        month.setColumns(10);

        JLabel lblName_3 = new JLabel("CVV:");
        lblName_3.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblName_3.setForeground(Color.BLACK);
        lblName_3.setBounds(65, 304, 200, 14);
        add(lblName_3);

        cvv = new JTextField();
        cvv.setBounds(271, 304, 150, 20);
        add(cvv);
        cvv.setColumns(10);

        JButton Submit = new JButton("Submit");
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.WHITE);
        Submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String emailValue = email.getText();
                    String usernameValue = username.getText();
                    Stripe.apiKey = "sk_test_51Ib2kWSEw6FAIm6XCdgACg4POrw5qG0wocT1K59WHb47SM4Djd1WNiOh8SXlrsbgGdpiE99iG0sfi2YVikcO0sfE00Sf3YPqGJ";
                    Map<String, Object> customerParameter = new HashMap<String, Object>();
                    customerParameter.put("email", emailValue);
                    customerParameter.put("name", usernameValue);

                    Map<String, Object> cardParameter = new HashMap<String, Object>();
                    cardParameter.put("number", number.getText());
                    cardParameter.put("exp_month", month.getText());
                    cardParameter.put("exp_year", year.getText());
                    cardParameter.put("cvc", cvv.getText());

                    // implemented in version above 20.0.1
                    CustomerRetrieveParams retrieveParams = CustomerRetrieveParams.builder().addExpand("sources")
                            .build();

                    Map<String, Object> tokenParameter = new HashMap<String, Object>();
                    tokenParameter.put("card", cardParameter);

                    // craete token
                    Token token = Token.create(tokenParameter);

                    Customer newCustomer = Customer.create(customerParameter);

                    String uniqueId = newCustomer.getId();

                    // retrive the customer
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();

                    Customer a = Customer.retrieve(uniqueId, retrieveParams, null);

                    Map<String, Object> source = new HashMap<String, Object>();
                    source.put("source", token.getId());

                    a.getSources().create(source);
                    System.out.println(gson.toJson(a));
                    JOptionPane.showMessageDialog(null, "Card Information Added Successfully!", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null, "Unique Id is " + newCustomer.getId(), "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                } catch (Exception err) {
                    System.out.println(err.getMessage());
                }

            }
        });
        Submit.setBounds(250, 370, 100, 40);
        add(Submit);

        setSize(1100, 500);
        setLocation(600, 220);
        setVisible(true);
        getContentPane().setBackground(Color.decode("#004C99"));
    }

    public static void main(String[] args) {
        new StripePY("");
    }
}