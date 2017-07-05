package model;

import java.sql.Date;

public class Pass_car {
	private int pass_id;   //车辆编号
	private int road_id;    //道路编号
	private int bayonet_id;   //卡位编号
	private Date collection_date;  //采集时间
	private String speed; //速度
	private String picpath;  //图片路径
	private int del;
	private  String direction; //方向
	
	public Pass_car() {
		this.pass_id = 0;
		this.road_id = 0;
		this.bayonet_id = 0;
		this.collection_date = new Date(0);
		this.speed ="";
		this.picpath = "";
		this.del = 0;
		this.direction = "";
	}
	
	public Pass_car(int pass_id, int road_id, int bayonet_id,
			Date collection_date, String speed, String picpath, int del,
			String direction) {
		super();
		this.pass_id = pass_id;
		this.road_id = road_id;
		this.bayonet_id = bayonet_id;
		this.collection_date = collection_date;
		this.speed = speed;
		this.picpath = picpath;
		this.del = del;
		this.direction = direction;
	}

	public int getPass_id() {
		return pass_id;
	}

	public void setPass_id(int pass_id) {
		this.pass_id = pass_id;
	}

	public int getRoad_id() {
		return road_id;
	}

	public void setRoad_id(int road_id) {
		this.road_id = road_id;
	}

	public int getBayonet_id() {
		return bayonet_id;
	}

	public void setBayonet_id(int bayonet_id) {
		this.bayonet_id = bayonet_id;
	}

	public Date getCollection_date() {
		return collection_date;
	}

	public void setCollection_date(Date collection_date) {
		this.collection_date = collection_date;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getPicpath() {
		return picpath;
	}

	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	

}
