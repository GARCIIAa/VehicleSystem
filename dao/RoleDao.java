package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Role;
import util.AppException;
import util.DBUtil;

public class RoleDao {
	public boolean addRole(Role role) throws  AppException{
		//����������־flag
		boolean flag = false;
		//�������ݿ��������
		Connection conn = null;
		PreparedStatement psmt = null;		
		try {
		//�������ݿ�����
		conn = DBUtil.getConnection();
		//����sql���
		String sql = "insert into role(role_id,role_name,menu_name,menu_id,role_desc)"
		+ "values(?,?,?,?,?)";
		//Ԥ����sql���
		psmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
		
		//���ò���
		psmt.setInt(1,role.getRole_id());
		psmt.setString(2,role.getRole_name());
		psmt.setString(3,role.getMenu_name());
		psmt.setString(4, role.getMenu_id());
		psmt.setString(5, role.getRole_desc());
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
			throw new AppException("RoleDao.addRole");
		}finally{
			//�ر����ӣ��ͷ���Դ
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);			
		}		
		return flag;
	}	
	
    public static void main(String[] avgs) throws AppException, SQLException{
		
    	RoleDao a = new RoleDao();
	
    	a.addRole(new Role(1,"��������Ա","��Ա����,��·����","1,2","chaojiguanlichaoji"));
    }

}
