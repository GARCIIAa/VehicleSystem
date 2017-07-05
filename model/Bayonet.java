package model;

import java.sql.Date;

public class Bayonet {
	private int bayonet_id; //卡口编号
	private int point_id;   //点位编号
	private String buy_name;  //采购人
	private Date install_date;  //安装时间
	private int state;    //状态
	private int del;
	
	public Bayonet() {
		this.bayonet_id = 0;
		this.point_id = 0;
		this.buy_name = "";
		this.install_date = new Date(0);
		this.state = 0;
		this.del = 0;
	}
	
	public Bayonet(int bayonet_id, int point_id, String buy_name,
			Date install_date, int state, int del) {
		super();
		this.bayonet_id = bayonet_id;
		this.point_id = point_id;
		this.buy_name = buy_name;
		this.install_date = install_date;
		this.state = state;
		this.del = del;
	}

	

	public int getBayonet_id() {
		return bayonet_id;
	}


	public void setBayonet_id(int bayonet_id) {
		this.bayonet_id = bayonet_id;
	}


	public int getPoint_id() {
		return point_id;
	}


	public void setPoint_id(int point_id) {
		this.point_id = point_id;
	}


	public String getBuy_name() {
		return buy_name;
	}


	public void setBuy_name(String buy_name) {
		this.buy_name = buy_name;
	}


	public Date getInstall_date() {
		return install_date;
	}


	public void setInstall_date(Date install_date) {
		this.install_date = install_date;
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
