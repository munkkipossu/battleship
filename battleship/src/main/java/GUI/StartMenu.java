/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;
import game.Game;
import java.awt.Color;
/** The holy mother of this program. I do not understand GUI very much :).
 * 
 * The start menu window is made of JFrame with 3 JPanels. The left most panel 
 * contains a button which rotates ships and another one for starting the actual game.
 * The middle JPanel makes up the player's board. The right JPanel has the ships
 * a player can place on the board.
 *
 *
 * @author tolaakso
 */

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class StartMenu implements Runnable {
    
    private JFrame frame;
    private static final int gridSize = 10;
    private int shipChosen;
    private boolean shipDirection;
    private boolean gameReady;
    private Game game;

    
    public StartMenu(){        
        this.shipChosen = 0;
        this.shipDirection = true;
        this.gameReady = false;
        this.game = new Game();
    }
    @Override
    /**
     * A standard run() method which creates a JFrame, components for it and 
     * sets everything visible.
     */
    public void run(){
        Game game = new Game();
        frame = new JFrame("Battleships");
        frame.setPreferredSize(new Dimension(900, 300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane(), game);

        frame.pack();
        frame.setVisible(true);    
    }
    
    /** createComponents(container, game) creates a gridlayout for the container,
     * then uses 3 private methods to create 3 JPanels:
     * 
     * createLeftSide(container)
     * createBoard(container, gridsize)
     * createRightSide(container, game)
     * 
     * 
     * @param container
     * @param game 
     */
    private void createComponents(Container container, Game game) {
        GridLayout layout = new GridLayout(1,3);
        container.setLayout(layout);       
        
        createLeftSide(container);
        createBoard(container, gridSize);
        createRightSide(container, game);
        
    }
    
    /** createRightSide(container,game) creates a JPanel of gridlayout(5,2).
     * The panel contains 4 buttons on the left side, each showing the number of
     * a ship created when the button is place. Next to each button is the original
     * number of the ships to be placed.
     * 
     * The method contain an internal class, because I had problems figuring out
     * how to use variables with the actionListeners. This works :).
     * 
     * The actionlistener reacts when the button is pressed, allowing the player 
     * to place a ship of the given size on to the board.
     * 
     * @param container
     * @param game 
     */
    private void createRightSide(Container container, Game game){
        
        JPanel ships = new JPanel();
        ships.setLayout(new GridLayout(5,2));
        
        JTextArea shipSize = new JTextArea("Ship size");
        ships.add(shipSize);
        JTextArea shipsLeft = new JTextArea("ships originally");
        ships.add(shipsLeft);
        
        for(int i=0; i<4; i++){
            JButton button =new JButton("" + (i + 2));
            button.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    shipChosen(evt);
                }
            }); 
            ships.add(button);
            
            JTextArea textArea = new JTextArea("" + game.getShipsLeft(i));
            ships.add(textArea);
        }
        container.add(ships);

    }
    
    /**
     * The shipChosen integer is set to be the one chosen by the player.
     * After this the player can set down a ship.
     * @param ae 
     */
    private void shipChosen(ActionEvent ae){
        this.shipChosen = Integer.parseInt(((JButton) ae.getSource()).getText());
    }
    
    /** createBoard(container, gridsize) is the method which creates the gameboard
     * in the middle of the window. After a ship has been chose from the right
     * side of the board, it can be placed on to a square simply by clicking the square.
     * 
     * The method contains an internal class, again because I could not figure out
     * how to use the variables found in the 'StartMenu' class in the actionlistener.
     * 
     * The actionlistener figures out which button is pressed, then tries to place
     * a ship. If no ship has been chosen, nothing happens. If a ship is placed
     * successfully, the squares are marked.
     * 
     * @param container
     * @param gridSize 
     */
    private void createBoard(Container container, final int gridSize){
        JPanel ownBoard = new JPanel();
        ownBoard.setLayout(new GridLayout(gridSize, gridSize));
        
        final JButton[][] board = new JButton[gridSize][gridSize]; // This array is used to find out which square the player presses    
        for (int i = 0; i < gridSize; i++)
        {
            for (int j = 0; j < gridSize; j++)
            {
                JButton button = new JButton();
                board[i][j] = button;
                button.addActionListener(
                    new java.awt.event.ActionListener() {
                        
                        public void actionPerformed(java.awt.event.ActionEvent ae) {
                            if(shipChosen != 0){
                                for (int row = 0; row < gridSize; row++) {
                                    for (int col = 0; col < gridSize; col++) {
                                        if (board[row][col] == ae.getSource()){
                                            if(placeShip(ae, row, col, shipDirection)){
                                                colorButtons(board, row, col);
                                                shipChosen = 0;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }); 
                ownBoard.add(button);
            }
        }
        container.add(ownBoard);
    }

    /** placeShip(ae, row, col, direction) - a ship is placed into the required
     * square, assuming it can fit there
     * 
     * @param ae - actionEven in question (pressing a button)
     * @param row - row of the ship to be place
     * @param col - column to which the ship is placed
     * @param direction - ship direction (vertical/horizontal)
     * @return - true is ship placement is successful
     */
    private boolean placeShip(ActionEvent ae, int row, int col, boolean direction){
        if(game.placeShip(shipChosen, row, col, direction)){
            return true;
        }
        return false;
    }
    
    /** createLeftSide(container) creates the left side of the board with a
     * gridlayout(3,1). Top portion is a JLabel with a sarcastic message. The
     * middle button rotates the ship (note - the rotation is not visible until
     * the ship is place on to the board). The last button starts the game.
     * 
     * @param container 
     */
    private void createLeftSide(Container container){
        JPanel leftSide = new JPanel();
        leftSide.setLayout(new GridLayout(3,1));
        leftSide.add(new JLabel("Let the GAMES begin"));
        
        JButton rotateButton = new JButton("rotate ship");
        rotateButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent ae) {
                            if(shipDirection == true)
                                shipDirection = false;
                            else
                                shipDirection = true;
                        }
                    });
        leftSide.add(rotateButton);
        
        JButton startButton = new JButton("Start");
        startButton.addActionListener(new StartButtonListener());
        leftSide.add(startButton);

        container.add(leftSide);
    }
    
    /** colorButtons(board, row, col) colors certain squares when a ship is successfully
     * placed onto them
     * 
     * @param board
     * @param row
     * @param col 
     */
    private void colorButtons(JButton[][] board, int row, int col){
        for(int i=0; i<shipChosen; i++){
            if(shipDirection){
                board[row+i][col].setBackground(Color.BLUE);
            }
            else
                board[row][col+i].setBackground(Color.BLUE);
        }
    }
    
    private JFrame getFrame() {
        return frame;
    }
    
}
