package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection single_instance = null;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/tournament";
    private String user = "student";
    private String pass = "123abcABC.";

    // private constructor restricted to this class itself
    private DatabaseConnection() {
        try {
            this.connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Anslutningen misslyckades");
        }
        System.out.println("Anslutning lyckades");
    }

    public Connection getConnection() {
        return connection;
    }


    // static method to create instance of Singleton class
    public static DatabaseConnection getInstance() {
        if (single_instance == null) {
            single_instance = new DatabaseConnection();
        } else {
            try {
                if (single_instance.getConnection().isClosed()) {
                    single_instance = new DatabaseConnection();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return single_instance;
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }


    public void insertWinner(String name) {
        PreparedStatement preStmt;
        {
            try {
                preStmt = connection.prepareStatement("insert into wins(fightername) " +
                        "values(?)");
                preStmt.setString(1, name);
                preStmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
