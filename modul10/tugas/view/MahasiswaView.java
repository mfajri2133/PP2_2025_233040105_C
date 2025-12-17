/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040105.modul10.tugas.view;

import id.ac.unpas.pp2_c_233040105.modul10.tugas.controller.MahasiswaController;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 *
 * @author spag9
 */
public class MahasiswaView extends JFrame {

    JTextField txtNama, txtNIM, txtJurusan, txtCari;
    JButton btnSimpan, btnEdit, btnHapus, btnClear, btnCari;
    JTable tableMahasiswa;
    DefaultTableModel model;

    MahasiswaController controller = new MahasiswaController();

    public MahasiswaView() {
        setTitle("Aplikasi CRUD Mahasiswa JDBC (MVC)");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelForm = new JPanel(new GridLayout(3, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelForm.add(new JLabel("Nama:"));
        txtNama = new JTextField();
        panelForm.add(txtNama);

        panelForm.add(new JLabel("NIM:"));
        txtNIM = new JTextField();
        panelForm.add(txtNIM);

        panelForm.add(new JLabel("Jurusan:"));
        txtJurusan = new JTextField();
        panelForm.add(txtJurusan);

        // ===== TOMBOL AKSI =====
        JPanel panelTombol = new JPanel(new FlowLayout());
        btnSimpan = new JButton("Simpan");
        btnEdit = new JButton("Edit");
        btnHapus = new JButton("Hapus");
        btnClear = new JButton("Clear");

        panelTombol.add(btnSimpan);
        panelTombol.add(btnEdit);
        panelTombol.add(btnHapus);
        panelTombol.add(btnClear);

        // ===== PANEL CARI =====
        JPanel panelCari = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelCari.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        panelCari.add(new JLabel("Cari Nama:"));
        txtCari = new JTextField(20);
        panelCari.add(txtCari);
        btnCari = new JButton("Cari");
        panelCari.add(btnCari);

        // ===== PANEL ATAS =====
        JPanel panelAtas = new JPanel();
        panelAtas.setLayout(new BoxLayout(panelAtas, BoxLayout.Y_AXIS));
        panelAtas.add(panelForm);
        panelAtas.add(panelTombol);
        panelAtas.add(panelCari);

        add(panelAtas, BorderLayout.NORTH);

        model = new DefaultTableModel(new Object[]{"NO", "Nama", "NIM", "Jurusan"}, 0);
        tableMahasiswa = new JTable(model);
        add(new JScrollPane(tableMahasiswa), BorderLayout.CENTER);

        tableMahasiswa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tableMahasiswa.getSelectedRow();
                txtNama.setText(model.getValueAt(row, 1).toString());
                txtNIM.setText(model.getValueAt(row, 2).toString());
                txtJurusan.setText(model.getValueAt(row, 3).toString());
            }
        });

        btnSimpan.addActionListener(e ->
            controller.insert(
                txtNama.getText(),
                txtNIM.getText(),
                txtJurusan.getText(),
                model
            )
        );

        btnEdit.addActionListener(e ->
            controller.update(
                txtNama.getText(),
                txtJurusan.getText(),
                txtNIM.getText(),
                model
            )
        );

        btnHapus.addActionListener(e ->
            controller.delete(txtNIM.getText(), model)
        );

        btnClear.addActionListener(e -> kosongkanForm());

        btnCari.addActionListener(e ->
            controller.search(txtCari.getText(), model)
        );

        controller.loadData(model);
    }

    private void kosongkanForm() {
        txtNama.setText("");
        txtNIM.setText("");
        txtJurusan.setText("");
    }
}