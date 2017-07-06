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
		//����������־flag
		boolean flag = false;
		//�������ݿ��������
		Connection conn = null;
		PreparedStatement psmt = null;		
		try {
		//�������ݿ�����
		conn = DBUtil.getConnection();
		//����sql���
		String sql = "insert into alarm(alarm_id,bayonet_id,road_id,car_id,collection_date,state,speed,picpath,del,direction)"
		+ "values(?,?,?,?,?,?,?,?,?,?)";
		//Ԥ����sql���
		psmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
		
		//���ò���
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
		
		//ִ����������		
        int result = -1;      
		result = psmt.executeUpdate();
		//System.out.println(flag);
		//������
		    if(result > 0){
		    	flag = true;
		    }		
			System.out.println(flag);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("AlarmDao.addAlarm");
		}finally{
			//�ر����ӣ��ͷ���Դ
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);			
		}		
		return flag;
	}	
	
	
	
    public static void main(String[] avgs) throws AppException, SQLException{
		
		AlarmDao a = new AlarmDao();
		a.addAlarm(new Alarm(123,78,90,"��A22323",new Date(0),0,"79","dedeafef",0,"S"));
	
    }	

}
