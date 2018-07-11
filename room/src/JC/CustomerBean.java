package JC;

public class CustomerBean {
	String CustomerNum;
	String CustomerName;
	String CustomerIDNum;
	String CustomerBD;
	String CustomerSex;
	String CustomerTel;
	String CustomerMail;
	String MemberNum;
	String CustomerStatus;
	String CheckInTime;
	String CheckOutTime;
	public CustomerBean(){
		
	}
	public CustomerBean(String CustomerNum,String CustomerName,String CustomerIDNum,String 
			CustomerBD,String CustomerSex,String CustomerTel,String CustomerMail,String MemberNum,
			String CustomerStatus,String CheckInTime,String CheckOutTime){
		this.CustomerNum = CustomerNum;
		this.CustomerName = CustomerName;
		this.CustomerIDNum = CustomerIDNum;
		this.CustomerBD = CustomerBD;
		this.CustomerSex = CustomerSex;
		this.CustomerTel = CustomerTel;
		this.CustomerMail = CustomerMail;
		this.MemberNum = MemberNum;
		this.CustomerStatus = CustomerStatus;
		this.CheckInTime = CheckInTime;
		this.CheckOutTime = CheckOutTime;
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
	public String getCustomerBD() {
		return CustomerBD;
	}
	public void setCustomerBD(String customerBD) {
		CustomerBD = customerBD;
	}
	public String getCustomerSex() {
		return CustomerSex;
	}
	public void setCustomerSex(String customerSex) {
		CustomerSex = customerSex;
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
	public String getCustomerStatus() {
		return CustomerStatus;
	}
	public void setCustomerStatus(String customerStatus) {
		CustomerStatus = customerStatus;
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
