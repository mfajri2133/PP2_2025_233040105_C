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
public class TugasModul7 extends JFrame {
    private JTextField fieldName, fieldNilai;
    private JComboBox<String> optionMatkul;
    private JTable tableData;
    private DefaultTableModel tableModel;
    private JTabbedPane tabbedPane;

    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
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
        btnSimpan.addActionListener(e -> prosesSimpan());
        
        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(e -> {
            fieldName.setText("");
            fieldNilai.setText("");
        });

        panel.add(new JLabel(""));
        panel.add(btnSimpan);
        panel.add(new JLabel(""));
        panel.add(btnReset);

        return panel;
    }

    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] cols = { "Nama Siswa", "Mata Kuliah", "Nilai", "Grade" };
        tableModel = new DefaultTableModel(cols, 0);
        tableData = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(tableData);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        JButton btnHapus = new JButton("Hapus Data");

        btnHapus.addActionListener(e -> {
            int selectedRow = tableData.getSelectedRow();
            if (selectedRow > -1) {
                tableModel.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Baris berhasil dihapus.");
            } else {
                JOptionPane.showMessageDialog(this, "Pilih baris terlebih dahulu!");
            }
        });

        bottomPanel.add(btnHapus);
        panel.add(bottomPanel, BorderLayout.EAST);

        return panel;
    }

    private void prosesSimpan() {
        String name = fieldName.getText();
        String matkul = (String) optionMatkul.getSelectedItem();
        String strNilai = fieldNilai.getText();

        if (name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!",
                    "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (name.length() < 3) {
            JOptionPane.showMessageDialog(this, "Nama minimal harus 3 karakter!",
                    "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int value;
        try {
            value = Integer.parseInt(strNilai);
            if (value < 0 || value > 100) {
                JOptionPane.showMessageDialog(this, "Nilai harus range 0 - 100!",
                        "Error Validasi", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nilai harus berupa angka!",
                    "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String grade;
        switch (value / 10) {
            case 10:
            case 9:
            case 8: grade = "A"; break;
            case 7: grade = "AB"; break;
            case 6: grade = "B"; break;
            case 5: grade = "BC"; break;
            case 4: grade = "C"; break;
            case 3: grade = "D"; break;
            default: grade = "E"; break;
        }

        Object[] dataBaris = { name, matkul, value, grade };
        tableModel.addRow(dataBaris);

        fieldName.setText("");
        fieldNilai.setText("");
        optionMatkul.setSelectedIndex(0);

        JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan!");
        tabbedPane.setSelectedIndex(1);
    }

    public TugasModul7() {
        setTitle("Aplikasi Manajemen Nilai Mahasiswa");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();

        JPanel panelInput = createInputPanel();
        tabbedPane.addTab("Input Data", panelInput);

        JPanel panelTabel = createTablePanel();
        tabbedPane.addTab("Daftar Nilai", panelTabel);

        add(tabbedPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TugasModul7().setVisible(true));
    }
}