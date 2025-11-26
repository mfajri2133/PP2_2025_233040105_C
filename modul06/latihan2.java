/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040105.modul06;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author spag9
 */
public class latihan2 {
        public static void main(String[] args) {
        JFrame frame = new JFrame("Konverter Suhu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250,150);
        
        JPanel container = new JPanel();
        container.setLayout(new GridLayout(3,2,5,5));
        
        JTextField input = new JTextField();
        JLabel output = new JLabel();
        JButton convertButton = new JButton("Konversi");
        
        container.add(new JLabel("Celcius:"));
        container.add(input);

        container.add(new JLabel("Fahrenheit:"));
        container.add(output);
        
       ActionListener convListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int celciusInput = Integer.parseInt(input.getText());
                    int hasil = (celciusInput * 9/5) + 32;

                    output.setText(String.valueOf(hasil));

                } catch (NumberFormatException err) {
                    output.setText("ERROR!");
                }
            }
        };
                
        convertButton.addActionListener(convListener);
        frame.add(convertButton, BorderLayout.SOUTH);
        frame.add(container, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
