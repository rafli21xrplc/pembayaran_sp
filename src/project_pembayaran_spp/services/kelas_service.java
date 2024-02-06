/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pembayaran_spp.services;

import java.sql.PreparedStatement;
import java.util.UUID;
import javax.swing.JOptionPane;
import project_pembayaran_spp.database.database_service;
import project_pembayaran_spp.model.Kelas_model;

/**
 *
 * @author Rafli
 */
public class kelas_service {

    public Boolean InsertClass(Kelas_model model) {
        try {
            String query = "INSERT INTO Kelas VALUES (?,?,?)";
            PreparedStatement ps = database_service.getConnection().prepareStatement(query);
            ps.setString(1, UUID.randomUUID().toString());
            ps.setString(2, model.getClassName());
            ps.setString(3, model.getKopetensi());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showConfirmDialog(null, "CREATE CLASS SUCCESS");
            return true;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            return false;
        }
    }

    public Boolean UpdateClass(Kelas_model model, String ID) {
        try {
            String query = "UPDATE Kelas SET Nama=?, Kompetensi=? WHERE ID=?";
            PreparedStatement ps = database_service.getConnection().prepareStatement(query);

            ps.setString(1, model.getClassName());
            ps.setString(2, model.getKopetensi());
            ps.setString(3, ID);

            int rowsUpdated = ps.executeUpdate();
            ps.close();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "UPDATE CLASS SUCCESS");
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

    public boolean DeleteClass(String ID) {
        try {
            String query = "DELETE FROM Kelas WHERE ID=?";
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
