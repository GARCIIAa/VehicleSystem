package model;

public class Department {
	private int depart_id; //部门号
	private int depart_type;  //部门类别
	private String depart_name;  //部门名称
	private int depart_level;   //级别
	private String depart_agent; //负责人
	private String depart_tel;   //电话
	private String depart_desc;  //描述
	private String depart_code;  //部门代码
	private String shortname;    //部门简称
	private String depart_parent; //上级部门
	private int del;
	
	public Department() {
		this.depart_id = 0;
		this.depart_type = 0;
		this.depart_name = "";
		this.depart_level = 0;
		this.depart_agent = "";
		this.depart_tel = "";
		this.depart_desc = "";
		this.depart_code = "";
		this.shortname = "";
		this.depart_parent = "";
		this.del = 0;
	}
	
	public Department(int depart_id, int depart_type, String depart_name,
			int depart_level, String depart_agent, String depart_tel,
			String depart_desc, String depart_code, String shortname,
			String depart_parent, int del) {
		super();
		this.depart_id = depart_id;
		this.depart_type = depart_type;
		this.depart_name = depart_name;
		this.depart_level = depart_level;
		this.depart_agent = depart_agent;
		this.depart_tel = depart_tel;
		this.depart_desc = depart_desc;
		this.depart_code = depart_code;
		this.shortname = shortname;
		this.depart_parent = depart_parent;
		this.del = del;
	}

	public int getDepart_id() {
		return depart_id;
	}

	public void setDepart_id(int depart_id) {
		this.depart_id = depart_id;
	}

	public int getDepart_type() {
		return depart_type;
	}

	public void setDepart_type(int depart_type) {
		this.depart_type = depart_type;
	}

	public String getDepart_name() {
		return depart_name;
	}

	public void setDepart_name(String depart_name) {
		this.depart_name = depart_name;
	}

	public int getDepart_level() {
		return depart_level;
	}

	public void setDepart_level(int depart_level) {
		this.depart_level = depart_level;
	}

	public String getDepart_agent() {
		return depart_agent;
	}

	public void setDepart_agent(String depart_agent) {
		this.depart_agent = depart_agent;
	}

	public String getDepart_tel() {
		return depart_tel;
	}

	public void setDepart_tel(String depart_tel) {
		this.depart_tel = depart_tel;
	}

	public String getDepart_desc() {
		return depart_desc;
	}

	public void setDepart_desc(String depart_desc) {
		this.depart_desc = depart_desc;
	}

	public String getDepart_code() {
		return depart_code;
	}

	public void setDepart_code(String depart_code) {
		this.depart_code = depart_code;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getDepart_parent() {
		return depart_parent;
	}

	public void setDepart_parent(String depart_parent) {
		this.depart_parent = depart_parent;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}
	
   
	
	

}
