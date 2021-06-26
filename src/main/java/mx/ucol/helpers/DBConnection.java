package mx.ucol.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private static Connection connection = null;

    private DBConnection() {
        String url = "jdbc:sqlite:resources/todos.db";

        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.err.println("Error on DBConnection: " + e.getMessage());
        }

    }

    public static Connection getInstance() {
        if (connection == null) {
            new DBConnection();
        }

        return connection;
    }


}
