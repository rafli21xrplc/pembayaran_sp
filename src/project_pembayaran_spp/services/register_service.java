/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pembayaran_spp.services;

import java.sql.PreparedStatement;
import java.util.UUID;
import javax.swing.JOptionPane;
import project_pembayaran_spp.database.database_service;
import project_pembayaran_spp.model.Siswa_model;

/**
 *
 * @author Rafli
 */
public class register_service {

//    public Boolean InsertSiswaRegister(Siswa_model model) {
//        try {
//            String query = "INSERT INTO SISWA VALUES (?,?,?,?,?,?,?,?,?)";
//            PreparedStatement ps = database_service.getConnection().prepareStatement(query);
//            ps.setString(1, UUID.randomUUID().toString());
//            ps.setString(2, model.getNisn());
//            ps.setString(3, model.getNis());
//            ps.setString(4, model.getUsername());
//            ps.setString(5, model.getPassword());
//            ps.setString(6, model.getAlamat());
//            ps.setString(7, model.getTlp().toString());
//            ps.setString(8, model.getId_spp().toString());
//            ps.setString(9, model.getId_kelas().toString());
//            ps.executeUpdate();
//            ps.close();
//            JOptionPane.showConfirmDialog(null, "REGISTER SUCCESS");
//            return true;
//        } catch (Exception e) {
//            JOptionPane.showConfirmDialog(null, e.getMessage());
//            return false;
//        }
//    }

}
