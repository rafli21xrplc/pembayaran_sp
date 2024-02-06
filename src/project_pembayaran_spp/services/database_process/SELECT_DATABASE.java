/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pembayaran_spp.services.database_process;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import project_pembayaran_spp.database.database_service;

/**
 *
 * @author Rafli
 */
public class SELECT_DATABASE {

    public ResultSet getData(String table) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM " + table;
            ps = database_service.getConnection().prepareStatement(query);
            rs = ps.executeQuery();

            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet getOneData(String table, String code) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM " + table + " WHERE ID = ?";
            ps = database_service.getConnection().prepareStatement(query);

            ps.setString(1, code);

            rs = ps.executeQuery();

            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet getOneDataString(String table, String code) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM " + table + " WHERE ID = ?";
            ps = database_service.getConnection().prepareStatement(query);
            ps.setString(1, code);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet getOneDatabyUuid(String table, String code) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM " + table + " WHERE uuid = ?";
            ps = database_service.getConnection().prepareStatement(query);

            ps.setString(1, code);

            rs = ps.executeQuery();

            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet getOneDataByName(String table, String by, String name) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM " + table + " WHERE " + by + "= ?";
            ps = database_service.getConnection().prepareStatement(query);

            ps.setString(1, name);

            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
