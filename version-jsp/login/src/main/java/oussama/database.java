package oussama;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
    private static database instance = null;

    
    // Database variables :)
    private final String url = "jdbc:mysql://localhost:3306/javabase";
    private final String username = "root";
    private final String password = "";

    
    private database() {
    }

    public static database getInstance() {
        if (instance == null) {
            instance = new database();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {

       	 try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return DriverManager.getConnection(url, username, password);
    }
}