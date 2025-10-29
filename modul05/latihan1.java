/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040105.modul05;
import javax.swing.*;

/**
 *
 * @author spag9
 */
public class latihan1 {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame f = new JFrame("Halo ini adalah frame");
                f.setSize(500, 300);
                f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
                f.setVisible(true);
            }
        });
    }
}
