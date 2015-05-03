package game;


import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/** The Player class contains a Board object, which the class uses to do the actions
 * a real player would do in a game of Battleship. Additionally the class contains
 * a String for the name of the player. Most of the Board classes properties are
 * used through he player class.
*
 * @author tolaakso
 */
public class Player {
    
    private String name;
    private Board board;
//    private Board opponentsBoard;
    
    public Player(){
        this("Teppo Testaaja");
    }
    
    public Player(String name){
        this.name = name;
        this.board = new Board();
    }
   
    /** fireAtSqure(x,y,oppopnentsBoard) is a method
     * 
     * @param x
     * @param y
     * @param opponentsBoard
     * @return 
     */
    public boolean fireAtSquare(int x, int y, Board opponentsBoard){ 
         return opponentsBoard.hitSquare(x, y);
    }
    
    /** rotateShip method is intended to be used is a game where the ships can move,
     * which is no possible at the moment.
     * 
     * @param ship 
     */
    public void rotateShip(Ship ship){
        ship.rotateShip();
    }
    
    /** The player must place ships on the board before the game can start.
     * This function is used to place the 'ship' into a (x,y) square found
     * on the board.
     * 
     * @param ship - ship which has size and direction defined
     * @param x - the x paramater for the square
     * @param y - the y parameter for the square
     * @return 
     */
    public boolean placeShip(Ship ship, int x, int y){
        return this.board.placeShip(ship, x,y);
    }
    
    public Square getSquare(int i, int j){
        return this.board.getSquare(i,j);
    }
    
    /** hasSquareBeenHit(i,j) method is used to find if a given square on the players
     * board has been hit.
     * 
     * @param i
     * @param j
     * @return 
     */
    public boolean hasSquareBeenHit(int i, int j){
        return this.board.hasSquareBeenHit(i, j);
    }
    
}
