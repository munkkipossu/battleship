/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author tolaakso
 * 
 * The board is a new window opened from the starting screen, containing m by n boxes for the grid of a 
 * 
 */


import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Board implements Runnable{
     private JFrame frame;

     @Override
     public void run(){
     }
     
    public void run(int korkeus, int leveys) {
        frame = new JFrame("The Grid");
        frame.setPreferredSize(new Dimension(100*korkeus, 100*leveys));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane(), leveys, korkeus);

        frame.pack();
        frame.setVisible(true);
    }

     
    private void luoKomponentit(Container container, int leveys, int korkeus) {
        GridLayout layout = new GridLayout(korkeus, leveys);
        container.setLayout(layout);
    
        for(int i=0; i<leveys*korkeus; i++){
            JButton lisaaNappi = new JButton("Lisää henkilö!");
            container.add(lisaaNappi);
        }
    }

    public JFrame getFrame() {
        return frame;
    }
    
}