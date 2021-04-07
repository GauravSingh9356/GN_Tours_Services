package traveltourism;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Loading extends JFrame implements Runnable {

    private JPanel contentPane;
    private JProgressBar progressBar;
    Connection conn;
    String username;
    int s;
    Thread th;

    public static void main(String[] args) {
        new Loading("").setVisible(true);
    }

    public void setUploading() {
        setVisible(false);
        th.start();
    }

    public void run() {
        try {
            while (progressBar.getValue() < progressBar.getMaximum()) {

                progressBar.setValue(progressBar.getValue() + 1);
                Thread.sleep(50);
            }
            // if (progressBar.getValue() == 100)
            setVisible(false);
            new Dashboards(username).setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Loading(String username) {
        UIManager.put("ProgressBar.foreground", Color.decode("#004C99"));
        UIManager.put("ProgressBar.selectionBackground", Color.GREEN);
        // UIManager.put("ProgressBar.selectionForeground", Color.GREEN);
        this.username = username;
        th = new Thread((Runnable) this);

        setBounds(600, 300, 600, 400);
        contentPane = new JPanel();
        contentPane.setBackground(Color.decode("#004C99"));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbllibraryManagement = new JLabel("GN Tours and Services");
        lbllibraryManagement.setForeground(Color.decode("#004C99"));
        lbllibraryManagement.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
        lbllibraryManagement.setBounds(115, 46, 700, 35);
        contentPane.add(lbllibraryManagement);

        progressBar = new JProgressBar();
        progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
        progressBar.setStringPainted(true);
        progressBar.setBounds(130, 135, 300, 25);

        contentPane.add(progressBar);

        JLabel lblNewLabel_2 = new JLabel("Please Wait....");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_2.setForeground(Color.BLACK);

        lblNewLabel_2.setBounds(225, 165, 150, 20);
        contentPane.add(lblNewLabel_2);

        JLabel welcomeLabel_3 = new JLabel("Welcome " + username);
        welcomeLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
        welcomeLabel_3.setForeground(Color.BLACK);
        welcomeLabel_3.setBounds(225, 340, 300, 40);
        contentPane.add(welcomeLabel_3);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(10, 10, 580, 380);
        contentPane.add(panel);

        setUndecorated(true);
        setUploading();
        setVisible(true);
    }
}