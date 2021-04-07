package traveltourism;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatBot extends JFrame implements ActionListener {
    private JTextArea chatArea = new JTextArea();
    private JTextField chatBox = new JTextField();
    JButton sendButton;

    ChatBot(String username) {
        chatArea.append("***********************Hello " + username + "***************************\n");

        getContentPane().setBackground(Color.decode("#004C99"));
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setBounds(100, 300, 1310, 600);
        setTitle("Chat Bot");

        add(chatBox);

        // textArea
        chatArea.setBounds(40, 40, 610, 420);
        chatArea.setBackground(Color.BLACK);
        chatArea.setForeground(Color.WHITE);
        chatArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
        // JScrollPane scroll = new JScrollPane(chatArea);
        // scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(chatArea);
        // chatBox
        chatBox.setBounds(70, 490, 400, 30);

        // button send
        sendButton = new JButton("Send");
        sendButton.addActionListener(this);
        sendButton.setBounds(500, 490, 125, 33);
        sendButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        sendButton.setBackground(Color.BLACK);
        sendButton.setForeground(Color.WHITE);
        add(sendButton);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("traveltourism/icons/icons/bot.jpg"));
        Image i3 = i1.getImage().getScaledInstance(606, 540, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l2 = new JLabel(i2);
        l2.setBounds(670, 7, 606, 540);
        add(l2);

        chatBox.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == chatBox || ae.getSource() == sendButton) {
            String text = chatBox.getText().toLowerCase();
            chatArea.append("You->  " + text + "\n");
            chatBox.setText("");
            if (text.contains("hi")) {
                bot("Helloooo! Welcome from GN Tours and Services");
            } else if (text.contains("created you?")) {
                bot("I am developed by Gaurav and Nitish");
            } else if (text.contains("who are you?")) {
                bot("I am simply a chatBot!");
            } else if (text.contains("who is gaurav?")) {
                bot("He is my Master!");
            } else if (text.contains("query")) {
                bot("Please elaborate more on your query!");
            } else if (text.contains("what is your working hour?")) {
                bot("We work 24/7 for you!");
            } else if (text.contains("toll-free number?")) {
                bot("You can call us at 1800 3600 4545. It's free");
            } else if (text.contains("diamond package price")) {
                bot("Rs 32000/- Only!");
            } else if (text.contains("gold package price")) {
                bot("Rs 24000/- Only!");
            } else if (text.contains("platinum package price")) {
                bot("Rs 12000/- Only!");
            } else if (text.contains("bye")) {
                bot("Bye! Have a Nice Day");
            } else {
                bot("I don't understand you!");
            }
        }
    }

    private void bot(String string) {
        chatArea.append("BOT->  " + string + "\n");
    }

    public static void main(String[] args) {
        new ChatBot("");
    }
}
