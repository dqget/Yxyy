package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.batch.Main;

import util.DBConnection;

/**
 * 
 * @author 木奈何
 * 查询会员折扣基本信息，包括：会员类型、会员折扣
 */
public class discountBpo {
	
	List<discountBean> list = new ArrayList<discountBean>();
	discountBean db = null;
	public List<discountBean> Getdiscount(){
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from discount order by MemberType";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				db = new discountBean();
				db.setDiscount(rs.getString("discount"));
				db.setMemberType(rs.getString("MemberType"));
				list.add(db);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBConnection.close(rs, pst, conn);
		return list;
	}
	
	//根据membertype获取
	public discountBean getdiscountbyid(String MemberType){
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from discount where MemberType=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, MemberType);
			rs = pst.executeQuery();
			while(rs.next()){
				db = new discountBean();
				db.setDiscount(rs.getString("discount"));
				db.setMemberType(rs.getString("MemberType"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBConnection.close(rs, pst, conn);
		return db;
	}
	public static void main(String[] args) {
		discountBpo dcb = new discountBpo();
		System.out.println(dcb.getdiscountbyid("黄牌会员").getDiscount());
	}
}
