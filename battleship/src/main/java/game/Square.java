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
public class Square {
    
    private boolean hasBeenHit;
    private boolean containsShip;
    
    public Square(){
        this.hasBeenHit = false;
        this.containsShip = false;
    }
    
    public boolean getHasBeenHit(){
        return this.hasBeenHit;
    }
    
    public boolean getContainsShip(){
        return this.containsShip;
    }
    
    public void hitSquare(){
        if(this.hasBeenHit == false){   // I'm thinking of throwing an error if the square has been hit already, but thats for a later day
            this.hasBeenHit = true;
        }
    }

    public void setShip(){
        this.containsShip = true;
    }
    
    public void removeShip(){
        this.containsShip = false;
    }
}
