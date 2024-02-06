package project_pembayaran_spp.controllers;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import project_pembayaran_spp.model.Pembayaran_model;
import project_pembayaran_spp.services.database_process.SELECT_DATABASE;
import project_pembayaran_spp.services.pembayaran_service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Rafli
 */
public class pembayaran_controller {

    public void insertPembayaranAction(String id_petugas, String nisn, String tgl_bayar, String bln_bayar, String thn_bayar, String id_spp, Integer jumlah_bayar, DefaultTableModel tableModel) {

        Pembayaran_model model = new Pembayaran_model(id_petugas, nisn, tgl_bayar, bln_bayar, thn_bayar, id_spp, jumlah_bayar);
        String  nama_petugas = null;
        String  nama_siswa = null;
        String  tahun_spp = null;

        try {
            pembayaran_service service = new pembayaran_service();
            service.InsertPembayaran(model);

            SELECT_DATABASE select = new SELECT_DATABASE();
            ResultSet data = select.getData("pembayaran");
            ResultSet data_petugas = select.getOneData("petugas", id_petugas);
            ResultSet data_siswa = select.getOneDatabyUuid("siswa", nisn);
            ResultSet data_spp = select.getOneData("spp", id_spp);

            if (data_petugas.next()) {
                nama_petugas = data_petugas.getString("username");
            }
            
            if (data_siswa.next()) {
                nama_siswa = data_siswa.getString("nama");
            }
            
            if (data_spp.next()) {
                tahun_spp = data_spp.getString("tahun");
            }
            
            tableModel.setRowCount(0);

            while (data.next()) {
                String ID = data.getString("ID");
                String petugas = nama_petugas;
                String siswa = nama_siswa;
                String tanggal = data.getString("tgl_bayar");
                String bulan = data.getString("bln_bayar");
                String tahun = data.getString("thn_bayar");
                String spp = tahun_spp;
                String nominal = data.getString("jumlah_bayar");

                String tbData[] = {ID, petugas, nisn, tanggal, bulan, tahun, spp, nominal};
                tableModel.addRow(tbData);
            }

            data.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void deletePembayaranAction(Integer selectedRow, String ID, DefaultTableModel tableModel) {
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Pilih baris yang ingin dihapus.");
            return;
        }

        try {
            pembayaran_service service = new pembayaran_service();

            if (service.DeletePembayaran(ID)) {
                SELECT_DATABASE select = new SELECT_DATABASE();
                ResultSet data = select.getData("pembayaran");

                tableModel.setRowCount(0);

                while (data.next()) {
                    String ID_DATA = data.getString("ID");
                    String petugas = data.getString("id_petugas");
                    String siswa = data.getString("nisn");
                    String tanggal = data.getString("tgl_bayar");
                    String bulan = data.getString("bulan_bayar");
                    String tahun = data.getString("tahun_bayar");
                    String spp = data.getString("id_spp");
                    String nominal = data.getString("jumlah_bayar");

                    String tbData[] = {ID_DATA, petugas, siswa, tanggal, bulan, tahun, spp, nominal};
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

    public List<String> getAllSiswa() {
        try {

            SELECT_DATABASE select = new SELECT_DATABASE();
            ResultSet data = select.getData("siswa");

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

    public List<String> getAllpetugas() {
        try {

            SELECT_DATABASE select = new SELECT_DATABASE();
            ResultSet data = select.getData("petugas");

            List<String> dataList = new ArrayList<>();

            while (data.next()) {
                String value = data.getString("username");
                dataList.add(value);
            }

            data.close();
            return dataList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet getOnePetugas(String name) {
        ResultSet data = null;
        try {
            SELECT_DATABASE select = new SELECT_DATABASE();
            data = select.getOneDataByName("petugas", "username", name);
            return data;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return data;
        }
    }

    public ResultSet getOneSiswa(String name) {
        ResultSet data = null;
        try {
            SELECT_DATABASE select = new SELECT_DATABASE();
            data = select.getOneDataByName("siswa", "nama", name);
            return data;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return data;
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
}
