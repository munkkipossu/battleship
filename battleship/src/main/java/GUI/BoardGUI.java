/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author tolaakso
 * 
 * The board is a new window opened from the starting screen, containing m by n boxes for the grid of a 
 * 
 */


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BoardGUI implements Runnable{
     private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Board");
        frame.setPreferredSize(new Dimension(1600,800));

        //frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

     
    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(2,2);
        container.setLayout(layout);
        
        JTextArea ownBoardName = new JTextArea("Own Board");
      //  container.add(ownBoardName);
        
        JTextArea emptyHolder = new JTextArea("Holder");
        container.add(emptyHolder);
      
        JTextArea opponentBoardName = new JTextArea("Opponents Board");
        container.add(opponentBoardName);
        
        int gridSize = 10;
        JPanel ownBoard = new JPanel();
        ownBoard.setLayout(new GridLayout(gridSize, gridSize));
        for (int i = 0; i < gridSize; i++)
        {
            for (int j = 0; j < gridSize; j++)
            {
                JButton button = new JButton("(" + i + ", " + j + ")");
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
                ownBoard.add(button);
            }
        }
        
        
        JPanel opponentsBoard = new JPanel();
        opponentsBoard.setLayout(new GridLayout(gridSize, gridSize));
        for (int i = 0; i < gridSize; i++)
        {
            for (int j = 0; j < gridSize; j++)
            {
                JButton button = new JButton("(" + i + ", " + j + ")");
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
                opponentsBoard.add(button);
            }
        }
        
        container.add(ownBoard);
                
        container.add(opponentsBoard);
        
    }

    public JFrame getFrame() {
        return frame;
    }
    
}