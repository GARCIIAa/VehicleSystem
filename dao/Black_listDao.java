package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Black_list;
import util.AppException;
import util.DBUtil;

public class Black_listDao {
	public boolean addBlack_list(Black_list black_list) throws  AppException{
		//����������־flag
		boolean flag = false;
		//�������ݿ��������
		Connection conn = null;
		PreparedStatement psmt = null;		
		try {
		//�������ݿ�����
		conn = DBUtil.getConnection();
		//����sql���
		String sql = "insert into black_list(black_id,car_type,car_id,reason,request_id,examine_id,control_id,comments,state,del)"
		+ "values(?,?,?,?,?,?,?,?,?,?)";
		//Ԥ����sql���
		psmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
		
		//���ò���
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
			throw new AppException("Black_listDao.addBlack_list");
		}finally{
			//�ر����ӣ��ͷ���Դ
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);			
		}		
		return flag;
	}	
	
    public static void main(String[] avgs) throws AppException, SQLException{
		
		Black_listDao a = new Black_listDao();
		a.addBlack_list(new Black_list(123,"С�ͳ�","��A1234","���ɳ���",123456,234567,345678,"tongguo",0,0));
	
    }

}
