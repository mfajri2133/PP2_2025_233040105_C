/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040105.modul10.tugas;

import id.ac.unpas.pp2_c_233040105.modul10.tugas.view.MahasiswaView;
import javax.swing.SwingUtilities;

/**
 *
 * @author spag9
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MahasiswaView().setVisible(true);
        });
    }
}