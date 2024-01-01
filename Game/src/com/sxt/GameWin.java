package com.sxt;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.Timer;

import java.awt.*;
public class GameWin extends JFrame {
    // Main method
    public static void main(String[] args) {
        GameWin win = new GameWin();
    }

    // GameWin class.
    public GameWin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Game");

        // Create a menu bar for the window.
        JMenuBar menuBar = new JMenuBar();

        // Create a menu named "Menu" and an array of menu items.
        JMenu menu = new JMenu("Menu");
        JMenuItem[] menuItems = new JMenuItem[2];
        menuItems[0] = new JMenuItem("Level1");
        menuItems[1] = new JMenuItem("Level2");

        // add them to the menu.
        for (int i = 0; i < menuItems.length; i++) {
            menu.add(menuItems[i]);

            // Add ActionListener to each menu item for handling events.
            menuItems[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Selected level.
                    if (e.getActionCommand().equals("Level1")) {
                        GamePanel.changeLevel(1);
                    } else if (e.getActionCommand().equals("Level2")) {
                        GamePanel.changeLevel(2);
                    }
                }
            });
        }

        // Add the menu to the menu bar.
        menuBar.add(menu);

        // Set the menu bar for the window.
        setJMenuBar(menuBar);

        // Create GamePanel to the content pane.
        GamePanel panel = new GamePanel(this);
        getContentPane().add(panel, BorderLayout.CENTER);

        // Window size, location, and visibility.
        setSize(800, 800);
        setLocationRelativeTo(null);
        setVisible(true);

        // Create a Timer to update the game state and repaint the panel.
        Timer timer = new Timer(25, e -> {
            panel.createObj();
            panel.repaint();
        });
        timer.start();
    }
}
