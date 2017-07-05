package model;

public class Point {

	private int point_id;  //��λ���
	private int road_id;   //��·���
	private String longitude;  //����
	private String latitude;   //γ��
	private int bayonet_num;   //������
	private String direction;  //����
	private String point_name;   //����
	private int state;     //��λ״̬
	private int del;
	
	public Point() {
		this.point_id = 0;
		this.road_id = 0;
		this.longitude = "";
		this.latitude = "";
		this.bayonet_num = 0;
		this.direction = "";
		this.point_name = "";
		this.state = 0;
		this.del = 0;
	}
	
	public Point(int point_id, int road_id, String longitude, String latitude,
			int bayonet_num, String direction, String point_name, int state,
			int del) {
		super();
		this.point_id = point_id;
		this.road_id = road_id;
		this.longitude = longitude;
		this.latitude = latitude;
		this.bayonet_num = bayonet_num;
		this.direction = direction;
		this.point_name = point_name;
		this.state = state;
		this.del = del;
	}

	public int getPoint_id() {
		return point_id;
	}

	public void setPoint_id(int point_id) {
		this.point_id = point_id;
	}

	public int getRoad_id() {
		return road_id;
	}

	public void setRoad_id(int road_id) {
		this.road_id = road_id;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public int getBayonet_num() {
		return bayonet_num;
	}

	public void setBayonet_num(int bayonet_num) {
		this.bayonet_num = bayonet_num;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getPoint_name() {
		return point_name;
	}

	public void setPoint_name(String point_name) {
		this.point_name = point_name;
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
