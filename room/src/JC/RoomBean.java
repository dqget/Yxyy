package JC;

import java.sql.*;
import JC.*;


public class RoomBean {
	
	/**
	 * @author 木奈何
	 * 客房信息管理
	 * 包括增删改查
	 */
	String RoomNum,FloorNum,RoomStandard,RoomCharge,RoomPosition,RoomStatus,DateTime;
	public RoomBean(){
		
	}
	public RoomBean(String RoomNum,String FloorNum,String RoomStandard,String RoomCharge,String RoomPosition,String RoomStatus,String DateTime){
		this.RoomNum = RoomNum;
		this.FloorNum = FloorNum;
		this.RoomStandard = RoomStandard;
		this.RoomCharge = RoomCharge;
		this.RoomPosition = RoomPosition;
		this.RoomStatus = RoomStatus;
		this.DateTime = DateTime;
	}
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
}