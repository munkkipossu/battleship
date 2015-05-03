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
public class GameTest {
    
    public GameTest() {
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
    public void wrongSizeShipCannotBePlaced(){
        Game game = new Game();
        assertFalse(game.placeShip(-2, 1, 1, true));
    }

    public void shipMustBePlacedOnBoardXmin(){
        Game game = new Game();
        assertFalse(game.placeShip(3, -1, 1, true));
    }
    
    public void shipMustBePlacedOnBoardXmax(){
        Game game = new Game();
        assertFalse(game.placeShip(3, 123, 1, true));
    }
    
    public void shipMustBePlacedOnBoardYMin(){
        Game game = new Game();
        assertFalse(game.placeShip(3, 1, -1, true));
    }
    
    public void shipMustBePlacedOnBoardYMax(){
        Game game = new Game();
        assertFalse(game.placeShip(3, 1, -1, true));
    }
}
