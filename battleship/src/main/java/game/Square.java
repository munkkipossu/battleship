package game;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * The square class represents a square of a game board. It only contains 2 properties,
 * the boolean variables 'containsShip' and 'hasBeenHit'. These two variables are set
 * to false when the square is created and can only be set to true (not returned back
 * to false).
 * 
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
    
    /**
     * hitSquare() sets the boolean variable 'hasBeenHit' to true when called.
     * 
     */
    public void hitSquare(){
        if(this.hasBeenHit == false){   // I'm thinking of throwing an error if the square has been hit already, but thats for a later day
            this.hasBeenHit = true;
        }
    }

    public void setShip(){
        this.containsShip = true;
    }
    
}
