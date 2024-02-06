package project_pembayaran_spp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database_service {

    private static final String URL = "jdbc:mysql://localhost:3306/pembayaran_spp";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Koneksi berhasil!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(connection);
        return connection;
    }

    public static void main(String[] args) {
        getConnection();
    }
}
