package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Point;
import util.AppException;
import util.DBUtil;

public class PointDao {
	public boolean addPoint(Point point) throws  AppException{
		//����������־flag
		boolean flag = false;
		//�������ݿ��������
		Connection conn = null;
		PreparedStatement psmt = null;		
		try {
		//�������ݿ�����
		conn = DBUtil.getConnection();
		//����sql���
		String sql = "insert into point(point_id,road_id,longitude,latitude,bayonet_num,direction,point_name,state,del)"
		+ "values(?,?,?,?,?,?,?,?,?)";
		//Ԥ����sql���
		psmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
		
		//���ò���
		psmt.setInt(1,point.getPoint_id());
		psmt.setInt(2,point.getRoad_id());
		psmt.setString(3,point.getLongitude());
		psmt.setString(4, point.getLatitude());
		psmt.setInt(5,point.getBayonet_num());
		psmt.setString(6,point.getDirection());
		psmt.setString(7, point.getPoint_name());
		psmt.setInt(8, point.getState());
		psmt.setInt(9, point.getDel());
		
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
			throw new AppException("PointDao.addPoint");
		}finally{
			//�ر����ӣ��ͷ���Դ
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);			
		}		
		return flag;
	}	
	
    public static void main(String[] avgs) throws AppException, SQLException{
		
    	PointDao a = new PointDao();
    	a.addPoint(new Point(12,90,"90��E","34��N",0,"N","jiaodadong",1,0));
	
    }


}
