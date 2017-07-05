package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import util.AppException;
import util.DBUtil;

public class UserDao {
	public String isExist(int id,String password) throws AppException{
		String exist = "";
		Connection conn =null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			 String sql = "select * from users where police_id = ? and password = ? and del = 0";
			 
			 psmt = conn.prepareStatement(sql);
			 psmt.setInt(1,id);
			 psmt.setString(2,password);
			 
			 rs = psmt.executeQuery();//返回查询结果
			 if(rs.next()){//判断结果集中是否有值
				 exist = rs.getString("police_name");
			}
			System.out.println(exist);
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("UserDao.isExist");
		}finally{
			 DBUtil.closeResultSet(rs);
			 DBUtil.closeStatement(psmt);
			 DBUtil.closeConnection(conn);
		 }
		 
		 return exist;
		
}
	
public static void main(String[] avgs) throws AppException, SQLException{
		
		UserDao a = new UserDao();
		a.isExist(123456,"12345678");
}	

}
