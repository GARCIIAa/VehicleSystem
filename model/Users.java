package model;

public class Users {
	private int police_id;  //警号
	private int depart_id;   //部门号
	private String password;  //密码
	private String police_name;  //姓名
	private String type;  //人员类型
	private String sex;   //性别
	private String tel;    //电话
	private String email;  //电子邮箱
	private int state;  //是否停用
	private String remark;   //备注
	private int del;    
	
	public Users() {
		this.police_id =  0;
		this.depart_id = 0;
		this.password = "";
		this.police_name = "";
		this.type = "";
		this.sex = "";
		this.tel = "";
		this.email = "";
		this.state = 0;
		this.remark = "";
		this.del = 0;
	}
	
	public Users(int police_id, int depart_id, String password,
			String police_name, String type, String sex, String tel,
			String email, int state, String remark, int del) {
		super();
		this.police_id = police_id;
		this.depart_id = depart_id;
		this.password = password;
		this.police_name = police_name;
		this.type = type;
		this.sex = sex;
		this.tel = tel;
		this.email = email;
		this.state = state;
		this.remark = remark;
		this.del = del;
	}


	public int getPolice_id() {
		return police_id;
	}


	public void setPolice_id(int police_id) {
		this.police_id = police_id;
	}


	public int getDepart_id() {
		return depart_id;
	}


	public void setDepart_id(int depart_id) {
		this.depart_id = depart_id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPolice_name() {
		return police_name;
	}


	public void setPolice_name(String police_name) {
		this.police_name = police_name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public int getDel() {
		return del;
	}


	public void setDel(int del) {
		this.del = del;
	}
	
	
	

}
