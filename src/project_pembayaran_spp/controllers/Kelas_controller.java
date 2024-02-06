package project_pembayaran_spp.controllers;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import project_pembayaran_spp.application.Dashboard;
import project_pembayaran_spp.model.Kelas_model;
import project_pembayaran_spp.services.database_process.SELECT_DATABASE;
import project_pembayaran_spp.services.kelas_service;
import java.sql.ResultSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Rafli
 */
public class Kelas_controller extends Dashboard {

    public void insertKelasAction(String ClassName, String Kompetensi, DefaultTableModel tableModel) {

        Kelas_model model = new Kelas_model(ClassName, Kompetensi);

        try {
            kelas_service service = new kelas_service();
            service.InsertClass(model);

            SELECT_DATABASE select = new SELECT_DATABASE();
            ResultSet data = select.getData("Kelas");

            tableModel.setRowCount(0);

            while (data.next()) {
                String ID = data.getString("ID");
                String NAMA = data.getString("Nama");
                String KOMPETENSI = data.getString("Kompetensi");

                String tbData[] = {ID, NAMA, KOMPETENSI};
                tableModel.addRow(tbData);  
            }

            data.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void updateKelasAction(String ClassName, String Kompetensi, Integer selectedRow, String ID, DefaultTableModel tableModel) {

        Kelas_model model = new Kelas_model(ClassName, Kompetensi);

        try {
            kelas_service service = new kelas_service();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Pilih baris yang ingin diupdate.");
                return;
            }

            System.out.println("ID = " + ID);

            if (service.UpdateClass(model, ID)) {
                SELECT_DATABASE select = new SELECT_DATABASE();
                ResultSet data = select.getData("Kelas");

                tableModel.setRowCount(0);

                while (data.next()) {
                    String rowID = data.getString("ID");
                    String NAMA = data.getString("Nama");
                    String KOMPETENSI = data.getString("Kompetensi");

                    String tbData[] = {rowID, NAMA, KOMPETENSI};
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
    
    public void deleteKelasAction(Integer selectedRow, String ID, DefaultTableModel tableModel)
    {
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Pilih baris yang ingin dihapus.");
            return;
        }

        try {
            kelas_service service = new kelas_service();

            if (service.DeleteClass(ID)) {
                SELECT_DATABASE select = new SELECT_DATABASE();
                ResultSet data = select.getData("Kelas");

                tableModel.setRowCount(0);

                while (data.next()) {
                    String rowID = data.getString("ID");
                    String NAMA = data.getString("Nama");
                    String KOMPETENSI = data.getString("Kompetensi");

                    String tbData[] = {rowID, NAMA, KOMPETENSI};
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
