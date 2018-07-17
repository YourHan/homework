package lianxi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
public class Test {

		private Connection getConnection() {
			// TODO Auto-generated method stub
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String dbURL="jdbc:mysql://localhost:3306/library";
				try {
					Connection connection=DriverManager.getConnection(dbURL, "root","root");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		private  void testInsert(String book_name,String book_publishers,String book_author) {
			java.sql.Statement statement=null;
			Connection connection=getConnection();
			try {
				//�������sql���
				String sql="insert into book(book_name,book_publishers,book_author) values('"+book_name+"','"+book_publishers+"','"+book_author+"')";
				//ִ�����
				statement=connection.createStatement();
				//��ȡִ����Ӱ����������ж��Ƿ�ִ�гɹ�
				statement.executeUpdate(sql);
				}catch (SQLException e) {
					e.printStackTrace();
				}finally {
					try {
						if(statement !=null) {
							statement.close();
						}
						if(connection !=null) {
							connection.close();
						}
						} catch (SQLException e2) {
						// TODO: handle exception
					}
				}
			}
		private void testUpdate(int id,String book_name,String book_publishers,String book_author ) {
			 java.sql.Statement statement=null;
			 Connection connection=getConnection();
			try {
				//1.�������ݿ�����
				connection=getConnection();
				//2.��������sql���
				String sql="update student set book_name='"+book_name+"',book_publishers="+book_publishers+",book_author="+book_author+"  where id="+id;
				statement=connection.createStatement();
				statement.executeUpdate(sql);
				
			}catch (SQLException  e) {
				e.printStackTrace();
				}	finally {
					try {
						
						if(statement !=null) {
							statement.close();
						}if (connection !=null) {
							connection.close();
						}
						
					} catch (SQLException e2) {
						// TODO: handle exception
					}
				}
		}
		 private void testDelete(int id,String book_name,String book_publishers,String book_author) {
			 java.sql.Statement statement=null;
			 Connection connection=getConnection();
			try {
				//1.�������ݿ�����
				//2.����ɾ��sql���
				String sql="delete from book where book_name='+book_name'";
				statement=connection.createStatement();
				statement.executeUpdate(sql);
			
			}catch (SQLException  e) {
				e.printStackTrace();
				}finally {
				try {
					
					if(statement !=null) {
						statement.close();
					}
					if (connection !=null) {
						connection.close();
					}
					
				} catch (SQLException e2) {
					// TODO: handle exception
				}
			}
			
		}

		//ģ����ѯ
		    private void  findAllData(String book_name,String book_publishers,String book_author){
		        Connection connection=getConnection();
		        java.sql.Statement statement=null;
		        java.sql.ResultSet resultSet=null;

		        try {
		            String sql="select * from book where id like '%2%' or book_name like '%W%' or book_publishers like '%S%'";
		            statement=connection.createStatement();
		            resultSet=statement.executeQuery(sql);
		            StringBuffer buffer=new StringBuffer();
		            buffer.append("*************************************************************"+System.lineSeparator());
		            buffer.append("id\t\t\tbook_name\t\t\tbook_publishers\t\t\tbook_author\t\t\t"+System.lineSeparator());
		            buffer.append("*************************************************************"+System.lineSeparator());
		            while (resultSet.next()) {
		                int id = resultSet.getInt("id");
		                String name1 = resultSet.getString("book_name");
		                String publish1 = resultSet.getString("book_publishers");
		                String author1 = resultSet.getString("book_author");
		                buffer.append(id + "\t|" + name1 + "|\t" + publish1 + "\t|" + author1 + "|" + System.lineSeparator());
		                System.out.print(buffer);
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        finally {
		        	try {
						if (resultSet !=null) {
							resultSet.close();
						}
						if(statement !=null) {
							statement.close();
						}
						if (connection !=null) {
							connection.close();
						}
						
					} catch (SQLException e) {
						// TODO: handle exception
					}
				}
		        }
		    
		 public  static void main(String []args) {
				Test ceshi=new Test();
				Scanner scanner=new Scanner(System.in);
				while(true) {
				System.out.println("===============================================");
				System.out.println("                     ��ӭ����                                                          ");
				System.out.println("1���������   2���޸�����   3��ɾ������    4 ���鿴�����鼮   5���˳�ϵͳ ");
				System.out.println("===============================================");
				System.out.println("��ѡ����Ҫ���еĲ���");
				int select =0;//�����û���ѡ��
				select=scanner.nextInt();
				while(select<1||select>4) {
					System.out.println("ѡ��Ĳ�������ʶ��������ѡ");
					select=scanner.nextInt();
				}
				String values=null;
				if (select==1) {//�������
					System.out.println("������Ҫ��ӵ�id,book_name,book_publishers,book_author��create_time");
					values=scanner.next();
					String [] values1=values.split(",");
					ceshi.testInsert(values1[0],values1[1],values1[2]);
				}else if(select==2){//�޸�����
					System.out.println("������Ҫ�޸ĵ�id��book_name,book_publishers,book_author��create_time��ϵͳ������id���и���");
					values=scanner.next();
					String [] values1=values.split(",");
					ceshi.testUpdate(Integer.parseInt(values1[0]),values1[1], values1[2], values1[3]);
				}else if(select==3) {//ɾ������
					System.out.println("������Ҫɾ����id");
					values=scanner.next();
					String [] values1=values.split(",");
					ceshi.testDelete(Integer.parseInt(values1[0]),values1[1],values1[2],values1[3]);
				}else if(select==4) {//ɾ������
					System.out.println("������Ҫ��ѯ��id,book_name��book_publishers");
					values=scanner.next();
					String [] values1=values.split(",");
					ceshi.findAllData(values1[0],values1[1],values1[2]);
				}else if(select==5) {//�˳�ϵͳ
					System.exit(-1);
				}
}
}
			// TODO Auto-generated method stub
			
		}

 