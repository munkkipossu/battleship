package game;


import game.Square;
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
    
    public boolean hasSquareBeenHit(int x, int y){
        return this.board[x][y].getHasBeenHit();
    }
    
    public int getBoardSize(){
        return this.size;
    }
    
    private boolean squareDoesNotExist(int x, int y){
        if(x<0 || x>= this.size || y <0 || y >= this.size){
            return true;
        }
        else 
            return false;
    }
    
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
    
    public boolean placeShip(Ship ship, int x, int y){
        
        if(ship.getOrientation()){        // vertical
            if(ship.getSize() + y  > this.size-1)
                return false;
    
            ship.setShip(getSquare(x,y));
            for(int i=y; i<y+ship.getSize(); i++){
                getSquare(x,y+i).setShip();
            }
            this.ships.add(ship);
        }
        else{                 // horizontal
            if(ship.getSize() + x > this.size-1)
                return false;
            
            ship.setShip(getSquare(x,y));
            for(int i=x; i<x+ship.getSize(); i++){
                getSquare(x+i,y).setShip();
            }
        }
        
        return true;
    }



}

