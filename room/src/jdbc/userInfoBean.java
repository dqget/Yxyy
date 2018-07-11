package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DBConnection;

public class userInfoBean {
	/**
	 * @author 木奈何
	 * 客房用户管理模块，包括增删改查等操作
	 * 用户分类型
	 */
private String UserNum,UserName,UserType,UserPassword,UserTrueName,Age,Sex;
	
	public userInfoBean(){
		
	}

	public String getUserNum() {
		return UserNum;
	}

	public void setUserNum(String userNum) {
		UserNum = userNum;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getUserType() {
		return UserType;
	}

	public void setUserType(String userType) {
		UserType = userType;
	}

	public String getUserPassword() {
		return UserPassword;
	}

	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}

	public String getUserTrueName() {
		return UserTrueName;
	}

	public void setUserTrueName(String userTrueName) {
		UserTrueName = userTrueName;
	}

	public String getAge() {
		return Age;
	}

	public void setAge(String age) {
		Age = age;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}
	
	//增加用户
	public int addUser(){
		Connection conn = null;
		PreparedStatement pst = null;
		String sql = "insert into user(UserNum,UserName,UserType,UserPassword,UserTrueName,Age,Sex) values(?,?,?,?,?,?,?)";
		int ret = 0;
		try {
			conn = DBConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, UserNum);
			pst.setString(2, UserName);
			pst.setString(3, UserType);
			pst.setString(4, UserPassword);
			pst.setString(5, UserTrueName);
			pst.setString(6, Age);
			pst.setString(7, Sex);
			ret = pst.executeUpdate();
			DBConnection.closed(pst, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("添加用户时出错"+e.getMessage());
		}
		return ret;
	}
	
	//更新用户信息
	public int updateinfo(){
		int ret = 0;
		Connection conn = null;
		PreparedStatement pst = null;
		String sql = "update user set UserName = ?,UserPassword = ?,UserTrueName = ?where UserNum = ?";
		try {
			conn = DBConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, UserName);
			pst.setString(2, UserPassword);
			pst.setString(3, UserTrueName);
			pst.setString(4, UserNum);
		 	ret = pst.executeUpdate();
		 	DBConnection.closed(pst, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("更新用户信息时出错"+e.getMessage());
		}
		return ret;
	}
	
	//删除用户信息
	public int deleteinfo(){
		int ret = 0;
		Connection conn = null;
		PreparedStatement pst = null;
		String sql = "delete from user where UserNum = ?";
		try {
			conn = DBConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, UserNum);
		 	ret = pst.executeUpdate();
		 	DBConnection.closed(pst, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("删除用户信息时出错"+e.getMessage());
		}
		return ret;
	}

}
