/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040105.modul06;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author spag9
 */
public class ContohMouseListener {
    public static void main(String[] args) {
        JFrame fr = new JFrame("Contoh MouseListener");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(300, 300);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.GREEN);
        panel.setPreferredSize(new Dimension(200, 200));
        
        MouseAdapter adpt = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                panel.setBackground(Color.RED);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                panel.setBackground(Color.BLUE);
            }
            
            @Override
            public void mouseClicked(MouseEvent e){
                System.err.println("Mouse diklik di: x-" + e.getX() + ", y-" + e.getY());
            }
        };
        
        panel.addMouseListener(adpt);
        fr.add(panel);
        fr.setVisible(true);
    }
}
