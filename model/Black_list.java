package model;

public class Black_list {
	private int black_id;   //���������
	private String car_type;   //��������
	private String car_id;     //�������
	private String reason;   //ԭ��
	private int request_id;    //������
	private int examine_id;    //������
	private int control_id;    //������
	private String comments;   //�������
	private int state;     //״̬��-1-�ܾ� 0-������ 1-����ͨ�������� 2-�Ѳ���  3-����
	private int del;
	
	public Black_list() {
		this.black_id = 0;
		this.car_type = "";
		this.car_id = "";
		this.reason = "";
		this.request_id = 0;
		this.examine_id = 0;
		this.control_id = 0;
		this.comments = "";
		this.state = 0;
		this.del = 0;
	}
	
	public Black_list(int black_id, String car_type, String car_id,
			String reason, int request_id, int examine_id, int control_id,
			String comments, int state, int del) {
		super();
		this.black_id = black_id;
		this.car_type = car_type;
		this.car_id = car_id;
		this.reason = reason;
		this.request_id = request_id;
		this.examine_id = examine_id;
		this.control_id = control_id;
		this.comments = comments;
		this.state = state;
		this.del = del;
	}

	public int getBlack_id() {
		return black_id;
	}

	public void setBlack_id(int black_id) {
		this.black_id = black_id;
	}

	public String getCar_type() {
		return car_type;
	}

	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}

	public String getCar_id() {
		return car_id;
	}

	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getRequest_id() {
		return request_id;
	}

	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}

	public int getExamine_id() {
		return examine_id;
	}

	public void setExamine_id(int examine_id) {
		this.examine_id = examine_id;
	}

	public int getControl_id() {
		return control_id;
	}

	public void setControl_id(int control_id) {
		this.control_id = control_id;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}
	
	

}
