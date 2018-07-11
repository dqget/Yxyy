package JC;
import java.sql.*;
import java.util.*;
public class CustomerBeanCL {
	private Connection cn = null;
	private Statement sm = null;
	private PreparedStatement psm = null;
	private ResultSet rs = null;
	public List<CustomerBean> getAllcb(){
		CustomerBean cb = null;
		List<CustomerBean> al = new ArrayList<CustomerBean>();
		try{
			ConnDB cdb = new ConnDB();
			cn = cdb.getCT();
			sm = cn.createStatement();
			rs = sm.executeQuery("select * from customer");
			while(rs.next()){
				cb = new CustomerBean();
				cb.setCustomerNum(rs.getString(1));
				cb.setCustomerName(rs.getString(2));
				cb.setCustomerIDNum(rs.getString(3));
				cb.setCustomerBD(rs.getString(4));
				cb.setCustomerSex(rs.getString(5));
				cb.setCustomerTel(rs.getString(6));
				cb.setCustomerMail(rs.getString(7));
				cb.setMemberNum(rs.getString(8));
				cb.setCustomerStatus(rs.getString(9));
				cb.setCheckInTime(rs.getString(10));
				cb.setCheckOutTime(rs.getString(11));
				al.add(cb);
			}
		}catch(Exception e){
			e.getStackTrace();
		}finally{
			this.CloseResourse();
		}
		return al;
	}
	public boolean Add(String CustomerNum,String CustomerName,String CustomerIDNum,String 
			CustomerBD,String CustomerSex,String CustomerTel,String CustomerMail,String MemberNum,
			String CustomerStatus,String CheckInTime,String CheckOutTime){
		boolean b = false;
		try{
			ConnDB cdb = new ConnDB();
			cn = cdb.getCT();
			String sql = "INSERT INTO customer VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			psm = cn.prepareStatement(sql);
			psm.setString(1,CustomerNum);
			psm.setString(2,CustomerName);
			psm.setString(3,CustomerIDNum);
			psm.setString(4,CustomerBD);
			psm.setString(5,CustomerSex);
			psm.setString(6,CustomerTel);
			psm.setString(7,CustomerMail);
			psm.setString(8,MemberNum);
			psm.setString(9,CustomerStatus);
			psm.setString(10,CheckInTime);
			psm.setString(11,CheckOutTime);
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
			String sql = "delete from customer where CustomerNum='"+CustomerNum+"'";
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
	public boolean Correct(String CustomerNum,String CustomerName,String CustomerIDNum,String 
			CustomerBD,String CustomerSex,String CustomerTel,String CustomerMail,String MemberNum,
			String CustomerStatus,String CheckInTime,String CheckOutTime){
		boolean b = false;
		try{
			ConnDB cdb = new ConnDB();
			cn = cdb.getCT();
			sm = cn.createStatement();
			String sql = "update customer set CustomerName='"+CustomerName+"',CustomerIDNum='"+CustomerIDNum+"',CustomerSex='"+CustomerSex+"',CustomerTel='"+CustomerTel+"',CustomerMail='"+CustomerMail+"',MemberNum='"+MemberNum+"',CustomerStatus='"+CustomerStatus+"',CheckInTime='"+CheckInTime+"',CheckOutTime='"+CheckOutTime+"' where CustomerNum='"+CustomerNum+"'";
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
	public CustomerBean dispaly(String CustomerNum){
		CustomerBean b = new CustomerBean();
		try{
			ConnDB cdb = new ConnDB();
			cn = cdb.getCT();
			sm = cn.createStatement();
			String sql = "select CustomerNum,CustomerName,CustomerIDNum,CustomerBD,CustomerSex,CustomerTel,"
					+ "CustomerMail,MemberNum,CustomerStatus,CheckInTime,CheckOutTime"
					+ " from users where UserID='"+CustomerNum+"'";
			rs = sm.executeQuery(sql);
			if(rs.next()){
				b.setMemberNum(rs.getString(1));
				b.setCustomerName(rs.getString(2));
				b.setCustomerIDNum(rs.getString(3));
				b.setCustomerBD(rs.getString(4));
				b.setCustomerSex(rs.getString(5));
				b.setCustomerTel(rs.getString(6));
				b.setCustomerMail(rs.getString(7));
				b.setMemberNum(rs.getString(8));
				b.setCustomerStatus(rs.getString(9));
				b.setCheckInTime(rs.getString(10));
				b.setCheckOutTime(rs.getString(11));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.CloseResourse();
		}
		return b;
	}
	public boolean flush(String a1,String a2,String a3){
		boolean b = false;
		try{
			ConnDB cdb = new ConnDB();
			cn = cdb.getCT();
			sm = cn.createStatement();
			String sql = "call upstatus('"+a1+"','"+a2+"','"+a3+"')";
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
