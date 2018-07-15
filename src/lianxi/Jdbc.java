package lianxi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLClientInfoException;

public class Jdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.exceptions");
			String dbURL="jdbc:mysql://127.0.0.1/hnnb11";
			try {
				Connection connection=DriverManager.getConnection(dbURL,"root" ,"root" );
		} catch ( Exception e) {
			e.printStackTrace();
		}
	}catch (ClassNotFoundException  e) {
	e.printStackTrace();
	}

}
}