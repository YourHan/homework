package lianxi;
import java.sql.*;
import java.util.Scanner;

/**
 * Created by DELL on 2018/7/17.
 */
public class Test{
    //�������ݿⷽ��
    private Connection getconnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL="jdbc:musql://localhost:3306/baba";
            try {
                Connection connection= DriverManager.getConnection(dbURL,"root","lld591921917");
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    //�ͷ����ݿ�����
    private void Close( Connection connection, Statement statement,ResultSet resultSet ){


        try {

            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
                ;
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //�������
    private void   Insert(int i, String name, String publish, String author) {
        Connection connection=getconnection();
        Statement statement=null;

        try {

            String sql = "insert into account(book_name,book_publishers,book_author)" + " VALUES (" +name+"'" +publish + "','" + author+ "')";
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            //int rows = statement.executeUpdate(sql);
            // System.out.print("ok" + rows);
        } catch (SQLException E) {
            E.printStackTrace();
        }
        finally {
            Close(connection,statement,null);
        }

    }
    //�޸�����
    private void Update(int id,String name,String publish,String author){
        Connection connection=getconnection();
        Statement statement=null;

        try {
            String sql = "update account set book_name='"+name+"',book_publishers='"+publish+"',book_author='"+author+"'where id="+id;
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            Close(connection,statement,null);
        }

    }
    //��ѯ
    private  void  Select(){
        Connection connection=getconnection();
        Statement statement=null;
        ResultSet resultSet=null;
        String sql="select  id ,book_name,book_publishers,book_author from book";
        try {
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            StringBuffer buffer=new StringBuffer();
            buffer.append("******************************"+System.lineSeparator());
            buffer.append("***********��ѯ���***********"+System.lineSeparator());
            buffer.append("*****************************"+System.lineSeparator());
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("book_name");
                String publish= resultSet.getString("book_publishers");
                String author=resultSet.getString("book_author");
                buffer.append(id + "\t|" + name+ "|\t" + publish +"\t|"+author+ "|" + System.lineSeparator());
                System.out.print(buffer);
            }

            } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            Close(connection,statement,resultSet);
        }
    }
    //ɾ������
    private void Delete(int id){
        Connection connection=getconnection();
        Statement statement=null;
        try {
            String sql = "delete from account where id="+id;
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        finally {
            Close(connection,statement,null);
        }

    }

    //ģ����ѯ
    private void  LikeSelect(String name,String author){
        Connection connection=getconnection();
        Statement statement=null;
        ResultSet resultSet=null;

        try {
            String sql="select  id ,book_name,book_publishers,book_author from book where book_name like '%"+name+"%' or like '%"+author+"%'";
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            StringBuffer buffer=new StringBuffer();
            buffer.append("******************************"+System.lineSeparator());
            buffer.append("***********��ѯ���***********"+System.lineSeparator());
            buffer.append("*****************************"+System.lineSeparator());
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
            Close(connection,statement,resultSet);
        }
    }
    //������
    public static void main(String[] args){
        String value = null;
        Test test = new Test();

        while(true) {
            System.out.println("==============================");
            System.out.println("|    ��ӭʹ��baba���˹�����    |");
            System.out.println("==============================");
            System.out.println("|*******1���������***********|");
            System.out.println("|*******2���޸�����***********|");
            System.out.println("|*******3����ѯ����***********|");
            System.out.println("|*******4��ɾ������***********|");
            System.out.println("|*******5��ģ����ѯ***********|");
            System.out.println("|*******6���˳�ϵͳ***********|");
            System.out.println("��ѡ��");
            Scanner input = new Scanner(System.in);
            int select = input.nextInt();
            while (select < 1 || select > 6) {
                System.out.println("������ѡ��");
                select = input.nextInt();
            }
            if (select == 1) {
                System.out.println("��������ӵ������������硢���ߣ����磺ף��������³Ѹ");
                value = input.next();
                String[] values = value.split(",");
                test.Insert((int)System.currentTimeMillis(),values[0],values[1],values[2]);

            } else if (select == 2) {
                System.out.println("�������޸ĵ������������硢���ߡ�id�����磺5��ף��������³Ѹ��");
                value=input.next();
                String[] values=value.split(",");
                test.Update(Integer.parseInt(values[3]),values[0],values[1],values[2]);

            } else if (select == 3) {
            	test.Select();

            } else if (select == 4) {
                System.out.println("������Ҫɾ����id");
                value=input.next();
                String[] values=value.split(",");
                test.Delete(Integer.parseInt(values[0]));

            } else if (select == 5) {
                System.out.println("�������ѯ�Ĺؼ���");
                value=input.next();
                String[] values=value.split(",");
                test.LikeSelect(values[0],values[1]);

            } else if (select == 6) {
                System.exit(-2);

            }
        }
    }
}
