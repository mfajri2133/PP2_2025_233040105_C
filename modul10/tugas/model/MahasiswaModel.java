/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040105.modul10.tugas.model;

import id.ac.unpas.pp2_c_233040105.modul10.KoneksiDB;
import java.sql.*;

/**
 *
 * @author spag9
 */
public class MahasiswaModel {
    public ResultSet getAll() throws SQLException {
        Connection conn = KoneksiDB.configDB();
        Statement stm = conn.createStatement();
        return stm.executeQuery("SELECT * FROM mahasiswa");
    }

    public void insert(String nama, String nim, String jurusan) throws SQLException {
        String sql = "INSERT INTO mahasiswa (nama, nim, jurusan) VALUES (?, ?, ?)";
        Connection conn = KoneksiDB.configDB();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, nama);
        pst.setString(2, nim);
        pst.setString(3, jurusan);
        pst.executeUpdate();
    }

    public void update(String nama, String jurusan, String nim) throws SQLException {
        String sql = "UPDATE mahasiswa SET nama = ?, jurusan = ? WHERE nim = ?";
        Connection conn = KoneksiDB.configDB();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, nama);
        pst.setString(2, jurusan);
        pst.setString(3, nim);
        pst.executeUpdate();
    }

    public void delete(String nim) throws SQLException {
        String sql = "DELETE FROM mahasiswa WHERE nim = ?";
        Connection conn = KoneksiDB.configDB();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, nim);
        pst.executeUpdate();
    }

    public ResultSet search(String keyword) throws SQLException {
        String sql = "SELECT * FROM mahasiswa WHERE nama LIKE ?";
        Connection conn = KoneksiDB.configDB();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, "%" + keyword + "%");
        return pst.executeQuery();
    }

    public boolean existNIM(String nim) throws SQLException {
        String sql = "SELECT 1 FROM mahasiswa WHERE nim = ?";
        Connection conn = KoneksiDB.configDB();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, nim);
        return pst.executeQuery().next();
    }
}
