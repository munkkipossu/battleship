package game;


import game.Square;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/** The Ship class represent a piece on a game board. The piece knows its own location
 * by 'Square location', the direction it is facing 'boolean orientation' where 
 * true = vertical, false = horizontal, and the length of the ship, measured in 'squares'
 *
 * @author tolaakso
 */
public class Ship {
    
    private int size;               // for now, i assume the game contains straight ships
    private Square location;        // upper/lerft most bit of the ship
    private boolean orientation;    // false = horizontal, true = vertical for now
    
    public Ship(int size, boolean direction){
        this.size = size;
        this.location = null;
        this.orientation = direction;
    }
    
    public void setShip(Square location){
        this.location = location;
    }
    
    public int getSize(){
        return this.size;
    }
    
    public Square getLocation(){
        return this.location;
    }
    
    public boolean getOrientation(){
        return this.orientation;
    }
    /**
     * rotateship() method changes the rotation of the ship from vertical to horizontal
     * or from horizontal to vertical.
     */
    public void rotateShip(){
        if (this.orientation == false){
            this.orientation = true;
        }else
            orientation = false;
        
        return;
    }
    
}
