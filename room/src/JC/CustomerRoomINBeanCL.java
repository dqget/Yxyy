package JC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerRoomINBeanCL {
	private Connection cn = null;
	private Statement sm = null;
	private PreparedStatement psm = null;
	private ResultSet rs = null;
	CustomerRoomINBean crib = null;
	public List<CustomerRoomINBean> getCustomerRoomINBean(String CustomerNum,String st,String et){
		List<CustomerRoomINBean> al = new ArrayList<CustomerRoomINBean>();
		try{
			ConnDB cdb = new ConnDB();
			cn = cdb.getCT();
			sm = cn.createStatement();
			rs = sm.executeQuery("select CustomerIDNum,CustomerName,RoomNum,roomin.CheckInTime,roomin.CheckOutTime,ActualFare from roomin,customer where customer.CustomerNum=roomin.CustomerNum and roomin.CustomerNum='"+CustomerNum+"' and DATEDIFF(roomin.CheckInTime,'"+st+"')>=0 and DATEDIFF(roomin.CheckOutTime,'"+et+"')<=0");
			while(rs.next()){
				crib = new CustomerRoomINBean();
				crib.setCustomerIDNum(rs.getString(1));
				crib.setCustomerName(rs.getString(2));
				crib.setRoomNum(rs.getString(3));
				crib.setCheckInTime(rs.getString(4));
				crib.setCheckOutTime(rs.getString(5));
				crib.setActualFare(rs.getString(6));
				System.out.println(crib.CustomerIDNum);
				al.add(crib);
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
