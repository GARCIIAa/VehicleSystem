package model;

import java.sql.Date;

public class Alarm {
	private int alarm_id;  //�������
	private int bayonet_id;   //���ڱ��
	private int road_id;  //��·���
	private String car_id;   //���ƺ�
	private Date collection_date;  //�ɼ�ʱ��
	private int state; //״̬ 0-δ���� 1-�Ѵ���
	private String speed;  //�ٶ�
	private String picpath;  //ͼƬ·��
	private int del;  
	private String direction;  //����
	
	public Alarm() {
		this.alarm_id = 0;
		this.bayonet_id = 0;
		this.road_id = 0;
		this.car_id = "";
		this.collection_date = new Date(0);
		this.state = 0;
		this.speed = "";
		this.picpath = "";
		this.del = 0;
		this.direction = "";
	}
	
	public Alarm(int alarm_id, int bayonet_id, int road_id, String car_id,
			Date collection_date, int state, String speed, String picpath,
			int del, String direction) {
		super();
		this.alarm_id = alarm_id;
		this.bayonet_id = bayonet_id;
		this.road_id = road_id;
		this.car_id = car_id;
		this.collection_date = collection_date;
		this.state = state;
		this.speed = speed;
		this.picpath = picpath;
		this.del = del;
		this.direction = direction;
	}

	public int getAlarm_id() {
		return alarm_id;
	}

	public void setAlarm_id(int alarm_id) {
		this.alarm_id = alarm_id;
	}

	public int getBayonet_id() {
		return bayonet_id;
	}

	public void setBayonet_id(int bayonet_id) {
		this.bayonet_id = bayonet_id;
	}

	public int getRoad_id() {
		return road_id;
	}

	public void setRoad_id(int road_id) {
		this.road_id = road_id;
	}

	public String getCar_id() {
		return car_id;
	}

	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}

	public Date getCollection_date() {
		return collection_date;
	}

	public void setCollection_date(Date collection_date) {
		this.collection_date = collection_date;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
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
