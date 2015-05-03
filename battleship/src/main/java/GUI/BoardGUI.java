/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;




import game.Game;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/** BoardGUI creates the window where the game is to be played. It is still under
 * construction, because I have had much trouble with the actionlisteners (how to
 * pass information through them efficiently).
 *
 * @author tolaakso
 */
public class BoardGUI implements Runnable{
    private JFrame frame;
    private Game game;
    
    public BoardGUI(Game game){
        this.game=game;
    }
    
    public BoardGUI(){
        this.game = null;
    }
    
    @Override
    public void run() {
        frame = new JFrame("Board");
        frame.setPreferredSize(new Dimension(900,900));

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

     
    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(2,2);
        container.setLayout(layout);
        
        JTextArea ownBoardName = new JTextArea("Own Board");
        
        JTextArea emptyHolder = new JTextArea("Holder");
        container.add(emptyHolder);
      
        JTextArea opponentBoardName = new JTextArea("Opponents Board");
        container.add(opponentBoardName);
        
        
        //createOwnBoard(container, final int gridSize)
        int gridSize = 10;
        JPanel ownBoard = new JPanel();
        ownBoard.setLayout(new GridLayout(gridSize, gridSize));
        for (int i = 0; i < gridSize; i++)
        {
            for (int j = 0; j < gridSize; j++)
            {
                JButton button = new JButton();
                ownBoard.add(button);
            }
        }
        
        
        JPanel opponentsBoard = new JPanel();
        opponentsBoard.setLayout(new GridLayout(gridSize, gridSize));
        for (int i = 0; i < gridSize; i++)
        {
            for (int j = 0; j < gridSize; j++)
            {
                JButton button = new JButton("x");
                opponentsBoard.add(button);
            }
        }
        
        container.add(ownBoard);
                
        container.add(opponentsBoard);
        
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
}