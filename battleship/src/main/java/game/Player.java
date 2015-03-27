package game;


import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tolaakso
 */
public class Player {
    
    private String name;
    private Board ownBoard;
//    private Board opponentsBoard;
    
    public Player(){
        this("Teppo Testaaja");
    }
    
    public Player(String name){
        this.name = name;
        this.ownBoard = new Board();
    }
   
    public boolean fireAtSquare(int x, int y, Board opponentsBoard){ 
         return opponentsBoard.hitSquare(x, y);
    }
    
    public void rotateShip(Ship ship){
        ship.rotateShip();
    }
    
    public boolean placeShip(Ship ship, int x, int y){
        return this.ownBoard.placeShip(ship, x,y);
    }
   
}
