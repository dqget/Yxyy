package JC;
import java.sql.*;
import java.util.*;


public class ReserveBeanCL {
	private Connection cn = null;
	private Statement sm = null;
	private PreparedStatement psm = null;
	private ResultSet rs = null;
	ReserveBean rb = null;
	public List<ReserveBean> getFreeRoom(String CustomerName,String LinkTel){
		List<ReserveBean> al = new ArrayList<ReserveBean>();
		try{
			ConnDB cdb = new ConnDB();
			cn = cdb.getCT();
			sm = cn.createStatement();
			rs = sm.executeQuery("select FloorNum,RoomNum,StartTime,EndTime from reserve where CustomerName='"+CustomerName+"' and LinkTel='"+LinkTel+"'");
			while(rs.next()){
				rb = new ReserveBean();
				rb.setFloorNum(rs.getString(1));
				rb.setRoomNum(rs.getString(2));
				rb.setStartTime(rs.getString(3));
				rb.setEndTime(rs.getString(4));
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
