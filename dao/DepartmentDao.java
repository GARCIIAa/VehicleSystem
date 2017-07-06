package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import java.util.List;

import model.Department;
import util.AppException;
import util.DBUtil;

public class DepartmentDao {
	public boolean addDepartment(Department department) throws  AppException{
		//声明操作标志flag
		boolean flag = false;
		//定义数据库操作对象
		Connection conn = null;
		PreparedStatement psmt = null;		
		try {
		//创建数据库连接
		conn = DBUtil.getConnection();
		//定义sql语句
		String sql = "insert into department(depart_id,depart_type,depart_name,depart_level,depart_agent,depart_tel,depart_desc,depart_code,shortname,depart_parent,del)"
		+ "values(?,?,?,?,?,?,?,?,?,?,?)";
		//预处理sql语句
		psmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
	
		//设置参数
		psmt.setInt(1,department.getDepart_id());
		psmt.setInt(2,department.getDepart_type());
		psmt.setString(3,department.getDepart_name());
		psmt.setInt(4, department.getDepart_level());
		psmt.setString(5,department.getDepart_agent());
		psmt.setString(6, department.getDepart_tel());
		psmt.setString(7, department.getDepart_desc());
		psmt.setString(8, department.getDepart_code());
		psmt.setString(9, department.getShortname());
		psmt.setInt(10, department.getDepart_parent());
		psmt.setInt(11, department.getDel());
		
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
			throw new AppException("DepartmentDao.AddDepartment");
		}finally{
			//关闭连接，释放资源
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);			
		}		
		return flag;
	}	
	
	public List<Department> QueryDepartment(int level) throws  AppException{
		//定义数据库操作对象
		ArrayList<Department> arr=null;
		Department department = null;
		Connection conn = null;
		PreparedStatement psmt = null;		
		try {
		//创建数据库连接
		conn = DBUtil.getConnection() ;			
		String sql = "select * from department where depart_level = ?";
		//预处理sql语句
		psmt = conn.prepareStatement(sql);		
		//设置参数
		psmt.setInt(1,level);
		//执行新增操作
		ResultSet res=psmt.executeQuery();
		arr = new ArrayList<Department>();
		while(res.next()){	
			department=new Department(res.getInt("depart_id"),res.getInt("depart_type"),
					res.getString("depart_name"),level,
					res.getString("depart_agent"),res.getString("depart_tel"),
					res.getString("depart_desc"),res.getString("depart_code"),
					res.getString("shortname"),res.getInt("depart_parent"),0);
			arr.add(department);							
		}		
		//System.out.println(arr.get(0));		
		} catch (SQLException e) {
			e.printStackTrace();		
			throw new AppException("DepartmentDao.QueryDepartment");
		}finally{
			//关闭连接，释放资源
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);			
		}
		//返回结果
		return arr;
	}
	
	
    public static void main(String[] avgs) throws AppException, SQLException{
		
    	DepartmentDao a = new DepartmentDao();
    //	a.addDepartment(new Department(1,0,"第一支队",3,"第一大队","0986432","包含四个警员","P123","yizhi",9898,0));
    	a.QueryDepartment(3);
    }


}
