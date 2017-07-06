package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Alarm;
import util.AppException;
import util.DBUtil;

public class AlarmDao {
	public boolean addAlarm(Alarm alarm) throws  AppException{
		//声明操作标志flag
		boolean flag = false;
		//定义数据库操作对象
		Connection conn = null;
		PreparedStatement psmt = null;		
		try {
		//创建数据库连接
		conn = DBUtil.getConnection();
		//定义sql语句
		String sql = "insert into alarm(alarm_id,bayonet_id,road_id,car_id,collection_date,state,speed,picpath,del,direction)"
		+ "values(?,?,?,?,?,?,?,?,?,?)";
		//预处理sql语句
		psmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
		
		//设置参数
		psmt.setInt(1,alarm.getAlarm_id());
		psmt.setInt(2,alarm.getBayonet_id());
		psmt.setInt(3,alarm.getRoad_id());
		psmt.setString(4, alarm.getCar_id());
		psmt.setDate(5,alarm.getCollection_date());
		psmt.setInt(6, alarm.getState());
		psmt.setString(7, alarm.getSpeed());
		psmt.setString(8,alarm.getPicpath());
		psmt.setInt(9, alarm.getDel());
		psmt.setString(10, alarm.getDirection());
		
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
			throw new AppException("AlarmDao.addAlarm");
		}finally{
			//关闭连接，释放资源
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);			
		}		
		return flag;
	}	
	
	
	
    public static void main(String[] avgs) throws AppException, SQLException{
		
		AlarmDao a = new AlarmDao();
		a.addAlarm(new Alarm(123,78,90,"京A22323",new Date(0),0,"79","dedeafef",0,"S"));
	
    }	

}
