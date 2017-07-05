package model;

import java.sql.Date;

public class Control {
	private int control_id; //布控编号
	private int bayonet_id;  //卡口编号
	private String car_id;    //车牌号
	private String car_type;  //车辆类型
	private Date control_date;  //布控时间
	private int del;

	public Control() {
		this.control_id = 0;
		this.bayonet_id = 0;
		this.car_id = "";
		this.car_type = "";
		this.control_date = new Date(0);
		this.del = 0;
	}
	
	public Control(int control_id, int bayonet_id, String car_id, String car_type,
			Date control_date, int del) {
		super();
		this.control_id = control_id;
		this.bayonet_id = bayonet_id;
		this.car_id = car_id;
		this.car_type = car_type;
		this.control_date = control_date;
		this.del = del;
	}

	public int getControl_id() {
		return control_id;
	}

	public void setControl_id(int control_id) {
		this.control_id = control_id;
	}

	public int getBayonet_id() {
		return bayonet_id;
	}

	public void setBayonet_id(int bayonet_id) {
		this.bayonet_id = bayonet_id;
	}

	public String getCar_id() {
		return car_id;
	}

	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}

	public String getCar_type() {
		return car_type;
	}

	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}

	public Date getControl_date() {
		return control_date;
	}

	public void setControl_date(Date control_date) {
		this.control_date = control_date;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}
	
	

}
