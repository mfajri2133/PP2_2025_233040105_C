/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040105.modul06;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author spag9
 */
public class ContohActionListener {
    public static void main(String[] args) {
        JFrame fr = new JFrame("Contoh ActionListener");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(300, 150);
        fr.setLayout(new FlowLayout());
        
        JLabel label = new JLabel("Halo, klik tombol ini!");
        JButton btn = new JButton("Klik Saya!");
        
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Tombol telah diklik!");
            }
        };
        
        btn.addActionListener(listener);
        fr.add(label);
        fr.add(btn);
        fr.setVisible(true);
    }
}
