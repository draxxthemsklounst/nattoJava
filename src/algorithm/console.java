/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Mi Ra
 */
public class console extends JPanel
{
    private JTextArea CON;
    public console() {
        init();
    }
    private void init() {
        this.setBackground(Color.MAGENTA);
        this.setSize(1280,150);
        this.setMinimumSize(new Dimension(1280,150));
        this.setVisible(true);
        
        CON = new JTextArea();
        add(CON);
    }
}
