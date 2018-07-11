package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DBConnection;

public class roomBean {
	
	/**
	 * @author 木奈何
	 * 客房信息管理
	 * 包括增删改查
	 */
	private String RoomNum,FloorNum,RoomStandard,RoomCharge,RoomPosition,RoomStatus,DateTime;

	public String getRoomNum() {
		return RoomNum;
	}

	public void setRoomNum(String roomNum) {
		RoomNum = roomNum;
	}

	public String getFloorNum() {
		return FloorNum;
	}

	public void setFloorNum(String floorNum) {
		FloorNum = floorNum;
	}

	public String getRoomStandard() {
		return RoomStandard;
	}

	public void setRoomStandard(String roomStandard) {
		RoomStandard = roomStandard;
	}

	public String getRoomCharge() {
		return RoomCharge;
	}

	public void setRoomCharge(String roomCharge) {
		RoomCharge = roomCharge;
	}

	public String getRoomPosition() {
		return RoomPosition;
	}

	public void setRoomPosition(String roomPosition) {
		RoomPosition = roomPosition;
	}

	public String getRoomStatus() {
		return RoomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		RoomStatus = roomStatus;
	}

	public String getDateTime() {
		return DateTime;
	}

	public void setDateTime(String dateTime) {
		DateTime = dateTime;
	}
	
	public roomBean(){
		
	}
	
	//添加房间信息
	public int addRoom(){
		Connection conn = null;
		PreparedStatement pst = null;
		String sql = "insert into room(RoomNum,FloorNum,RoomStandard,RoomCharge,RoomPosition) values(?,?,?,?,?)";
		int ret = 0;
		try {
			conn = DBConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, RoomNum);
			pst.setString(2, FloorNum);
			pst.setString(3, RoomStandard);
			pst.setString(4, RoomCharge);
			pst.setString(5, RoomPosition);
			ret = pst.executeUpdate();
			DBConnection.closed(pst, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("添加房间时出错"+e.getMessage());
		}
		return ret;
	}
	
	//更新房间信息
	public int updateroom(){
		int ret = 0;
		Connection conn = null;
		PreparedStatement pst = null;
		String sql = "update room set RoomCharge = ?, RoomStatus = ?,DateTime = ? where RoomNum = ?";
		try {
			conn = DBConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, RoomCharge);
			pst.setString(2, RoomStatus);
			pst.setString(3, DateTime);
			pst.setString(4, RoomNum);
		 	ret = pst.executeUpdate();
		 	DBConnection.closed(pst, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("更新房间信息时出错"+e.getMessage());
		}
		return ret;
	}
	public int insertfare(String UserNum,String Time){
		int ret = 0;
		Connection conn = null;
		PreparedStatement pst = null;
		String sql = "insert into farejustrecord(UserNum,Time) values(?,?) where RoomNum = ? and RoomACharge= ?";
		try {
			conn = DBConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, UserNum);
			pst.setString(2, Time);
			pst.setString(3, RoomNum);
			pst.setString(4, RoomCharge);
		 	ret = pst.executeUpdate();
		 	DBConnection.closed(pst, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("插入费用日志时信息时出错"+e.getMessage());
		}
		return ret;
	}
	
	public int deleteroom(){
		int ret = 0;
		Connection conn = null;
		PreparedStatement pst = null;
		String sql = "delete from room where RoomNum = ?";
		try {
			conn = DBConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, RoomNum);
		 	ret = pst.executeUpdate();
		 	DBConnection.closed(pst, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("删除房间信息时出错"+e.getMessage());
		}
		return ret;
	}

}
