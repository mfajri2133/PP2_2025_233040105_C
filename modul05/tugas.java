/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040105.modul05;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author spag9
 */
public class tugas {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame f = new JFrame("Halo ini adalah frame Tugas");
                f.setSize(500, 300);
                f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
                
                f.setLayout(new BorderLayout());
                
                JLabel l = new JLabel("Label ada di atas (NORTH)");
                JButton btnS = new JButton("Tombol ada di bawah (SOUTH)");
                JButton btnW = new JButton("WEST");
                JButton btnE = new JButton("EAST");
                JButton btnC = new JButton("CENTER");
                
                btnS.addActionListener(e -> {
                    l.setText("Tombol SOUTH berhasil di klik!");
                });
                btnW.addActionListener(e -> {
                    l.setText("Tombol WEST berhasil di klik!");
                });
                btnE.addActionListener(e -> {
                    l.setText("Tombol EAST berhasil di klik!");
                });
                btnC.addActionListener(e -> {
                    l.setText("Tombol CENTER berhasil di klik!");
                });
                
                f.add(l, BorderLayout.NORTH);
                f.add(btnS, BorderLayout.SOUTH);
                f.add(btnW, BorderLayout.WEST);
                f.add(btnE, BorderLayout.EAST);
                f.add(btnC, BorderLayout.CENTER);
                
                f.setVisible(true);
            }
        });
    }
}
