package game;


import game.Square;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/** The Board class contains a 2D array of squares, making up the conceptual board.
 * Additionally the class has an integer 'size' defining the maximum size of the board,
 * as well as a list of ship which contains the 'Ships' that have been placed on the board.
 *
 * @author tolaakso
 */
public class Board {

    private Square[][] board;
    private int size;
    private List<Ship> ships;
    
    // Constructors
    
    public Board(){
        this(10);
    }

    public Board(int size){
        this.size = size;
        this.board = new Square[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                this.board[i][j]=new Square();
            }
        }        
        this.ships = new ArrayList<Ship>();
    }
    
    public Square getSquare(int x, int y){
        return this.board[x][y];
    }
    /** hasSquareBeenHit(x,y) method can be used if the square defined by point
     * (x,y) has been hit
     * 
     * @param x
     * @param y
     * @return - true if the square has been hit, false if not
     */
    public boolean hasSquareBeenHit(int x, int y){
        return this.board[x][y].getHasBeenHit();
    }
    
    public int getBoardSize(){
        return this.size;
    }
    
    /** squareDoesNotExist(x,y) is a private method used for checking out of bound
     * problems
     * 
     * @param x
     * @param y
     * @return - true if the given point (x,y) is not on the board
     */
    private boolean squareDoesNotExist(int x, int y){
        if(x<0 || x>= this.size || y <0 || y >= this.size){
            return true;
        }
        else 
            return false;
    }
    
    /** hitSquare(x,y) hits the point (x,y) if it exists
     * 
     * @param x
     * @param y
     * @return 
     */
    public boolean hitSquare(int x, int y){
        if(this.squareDoesNotExist(x,y)){
            return false;
        }
        if(this.hasSquareBeenHit(x,y)){
            return false;
        }
        else
            this.board[x][y].hitSquare();
            
        return true;
    }
    
    /** placeShip(ship,x,y) method places a ship to a point (x,y). The method checks
     * for out of bounds points. It assumes that the given point is the highest
     * point of the ship (of a given size) if the ship is set vertically, or the leftmost
     * point if the ship is horizontally and checks  the location accordingly.
     * 
     * Additionally the method makes sure that the squares onto which a new ship
     * is trying to be placed does not already contain a ship. 
     * 
     * @param ship
     * @param x
     * @param y
     * @return - true if a ship is place successfully. False if the given point 
     * (x,y) is out of bounds, ship can not fit the board, or an existing ship is 
     * already under the new ship.
     */
    public boolean placeShip(Ship ship, int x, int y){
        
        if(ship.getOrientation()){                    // vertical
            if(ship.getSize() + x  > this.size)
                return false;
 
            for(int i=x; i<x+ship.getSize(); i++){
                if(getSquare(i,y).getContainsShip()){
                    return false;
                }
            }
            
            ship.setShip(getSquare(x,y));
            for(int i=x; i<x+ship.getSize(); i++){
                getSquare(i,y).setShip();
            }
            this.ships.add(ship);
        }
        else{                                   // horizontal
            if(ship.getSize() + y > this.size)
                return false;
                      
            
            for(int i=y; i<y+ship.getSize(); i++){
                if(getSquare(x,i).getContainsShip()){
                    return false;
                }
            }
            ship.setShip(getSquare(x,y));
            for(int i=y; i<y+ship.getSize(); i++){
                getSquare(x,i).setShip();
            }
        }
        
        return true;
    }



}

