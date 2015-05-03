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

import java.util.ArrayList;
import javax.swing.SwingUtilities;

public class Game {

    private Player human;
    private Player computer;
    private int[] ships;
    
    public Game(){
        this.human = new Player("pekka pelaaja");
        this.computer = new Player("computer");
        this.ships = new int[4];
        ships[0] =1;
        ships[1] =2;
        ships[2] =1;
        ships[3] =1;
    }
        
    public static void main(String[] args) {
        GUI.StartMenu mainScreen = new GUI.StartMenu();
        SwingUtilities.invokeLater(mainScreen);
    }
    
    public boolean hasSquareBeenHit(int i, int j){
        return human.hasSquareBeenHit(i,j);
    }
    
    public int getShipsLeft(int i){
        return ships[i];
    }
    
    public boolean placeShip(int shipSize, int x, int y, boolean shipDirection){
        if(shipSize < 2 || shipSize > 5)
            return false;

        Ship ship = new Ship(shipSize, shipDirection);
        if(ships[shipSize-2] == 0)
            return false;
        else if(human.placeShip(ship, x, y)){
            ships[shipSize-2]--;
            return true;
        }
        else
            return false;
    }
}
