package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DBConnection;

/**
 * 
 * @author 木奈何 会员信息管理 包括会员级别，折扣
 */
public class discountBean {
	private String MemberType, Discount;
	Connection conn = null;
	PreparedStatement pst = null;

	public String getMemberType() {
		return MemberType;
	}

	public void setMemberType(String memberType) {
		MemberType = memberType;
	}

	public String getDiscount() {
		return Discount;
	}

	public void setDiscount(String discount) {
		Discount = discount;
	}

	public discountBean() {

	}

	// 增加新的会员类型和折扣
	public int adddiscount() {
		int re = 0;
		try {
			conn = DBConnection.getConnection();
			String sql = "insert into discount values(?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, MemberType);
			pst.setString(2, Discount);
			re = pst.executeUpdate();
			DBConnection.closed(pst, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}

	// 更新会员类型和折扣
	public int updatediscount() {
		int re = 0;
		try {
			conn = DBConnection.getConnection();
			String sql = "update discount set Discount = ? where MemberType = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, Discount);
			pst.setString(2, MemberType);
			re = pst.executeUpdate();
			DBConnection.closed(pst, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return re;
	}

	// 删除会员类型与折扣
	public int deletediscount() {
		int re = 0;
		try {
			conn = DBConnection.getConnection();
			String sql = "delete from discount where MemberType = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, MemberType);
			re = pst.executeUpdate();
			DBConnection.closed(pst, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return re;
	}

	public static void main(String[] args) {
		discountBean db = new discountBean();
		db.setDiscount("0.5");
		db.setMemberType("黄牌会员");
		System.out.println(db.updatediscount());
	}
}
