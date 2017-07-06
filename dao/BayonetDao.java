package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

import model.Bayonet;
import util.AppException;
import util.DBUtil;

public class BayonetDao {
	public boolean addBayonet(Bayonet bayonet) throws  AppException{
		//声明操作标志flag
		boolean flag = false;
		//定义数据库操作对象
		Connection conn = null;
		PreparedStatement psmt = null;		
		try {
		//创建数据库连接
		conn = DBUtil.getConnection();
		//定义sql语句
		String sql = "insert into bayonet(bayonet_id,point_id,buy_name,install_date,state,del)"
		+ "values(?,?,?,?,?,?)";
		//预处理sql语句
		psmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
		
		//设置参数
		psmt.setInt(1,bayonet.getBayonet_id());
		psmt.setInt(2,bayonet.getPoint_id());
		psmt.setString(3,bayonet.getBuy_name());
		psmt.setDate(4, bayonet.getInstall_date());
		psmt.setInt(5,bayonet.getState());
		psmt.setInt(6, bayonet.getDel());
		
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
			throw new AppException("BayonetDao.addBayonet");
		}finally{
			//关闭连接，释放资源
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);			
		}		
		return flag;
	}	
	
    public static void main(String[] avgs) throws AppException, SQLException{
		
		BayonetDao a = new BayonetDao();
		a.addBayonet(new Bayonet(78,12,"youjax",new Date(2017-02-12),0,0));
	
    }

}
