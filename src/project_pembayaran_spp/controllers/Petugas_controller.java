/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pembayaran_spp.controllers;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import project_pembayaran_spp.model.Petugas_model;
import project_pembayaran_spp.model.Spp_model;
import project_pembayaran_spp.services.database_process.SELECT_DATABASE;
import project_pembayaran_spp.services.petugas_service;
import project_pembayaran_spp.services.spp_service;

/**
 *
 * @author Rafli
 */
public class Petugas_controller {

    public void insertPetugasAction(String username, String password, String nama_petugas, String level, DefaultTableModel tableModel) {
        Petugas_model model = new Petugas_model(username, password, nama_petugas, level);

        try {
            petugas_service service = new petugas_service();
            service.InsertPetugas(model);

            SELECT_DATABASE select = new SELECT_DATABASE();
            ResultSet data = select.getData("Petugas");

            tableModel.setRowCount(0);

            while (data.next()) {
                String ID = data.getString("ID");
                String USERNAME = data.getString("username");
                String NAMA_PETUGAS = data.getString("nama_petugas");
                String LEVEL = data.getString("level");

                String tbData[] = {ID, USERNAME, NAMA_PETUGAS, LEVEL};
                tableModel.addRow(tbData);
            }

            data.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void updatePetugasAction(String username, String password, String nama_petugas, String level, Integer selectedRow, String ID, DefaultTableModel tableModel) {

        Petugas_model model = new Petugas_model(username, password, nama_petugas, level);

        try {
            petugas_service service = new petugas_service();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Pilih baris yang ingin diupdate.");
                return;
            }

            System.out.println("ID = " + ID);

            if (service.UpdatePetugas(model, ID)) {
                SELECT_DATABASE select = new SELECT_DATABASE();
                ResultSet data = select.getData("Petugas");

                tableModel.setRowCount(0);

                while (data.next()) {
                    String rowID = data.getString("ID");
                    String USERNAME = data.getString("username");
                    String NAMA_PETUGAS = data.getString("nama_petugas");
                    String LEVEL = data.getString("level");

                    String tbData[] = {rowID, USERNAME, NAMA_PETUGAS, LEVEL};
                    tableModel.addRow(tbData);
                }

                data.close();

                JOptionPane.showMessageDialog(null, "Update berhasil.");
            } else {
                JOptionPane.showMessageDialog(null, "Update gagal.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void deletePetugasAction(Integer selectedRow, String ID, DefaultTableModel tableModel) {
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Pilih baris yang ingin dihapus.");
            return;
        }

        try {
            petugas_service service = new petugas_service();

            if (service.DeletePetugas(ID)) {
                SELECT_DATABASE select = new SELECT_DATABASE();
                ResultSet data = select.getData("Petugas");

                tableModel.setRowCount(0);

                while (data.next()) {
                    String rowID = data.getString("ID");
                    String USERNAME = data.getString("username");
                    String NAMA_PETUGAS = data.getString("nama_petugas");
                    String LEVEL = data.getString("level");

                    String tbData[] = {rowID, USERNAME, NAMA_PETUGAS, LEVEL};
                    tableModel.addRow(tbData);
                }

                data.close();

                JOptionPane.showMessageDialog(null, "Penghapusan berhasil.");
            } else {
                JOptionPane.showMessageDialog(null, "Penghapusan gagal.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
}
