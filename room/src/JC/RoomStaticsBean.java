package JC;

public class RoomStaticsBean {
	String RoomStandard;
	String RoomStatus;
	String CountRN;
	public RoomStaticsBean(){
		
	}
	public RoomStaticsBean(String RoomStandard,String RoomStatus,String CountRN){
		this.RoomStandard = RoomStandard;
		this.RoomStatus = RoomStatus;
		this.CountRN = CountRN;
	}
	public String getRoomStandard() {
		return RoomStandard;
	}
	public void setRoomStandard(String roomStandard) {
		RoomStandard = roomStandard;
	}
	public String getRoomStatus() {
		return RoomStatus;
	}
	public void setRoomStatus(String roomStatus) {
		RoomStatus = roomStatus;
	}
	public String getCountRN() {
		return CountRN;
	}
	public void setCountRN(String countRN) {
		CountRN = countRN;
	}
}
