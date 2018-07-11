package JC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
;*/
public class RoomStaticsBeanCL {
	private Connection cn = null;
	private Statement sm = null;
	private PreparedStatement psm = null;
	private ResultSet rs = null;
	RoomStaticsBean ib = null;
	public List<RoomStaticsBean> getRoomStaticsBeanCL(String RoomStandard,String st,String et){
		List<RoomStaticsBean> al = new ArrayList<RoomStaticsBean>();
		try{
			ConnDB cdb = new ConnDB();
			cn = cdb.getCT();
			sm = cn.createStatement();
			rs = sm.executeQuery("SELECT room.RoomStandard,room.RoomStatus ,COUNT(room.RoomNum) FROM room where room.RoomStandard='"+RoomStandard+"' and DATEDIFF('"+st+"',room.DateTime)<=0 and DATEDIFF('"+et+"',room.DateTime)>0 GROUP BY RoomStandard,room.RoomStatus");
			while(rs.next()){
				ib = new RoomStaticsBean();
				ib.setRoomStandard(rs.getString(1));
				ib.setRoomStatus(rs.getString(2));
				ib.setCountRN(rs.getString(3));
				al.add(ib);
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
