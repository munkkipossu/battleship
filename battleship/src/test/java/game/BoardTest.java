/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mp
 */
public class BoardTest {
    
    public BoardTest() {
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
    public void newSquareIsNotHit(){
        Board board = new Board();
        assertFalse(board.hasSquareBeenHit(0,0));
    }

    @Test
    public void whenFiredSquareIsHit(){
        Player player = new Player();
        Board board = new Board();
        player.fireAtSquare(0,0, board);
        assertTrue(board.hasSquareBeenHit(0,0));
    }    
    
    /*
    @Test
    public void SquareWithNoShipHasNoShip(){
        Player player = new Player();
        assertFalse(player.getOwnSquare(0,0).getContainsShip());
    }
    
    @Test
    public void PlacingShipIsSeenBySquare(){
        Player player = new Player();
        player.setShip(0,0,0,false);
        assertTrue(player.getOwnSquare(0,0).getContainsShip());
    }

    @Test
    public void PlacingShipIsSeenBySquare2(){
        Player player = new Player();
        player.setShip(0,0,0,false);
        assertTrue(player.getOwnSquare(1,0).getContainsShip());
    }
    
    @Test
    public void SquareWithNoShipHasNoShip2(){
        Player player = new Player();
        player.setShip(0,0,0,false);
        assertFalse(player.getOwnSquare(2,0).getContainsShip());
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    */
    }
