package service;

import dao.RightDao;
import dao.RoleDao;
import dao.UserDao;
import util.AppException;

public class UserService {
	private UserDao userDao = null; 
	private RoleDao roleDao = null; 
	private RightDao rightDao = null;
	
	public String  login(String id,String password) throws AppException{
		String name = null;
		try{
			name = UserDao.login(id,password);
		}catch(util.AppException e){
			e.printStackTrace();
			throw new AppException("service.login");
		}
		return name;
	}
	
}
