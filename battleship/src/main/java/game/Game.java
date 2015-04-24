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

public class Game {

    private Player human;
    private Player computer;
    private Board gameboard;
    
    
    public Game(String name){
        this.human = new Player(name);
        this.computer = new Player("computer");
        this.gameboard = new Board();        
    }
    
    
    public static void main(String[] args) {
        GUI.StartMenu mainScreen = new GUI.StartMenu();
        SwingUtilities.invokeLater(mainScreen);
       
       // humanPlayer.placeShip();
    }
    
}
