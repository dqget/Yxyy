package JC;

public class CustomerRoomINBean {
	String CustomerIDNum;
	String CustomerName;
	String RoomNum;
	String CheckInTime;
	String CheckOutTime;
	String ActualFare;
	public CustomerRoomINBean(){
		
	}
	public CustomerRoomINBean(	String CustomerIDNum,String CustomerName,String RoomNum,
			String CheckInTime,String CheckOutTime,String ActualFare){
		this.CustomerIDNum = CustomerIDNum;
		this.CustomerName = CustomerName;
		this.RoomNum = RoomNum;
		this.CheckInTime = CheckInTime;
		this.CheckOutTime = CheckOutTime;
		this.ActualFare = ActualFare;
	}
	public String getCustomerIDNum() {
		return CustomerIDNum;
	}
	public void setCustomerIDNum(String customerIDNum) {
		CustomerIDNum = customerIDNum;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
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
	public String getActualFare() {
		return ActualFare;
	}
	public void setActualFare(String actualFare) {
		ActualFare = actualFare;
	}
}