package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Point;
import util.AppException;
import util.DBUtil;

public class PointDao {
	public boolean addPoint(Point point) throws  AppException{
		//声明操作标志flag
		boolean flag = false;
		//定义数据库操作对象
		Connection conn = null;
		PreparedStatement psmt = null;		
		try {
		//创建数据库连接
		conn = DBUtil.getConnection();
		//定义sql语句
		String sql = "insert into point(point_id,road_id,longitude,latitude,bayonet_num,direction,point_name,state,del)"
		+ "values(?,?,?,?,?,?,?,?,?)";
		//预处理sql语句
		psmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
		
		//设置参数
		psmt.setInt(1,point.getPoint_id());
		psmt.setInt(2,point.getRoad_id());
		psmt.setString(3,point.getLongitude());
		psmt.setString(4, point.getLatitude());
		psmt.setInt(5,point.getBayonet_num());
		psmt.setString(6,point.getDirection());
		psmt.setString(7, point.getPoint_name());
		psmt.setInt(8, point.getState());
		psmt.setInt(9, point.getDel());
		
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
			throw new AppException("PointDao.addPoint");
		}finally{
			//关闭连接，释放资源
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);			
		}		
		return flag;
	}	
	
    public static void main(String[] avgs) throws AppException, SQLException{
		
    	PointDao a = new PointDao();
    	a.addPoint(new Point(12,90,"90°E","34°N",0,"N","jiaodadong",1,0));
	
    }


}
