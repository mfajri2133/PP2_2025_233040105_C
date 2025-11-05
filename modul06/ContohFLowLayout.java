/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040105.modul06;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author spag9
 */
public class ContohFLowLayout {
    public static void main(String[] args){
        JFrame frame = new JFrame("COntoh FlowLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,150);
        
        JPanel p = new JPanel();
        
        p.add(new JButton("Tombol 1"));
        p.add(new JButton("TOmbol 2"));
        p.add(new JButton("TOmbol Tiga"));
        p.add(new JButton("TOmbol Empat Panjang"));
        p.add(new JButton("TOmbol 5"));
        
        frame.add(p);
        frame.setVisible(true);
    }
}
