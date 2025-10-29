/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040105.modul05;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author spag9
 */
public class latihan2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame f = new JFrame("Halo ini adalah frame 2");
                f.setSize(500, 300);
                f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
                
                JLabel l = new JLabel("Halo ini label");
                f.add(l);
                
                f.setVisible(true);
            }
        });
    }
}
