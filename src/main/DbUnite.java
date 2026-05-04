package main;

import java.sql.*;

public class DbUnite {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {

        final String URL = "jdbc:mysql://localhost:3306/studentdb";
        final String USER = "root";
        final String PASSWORD = "root123";

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void closeConnetion(Connection connet, Statement stmt, ResultSet rset) throws SQLException {
        connet.close();
        stmt.close();
        rset.close();
    }

}
