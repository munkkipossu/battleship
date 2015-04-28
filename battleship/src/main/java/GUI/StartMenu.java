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
import javax.swing.JPanel;
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
        frame.setPreferredSize(new Dimension(900, 300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);    
    }
    
    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(1,3);
        container.setLayout(layout);
    
        
        JPanel leftSide = new JPanel();
        leftSide.setLayout(new GridLayout(3,1));
        leftSide.add(new JLabel("Let the GAMES begin"));

        JTextArea playerName = new JTextArea("Player name");
        leftSide.add(playerName);
        
        JButton startButton = new JButton("Start");
        startButton.addActionListener(new StartButtonListener(playerName));
        
        leftSide.add(startButton);
        container.add(leftSide);
        
        int gridSize = 10;
        JPanel ownBoard = new JPanel();
        ownBoard.setLayout(new GridLayout(gridSize, gridSize));
        for (int i = 0; i < gridSize; i++)
        {
            for (int j = 0; j < gridSize; j++)
            {
                JButton button = new JButton("(" + i + ", " + j + ")");
                ownBoard.add(button);
            }
        }
        container.add(ownBoard);
        
     
       
        JPanel ships = new JPanel();
        ships.setLayout(new GridLayout(5,2));
        
        JTextArea shipSize = new JTextArea("Ship size");
        ships.add(shipSize);
        JTextArea shipsLeft = new JTextArea("Ships Left");
        ships.add(shipsLeft);
        
        for(int i=0; i<4; i++){
            JButton button = new JButton("(" + (i + 2) + ")");
            ships.add(button);
            JButton button2 = new JButton("1");
            ships.add(button2);
        }
        container.add(ships);
        
    }

    public JFrame getFrame() {
        return frame;
    }
    
}



               /*
                button.setActionCommand("(" + i + ", " + j + ")");
                button.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                        JButton but = (JButton) ae.getSource();
                        positionLabel.setText(
                            but.getActionCommand() + ADDED_TEXT);                           
                    }
                });
                */