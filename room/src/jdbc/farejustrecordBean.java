package jdbc;

public class farejustrecordBean {
	
	/**
	 * @author 木奈何
	 * 费用调整日志
	 */
	public farejustrecordBean(){
		
	}
	private String RoomNum,RoomBCharge,RoomACharge,UserNum,Time,FloorNum;
	public String getRoomNum() {
		return RoomNum;
	}
	public void setRoomNum(String roomNum) {
		RoomNum = roomNum;
	}
	public String getRoomBCharge() {
		return RoomBCharge;
	}
	public void setRoomBCharge(String roomBCharge) {
		RoomBCharge = roomBCharge;
	}
	public String getRoomACharge() {
		return RoomACharge;
	}
	public void setRoomACharge(String roomACharge) {
		RoomACharge = roomACharge;
	}
	public String getUserNum() {
		return UserNum;
	}
	public void setUserNum(String userNum) {
		UserNum = userNum;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public String getFloorNum() {
		return FloorNum;
	}
	public void setFloorNum(String floorNum) {
		FloorNum = floorNum;
	}

}
