package project_pembayaran_spp.services;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import project_pembayaran_spp.database.database_service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rafli
 */
public class login_service {
    public Boolean CheckSiswaRegister(String nisn, String password) {
        try {
            String query = "SELECT Nisn FROM SISWA WHERE Nisn=? AND Password=?";
            PreparedStatement ps = database_service.getConnection().prepareStatement(query);
            ps.setString(1, nisn);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Login successful!");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password.");
            }

            ps.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            return false;
        }
    }
}
