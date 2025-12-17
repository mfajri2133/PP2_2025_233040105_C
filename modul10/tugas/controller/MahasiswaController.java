/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040105.modul10.tugas.controller;

import id.ac.unpas.pp2_c_233040105.modul10.tugas.model.MahasiswaModel;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author spag9
 */
public class MahasiswaController {

    private MahasiswaModel model = new MahasiswaModel();

    public void loadData(DefaultTableModel table) {
        table.setRowCount(0);
        try {
            ResultSet rs = model.getAll();
            int no = 1;
            while (rs.next()) {
                table.addRow(new Object[]{
                    no++,
                    rs.getString("nama"),
                    rs.getString("nim"),
                    rs.getString("jurusan")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void insert(String nama, String nim, String jurusan, DefaultTableModel table) {
        try {
            if (nama.isEmpty() || nim.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nama dan NIM wajib diisi");
                return;
            }

            if (model.existNIM(nim)) {
                JOptionPane.showMessageDialog(null, "NIM sudah terdaftar");
                return;
            }

            model.insert(nama, nim, jurusan);
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            loadData(table);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void update(String nama, String jurusan, String nim, DefaultTableModel table) {
        try {
            model.update(nama, jurusan, nim);
            JOptionPane.showMessageDialog(null, "Data berhasil diubah");
            loadData(table);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void delete(String nim, DefaultTableModel table) {
        try {
            model.delete(nim);
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            loadData(table);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void search(String keyword, DefaultTableModel table) {
        table.setRowCount(0);
        try {
            ResultSet rs = model.search(keyword);
            int no = 1;
            while (rs.next()) {
                table.addRow(new Object[]{
                    no++,
                    rs.getString("nama"),
                    rs.getString("nim"),
                    rs.getString("jurusan")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
