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
    private Board opponentsBoard;
    private List<Ship> ships;
    
    public Player(){
        this.name = "Teppo Testaaja";
        this.ownBoard = new Board();
        this.opponentsBoard = new Board();
        
        this.ships = new ArrayList<Ship>();
        this.generateDefaultShips();
    }
    
    public Player(String name){
        this.name = name;
        this.ownBoard = new Board();
        this.opponentsBoard = new Board();
        
        this.ships = new ArrayList<Ship>();
        this.generateDefaultShips();
        
    }
    
    private void generateDefaultShips(){
        this.ships.add(new Ship(2));
        this.ships.add(new Ship(3));
        this.ships.add(new Ship(3));
        this.ships.add(new Ship(4));
        this.ships.add(new Ship(5));
    
        return;
    }
    
    public void fireAtSquare(int x, int y){ 
        /*
         * I haven't decided how to do the communication between the boards yet
         */
        this.opponentsBoard.hitSquare(x, y);
    }
    
    public boolean hasSquareBeenHit(int x, int y){
        return this.opponentsBoard.hasSquareBeenHit(x, y);
    }
    
    public boolean setShip(int ship, int x, int y, boolean orientation){
        /*
         * Still not sure who/where the check is made so ships aren't off board
         * For now, true = successfull ship placement, false = failure
         */
        
        Ship temp;
        if(ship< this.ships.size()){
            temp = this.ships.get(ship);
        }
        else 
            return false;

        if(orientation){        // vertical
            if(temp.getSize() + y  > 9)
                return false;
    
            temp.setShip(getOwnSquare(x,y), orientation);
            for(int i=y; i<y+temp.getSize(); i++){
                getOwnSquare(x,y+i).setShip();
            }
        }
        else{                 // horizontal
            if(temp.getSize() + x > 9)
                return false;
            
            temp.setShip(getOwnSquare(x,y), orientation);
            for(int i=x; i<x+temp.getSize(); i++){
                getOwnSquare(x+i,y).setShip();
            }
        }
               
        
        return true;
    }
    
    public Square getOwnSquare(int x, int y){
        return this.ownBoard.getSquare(x, y);
    }    
    
    
    
}
