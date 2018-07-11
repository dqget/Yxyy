package JC;

public class RealRoomInBean {
	String CustomerNum;
	String RoomNum;
	String CheckInTime;
	String CheckOutTime;
	Float ActualFare;
	String UserNum;
	String DayNum;
	public RealRoomInBean(){
		
	}
	public RealRoomInBean(String CustomerNum,String RoomNum,String CheckInTime,
			String CheckOutTime,Float ActualFare,String UserNum,String DayNum){
		this.CustomerNum = RoomNum;
		this.RoomNum = RoomNum;
		this.CheckInTime = CheckInTime;
		this.CheckOutTime = CheckOutTime;
		this.ActualFare = ActualFare;
		this.UserNum = UserNum;
		this.DayNum = DayNum;
	}
	public String getCustomerNum() {
		return CustomerNum;
	}
	public void setCustomerNum(String customerNum) {
		CustomerNum = customerNum;
	}
	public String getRoomNum() {
		return RoomNum;
	}
	public void setRoomNum(String roomNum) {
		RoomNum = roomNum;
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
	public Float getActualFare() {
		return ActualFare;
	}
	public void setActualFare(Float actualFare) {
		ActualFare = actualFare;
	}
	public String getUserNum() {
		return UserNum;
	}
	public void setUserNum(String userNum) {
		UserNum = userNum;
	}
	public String getDayNum() {
		return DayNum;
	}
	public void setDayNum(String dayNum) {
		DayNum = dayNum;
	}
}
