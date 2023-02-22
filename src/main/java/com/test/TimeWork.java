package com.test;


import javax.swing.*;
import java.awt.*;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-01-17 13:40
 */
public class TimeWork {
    private static JFrame frame;
    private static JLabel jl0;

    public static void main(String[] args) {
        init();
        int hour = 1187;
        int min = 45;
        int second = 59;
        while (true) {
            String text = "";
            if (second / 10 == 0) {
                text = hour + ":" + min + ":" + "0" + second;
            } else {
                text = hour + ":" + min + ":" + second;
            }
            jl0.setText("<html>" + text + "</html>");
            jl0.setHorizontalAlignment(0);
            second--;
            if (second < 0) {
                min--;
                second = 59;
            }
            if (min < 0) {
                hour--;
                min = 59;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static int init() {
        frame = new JFrame("整个宇宙将为你闪耀");
        jl0 = new JLabel();
        JPanel jp = new JPanel(new BorderLayout());
        jp.add(jl0);
        frame.add(jp);
        frame.setUndecorated(true);
        jl0.setFont(new Font("Dialog", 1, 32));
        jl0.setForeground(new Color(95, 158, 160));
        jl0.setBackground(Color.BLACK);
        jl0.setOpaque(true);
        frame.setVisible(true);
        frame.setLocation(600, 400);
        frame.setSize(660, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return 0;
    }

}
