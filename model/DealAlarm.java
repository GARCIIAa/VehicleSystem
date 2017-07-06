package model;

import java.sql.Date;

public class DealAlarm {
	private int iden_state;
	private String iden_police;
	private String tel;
	private String iden_depart;
	private Date iden_date;
	private String remark;
	private int deal_state;
	private String unstop_reason;
	private int stop;
	private int del;
	private int deal_id;
	private int alarm_id;
	
	public DealAlarm() {
	//	super();
		this.iden_state = 0;
		this.iden_police = "";
		this.tel = "";
		this.iden_depart = "";
		this.iden_date = new Date(0);
		this.remark = "";
		this.deal_state = 0;
		this.unstop_reason = "";
		this.stop = 0;
		this.del = 0;
		this.deal_id = 0;
		this.alarm_id = 0;
	}
	
	public DealAlarm(int iden_state, String iden_police, String tel,
			String iden_depart, Date iden_date, String remark, int deal_state,
			String unstop_reason, int stop, int del, int deal_id, int alarm_id) {
		super();
		this.iden_state = iden_state;
		this.iden_police = iden_police;
		this.tel = tel;
		this.iden_depart = iden_depart;
		this.iden_date = iden_date;
		this.remark = remark;
		this.deal_state = deal_state;
		this.unstop_reason = unstop_reason;
		this.stop = stop;
		this.del = del;
		this.deal_id = deal_id;
		this.alarm_id = alarm_id;
	}
	public int getIden_state() {
		return iden_state;
	}
	public void setIden_state(int iden_state) {
		this.iden_state = iden_state;
	}
	public String getIden_police() {
		return iden_police;
	}
	public void setIden_police(String iden_police) {
		this.iden_police = iden_police;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getIden_depart() {
		return iden_depart;
	}
	public void setIden_depart(String iden_depart) {
		this.iden_depart = iden_depart;
	}
	public Date getIden_date() {
		return iden_date;
	}
	public void setIden_date(Date iden_date) {
		this.iden_date = iden_date;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getDeal_state() {
		return deal_state;
	}
	public void setDeal_state(int deal_state) {
		this.deal_state = deal_state;
	}
	public String getUnstop_reason() {
		return unstop_reason;
	}
	public void setUnstop_reason(String unstop_reason) {
		this.unstop_reason = unstop_reason;
	}
	public int getStop() {
		return stop;
	}
	public void setStop(int stop) {
		this.stop = stop;
	}
	public int getDel() {
		return del;
	}
	public void setDel(int del) {
		this.del = del;
	}
	public int getDeal_id() {
		return deal_id;
	}
	public void setDeal_id(int deal_id) {
		this.deal_id = deal_id;
	}
	public int getAlarm_id() {
		return alarm_id;
	}
	public void setAlarm_id(int alarm_id) {
		this.alarm_id = alarm_id;
	}
	
	

}
