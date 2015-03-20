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
    public void newOpponentsSquareHasNotBeenHit(){
        Player player = new Player();
        assertFalse(player.hasSquareBeenHit(0,0));
    }
    
    @Test
    public void squareIsHitWhenFired(){
        Player player = new Player();
        player.fireAtSquare(0,0);
        assertTrue(player.hasSquareBeenHit(0,0));
    }
    
    
    //    public boolean setShip(int ship, int x, int y, boolean orientation){
    
    @Test
    public void PlacingNonexistantShipFails(){
        Player player = new Player();
        assertFalse(player.setShip(10, 0,0, false));
    }
    
    @Test
    public void PlacingShipProperlyInsideWorks(){
        Player player = new Player();
        assertTrue(player.setShip(2,0,0,false));
    }
    
    @Test
    public void PlacingShipOutSideBoardFails(){
        Player player = new Player();
        assertFalse(player.setShip(2,15,15,false));
    }
    
    @Test
    public void PlacingShipOnTheBorderFails(){
        Player player = new Player();
        assertFalse(player.setShip(2,8,8,false));
    }
    
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
}
