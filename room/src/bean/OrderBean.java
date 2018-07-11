package bean;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import util.DBConnection;

public class OrderBean {
private String cid;
private String rid;
private String floor;
private String handsel;
private String money;
private String oname;
private String cname;
private String phone;
private String username;
private Date starttime;
private Date endtime;
private Date time;
public String getFloor() {
	return floor;
}
public void setFloor(String floor) {
	this.floor = floor;
}

public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public Date getStarttime() {
	return starttime;
}
public void setStarttime(String starttime) throws ParseException {
	this.starttime = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(starttime).getTime());
}
public Date getEndtime() {
	return endtime;
}
public void setEndtime(String endtime) throws ParseException {
	this.endtime = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(endtime).getTime());
}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public void orderRoom(OrderBean orderBean) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn=DBConnection.getConnection();
			ps=conn.prepareStatement("INSERT INTO reserve(RoomNum,FloorNum,CustomerNum,CustomerName,StartTime,EndTime,LinkMan,LinkTel,UserOP,Handsel,RoomCharge,OPTime)SELECT ?,FloorNum,?,?,?,?,?,?,?,?,?,?  FROM room WHERE room.RoomNum=?;");
			ps.setString(1,rid);
			ps.setString(2,cid);
			ps.setString(3,cname);
			ps.setDate(4,(java.sql.Date) starttime);
			ps.setDate(5,(java.sql.Date) endtime);
			ps.setString(6,oname);
			ps.setString(7,phone);
			ps.setString(8,username);
			ps.setInt(9,0);
			ps.setString(10,money);
			ps.setDate(11,(java.sql.Date) time);
			ps.setString(12,rid);
			ps.executeUpdate();
		}finally{
			DBConnection.close(null,ps,conn);
		}
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public List<OrderBean>getOrderByCname(String cname) throws SQLException, ParseException, UnsupportedEncodingException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<OrderBean>list=new ArrayList<OrderBean>();
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement("select * from reserve where CustomerName=?;");
			System.out.println("select * from reserve where CustomerName="+new String(cname.getBytes("UTF-8"),"gbk")+";");
			ps.setString(1, new String(cname.getBytes("UTF-8"),"gbk"));
			rs = ps.executeQuery();
			OrderBean ob = new OrderBean();
			while(rs.next()){
				ob.setRid(rs.getString("RoomNum"));
				ob.setFloor(rs.getString("FloorNum"));
				ob.setCid(rs.getString("CustomerNum"));
				ob.setCname(rs.getString("CustomerName"));
				ob.setStarttime(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("StartTime")));
				ob.setEndtime(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("EndTime")));
				ob.setOname(rs.getString("LinkMan"));
				ob.setPhone(rs.getString("LinkTel"));
				ob.setUsername(rs.getString("UserOP"));
				ob.setHandsel(rs.getString("Handsel"));
				ob.setMoney(rs.getString("RoomCharge"));
				ob.setTime(rs.getDate("OPTime"));
				list.add(ob);
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return list;
	}
	public List<OrderBean>getOrderByPhone(String phone) throws SQLException, ParseException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<OrderBean>list=new ArrayList<OrderBean>();
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement("select * from reserve where LinkTel=?;");
			ps.setString(1, phone);
			rs = ps.executeQuery();
			OrderBean ob = new OrderBean();
			while(rs.next()){
				ob.setRid(rs.getString("RoomNum"));
				ob.setFloor(rs.getString("FloorNum"));
				ob.setCid(rs.getString("CustomerNum"));
				ob.setCname(rs.getString("CustomerName"));
				ob.setStarttime(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("StartTime")));
				ob.setEndtime(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("EndTime")));
				ob.setOname(rs.getString("LinkMan"));
				ob.setPhone(rs.getString("LinkTel"));
				ob.setUsername(rs.getString("UserOP"));
				ob.setHandsel(rs.getString("Handsel"));
				ob.setMoney(rs.getString("RoomCharge"));
				ob.setTime(rs.getDate("OPTime"));
				list.add(ob);
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return list;
	}
	public List<OrderBean>getOrderByFloor(String floor) throws SQLException, ParseException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<OrderBean>list=new ArrayList<OrderBean>();
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement("select * from reserve where FloorNum=?;");
			ps.setString(1, floor);
			rs = ps.executeQuery();
			OrderBean ob = new OrderBean();
			while(rs.next()){
				ob.setRid(rs.getString("RoomNum"));
				ob.setFloor(rs.getString("FloorNum"));
				ob.setCid(rs.getString("CustomerNum"));
				ob.setCname(rs.getString("CustomerName"));
				ob.setStarttime(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("StartTime")));
				ob.setEndtime(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("EndTime")));
				ob.setOname(rs.getString("LinkMan"));
				ob.setPhone(rs.getString("LinkTel"));
				ob.setUsername(rs.getString("UserOP"));
				ob.setHandsel(rs.getString("Handsel"));
				ob.setMoney(rs.getString("RoomCharge"));
				ob.setTime(rs.getDate("OPTime"));
				list.add(ob);
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return list;
	}
	public List<OrderBean>getOrderByRid(String rid) throws SQLException, ParseException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<OrderBean>list=new ArrayList<OrderBean>();
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement("select * from reserve where RoomNum=?;");
			ps.setString(1, rid);
			rs = ps.executeQuery();
			OrderBean ob = new OrderBean();
			while(rs.next()){
				ob.setRid(rs.getString("RoomNum"));
				ob.setFloor(rs.getString("FloorNum"));
				ob.setCid(rs.getString("CustomerNum"));
				ob.setCname(rs.getString("CustomerName"));
				ob.setStarttime(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("StartTime")));
				ob.setEndtime(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("EndTime")));
				ob.setOname(rs.getString("LinkMan"));
				ob.setPhone(rs.getString("LinkTel"));
				ob.setUsername(rs.getString("UserOP"));
				ob.setHandsel(rs.getString("Handsel"));
				ob.setMoney(rs.getString("RoomCharge"));
				ob.setTime(rs.getDate("OPTime"));
				list.add(ob);
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return list;
	}
	public String getHandsel() {
		return handsel;
	}
	public void setHandsel(String handsel) {
		this.handsel = handsel;
	}
}
