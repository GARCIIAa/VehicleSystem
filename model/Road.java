package model;

public class Road {
	private int road_id;
	private String road_name;
	private int del;
	
	public Road() {
		this.road_id = 0;   //道路编号
		this.road_name ="";   //道路名字
		this.del = 0;
	}
	
	public Road(int road_id, String road_name, int del) {
		super();
		this.road_id = road_id;
		this.road_name = road_name;
		this.del = del;
	}
	public int getRoad_id() {
		return road_id;
	}
	public void setRoad_id(int road_id) {
		this.road_id = road_id;
	}
	public String getRoad_name() {
		return road_name;
	}
	public void setRoad_name(String road_name) {
		this.road_name = road_name;
	}
	public int getDel() {
		return del;
	}
	public void setDel(int del) {
		this.del = del;
	}
	
	

}
