package JC;

public class ReserveBean {
	String RoomNum;
	String FloorNum;
	String CustomerNum;
	String CustomerName;
	String StartTime;
	String EndTime;
	String LinkMan;
	String LinkTel;
	String UserOP;
	String Handsel;
	String RoomCharge;
	String OPTime;
	public ReserveBean(){
		
	}
	public ReserveBean(String RoomNum,String FloorNum,String CustomerNum,String CustomerName,String StartTime
			,String EndTime,String LinkMan,String LinkTel,String UserOP,String Handsel,String RoomCharge,
			String OPTime){
		this.RoomNum = RoomNum;
		this.FloorNum = FloorNum;
		this.CustomerNum = CustomerNum;
		this.CustomerName = CustomerName;
		this.StartTime = StartTime;
		this.EndTime = EndTime;
		this.LinkMan = LinkMan;
		this.LinkTel = LinkTel;
		this.UserOP = UserOP;
		this.Handsel = Handsel;
		this.RoomCharge = RoomCharge;
		this.OPTime = OPTime;
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
	public String getCustomerNum() {
		return CustomerNum;
	}
	public void setCustomerNum(String customerNum) {
		CustomerNum = customerNum;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getStartTime() {
		return StartTime;
	}
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}
	public String getEndTime() {
		return EndTime;
	}
	public void setEndTime(String endTime) {
		EndTime = endTime;
	}
	public String getLinkMan() {
		return LinkMan;
	}
	public void setLinkMan(String linkMan) {
		LinkMan = linkMan;
	}
	public String getLinkTel() {
		return LinkTel;
	}
	public void setLinkTel(String linkTel) {
		LinkTel = linkTel;
	}
	public String getUserOP() {
		return UserOP;
	}
	public void setUserOP(String userOP) {
		UserOP = userOP;
	}
	public String getHandsel() {
		return Handsel;
	}
	public void setHandsel(String handsel) {
		Handsel = handsel;
	}
	public String getRoomCharge() {
		return RoomCharge;
	}
	public void setRoomCharge(String roomCharge) {
		RoomCharge = roomCharge;
	}
	public String getOPTime() {
		return OPTime;
	}
	public void setOPTime(String oPTime) {
		OPTime = oPTime;
	}
}
