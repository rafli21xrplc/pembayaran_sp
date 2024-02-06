/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pembayaran_spp.controllers;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import project_pembayaran_spp.model.Siswa_model;
import project_pembayaran_spp.services.database_process.SELECT_DATABASE;
import project_pembayaran_spp.services.siswa_service;

/**
 *
 * @author Rafli
 */
public class Siswa_controller {

    public void insertSiswaAction(String SPP_NAME, String KELAS_NAME, String nisn, String nis, String name, String alamat, Integer no_tlp, String Id_spp, String Id_kelas, DefaultTableModel tableModel) {
        Siswa_model model = new Siswa_model(nisn, nis, name, alamat, no_tlp, Id_spp, Id_kelas);

        try {
            siswa_service service = new siswa_service();
            System.out.println("model spp = " + model.getId_spp());
            service.InsertSiswa(model);

            System.out.println("check 1");

            SELECT_DATABASE select = new SELECT_DATABASE();
            ResultSet data = select.getData("siswa");

            tableModel.setRowCount(0);

            while (data.next()) {
                String ID = data.getString("uuid");
                String NISN = data.getString("nisn");
                String NIS = data.getString("nis");
                String NAMA = data.getString("nama");
                String ALAMAT = data.getString("alamat");
                String TELP = data.getString("no_tlp");
                String ID_SPP = data.getString("id_spp");
                String ID_KELAS = data.getString("id_kelas");

                System.out.println("ID SPP " + ID_SPP);
                System.out.println("ID KELAS " + ID_KELAS);

                String tbData[] = {ID, NISN, NIS, NAMA, ALAMAT, TELP, SPP_NAME, KELAS_NAME};
                tableModel.addRow(tbData);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

    }

    public void updateSiswaAction(String SPP_NAME, String KELAS_NAME, String nisn, String nis, String name, String alamat, Integer no_tlp, String Id_spp, String Id_kelas, Integer selectedRow, String ID, DefaultTableModel tableModel) {

        Siswa_model model = new Siswa_model(nisn, nis, name, alamat, no_tlp, Id_spp, Id_kelas);

        try {
            siswa_service service = new siswa_service();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Pilih baris yang ingin diupdate.");
                return;
            }

            System.out.println("ID = " + ID);
            System.out.println("ID Kelas = " + Id_spp);
            System.out.println("ID Spp = " + Id_kelas);

            if (service.UpdateSiswa(model, ID)) {
                SELECT_DATABASE select = new SELECT_DATABASE();
                ResultSet data = select.getData("siswa");

                tableModel.setRowCount(0);

                while (data.next()) {
                    String NISN = data.getString("nisn");
                    String NIS = data.getString("nis");
                    String NAMA = data.getString("nama");
                    String ALAMAT = data.getString("alamat");
                    String TELP = data.getString("no_tlp");
                    String ID_SPP = data.getString("id_spp");
                    String ID_KELAS = data.getString("id_kelas");

                    String tbData[] = {ID, NISN, NIS, NAMA, ALAMAT, TELP, SPP_NAME, KELAS_NAME};
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

    public void deleteSiswaAction(String SPP, String KELAS, Integer selectedRow, String ID, DefaultTableModel tableModel) {
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Pilih baris yang ingin dihapus.");
            return;
        }

        try {
            siswa_service service = new siswa_service();

            if (service.DeleteSiswa(ID)) {
                SELECT_DATABASE select = new SELECT_DATABASE();
                ResultSet data = select.getData("siswa");

                tableModel.setRowCount(0);

                while (data.next()) {
                    String UUID = data.getString("uuid");
                    String NISN = data.getString("nisn");
                    String NIS = data.getString("nis");
                    String NAMA = data.getString("nama");
                    String ALAMAT = data.getString("alamat");
                    String TELP = data.getString("no_tlp");
                    String ID_SPP = data.getString("id_spp");
                    String ID_KELAS = data.getString("id_kelas");

                    String tbData[] = {UUID, NISN, NIS, NAMA, ALAMAT, TELP, SPP, KELAS};
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

    public List<String> getAllKelas() {
        try {

            SELECT_DATABASE select = new SELECT_DATABASE();
            ResultSet data = select.getData("kelas");

            List<String> dataList = new ArrayList<>();

            while (data.next()) {
                String value = data.getString("nama");
                dataList.add(value);
            }

            data.close();
            return dataList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> getAllSpp() {
        try {

            SELECT_DATABASE select = new SELECT_DATABASE();
            ResultSet data = select.getData("spp");

            List<String> dataList = new ArrayList<>();

            while (data.next()) {
                String value = data.getString("Tahun");
                dataList.add(value);
            }

            data.close();
            return dataList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet getOneSpp(String name) {
        System.out.println("name = " + name);
        ResultSet data = null;
        try {
            SELECT_DATABASE select = new SELECT_DATABASE();
            data = select.getOneDataByName("spp", "tahun", name);
            return data;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return data;
        }
    }

    public ResultSet getOneKelas(String name) {
        ResultSet data = null;
        try {
            SELECT_DATABASE select = new SELECT_DATABASE();
            data = select.getOneDataByName("kelas", "nama", name);
            if (data.next()) {
                System.out.println(data.getString("nama"));
            }
            return data;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return data;
        }
    }

    public ResultSet getOneSppByID(String name) {
        System.out.println("name = " + name);
        ResultSet data = null;
        try {
            SELECT_DATABASE select = new SELECT_DATABASE();
            data = select.getOneDataString("spp", name);
            Integer data_spp = (data.next()) ? data.getInt("Tahun") : null;

            System.out.println("data spp = " + data_spp);
            return data;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return data;
        }
    }

    public ResultSet getOneKelasByID(String name) {
        ResultSet data = null;
        System.out.println("code = " + name);
        try {
            SELECT_DATABASE select = new SELECT_DATABASE();
            data = select.getOneDataString("kelas", name);
            if (data.next()) {
                System.out.println(data.getString("Nama"));
            }
            return data;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return data;
        }
    }
}
