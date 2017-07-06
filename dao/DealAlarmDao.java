package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.DealAlarm;
import util.AppException;
import util.DBUtil;

public class DealAlarmDao {
	public boolean addDealAlarm(DealAlarm dealAlarm) throws  AppException{
		//声明操作标志flag
		boolean flag = false;
		//定义数据库操作对象
		Connection conn = null;
		PreparedStatement psmt = null;		
		try {
		//创建数据库连接
		conn = DBUtil.getConnection();
		//定义sql语句
		String sql = "insert into dealAlarm(iden_state,iden_police,tel,iden_depart,iden_time,remark,deal_state,unstop_reason,stop,del,deal_id,alarm_id)"
		+ "values(?,?,?,?,?,?,?,?,?,?,?,?)";
		//预处理sql语句
		psmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
	
		//设置参数
		psmt.setInt(1,dealAlarm.getIden_state());
		psmt.setString(2,dealAlarm.getIden_police());
		psmt.setString(3,dealAlarm.getTel());
		psmt.setString(4, dealAlarm.getIden_depart());
		psmt.setDate(5,dealAlarm.getIden_date());
		psmt.setString(6, dealAlarm.getRemark());
		psmt.setInt(7, dealAlarm.getDeal_state());
		psmt.setString(8, dealAlarm.getUnstop_reason());
		psmt.setInt(9, dealAlarm.getStop());
		psmt.setInt(10, dealAlarm.getDel());
		psmt.setInt(11, dealAlarm.getDeal_id());
		psmt.setInt(12, dealAlarm.getAlarm_id());
		
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
			throw new AppException("DealAlarmDao.AddDealAlarm");
		}finally{
			//关闭连接，释放资源
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);			
		}		
		return flag;
	}	
	
    public static void main(String[] avgs) throws AppException, SQLException{
		
    	DealAlarmDao a = new DealAlarmDao();
    	a.addDealAlarm(new DealAlarm(0,"you","983753","dedsvc",new Date(0),"dee",0,"xianfe",0,0,12222,123));
	
    }

}
