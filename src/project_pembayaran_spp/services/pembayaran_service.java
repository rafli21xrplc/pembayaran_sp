package project_pembayaran_spp.services;


import java.sql.PreparedStatement;
import java.util.UUID;
import javax.swing.JOptionPane;
import project_pembayaran_spp.database.database_service;
import project_pembayaran_spp.model.Kelas_model;
import project_pembayaran_spp.model.Pembayaran_model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Rafli
 */
public class pembayaran_service {

    public Boolean InsertPembayaran(Pembayaran_model model) {
        try {
            String query = "INSERT INTO pembayaran VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = database_service.getConnection().prepareStatement(query);
            ps.setString(1, UUID.randomUUID().toString());
            ps.setString(2, model.getId_petugas());
            ps.setString(3, model.getNisn());
            ps.setString(4, model.getTgl_bayar());
            ps.setString(5, model.getBln_bayar());
            ps.setString(6, model.getThn_bayar());
            ps.setString(7, model.getId_spp());
            ps.setString(8, model.getJumlah_bayar().toString());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showConfirmDialog(null, "PEMBAYARAN CLASS SUCCESS");
            return true;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            return false;
        }
    }

    public Boolean UpdatePembayaran(Pembayaran_model model, String ID) {
        try {
            String query = "UPDATE Kelas SET id_petugas=?, nisn=?, tgl_bayar=?, bln_bayar=?, thn_bayar=?, id_spp=?, jumlah_bayar=? WHERE ID=?";
            PreparedStatement ps = database_service.getConnection().prepareStatement(query);

            ps.setString(1, model.getId_petugas());
            ps.setString(2, model.getNisn());
            ps.setString(3, model.getTgl_bayar());
            ps.setString(4, model.getBln_bayar());
            ps.setString(5, model.getThn_bayar());
            ps.setString(6, model.getId_spp());
            ps.setString(7, model.getJumlah_bayar().toString());
            ps.setString(8, ID);

            int rowsUpdated = ps.executeUpdate();
            ps.close();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "UPDATE PEMBAYARAN SUCCESS");
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

    public boolean DeletePembayaran(String ID) {
        try {
            String query = "DELETE FROM pembayaran WHERE ID=?";
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
