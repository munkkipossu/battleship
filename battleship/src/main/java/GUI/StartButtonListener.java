/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.*;
/**
 *
 * @author tolaakso
 */

public class StartButtonListener implements ActionListener {

    public StartButtonListener(){
    }
    
    public StartButtonListener(JTextArea playerName){
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        BoardGUI gameBoard = new BoardGUI();
        SwingUtilities.invokeLater(gameBoard);
    }
}