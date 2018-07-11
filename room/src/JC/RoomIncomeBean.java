package JC;
/*
*/

public class RoomIncomeBean {

	String RoomNum;
	String RoomStandard;
	String ActualFare;
	String CheckInTime;
	String CheckOutTime;
	public RoomIncomeBean(){
		
	}
	public RoomIncomeBean(String RoomNum,String RoomStandard,String ActualFare,String CheckInTime,String CheckOutTime){
		this.RoomNum = RoomNum;
		this.RoomStandard = RoomStandard;
		this.ActualFare = ActualFare;
		this.CheckInTime = CheckInTime;
		this.CheckOutTime = CheckOutTime;
	}
	public String getRoomNum() {
		return RoomNum;
	}
	public void setRoomNum(String roomNum) {
		RoomNum = roomNum;
	}
	public String getRoomStandard() {
		return RoomStandard;
	}
	public void setRoomStandard(String roomStandard) {
		RoomStandard = roomStandard;
	}
	public String getActualFare() {
		return ActualFare;
	}
	public void setActualFare(String actualFare) {
		ActualFare = actualFare;
	}
	public String getCheckInTime() {
		return CheckInTime;
	}
	public void setCheckInTime(String checkInTime) {
		CheckInTime = checkInTime;
	}
	public String getCheckOutTime() {
		return CheckOutTime;
	}
	public void setCheckOutTime(String checkOutTime) {
		CheckOutTime = checkOutTime;
	}
}
