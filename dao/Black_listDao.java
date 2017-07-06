package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Black_list;
import util.AppException;
import util.DBUtil;

public class Black_listDao {
	public boolean addBlack_list(Black_list black_list) throws  AppException{
		//声明操作标志flag
		boolean flag = false;
		//定义数据库操作对象
		Connection conn = null;
		PreparedStatement psmt = null;		
		try {
		//创建数据库连接
		conn = DBUtil.getConnection();
		//定义sql语句
		String sql = "insert into black_list(black_id,car_type,car_id,reason,request_id,examine_id,control_id,comments,state,del)"
		+ "values(?,?,?,?,?,?,?,?,?,?)";
		//预处理sql语句
		psmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
		
		//设置参数
		psmt.setInt(1,black_list.getBlack_id());
		psmt.setString(2,black_list.getCar_type());
		psmt.setString(3,black_list.getCar_id());
		psmt.setString(4, black_list.getReason());
		psmt.setInt(5,black_list.getRequest_id());
		psmt.setInt(6, black_list.getExamine_id());
		psmt.setInt(7, black_list.getControl_id());
		psmt.setString(8, black_list.getComments());
		psmt.setInt(9, black_list.getState());
		psmt.setInt(10, black_list.getDel());
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
			throw new AppException("Black_listDao.addBlack_list");
		}finally{
			//关闭连接，释放资源
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);			
		}		
		return flag;
	}	
	
    public static void main(String[] avgs) throws AppException, SQLException{
		
		Black_listDao a = new Black_listDao();
		a.addBlack_list(new Black_list(123,"小型车","京A1234","嫌疑车辆",123456,234567,345678,"tongguo",0,0));
	
    }

}
