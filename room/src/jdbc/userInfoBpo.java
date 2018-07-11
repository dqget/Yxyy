package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBConnection;

public class userInfoBpo {
	/**
	 * @author 木奈何
	 * 根据用户id查找用户
	 * 查找全部用户
	 */
	
	public userInfoBpo(){
		
	}
	
	public userInfoBean getuserinfoByid(String userNum){
		userInfoBean uib = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from user where UserNum = ?";
		try {
			conn = DBConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, userNum);
			rs = pst.executeQuery();
			while(rs.next()){
				uib = new userInfoBean();
				uib.setUserNum(rs.getString("UserNum"));
				uib.setUserName(rs.getString("UserName"));
				uib.setUserType(rs.getString("UserType"));
				uib.setUserTrueName(rs.getString("UserTrueName"));
				uib.setUserPassword(rs.getString("UserPassword"));
				uib.setAge(rs.getString("Age"));
				uib.setSex(rs.getString("Sex"));
			}
			DBConnection.close(rs, pst, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uib;
	}
	
	//查询全部的用户
	public List<userInfoBean> getuserinfo(){
		List<userInfoBean> list = new ArrayList<userInfoBean>();
		userInfoBean uib = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from user";
		try {
			conn = DBConnection.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				uib = new userInfoBean();
				uib.setUserNum(rs.getString("UserNum"));
				uib.setUserName(rs.getString("UserName"));
				uib.setUserType(rs.getString("UserType"));
				uib.setUserTrueName(rs.getString("UserTrueName"));
				uib.setUserPassword(rs.getString("UserPassword"));
				uib.setAge(rs.getString("Age"));
				uib.setSex(rs.getString("Sex"));
				list.add(uib);
			}
			DBConnection.close(rs, pst, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
