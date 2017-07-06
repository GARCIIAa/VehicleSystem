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
		//����������־flag
		boolean flag = false;
		//�������ݿ��������
		Connection conn = null;
		PreparedStatement psmt = null;		
		try {
		//�������ݿ�����
		conn = DBUtil.getConnection();
		//����sql���
		String sql = "insert into control(control_id,bayonet_id,car_id,car_type,control_date,del)"
		+ "values(?,?,?,?,?,?)";
		//Ԥ����sql���
		psmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
		
		//���ò���
		psmt.setInt(1,control.getControl_id());
		psmt.setInt(2,control.getBayonet_id());
		psmt.setString(3,control.getCar_id());
		psmt.setString(4, control.getCar_type());
		psmt.setDate(5,control.getControl_date());
		psmt.setInt(6, control.getDel());
		
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
			throw new AppException("ControlDao.addControl");
		}finally{
			//�ر����ӣ��ͷ���Դ
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);			
		}		
		return flag;
	}	
	
    public static void main(String[] avgs) throws AppException, SQLException{
		
		ControlDao a = new ControlDao();
		a.addControl(new Control(6,78,"��","С�ͳ�",new Date(0),0));
	
	
    }

}
