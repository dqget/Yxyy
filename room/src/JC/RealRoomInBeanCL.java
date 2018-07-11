package JC;
import java.sql.*;
import java.util.*;
public class RealRoomInBeanCL {
	private Connection cn = null;
	private Statement sm = null;
	private PreparedStatement psm = null;
	private ResultSet rs = null;
	public List<RealRoomInBean> getAllrrib(){
		RealRoomInBean rrib = null;
		List<RealRoomInBean> al = new ArrayList<RealRoomInBean>();
		try{
			ConnDB cdb = new ConnDB();
			cn = cdb.getCT();
			sm = cn.createStatement();
			rs = sm.executeQuery("select * from roomin");
			while(rs.next()){
				rrib = new RealRoomInBean();
				rrib.setCustomerNum(rs.getString(1));
				rrib.setRoomNum(rs.getString(2));
				rrib.setCheckInTime(rs.getString(3));
				rrib.setCheckOutTime(rs.getString(4));
				rrib.setActualFare(rs.getFloat(5));
				rrib.setUserNum(rs.getString(6));
				rrib.setDayNum(rs.getString(7));
				al.add(rrib);
			}
		}catch(Exception e){
			e.getStackTrace();
		}
		return al;
	}
	public boolean Add(String CustomerNum,String RoomNum,String CheckInTime,
			String CheckOutTime,Float ActualFare,String UserNum,String DayNum){
		boolean b = false;
		try{
			ConnDB cdb = new ConnDB();
			cn = cdb.getCT();
			String sql = "INSERT INTO roomin VALUES(?,?,?,?,?,?,?)";
			psm = cn.prepareStatement(sql);
			psm.setString(1,CustomerNum);
			psm.setString(2,RoomNum);
			psm.setString(3,CheckInTime);
			psm.setString(4,CheckOutTime);
			psm.setFloat(5,ActualFare);
			psm.setString(6,UserNum);
			psm.setString(7,DayNum);
			int num = psm.executeUpdate();
			if(num==1){
				b = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.CloseResourse();
		}
		return b;
	}
	public boolean Remove(String CustomerNum){
		boolean b = false;
		try{
			ConnDB cdb = new ConnDB();
			cn = cdb.getCT();
			sm = cn.createStatement();
			String sql = "delete from roomin where CustomerNum='"+CustomerNum+"'";
			int num = sm.executeUpdate(sql);
			if(num==1){
				b = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.CloseResourse();
		}
		return b;
	}
	public boolean Correct(String CustomerNum,String RoomNum,String CheckInTime,String CheckOutTime,Float ActualFare,String UserNum,String DayNum){
		boolean b = false;
		try{
			ConnDB cdb = new ConnDB();
			cn = cdb.getCT();
			sm = cn.createStatement();
			String sql = "update roomin set RoomNum="+RoomNum+",CheckInTime="+CheckInTime+",CheckOutTime="+CheckOutTime+",ActualFare="+ActualFare+",UserNum="+UserNum+",DayNum="+DayNum+" where CustomerNum="+CustomerNum+"";
			int num = sm.executeUpdate(sql);
			if(num==1){
				b = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.CloseResourse();
		}
		return b;
	}
	public RealRoomInBean dispaly(String CustomerNum){
		RealRoomInBean rrib = new RealRoomInBean();
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.CloseResourse();
		}
		return rrib;
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