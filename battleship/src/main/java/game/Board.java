package game;


import game.Square;

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
    
    public Board(){
        this.board = new Square[10][10];
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                this.board[i][j]=new Square(i,j);
            }
        }
    }

    public Square getSquare(int x, int y){
        return this.board[x][y];
    }
    
    public boolean hasSquareBeenHit(int x, int y){
        return this.board[x][y].getHasBeenHit();
    }
    
    public void hitSquare(int x, int y){
        this.board[x][y].hitSquare();        
    }
    
}
