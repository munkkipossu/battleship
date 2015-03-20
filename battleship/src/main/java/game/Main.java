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
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        System.out.println("I'm alive");

        Player humanPlayer = new Player();
        Player computer = new Player("computer");
        
        humanPlayer.setShip(0, 1, 2, true);
    }
    
}
