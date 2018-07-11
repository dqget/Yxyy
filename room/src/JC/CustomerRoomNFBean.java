package JC;

public class CustomerRoomNFBean {
	String CustomerIDNum;
	String CustomerName;
	String FareType;
	String Fare;
	String OPTime;
	public CustomerRoomNFBean(){
		
	}
	public CustomerRoomNFBean(String CustomerIDNum,String CustomerName,String FareType,String Fare,String OPTime){
		this.CustomerIDNum = CustomerIDNum;
		this.CustomerName = CustomerName;
		this.FareType = FareType;
		this.Fare = Fare;
		this.OPTime = OPTime;
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
	public String getFareType() {
		return FareType;
	}
	public void setFareType(String fareType) {
		FareType = fareType;
	}
	public String getFare() {
		return Fare;
	}
	public void setFare(String fare) {
		Fare = fare;
	}
	public String getOPTime() {
		return OPTime;
	}
	public void setOPTime(String oPTime) {
		OPTime = oPTime;
	}
}
