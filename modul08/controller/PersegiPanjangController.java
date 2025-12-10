/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040105.modul08.controller;

import id.ac.unpas.pp2_c_233040105.modul08.model.PersegiPanjangModel;
import id.ac.unpas.pp2_c_233040105.modul08.view.PersegiPanjangView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author spag9
 */
public class PersegiPanjangController {
    private PersegiPanjangModel model;
    private PersegiPanjangView view;
    
    public PersegiPanjangController(PersegiPanjangModel model, PersegiPanjangView view){
        this.model = model;
        this.view = view;
        
        this.view.addHitungListener(new HitungListener());
        
        // mengisi reset listener kepada addresetlistener
        this.view.addResetListener(new ResetListener());
    }
    
    class HitungListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            try {
                double p = view.getPanjang();
                double l = view.getLebar();
                
                model.setPanjang(p);
                model.setLebar(l);
                
                model.hitungLuas();
                
                // memanggil hitung keliling dari model
                model.hitungKeliling();
                
                double hasil = model.getLuas();
                view.setHasil(hasil);

                double hasilLuas = model.getKeliling();
                view.setKeliling(hasilLuas);
            } catch (NumberFormatException ex) {
                view.tampilkanPesanError("Masukkan angka yang valid!");
            }
        }
    }
    
    class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.resetForm();
        }
    }
}
