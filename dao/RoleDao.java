package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Role;
import util.AppException;
import util.DBUtil;

public class RoleDao {
	public boolean addRole(Role role) throws  AppException{
		//声明操作标志flag
		boolean flag = false;
		//定义数据库操作对象
		Connection conn = null;
		PreparedStatement psmt = null;		
		try {
		//创建数据库连接
		conn = DBUtil.getConnection();
		//定义sql语句
		String sql = "insert into role(role_id,role_name,menu_name,menu_id,role_desc)"
		+ "values(?,?,?,?,?)";
		//预处理sql语句
		psmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
		
		//设置参数
		psmt.setInt(1,role.getRole_id());
		psmt.setString(2,role.getRole_name());
		psmt.setString(3,role.getMenu_name());
		psmt.setString(4, role.getMenu_id());
		psmt.setString(5, role.getRole_desc());
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
			throw new AppException("RoleDao.addRole");
		}finally{
			//关闭连接，释放资源
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);			
		}		
		return flag;
	}	
	
    public static void main(String[] avgs) throws AppException, SQLException{
		
    	RoleDao a = new RoleDao();
	
    	a.addRole(new Role(1,"超级管理员","人员管理,道路布控","1,2","chaojiguanlichaoji"));
    }

}
