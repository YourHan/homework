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
			//1.�������ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("Jdbc:mysql://localhost:3306/dhdh","root" ,"root" );
			//2.�������sql���
			String sql="insert into student "+" values(4,'rr',15)";
			//3ִ�����
			java.sql.Statement statement=connection.createStatement();
			//4��ȡִ����Ӱ����������ж��Ƿ�ִ�гɹ�
			int rows=statement.executeUpdate(sql);
			System.out.println("����ӵ�����Ϊ��"+rows);
		}catch (ClassNotFoundException  e) {
			e.printStackTrace();
			}	
		 catch ( Exception e) {
				e.printStackTrace();
			}

	}

 private void testUpdate() {
	try {
		//1.�������ݿ�����
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection=DriverManager.getConnection("Jdbc:mysql://localhost:3306/dhdh","root" ,"root" );
		//2.��������sql���
		String sql="update student set name='"+name+"',age="+age+" where id="+id;
		java.sql.Statement statement=connection.createStatement();
		int rows=statement.executeUpdate(sql);
		System.out.println("�����µĽ��Ϊ��"+(rows>0));
	}catch (Exception  e) {
		e.printStackTrace();
		}	
	
}
 private void teseDelete() {
	try {
		//1.�������ݿ�����
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection=DriverManager.getConnection("Jdbc:mysql://localhost:3306/dhdh","root" ,"root" );
		//2.��������sql���
		String sql="delete from student where name='+qq'";
		java.sql.Statement statement=connection.createStatement();
		int rows=statement.executeUpdate(sql);
		System.out.println("�����µ�����Ϊ��"+rows);
	}catch (Exception  e) {
		e.printStackTrace();
		}	
}
 
 
}

