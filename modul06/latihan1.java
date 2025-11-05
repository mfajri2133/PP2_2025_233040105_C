/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040105.modul06;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author spag9
 */
public class latihan1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Kalkulator Sederhana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,400);
        JTextField input = new JTextField();
        frame.add(input, BorderLayout.NORTH);
        
        JPanel buttonContainer = new JPanel();
        buttonContainer.setLayout(new GridLayout(4,4,5,5));
        
        buttonContainer.add(new JButton("7"));
        buttonContainer.add(new JButton("8"));
        buttonContainer.add(new JButton("9"));
        buttonContainer.add(new JButton("/"));
        buttonContainer.add(new JButton("4"));
        buttonContainer.add(new JButton("5"));
        buttonContainer.add(new JButton("6"));
        buttonContainer.add(new JButton("*"));
        buttonContainer.add(new JButton("1"));
        buttonContainer.add(new JButton("2"));
        buttonContainer.add(new JButton("3"));
        buttonContainer.add(new JButton("-"));
        buttonContainer.add(new JButton("0"));
        buttonContainer.add(new JButton("."));
        buttonContainer.add(new JButton("="));
        buttonContainer.add(new JButton("+"));
        
        frame.add(buttonContainer, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
