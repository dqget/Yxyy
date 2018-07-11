package JC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerRoomNFBeanCL {
	private Connection cn = null;
	private Statement sm = null;
	private PreparedStatement psm = null;
	private ResultSet rs = null;
	CustomerRoomNFBean rb = null;
	public List<CustomerRoomNFBean> getCustomerRoomNFBeanCL(String CustomerIDNum,String CustomerTel,String st,String et){
		List<CustomerRoomNFBean> al = new ArrayList<CustomerRoomNFBean>();
		try{
			ConnDB cdb = new ConnDB();
			cn = cdb.getCT();
			sm = cn.createStatement();
			rs = sm.executeQuery("select distinct CustomerIDNum,CustomerName,FareType,Fare,OPTime from roomin,customer,otherfare where customer.CustomerNum=roomin.CustomerNum and CustomerIDNum='"+CustomerIDNum+"' and CustomerTel='"+CustomerTel+"' and roomin.RoomNum=otherfare.RoomNum and DATEDIFF(roomin.CheckInTime,'"+st+"')>=0 and DATEDIFF(roomin.CheckOutTime,'"+et+"')<=0;");
			while(rs.next()){
				rb = new CustomerRoomNFBean();
				rb.setCustomerIDNum(rs.getString(1));
				rb.setCustomerName(rs.getString(2));
				rb.setFareType(rs.getString(3));
				rb.setFare(rs.getString(4));
				rb.setOPTime(rs.getString(5));
				al.add(rb);
			}
		}catch(Exception e){
			e.getStackTrace();
		}finally{
			this.CloseResourse();
		}
		return al;
	}
	public void CloseResourse(){
		try{
			if(rs!=null){
				rs.close();
				rs = null;
			}
			if(sm!=null){
				sm.close();
				sm = null;
			}
			if(psm!=null){
				psm.close();
				psm = null;
			}
			if(cn!=null){
				cn.close();
				cn = null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
