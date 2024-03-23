/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg123220064_if.g_quiz;

/**
 *
 * @author Lenovo
 */
public class Mahasiswa {
    private String nama;
    private int nim;
    private double nilaiTugas;
    private double nilaiQuiz;
    private String tipeKelas;
    private String mataKuliah;

    public Mahasiswa(String nama, int nim, double nilaiTugas, double nilaiQuiz, String tipeKelas, String mataKuliah) {
        this.nama = nama;
        this.nim = nim;
        this.nilaiTugas = nilaiTugas;
        this.nilaiQuiz = nilaiQuiz;
        this.tipeKelas = tipeKelas;
        this.mataKuliah = mataKuliah;
    }

    public double hitungTotalNilai() {
        if (tipeKelas.equals("Kelas Praktikum")) {
            return nilaiTugas * 0.3 + nilaiQuiz * 0.7;
        } else {
            return nilaiTugas * 0.7 + nilaiQuiz * 0.3;
        }
    }

    public String hasilPenilaian() {
        if (hitungTotalNilai() >= 85) {
            return "Pass";
        } else {
            return "Not Pass";
        }
    }
}


