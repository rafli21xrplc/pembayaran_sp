/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project_pembayaran_spp;

import project_pembayaran_spp.application.Login;
import project_pembayaran_spp.database.database_service;


/**
 *
 * @author Rafli
 */
public class Project_pembayaran_spp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Login login = new Login();
        login.show();
        
        database_service.getConnection();
    }
    
}
