package JC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerRoomDFBeanCL {
	private Connection cn = null;
	private Statement sm = null;
	private PreparedStatement psm = null;
	private ResultSet rs = null;
	CustomerRoomDFBean rb = null;
	public List<CustomerRoomDFBean> getCustomerRoomDFBeanCL(String st,String et){
		List<CustomerRoomDFBean> al = new ArrayList<CustomerRoomDFBean>();
		try{
			ConnDB cdb = new ConnDB();
			cn = cdb.getCT();
			sm = cn.createStatement();
			rs = sm.executeQuery("select CustomerIDNum,CustomerName,SUM(DayNum), SUM(ActualFare) from roomin,customer where customer.CustomerNum=roomin.CustomerNum and DATEDIFF(roomin.CheckInTime,'"+st+"')>=0 and DATEDIFF(roomin.CheckOutTime,'"+et+"')<=0;");
			while(rs.next()){
				rb = new CustomerRoomDFBean();
				rb.setCustomerIDNum(rs.getString(1));
				rb.setCustomerName(rs.getString(2));
				rb.setSUMDayNum(rs.getString(3));
				rb.setSUMActualFare(rs.getString(4));
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
