package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBConnection;

public class roomBpo {
	
	/**
	 * @author 木奈何
	 * 能够按照楼层号、标准查询客房详细信息，
	 * 若没有输入标准，则显示指定楼层的所有客房信息
	 * 能够根据楼层号和房间号查询费用修改信息。
	 */
	
	//根据楼层号、标准查询客房详细信息
	public  List<roomBean> getRoomById(String FloorNum,String RoomStandard){
		List<roomBean> list=new ArrayList<roomBean>();
		roomBean r =null;
		try {
			Connection conn=DBConnection.getConnection();
			String sql="select * from room where FloorNum=? and RoomStandard=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, FloorNum);
			pst.setString(2, RoomStandard);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				r = new roomBean();
				r.setRoomNum(rs.getString("RoomNum"));
				r.setFloorNum(rs.getString("FloorNum"));
				r.setRoomStandard(rs.getString("RoomStandard"));
				r.setRoomCharge(rs.getString("RoomCharge"));
				r.setRoomPosition(rs.getString("RoomPosition"));
				r.setRoomStatus(rs.getString("RoomStatus"));
				list.add(r);
			}
			DBConnection.close(rs, pst, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("根据课程编号查询出错:"+e.getMessage());
		}
		return list;
	}
	
	//根据楼层号查询房间信息
	public  List<roomBean> getRoomByFn(String FloorNum){
		List<roomBean> list=new ArrayList<roomBean>();
		roomBean r =null;
		try {
			Connection conn=DBConnection.getConnection();
			String sql="select * from room where FloorNum=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, FloorNum);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				r = new roomBean();
				r.setRoomNum(rs.getString("RoomNum"));
				r.setFloorNum(rs.getString("FloorNum"));
				r.setRoomStandard(rs.getString("RoomStandard"));
				r.setRoomCharge(rs.getString("RoomCharge"));
				r.setRoomPosition(rs.getString("RoomPosition"));
				r.setRoomStatus(rs.getString("RoomStatus"));
				list.add(r);
			}
			DBConnection.close(rs, pst, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("根据课程编号查询出错:"+e.getMessage());
		}
		return list;
	}
	
	//根据标准查询房间信息
		public  List<roomBean> getRoomByRs(String RoomStandard){
			List<roomBean> list=new ArrayList<roomBean>();
			roomBean r =null;
			try {
				Connection conn=DBConnection.getConnection();
				String sql="select * from room where RoomStandard=?";
				PreparedStatement pst=conn.prepareStatement(sql);
				pst.setString(1, RoomStandard);
				ResultSet rs=pst.executeQuery();
				while(rs.next()){
					r = new roomBean();
					r.setRoomNum(rs.getString("RoomNum"));
					r.setFloorNum(rs.getString("FloorNum"));
					r.setRoomStandard(rs.getString("RoomStandard"));
					r.setRoomCharge(rs.getString("RoomCharge"));
					r.setRoomPosition(rs.getString("RoomPosition"));
					r.setRoomStatus(rs.getString("RoomStatus"));
					list.add(r);
				}
				DBConnection.close(rs, pst, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("根据课程编号查询出错:"+e.getMessage());
			}
			return list;
		}
	
	public  roomBean getRoomById(String RoomNum){
		roomBean r =null;
		try {
			Connection conn=DBConnection.getConnection();
			String sql="select * from room where RoomNum=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, RoomNum);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				r = new roomBean();
				r.setRoomNum(rs.getString("RoomNum"));
				r.setFloorNum(rs.getString("FloorNum"));
				r.setRoomStandard(rs.getString("RoomStandard"));
				r.setRoomCharge(rs.getString("RoomCharge"));
				r.setRoomPosition(rs.getString("RoomPosition"));
				r.setRoomStatus(rs.getString("RoomStatus"));
			}
			DBConnection.close(rs, pst, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("根据房间号查询出错:"+e.getMessage());
		}
		return r;
	}
	
	//查找所有房间
	public  List<roomBean> getRoom(){
		List<roomBean> list=new ArrayList<roomBean>();
		try {
			Connection conn=DBConnection.getConnection();
			String sql="select * from room order by RoomNum";
			PreparedStatement pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				roomBean r =new roomBean();
				r.setRoomNum(rs.getString("RoomNum"));
				r.setFloorNum(rs.getString("FloorNum"));
				r.setRoomStandard(rs.getString("RoomStandard"));
				r.setRoomCharge(rs.getString("RoomCharge"));
				r.setRoomPosition(rs.getString("RoomPosition"));
				r.setRoomStatus(rs.getString("RoomStatus"));
				list.add(r);
			}
			DBConnection.close(rs, pst, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查询所有房间时出错:"+e.getMessage());
		}
		return list;
	}
	
	//根据楼层号和房间号查询费用修改信息
	public  farejustrecordBean getrecordById(String FloorNum,String RoomNum){
		farejustrecordBean r = null;
		//roomBean r =null;
		try {
			Connection conn=DBConnection.getConnection();
			String sql="select * from farejustrecord where FloorNum=? and RoomNum=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, FloorNum);
			pst.setString(2, RoomNum);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				r = new farejustrecordBean();
				r.setRoomNum(rs.getString("RoomNum"));
				r.setFloorNum(rs.getString("FloorNum"));
				r.setRoomBCharge(rs.getString("RoomBCharge"));
				r.setRoomACharge(rs.getString("RoomACharge"));
				r.setTime(rs.getString("Time"));
			}
			DBConnection.close(rs, pst, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("根据楼层号房间号查询时出错:"+e.getMessage());
		}
		return r;
	}
	
	//插入费用日志里面的用户名
	public  int insertrecordById(String RoomNum,String UserNum,String DateTime){
		int r =0;
		try {
			Connection conn=DBConnection.getConnection();
			String sql="update farejustrecord set UserNum = ? where RoomNum=? and Time=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, UserNum);
			pst.setString(2, RoomNum);
			pst.setDate(3, Date.valueOf(DateTime));
			 r=pst.executeUpdate();
			DBConnection.closed(pst, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("插入费用日志时出错:"+e.getMessage());
		}
		return r;
	}
	public static void main(String[] args) {
		List<roomBean> list = new roomBpo().getRoom();
		System.out.println(list.get(0).getFloorNum());
	}
}
