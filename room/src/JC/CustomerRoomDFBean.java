package JC;
/*select CustomerIDNum,CustomerName,SUM(DayNum), SUM(ActualFare) 
from roomin,customer 
where customer.CustomerNum=roomin.CustomerNum and
DATEDIFF(roomin.CheckInTime,'2018-1-11')>=0 and DATEDIFF(roomin.CheckOutTime,'2018-1-14')<=0;*/
public class CustomerRoomDFBean {
	String CustomerIDNum;
	String CustomerName;
	String SUMDayNum;
	String SUMActualFare;
	public CustomerRoomDFBean(){
		
	}
	public CustomerRoomDFBean(String CustomerIDNum,String CustomerName,String SUMDayNum,String SUMActualFare){
		this.CustomerIDNum = CustomerIDNum;
		this.CustomerName = CustomerName;
		this.SUMDayNum = SUMDayNum;
		this.SUMActualFare = SUMActualFare;
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
	public String getSUMDayNum() {
		return SUMDayNum;
	}
	public void setSUMDayNum(String sUMDayNum) {
		SUMDayNum = sUMDayNum;
	}
	public String getSUMActualFare() {
		return SUMActualFare;
	}
	public void setSUMActualFare(String sUMActualFare) {
		SUMActualFare = sUMActualFare;
	}
}
