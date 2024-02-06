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
import project_pembayaran_spp.model.Petugas_model;

/**
 *
 * @author Rafli
 */
public class petugas_service {
    public Boolean InsertPetugas(Petugas_model model) {
        try {
            String query = "INSERT INTO Petugas VALUES (?,?,?,?,?)";
            PreparedStatement ps = database_service.getConnection().prepareStatement(query);
            ps.setString(1, UUID.randomUUID().toString());
            ps.setString(2, model.getUsername());
            ps.setString(3, model.getPassword());
            ps.setString(4, model.getNama_petugas());
            ps.setString(5, model.getLevel().toString());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showConfirmDialog(null, "CREATE PETUGAS SUCCESS");
            return true;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            return false;
        }
    }

    public Boolean UpdatePetugas(Petugas_model model, String ID) {
        try {
            String query = "UPDATE Petugas SET username=?, password=?, nama_petugas=?, level=? WHERE ID=?";
            PreparedStatement ps = database_service.getConnection().prepareStatement(query);

            ps.setString(1, model.getUsername());
            ps.setString(2, model.getPassword());
            ps.setString(3, model.getNama_petugas());
            ps.setString(4, model.getLevel().toString());
            ps.setString(5, ID);

            int rowsUpdated = ps.executeUpdate();
            ps.close();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "UPDATE PETUGAS SUCCESS");
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

    public boolean DeletePetugas(String ID) {
        try {
            String query = "DELETE FROM Petugas WHERE ID=?";
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
