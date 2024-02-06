/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pembayaran_spp.model;

/**
 *
 * @author Rafli
 */
public class Pembayaran_model {
    String id_petugas;
    String nisn;
    String tgl_bayar;
    String bln_bayar;
    String thn_bayar;
    String id_spp;
    Integer jumlah_bayar;
    
    public Pembayaran_model(String id_petugas, String nisn, String tgl_bayar, String bln_bayar, String thn_bayar, String id_spp, Integer jumlah_bayar) {
        this.id_petugas = id_petugas;
        this.nisn = nisn;
        this.tgl_bayar = tgl_bayar;
        this.bln_bayar = bln_bayar;
        this.thn_bayar = thn_bayar;
        this.id_spp = id_spp;
        this.jumlah_bayar = jumlah_bayar;
    }

    public String getId_petugas() {
        return id_petugas;
    }

    public void setId_petugas(String id_petugas) {
        this.id_petugas = id_petugas;
    }

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public String getTgl_bayar() {
        return tgl_bayar;
    }

    public void setTgl_bayar(String tgl_bayar) {
        this.tgl_bayar = tgl_bayar;
    }

    public String getBln_bayar() {
        return bln_bayar;
    }

    public void setBln_bayar(String bln_bayar) {
        this.bln_bayar = bln_bayar;
    }

    public String getThn_bayar() {
        return thn_bayar;
    }

    public void setThn_bayar(String thn_bayar) {
        this.thn_bayar = thn_bayar;
    }

    public String getId_spp() {
        return id_spp;
    }

    public void setId_spp(String id_spp) {
        this.id_spp = id_spp;
    }

    public Integer getJumlah_bayar() {
        return jumlah_bayar;
    }

    public void setJumlah_bayar(Integer jumlah_bayar) {
        this.jumlah_bayar = jumlah_bayar;
    }
    
    
}
