/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import game.Game;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.*;
/** StartbuttonListener starts the game after the board has been set properly.
 *
 * @author tolaakso
 */

public class StartButtonListener implements ActionListener {

    public StartButtonListener(){
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        BoardGUI gameBoard = new BoardGUI();
        SwingUtilities.invokeLater(gameBoard);
    }
    /*
    public void actionPerformed(ActionEvent ae, Game game){
        BoardGUI gameBoard = new BoardGUI(game);
        SwingUtilities.invokeLater(gameBoard);
    }
    */
}