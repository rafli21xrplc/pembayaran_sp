/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pembayaran_spp.controllers;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import project_pembayaran_spp.model.Spp_model;
import project_pembayaran_spp.services.database_process.SELECT_DATABASE;
import project_pembayaran_spp.services.spp_service;

/**
 *
 * @author Rafli
 */
public class Spp_controller {

    public void insertSppAction(Integer Tahun, Double Nominal, DefaultTableModel tableModel) {
        Spp_model model = new Spp_model(Tahun, Nominal);

        try {
            spp_service service = new spp_service();
            service.InsertSpp(model);

            SELECT_DATABASE select = new SELECT_DATABASE();
            ResultSet data = select.getData("Spp");

            tableModel.setRowCount(0);

            while (data.next()) {
                String ID = data.getString("ID");
                String TAHUN = data.getString("Tahun");
                String NOMINAL = data.getString("Nominal");

                String tbData[] = {ID, TAHUN, NOMINAL};
                tableModel.addRow(tbData);
            }

            data.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void updateSppAction(Integer Tahun, Double Nominal, Integer selectedRow, String ID, DefaultTableModel tableModel) {

        Spp_model model = new Spp_model(Tahun, Nominal);

        try {
            spp_service service = new spp_service();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Pilih baris yang ingin diupdate.");
                return;
            }

            System.out.println("ID = " + ID);

            if (service.UpdateSpp(model, ID)) {
                SELECT_DATABASE select = new SELECT_DATABASE();
                ResultSet data = select.getData("Spp");

                tableModel.setRowCount(0);

                while (data.next()) {
                    String rowID = data.getString("ID");
                    String TAHUN = data.getString("Tahun");
                    String NOMINAL = data.getString("Nominal");

                    String tbData[] = {rowID, TAHUN, NOMINAL};
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

    public void deleteSppAction(Integer selectedRow, String ID, DefaultTableModel tableModel) {
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Pilih baris yang ingin dihapus.");
            return;
        }

        try {
            spp_service service = new spp_service();

            if (service.DeleteSpp(ID)) {
                SELECT_DATABASE select = new SELECT_DATABASE();
                ResultSet data = select.getData("Spp");

                tableModel.setRowCount(0);

                while (data.next()) {
                    String rowID = data.getString("ID");
                    String TAHUN = data.getString("Tahun");
                    String NOMINAL = data.getString("Nominal");

                    String tbData[] = {rowID, TAHUN, NOMINAL};
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
