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
import project_pembayaran_spp.model.Spp_model;

/**
 *
 * @author Rafli
 */
public class siswa_service {
      public Boolean InsertSiswa(Siswa_model model) {
        try {
            String query = "INSERT INTO SISWA VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = database_service.getConnection().prepareStatement(query);
            ps.setString(1, UUID.randomUUID().toString());
            ps.setString(2, model.getNisn());
            ps.setString(3, model.getNis());
            ps.setString(4, model.getNama());
            ps.setString(5, model.getAlamat());
            ps.setString(6, model.getTlp().toString());
            ps.setString(7, model.getId_kelas());
            ps.setString(8, model.getId_spp());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showConfirmDialog(null, "CREATE SISWA SUCCESS");
            return true;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            return false;
        }
    }
      
      public Boolean UpdateSiswa(Siswa_model model, String ID) {
        try {
            String query = "UPDATE siswa SET nisn=?, nis=?, nama=?, alamat=?, no_tlp=?, id_spp=?, id_kelas=? WHERE uuid=?";
            PreparedStatement ps = database_service.getConnection().prepareStatement(query);

            ps.setString(1, model.getNisn());
            ps.setString(2, model.getNis());
            ps.setString(3, model.getNama());
            ps.setString(4, model.getAlamat());
            ps.setString(5, model.getTlp().toString());
            ps.setString(6, model.getId_spp().toString());
            ps.setString(7, model.getId_kelas().toString());
            ps.setString(8, ID);

            int rowsUpdated = ps.executeUpdate();
            ps.close();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "UPDATE SISWA SUCCESS");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No data updated. ID not found.");
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public boolean DeleteSiswa(String ID) {
        try {
            String query = "DELETE FROM siswa WHERE uuid=?";
            PreparedStatement ps = database_service.getConnection().prepareStatement(query);

            ps.setString(1, ID);

            int rowsDeleted = ps.executeUpdate();
            ps.close();

            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus.");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Tidak ada data yang dihapus. ID tidak ditemukan.");
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return false;
        }
    }

}
