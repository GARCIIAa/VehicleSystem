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
		//����������־flag
		boolean flag = false;
		//�������ݿ��������
		Connection conn = null;
		PreparedStatement psmt = null;		
		try {
		//�������ݿ�����
		conn = DBUtil.getConnection();
		//����sql���
		String sql = "insert into department(depart_id,depart_type,depart_name,depart_level,depart_agent,depart_tel,depart_desc,depart_code,shortname,depart_parent,del)"
		+ "values(?,?,?,?,?,?,?,?,?,?,?)";
		//Ԥ����sql���
		psmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
	
		//���ò���
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
			throw new AppException("DepartmentDao.AddDepartment");
		}finally{
			//�ر����ӣ��ͷ���Դ
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);			
		}		
		return flag;
	}	
	
	public List<Department> QueryDepartment(int level) throws  AppException{
		//�������ݿ��������
		ArrayList<Department> arr=null;
		Department department = null;
		Connection conn = null;
		PreparedStatement psmt = null;		
		try {
		//�������ݿ�����
		conn = DBUtil.getConnection() ;			
		String sql = "select * from department where depart_level = ?";
		//Ԥ����sql���
		psmt = conn.prepareStatement(sql);		
		//���ò���
		psmt.setInt(1,level);
		//ִ����������
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
			//�ر����ӣ��ͷ���Դ
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);			
		}
		//���ؽ��
		return arr;
	}
	
	
    public static void main(String[] avgs) throws AppException, SQLException{
		
    	DepartmentDao a = new DepartmentDao();
    //	a.addDepartment(new Department(1,0,"��һ֧��",3,"��һ���","0986432","�����ĸ���Ա","P123","yizhi",9898,0));
    	a.QueryDepartment(3);
    }


}
