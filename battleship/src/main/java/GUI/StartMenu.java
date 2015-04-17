/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

/**
 *
 * @author tolaakso
 */

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

public class StartMenu implements Runnable {
    
    private JFrame frame;
    
    /*
    public static void main(String[] args) {
        StartMenu mainScreen = new StartMenu();
        SwingUtilities.invokeLater(mainScreen);
    }
    */
    
    
    
    public StartMenu(){        
    }
    
    @Override
    public void run(){
        frame = new JFrame("Battleships");
        frame.setPreferredSize(new Dimension(400, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);    
    }
    
    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(7,1);
        container.setLayout(layout);
    
        container.add(new JLabel("Let the GAMES begin"));

        JTextArea boardSize = new JTextArea("Boardsize");
        container.add(boardSize);
        
        container.add(new JLabel("How many players?"));
        
        JRadioButton onePlayer = new JRadioButton("One");
        JRadioButton twoPlayers = new JRadioButton("Two");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(onePlayer);
        buttonGroup.add(twoPlayers);

        container.add(onePlayer);
        container.add(twoPlayers);
        
        JButton startButton = new JButton("Start");
        startButton.addActionListener(new GameStarterListener());
        
        container.add(startButton);
        
    }

    public JFrame getFrame() {
        return frame;
    }
    
}