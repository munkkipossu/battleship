package game;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tolaakso
 */
public class PlayerTest {
    
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
     }
    
    @After
    public void tearDown() {
    }


    
    @Test
    public void squareIsHitWhenFired(){
        Player player = new Player();
        Board board = new Board();
        assertTrue(player.fireAtSquare(0,0,board));
    }
    
    @Test
    public void squareCannotBeHitTwice(){
        Player player = new Player();
        Board board = new Board();
        player.fireAtSquare(0,0, board);
        assertFalse(player.fireAtSquare(0,0,board));
    }

    @Test
    public void squareOutsideBoardCannotBeHit(){
        Player player = new Player();
        Board board = new Board();
        assertFalse(player.fireAtSquare(-1,0, board));

    }
    
    @Test
    public void changingOrientationWorks(){
        Player player = new Player();
        Ship ship = new Ship(3, true);
        player.rotateShip(ship);
        assertFalse(ship.getOrientation());
    }
    
    @Test
    public void PlacingShipProperlyInsideWorks(){
        Player player = new Player();
        Ship ship = new Ship(3, true);
                
        assertTrue(player.placeShip(ship,0,0));
    }
    
    @Test
    public void PlacingShipOutSideBoardFails(){
        Player player = new Player();
        Ship ship = new Ship(3, true);
        assertFalse(player.placeShip(ship,15,15));
    }
    
    @Test
    public void PlacingShipOnTheBorderFails(){
        Player player = new Player();
        Ship ship = new Ship(3, true);
        assertFalse(player.placeShip(ship,8,8));
    }
    

}
