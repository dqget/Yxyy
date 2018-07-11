package JC;

import java.util.*;
import java.sql.*;
public class RoomBeanCL {
	private Connection cn = null;
	private Statement sm = null;
	private PreparedStatement psm = null;
	private ResultSet rs = null;
	RoomBean rb = null;
	public List<RoomBean> getFreeRoom(String RoomStatus,String RoomStandard){
		List<RoomBean> al = new ArrayList<RoomBean>();
		
		try{
			ConnDB cdb = new ConnDB();
			cn = cdb.getCT();
			sm = cn.createStatement();
			rs = sm.executeQuery("select RoomNum,FloorNum,RoomStandard,RoomCharge,RoomPosition,RoomStatus,DateTime from room "
					+ "where RoomStatus='"+RoomStatus+"' and RoomStandard='"+RoomStandard+"'");
			while(rs.next()){
				rb = new RoomBean();
				

				rb.setRoomNum(rs.getString(1));
				rb.setFloorNum(rs.getString(2));
				rb.setRoomStandard(rs.getString(3));
				rb.setRoomCharge(rs.getString(4));
				rb.setRoomPosition(rs.getString(5));
				rb.setRoomStatus(rs.getString(6));
				rb.setDateTime(rs.getString(7));
				al.add(rb);
			}
			
		}catch(Exception e){
			e.getStackTrace();
		}finally{
			this.CloseResourse();
		}
		return al;
	}
	public List<RoomBean> getRoom(String RoomNum){
		List<RoomBean> al = new ArrayList<RoomBean>();
		try{
			ConnDB cdb = new ConnDB();
			cn = cdb.getCT();
			sm = cn.createStatement();
			rs = sm.executeQuery("select RoomNum,FloorNum,RoomStandard,RoomCharge,RoomPosition,RoomStatus,DateTime from room where RoomNum='"+RoomNum+"'");
			while(rs.next()){
				rb = new RoomBean();
				rb.setRoomNum(rs.getString(1));
				rb.setFloorNum(rs.getString(2));
				rb.setRoomStandard(rs.getString(3));
				rb.setRoomCharge(rs.getString(4));
				rb.setRoomPosition(rs.getString(5));
				rb.setRoomStatus(rs.getString(6));
				rb.setDateTime(rs.getString(7));
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
