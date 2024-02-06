/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pembayaran_spp.model;

/**
 *
 * @author Rafli
 */
public class Spp_model {
    private Integer Tahun;
    private Double Nominal;
    
    public Spp_model(Integer Tahun, Double Nominal)
    {
        this.Tahun = Tahun;
        this.Nominal = Nominal;
    }

    public Integer getTahun() {
        return Tahun;
    }

    public void setTahun(Integer Tahun) {
        this.Tahun = Tahun;
    }

    public Double getNominal() {
        return Nominal;
    }

    public void setNominal(Double Nominal) {
        this.Nominal = Nominal;
    }
    
    
}
