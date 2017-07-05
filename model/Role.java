package model;

public class Role {
	private int role_id;   //��ɫ���
	private String role_name;   //��ɫ����
	private String menu_name;   //�˵��������� ��,��ƴ��
	private String menu_id;     //�˵����ܱ�� ������ƴ��
	private String role_desc;   //��ɫ����

	public Role() {
		this.role_id = 0;
		this.role_name = "";
		this.menu_name = "";
		this.menu_id = "";
		this.role_desc = "";
	}
	
	public Role(int role_id, String role_name, String menu_name,
			String menu_id, String role_desc) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
		this.menu_name = menu_name;
		this.menu_id = menu_id;
		this.role_desc = role_desc;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	public String getRole_desc() {
		return role_desc;
	}
	public void setRole_desc(String role_desc) {
		this.role_desc = role_desc;
	}
	
	
	

}
