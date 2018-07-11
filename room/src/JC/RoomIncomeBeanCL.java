package JC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoomIncomeBeanCL {
	private Connection cn = null;
	private Statement sm = null;
	private PreparedStatement psm = null;
	private ResultSet rs = null;
	public List<RoomIncomeBean> getRoomIncomeBeanCL(String st,String et){
		RoomIncomeBean cb = null;
		List<RoomIncomeBean> al = new ArrayList<RoomIncomeBean>();
		try{
			ConnDB cdb = new ConnDB();
			cn = cdb.getCT();
			sm = cn.createStatement();
			rs = sm.executeQuery("SELECT room.RoomNum, room.RoomStandard ,roomin.ActualFare ,roomin.CheckInTime,roomin.CheckOutTime from room,roomin  where DATEDIFF('"+st+"',roomin.CheckOutTime)<=0 and DATEDIFF('"+et+"',roomin.CheckOutTime)>0 and room.RoomNum =roomin.RoomNum GROUP BY room.RoomNum,roomin.CheckOutTime,roomin.CheckOutTime;");
			while(rs.next()){
				cb = new RoomIncomeBean();
				cb.setRoomNum(rs.getString(1));
				cb.setRoomStandard(rs.getString(2));
				cb.setActualFare(rs.getString(3));
				cb.setCheckInTime(rs.getString(4));
				cb.setCheckOutTime(rs.getString(5));
				al.add(cb);
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
