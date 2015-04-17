package game;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tolaakso
 */

import javax.swing.SwingUtilities;

public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        System.out.println("I'm alive");
        GUI.StartMenu mainScreen = new GUI.StartMenu();
        SwingUtilities.invokeLater(mainScreen);
        Player humanPlayer = new Player();
        Player computer = new Player("computer");
        
       // humanPlayer.placeShip();
    }
    
}
