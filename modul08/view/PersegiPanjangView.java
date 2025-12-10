/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040105.modul08.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author spag9
 */
public class PersegiPanjangView extends JFrame {
    private JTextField txtPanjang = new JTextField(10);
    private JTextField txtLebar = new JTextField(10);
    private JButton btnHitung = new JButton("Hitung");
    private JButton btnReset = new JButton("Reset");
    private JLabel lblHasil = new JLabel("-");
    // tempat untuk render hasil dari keliling
    private JLabel lblKeliling = new JLabel("-");
    
    public PersegiPanjangView() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);
        this.setLayout(new GridLayout(6, 2, 10, 10));
        this.setTitle("MVC Kalkulator");
        
        this.add(new JLabel("Panjang:"));
        this.add(txtPanjang);
        this.add(new JLabel("Lebar:"));
        this.add(txtLebar);
        this.add(new JLabel("Hasil Luas:"));
        this.add(lblHasil);
        // keliling label form dan field
        this.add(new JLabel("Hasil Keliling:"));
        this.add(lblKeliling);
        this.add(btnReset);
        this.add(btnHitung);
    }
    
    public double getPanjang(){
        return Double.parseDouble(txtPanjang.getText());
    }
    
    public double getLebar(){
        return Double.parseDouble(txtLebar.getText());
    }
    
    public void setHasil(double hasil) {
        lblHasil.setText(String.valueOf(hasil));
    }
    
    // untuk melakukan set hasil keliling ke lblKeliling
    public void setKeliling(double keliling) {
        lblKeliling.setText(String.valueOf(keliling));
    }
    
    public void tampilkanPesanError(String pesan) {
        JOptionPane.showMessageDialog(this, pesan);
    }
    
    public void addHitungListener(ActionListener listener) {
        btnHitung.addActionListener(listener);
    }
    
    // logic untuk mereset form
    public void resetForm() {
        txtPanjang.setText("");
        txtLebar.setText("");
        lblHasil.setText("-");
        lblKeliling.setText("-");
    }

    // menambahkan action pada btn reset
    public void addResetListener(ActionListener listener) {
        btnReset.addActionListener(listener);
    }
}
