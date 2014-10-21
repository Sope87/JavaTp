package Datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {

	public static Connection conectarDB() {
		Connection conexion;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// setup the connection with the DB.
			conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/dbjava", "root", "root");
			return conexion;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
