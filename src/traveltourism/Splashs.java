package traveltourism;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Splashs {
    public static void main(String[] args) {
        SplashFrames f1 = new SplashFrames();
        f1.setVisible(true);
        int i;
        int x = 1;
        for (i = 2; i <= 600; i += 10, x += 7) {
            f1.setLocation(900 - ((i + x) / 2), 500 - (i / 2));
            f1.setSize(i + x, i);
            try {
                Thread.sleep(15);
            } catch (Exception e) {
            }
        }

    }
}

class SplashFrames extends JFrame implements Runnable {
    Thread t1;

    SplashFrames() {
        setLayout(new FlowLayout());
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("traveltourism/icons/icons/img1.jpg"));
        Image i1 = c1.getImage().getScaledInstance(1030, 750, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);

        JLabel l1 = new JLabel(i2);
        add(l1);
        setUndecorated(true);
        t1 = new Thread(this);
        t1.start();
    }

    public void run() {
        try {
            Thread.sleep(7000);
            this.setVisible(false);

            new Logins();
            // l.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}