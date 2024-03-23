/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg123220064_if.g_quiz;

/**
 *
 * @author Lenovo
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputNilaiFrame extends JFrame {
    private JTextField textFieldNama;
    private JTextField textFieldNim;
    private JTextField textFieldNilaiTugas;
    private JTextField textFieldNilaiQuiz;
    private JRadioButton radioKelasPraktikum;
    private JRadioButton radioKelasTeori;
    private JComboBox<String> comboBoxMataKuliah;
    private JButton buttonSubmit;
    private JButton buttonLogout;

    public InputNilaiFrame() {
        setTitle("HALAMAN INPUT NILAI");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(7, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        textFieldNama = new JTextField();
        textFieldNim = new JTextField();
        textFieldNilaiTugas = new JTextField();
        textFieldNilaiQuiz = new JTextField();
        radioKelasPraktikum = new JRadioButton("Kelas Praktikum");
        radioKelasTeori = new JRadioButton("Kelas Teori");
        ButtonGroup buttonGroupKelas = new ButtonGroup();
        buttonGroupKelas.add(radioKelasPraktikum);
        buttonGroupKelas.add(radioKelasTeori);
        comboBoxMataKuliah = new JComboBox<>(new String[]{"PBO", "SCPK", "Algo Lanjut"});
        buttonSubmit = new JButton("Submit");
        buttonLogout = new JButton("Log-out");

        inputPanel.add(new JLabel("Nama Mahasiswa:"));
        inputPanel.add(textFieldNama);
        inputPanel.add(new JLabel("NIM Mahasiswa:"));
        inputPanel.add(textFieldNim);
        inputPanel.add(new JLabel("Nilai Tugas:"));
        inputPanel.add(textFieldNilaiTugas);
        inputPanel.add(new JLabel("Nilai Quiz:"));
        inputPanel.add(textFieldNilaiQuiz);
        inputPanel.add(new JLabel("Tipe Kelas:"));
        inputPanel.add(radioKelasPraktikum);
        inputPanel.add(new JLabel()); // Spasi
        inputPanel.add(radioKelasTeori);
        inputPanel.add(new JLabel("Mata Kuliah:"));
        inputPanel.add(comboBoxMataKuliah);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(buttonSubmit);
        buttonPanel.add(buttonLogout);

        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        buttonSubmit.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 
                 String nama = textFieldNama.getText().trim();
                 if (!nama.matches("[a-zA-Z\\s]+")) {
                     JOptionPane.showMessageDialog(InputNilaiFrame.this,
                             "Yang bener aja bang, nama kan harusnya huruf dan spasi aja, coba lagi deh...",
                             "Error", JOptionPane.ERROR_MESSAGE);
                     return;
                 }

                 String nimText = textFieldNim.getText().trim();
                 if (!nimText.matches("\\d+")) {
                     JOptionPane.showMessageDialog(InputNilaiFrame.this,
                             "Tau kepanjangan NIM kan? NOMOR Induk Mahasiswa, coba lagi!!!!",
                             "Error", JOptionPane.ERROR_MESSAGE);
                     return;
                 }
                 int nim = Integer.parseInt(nimText);

                 double nilaiTugas;
                 try {
                     nilaiTugas = Double.parseDouble(textFieldNilaiTugas.getText().trim());
                     if (nilaiTugas < 0 || nilaiTugas > 100) {
                         throw new NumberFormatException();
                     }
                 } catch (NumberFormatException ex) {
                     JOptionPane.showMessageDialog(InputNilaiFrame.this,
                             "Nilai kok huruf atau minus, nilai tuh 0 sampai 100, coba lagi!!",
                             "Error", JOptionPane.ERROR_MESSAGE);
                     return;
                 }

                 double nilaiQuiz;
                 try {
                     nilaiQuiz = Double.parseDouble(textFieldNilaiQuiz.getText().trim());
                     if (nilaiQuiz < 0 || nilaiQuiz > 100) {
                         throw new NumberFormatException();
                     }
                 } catch (NumberFormatException ex) {
                     JOptionPane.showMessageDialog(InputNilaiFrame.this,
                             "Nilai kok huruf atau minus, nilai tuh 0 sampai 100, coba lagi!!",
                             "Error", JOptionPane.ERROR_MESSAGE);
                     return;
                 }

                 String tipeKelas = radioKelasPraktikum.isSelected() ? "Kelas Praktikum" : "Kelas Teori";
                 String mataKuliah = comboBoxMataKuliah.getSelectedItem().toString();

                 Mahasiswa mahasiswa = new Mahasiswa(nama, nim, nilaiTugas, nilaiQuiz, tipeKelas, mataKuliah);

                 double totalNilai = mahasiswa.hitungTotalNilai();
                 String hasilPenilaian = mahasiswa.hasilPenilaian();

                 JOptionPane.showMessageDialog(InputNilaiFrame.this,
                         "Nama: " + nama + "\n" +
                                 "NIM: " + nim + "\n" +
                                 "Tipe Kelas: " + tipeKelas + "\n" +
                                 "Mata Kuliah: " + mataKuliah + "\n" +
                                 "Hasil: " + hasilPenilaian + "\n" +
                                 "Total Nilai: " + totalNilai);
             }
         });


        buttonLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(InputNilaiFrame.this, "Mau Logout Yah?", "Konfirmasi Logout", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    dispose();
                    LoginFrame loginFrame = new LoginFrame();
                }
            }
        });

 
        add(mainPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        InputNilaiFrame inputNilaiFrame = new InputNilaiFrame();
    }
}
