/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040105.modul07;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author spag9
 */
public class ManajemenNilaiSiswaApp extends JFrame {
    private JTextField fieldName, fieldNilai;
    private JComboBox<String> optionMatkul;
    private JTable tableData;
    private DefaultTableModel tableModel;
    private JTabbedPane tabbedPane;
    
    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(4,2,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        
        panel.add(new JLabel("Nama Siswa: "));
        fieldName = new JTextField();
        panel.add(fieldName);
        
        panel.add(new JLabel("Mata Kuliah: "));
        String[] matkul = {
            "Matematika Dasar",
            "Bahasa Indonesia",
            "Algoritma dan Pemrograman I",
            "Praktikum Pemrograman"
        };
        optionMatkul = new JComboBox<>(matkul);
        panel.add(optionMatkul);
        
        panel.add(new JLabel("Nilai (0-100): "));
        fieldNilai = new JTextField();
        panel.add(fieldNilai);

        JButton btnSimpan = new JButton("Simpan Data");
        panel.add(new JLabel(""));
        panel.add(btnSimpan);
        
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                prosesSimpan();
            }
        });
        
        return panel;
    }
    
    private JPanel createTablePanel(){
        JPanel panel = new JPanel(new BorderLayout());
        
        String[] cols = {
            "Nama Siswa", "Mata Kuliah", "Nilai", "Grade"
        };
        tableModel = new DefaultTableModel(cols, 0);
        tableData = new JTable(tableModel);
        
        JScrollPane scrollPane = new JScrollPane(tableData);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private void prosesSimpan(){
        String name= fieldName.getText();
        String matkul = (String) optionMatkul.getSelectedItem();
        String strNilai = fieldNilai.getText();
        
        if (name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!",
                    "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int value;
        try {
            value = Integer.parseInt(strNilai);
            if (value < 0 || value > 100){
                JOptionPane.showMessageDialog(this, "Nilai harus range 0 - 100!",
                        "Error Validasi", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Nilai harus berupa angka!", 
                    "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String grade;
        if (value >= 80) grade = "A";
        else if (value >= 70) grade = "AB";
        else if (value >= 60) grade = "B";
        else if (value >= 50) grade = "BC";
        else if (value >= 40) grade = "C";
        else if (value >= 30) grade = "D";
        else grade = "E";
        
        
        Object[] dataBaris = {name, matkul, value, grade};
        tableModel.addRow(dataBaris);
        
        fieldName.setText("");
        fieldNilai.setText("");
        optionMatkul.setSelectedIndex(0);
        
        JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan!");
        tabbedPane.setSelectedIndex(1);
    }
    
    
    public ManajemenNilaiSiswaApp() {
        setTitle("Aplikasi Manajemen Nilai Mahasiswa");
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        tabbedPane = new JTabbedPane();
        
        JPanel panelInput = createInputPanel();
        tabbedPane.addTab("Daftar Nilai", panelInput);
        
        JPanel panelTabel = createTablePanel();
        tabbedPane.addTab("Daftar Nilai", panelTabel);
        
        add(tabbedPane);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ManajemenNilaiSiswaApp().setVisible(true);
        });
    }
}
