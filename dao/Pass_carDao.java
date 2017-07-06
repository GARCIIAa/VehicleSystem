package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Pass_car;
import util.AppException;
import util.DBUtil;

public class Pass_carDao {
	public boolean addPass_car(Pass_car pass_car) throws  AppException{
		//声明操作标志flag
		boolean flag = false;
		//定义数据库操作对象
		Connection conn = null;
		PreparedStatement psmt = null;		
		try {
		//创建数据库连接
		conn = DBUtil.getConnection();
		//定义sql语句
		String sql = "insert into pass_car(pass_id,road_id,bayonet_id,car_id,collection_date,speed,picpath,del,direction)"
		+ "values(?,?,?,?,?,?,?,?,?)";
		//预处理sql语句
		psmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
		
		//设置参数
		psmt.setInt(1,pass_car.getPass_id());
		psmt.setInt(2,pass_car.getRoad_id());
		psmt.setInt(3,pass_car.getBayonet_id());		
		psmt.setString(4, pass_car.getCar_id());
		psmt.setDate(5,pass_car.getCollection_date());
		psmt.setString(6, pass_car.getSpeed());
		psmt.setString(7,pass_car.getPicpath());
		psmt.setInt(8, pass_car.getDel());
		psmt.setString(9, pass_car.getDirection());
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
			throw new AppException("Pass_carDao.addPass_car");
		}finally{
			//关闭连接，释放资源
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);			
		}		
		return flag;
	}	
	
	
	
    public static void main(String[] avgs) throws AppException, SQLException{
		
    	Pass_carDao a = new Pass_carDao();
    	a.addPass_car(new Pass_car(12,90,78,"京A223",new Date(0),"79","dedeafef",0,"S"));
    }	


}
