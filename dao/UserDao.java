package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Users;
import util.AppException;
import util.DBUtil;

public class UserDao {
	
	public boolean addUser(Users user) throws  AppException{
		//声明操作标志flag
		boolean flag = false;
		//定义数据库操作对象
		Connection conn = null;
		PreparedStatement psmt = null;		
		try {
		//创建数据库连接
		conn = DBUtil.getConnection();
		//定义sql语句
		String sql = "insert into users(police_id,depart_id,password,police_name,type,sex,tel,email,state,remark,del)"
		+ "values(?,?,?,?,?,?,?,?,?,?,?)";
		//预处理sql语句
		psmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
		
		//设置参数
		psmt.setInt(1,user.getPolice_id());
		psmt.setInt(2,user.getDepart_id());
		psmt.setString(3, user.getPassword());
		psmt.setString(4,user.getPolice_name());
		psmt.setString(5, user.getType());
		psmt.setString(6, user.getSex());
		psmt.setString(7,user.getTel());
		psmt.setString(8, user.getEmail());
		psmt.setInt(9,user.getState());
		psmt.setString(10, user.getRemark());
		psmt.setInt(11,user.getDel());
		//执行新增操作
		
        int result = -1;
      
		result = psmt.executeUpdate();
		//System.out.println(flag);
		//处理结果
		    if(result > 0){
		    	flag = true;
		    }		
			System.out.println(flag);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("UserDao.addUser");
		}finally{
			//关闭连接，释放资源
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);			
		}
		
		return flag;
	}	
	
	
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
		//a.isExist(123456,"12345678");
		a.addUser(new Users(123456,1,"12345678",
				"yyy", "dd", "M", "1344554",
				"d3eff@aa.com", 0, "deggafrc", 0));		
		//a.isExist(123456,"12345678");
	
}	

}
