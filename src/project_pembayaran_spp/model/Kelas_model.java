/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pembayaran_spp.model;

/**
 *
 * @author Rafli
 */
public class Kelas_model {
    private String ClassName;
    private String Kopetensi;
    
    public Kelas_model(String ClassName, String Kopetensi)
    {
        this.ClassName = ClassName;
        this.Kopetensi = Kopetensi;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String ClassName) {
        this.ClassName = ClassName;
    }

    public String getKopetensi() {
        return Kopetensi;
    }

    public void setKopetensi(String Kopetensi) {
        this.Kopetensi = Kopetensi;
    }
    
    
}
