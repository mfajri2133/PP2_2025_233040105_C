/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040105.modul05;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author spag9
 */
public class latihan4 {
     public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame f = new JFrame("Halo ini adalah frame 4 (BorderLayout)");
                f.setSize(500, 300);
                f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
                
                f.setLayout(new BorderLayout());
                
                JLabel l = new JLabel("Label ada di atas (NORTH)");
                JButton btn = new JButton("Tombol ada di bawah (SOUTH)");
                
                btn.addActionListener(e -> {
                    l.setText("Tombol di SOUTH diklik!");
                });
                
                f.add(l, BorderLayout.NORTH);
                f.add(btn, BorderLayout.SOUTH);
                
                f.add(new JButton("WEST"), BorderLayout.WEST);
                f.add(new JButton("EAST"), BorderLayout.EAST);
                f.add(new JButton("CENTER"), BorderLayout.CENTER);
                f.setVisible(true);
            }
        });
    }
}
