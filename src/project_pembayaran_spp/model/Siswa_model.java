/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pembayaran_spp.model;

/**
 *
 * @author Rafli
 */
public class Siswa_model {

    private String nisn;
    private String nis;
    private String nama;
    private String alamat;
    private Integer tlp;

    // relation column id
    private String id_kelas;
    private String id_spp;

    public Siswa_model(String nisn, String nis, String nama, String alamat, Integer tlp, String id_kelas, String id_spp) {
        this.nisn = nisn;
        this.nis = nis;
        this.nama = nama;
        this.alamat = alamat;
        this.tlp = tlp;

        // relation column id
        this.id_kelas = id_kelas;
        this.id_spp = id_spp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Integer getTlp() {
        return tlp;
    }

    public void setTlp(Integer tlp) {
        this.tlp = tlp;
    }

    public String getId_kelas() {
        return id_kelas;
    }

    public void setId_kelas(String id_kelas) {
        this.id_kelas = id_kelas;
    }

    public String getId_spp() {
        return id_spp;
    }

    public void setId_spp(String id_spp) {
        this.id_spp = id_spp;
    }

}
