/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.imageio.*;
import java.io.File;
import java.awt.Color;

import Game.*;



/**
 *
 * @author tolaakso
 */
public class GameScreen implements Runnable {

    private JFrame frame;

    public GameScreen() {
        
    }
    
    @Override
    public void run() {
        frame = new JFrame("Who shall win?");
        frame.setPreferredSize(new Dimension(1600, 800));

        //frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane(), 10);

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container, int boardSize){
        GridLayout layout = new GridLayout(2,1);
        
       
    }
}