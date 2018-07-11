package bean;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import util.DBConnection;

public class OrderRoomBean {
	private String floor;
	private String rid;
	private String standard;
	private String charge;
	private String position;
	private String state;
	private String datetime;

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public OrderRoomBean() {
	}
	public List<OrderRoomBean>getOrderRooms(String rtype,String start,String end) throws SQLException, ParseException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<OrderRoomBean>list=new ArrayList<OrderRoomBean>();
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement("select * from room where RoomStatus='空闲' AND RoomStandard=? AND DateTime>=? AND datetime<=?;");
			if(rtype.equals("0"))ps.setString(1, "大床房");
			else if(rtype.equals("1"))ps.setString(1, "标间");
			else ps.setString(1, "豪华套房");
			ps.setDate(2, new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(start).getTime()));
			ps.setDate(3, new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(end).getTime()));
			rs = ps.executeQuery();
			while(rs.next()){
				OrderRoomBean orb = new OrderRoomBean();
				orb.setRid(rs.getString("RoomNum"));
				orb.setFloor(rs.getString("FloorNum"));
				orb.setStandard(rs.getString("RoomStandard"));
				orb.setCharge(rs.getString("RoomCharge"));
				orb.setPosition(rs.getString("RoomPosition"));
				orb.setState(rs.getString("RoomStatus"));
				orb.setDatetime(rs.getString("DateTime"));
				list.add(orb);
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return list;
	}
	public List<OrderRoomBean>getAllOrderRooms() throws SQLException, ParseException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<OrderRoomBean>list=new ArrayList<OrderRoomBean>();
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement("select * from room where RoomStatus='空闲';");
			rs = ps.executeQuery();
			while(rs.next()){
				OrderRoomBean orb = new OrderRoomBean();
				orb.setRid(rs.getString("RoomNum"));
				orb.setFloor(rs.getString("FloorNum"));
				orb.setStandard(rs.getString("RoomStandard"));
				orb.setCharge(rs.getString("RoomCharge"));
				orb.setPosition(rs.getString("RoomPosition"));
				orb.setState(rs.getString("RoomStatus"));
				orb.setDatetime(rs.getString("DateTime"));
				list.add(orb);
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return list;
	}
}
