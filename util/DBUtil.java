package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	private static String url = 
			"jdbc:oracle:thin:@localhost:1521:orcl";
	private static String user = "b";
	private static String password = "123456";
	
	//��������
	static{
			try {    
		            //��ʼ��������     
		            Class.forName("oracle.jdbc.driver.OracleDriver");    
		      
		        } catch (ClassNotFoundException e) {    
		            // TODO: handle exception     
		            e.printStackTrace();    
		        }  
	}
	
	//�������������ӣ��ر�����
	public static Connection getConnection(){
		Connection conn = null;
		
		//�������ݿ�����
		try {
			//�������ݿ������ַ������ƣ������conn��ֵ     
		     conn=DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
		 return conn;
	}
	
	
	public static void closeConnection(Connection conn){
		try {
			if(conn != null && !conn.isClosed()){
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public static void closeStatement(Statement st){
    	try {
			if(st != null && !st.isClosed()){
				st.close();
				st = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public static void closeResultSet(ResultSet rs){
    	try {
			if(rs != null && !rs.isClosed()){
				rs.close();
				rs = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public static void main(String []args){
    	Connection conn = null;
    	conn = getConnection();
    	if(conn != null){
    		System.out.println("success");
    	}else
    		System.out.println("fail");
    	
    }
}
