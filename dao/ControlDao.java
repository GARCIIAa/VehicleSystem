package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Control;
import util.AppException;
import util.DBUtil;

public class ControlDao {
	public boolean addControl(Control control) throws  AppException{
		//声明操作标志flag
		boolean flag = false;
		//定义数据库操作对象
		Connection conn = null;
		PreparedStatement psmt = null;		
		try {
		//创建数据库连接
		conn = DBUtil.getConnection();
		//定义sql语句
		String sql = "insert into control(control_id,bayonet_id,car_id,car_type,control_date,del)"
		+ "values(?,?,?,?,?,?)";
		//预处理sql语句
		psmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
		
		//设置参数
		psmt.setInt(1,control.getControl_id());
		psmt.setInt(2,control.getBayonet_id());
		psmt.setString(3,control.getCar_id());
		psmt.setString(4, control.getCar_type());
		psmt.setDate(5,control.getControl_date());
		psmt.setInt(6, control.getDel());
		
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
			throw new AppException("ControlDao.addControl");
		}finally{
			//关闭连接，释放资源
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);			
		}		
		return flag;
	}	
	
    public static void main(String[] avgs) throws AppException, SQLException{
		
		ControlDao a = new ControlDao();
		a.addControl(new Control(6,78,"京","小型车",new Date(0),0));
	
	
    }

}
