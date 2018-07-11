package a;

public class Customer_Fare {
	String CustomerNum;
	String CustomerName;
	String CustomerIDNum;
	String CustomerTel;
	String CustomerMail;
	String MemberNum;
	Float handsel;
	String rnum;
	
	Float roomcharge;
	Float otherfare;
	Float actualfare;
	Float sumFare;
	
	String OPTime;
	
	public Customer_Fare(){
		
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
	public String getCustomerIDNum() {
		return CustomerIDNum;
	}
	public void setCustomerIDNum(String customerIDNum) {
		CustomerIDNum = customerIDNum;
	}
	public String getCustomerTel() {
		return CustomerTel;
	}
	public void setCustomerTel(String customerTel) {
		CustomerTel = customerTel;
	}
	public String getCustomerMail() {
		return CustomerMail;
	}
	public void setCustomerMail(String customerMail) {
		CustomerMail = customerMail;
	}
	public String getMemberNum() {
		return MemberNum;
	}
	public void setMemberNum(String memberNum) {
		MemberNum = memberNum;
	}
	public Float getHandsel() {
		return handsel;
	}
	public void setHandsel(Float handsel) {
		this.handsel = handsel;
	}
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	public Float getRoomcharge() {
		return roomcharge;
	}
	public void setRoomcharge(Float roomcharge) {
		this.roomcharge = roomcharge;
	}
	public Float getOtherfare() {
		return otherfare;
	}
	public void setOtherfare(Float otherfare) {
		this.otherfare = otherfare;
	}
	public Float getActualfare() {
		return actualfare;
	}
	public void setActualfare(Float actualfare) {
		this.actualfare = actualfare;
	}
	public Float getSumFare() {
		return roomcharge+otherfare;
	}
	public String getOPTime() {
		return OPTime;
	}
	public void setOPTime(String oPTime) {
		OPTime = oPTime;
	}
	
}
