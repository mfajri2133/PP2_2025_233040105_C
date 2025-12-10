/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040105.modul09;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 *
 * @author spag9
 */
public class AplikasiFileIO extends JFrame {
    private JTextArea textArea;
    private JButton btnOpenText, btnSaveText, btnAddText;
    private JButton btnSaveBinary, btnLoadBinary;
    private JFileChooser fileChooser;
    
    public AplikasiFileIO() {
        super("Tutorial FIle IO & Exception Handling");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        fileChooser = new JFileChooser();
        
        JPanel buttonPanel = new JPanel();
        btnOpenText = new JButton("Buka Text");
        btnSaveText = new JButton("Simpan Text");
        btnAddText = new JButton("Tambah Text");
        btnSaveBinary = new JButton("Simpan Config (Binary)");
        btnLoadBinary = new JButton("Muat Config (Binary)");
        
        buttonPanel.add(btnOpenText);
        buttonPanel.add(btnSaveBinary);
        buttonPanel.add(btnSaveText);
        buttonPanel.add(btnAddText);
        buttonPanel.add(btnLoadBinary);
        
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        btnOpenText.addActionListener(e -> bukaFIleText());
        btnSaveText.addActionListener(e -> simpanFileText());
        btnSaveBinary.addActionListener(e -> simpanConfigBinary());
        btnLoadBinary.addActionListener(e -> muatConfigBinary());
        btnAddText.addActionListener(e -> appendFileText());
        
        muatFileOtomatis();
        setVisible(true);
    }
    
    private void bukaFIleText() {
        if(fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            BufferedReader reader = null;
            
            try {
                reader = new BufferedReader(new FileReader(file));
                textArea.setText("");
                
                String line;
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }
                
                JOptionPane.showMessageDialog(this, "File berhasil dimuat!");
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(this, "File tidak ditemukan: " + e.getMessage());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Gagal membaca file: " + e.getMessage());
            } finally {
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    private void simpanFileText() {
        if(fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(textArea.getText());
                
                JOptionPane.showMessageDialog(this, "File berhasil disimpan!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan file: " + e.getMessage());
            }
        }
    }
    
    private void simpanConfigBinary() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("userconfig.bin"))) {

            UserConfig config = new UserConfig();
            config.setUsername("DefaultUser");
            config.setFontSize(textArea.getFont().getSize());

            oos.writeObject(config);

            JOptionPane.showMessageDialog(this, 
                "Config disimpan! Username: " + config.getUsername() + 
                "Font Size: " + config.getFontSize());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan config: " + e.getMessage());
        }
    }

    
    private void muatConfigBinary() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("userconfig.bin"))) {

            UserConfig config = (UserConfig) ois.readObject();

            textArea.setFont(new Font("Monospaced", Font.PLAIN, config.getFontSize()));

            JOptionPane.showMessageDialog(this, 
                "Config dimuat! Username: " + config.getUsername() + 
                "Font Size: " + config.getFontSize());

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Config belum dibuat!");
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Gagal membaca config: " + e.getMessage());
        }
    }

    
    private void muatFileOtomatis() {
        try (BufferedReader reader = new BufferedReader(new FileReader("last_notes.txt"))) {
            textArea.setText("");
                
                String line;
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "File last_notes.text belum dibuat!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "gagal membaca file: " + e.getMessage());
        }
    }
    
    private void appendFileText() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write(textArea.getText());
                writer.newLine();
                JOptionPane.showMessageDialog(this, "Teks berhasil ditambahkan ke file!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Gagal menambah teks: " + e.getMessage());
            }
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AplikasiFileIO().setVisible(true);
        });
    }
}
