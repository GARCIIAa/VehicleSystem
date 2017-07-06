package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Road;
import util.AppException;
import util.DBUtil;

public class RoadDao {
	public boolean addRoad(Road road) throws  AppException{
		//声明操作标志flag
		boolean flag = false;
		//定义数据库操作对象
		Connection conn = null;
		PreparedStatement psmt = null;		
		try {
		//创建数据库连接
		conn = DBUtil.getConnection();
		//定义sql语句
		String sql = "insert into road(road_id,road_name,del)"
		+ "values(?,?,?)";
		//预处理sql语句
		psmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
		
		//设置参数
		psmt.setInt(1,road.getRoad_id());
		psmt.setString(2,road.getRoad_name());
		psmt.setInt(3, road.getDel());
		
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
			throw new AppException("RoadDao.addRoad");
		}finally{
			//关闭连接，释放资源
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);			
		}		
		return flag;
	}	
	
    public static void main(String[] avgs) throws AppException, SQLException{
		
    	RoadDao a = new RoadDao();
    	a.addRoad(new Road(90,"see",0));
    	
    }


}
