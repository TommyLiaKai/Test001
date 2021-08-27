package com.company;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WindowGUI {

    public static void showImage(String image) {
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("C:/Users/tommy/IdeaProjects/Test01/images/" + image));
        new WindowGUI().createWindow(label);
    }

    private void createWindow(JLabel label) {
        JFrame frame = new JFrame("Ships");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1210,630);
        frame.setVisible(true);
        frame.add(label);
        new WindowGUI().closeWindow(frame);
    }

    private void closeWindow(JFrame frame) {
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                super.mouseClicked(e);
            }
        });
    }
}
