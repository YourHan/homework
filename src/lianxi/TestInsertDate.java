package lianxi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.jar.Attributes.Name;

import com.mysql.jdbc.Statement;
public class TestInsertDate {
	int id;
	String name;
	String age ;
	public  void testInsert() {
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
		
		try {
			//1.创建数据库连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("Jdbc:mysql://localhost:3306/dhdh","root" ,"root" );
			//2.构建添加sql语句
			String sql="insert into student "+" values(4,'rr',15)";
			//3执行语句
			java.sql.Statement statement=connection.createStatement();
			//4获取执行所影响的行数，判断是否执行成功
			int rows=statement.executeUpdate(sql);
			System.out.println("所添加的行数为："+rows);
		}catch (ClassNotFoundException  e) {
			e.printStackTrace();
			}	
		 catch ( Exception e) {
				e.printStackTrace();
			}

	}

 private void testUpdate() {
	try {
		//1.创建数据库连接
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection=DriverManager.getConnection("Jdbc:mysql://localhost:3306/dhdh","root" ,"root" );
		//2.构建更新sql语句
		String sql="update student set name='"+name+"',age="+age+" where id="+id;
		java.sql.Statement statement=connection.createStatement();
		int rows=statement.executeUpdate(sql);
		System.out.println("所更新的结果为："+(rows>0));
	}catch (Exception  e) {
		e.printStackTrace();
		}	
	
}
 private void teseDelete() {
	try {
		//1.创建数据库连接
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection=DriverManager.getConnection("Jdbc:mysql://localhost:3306/dhdh","root" ,"root" );
		//2.构建更新sql语句
		String sql="delete from student where name='+qq'";
		java.sql.Statement statement=connection.createStatement();
		int rows=statement.executeUpdate(sql);
		System.out.println("所更新的行数为："+rows);
	}catch (Exception  e) {
		e.printStackTrace();
		}	
}
 
 
}

