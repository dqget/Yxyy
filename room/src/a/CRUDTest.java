package a;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;



public class CRUDTest {
	private final static String url = "jdbc:mysql://localhost:3306/room?useUnicode=true&characterEncoding=UTF-8&useSSL=true";
	private final static String dbUser = "root";
	private final static String dbPassword = "root";
	private final static String driverName = "com.mysql.jdbc.Driver"; 
	private static PreparedStatement ps = null;
	public  static void main(String[] args) throws ClassNotFoundException, SQLException, UnsupportedEncodingException{
		//getall();
		//getTJmember();
		//addotherfare("r001","饮料",(float)20, "0000-00-00","12");
		//updateotherfare("r001", "饮料", (float)201, "2018-01-05", "1");
		//deleteotherfare("r001", "饮料", "0000.00.00");
		//updateHandsel((float) 500, "r001", "0000-00-00");
		//getOtherFare("r001");
		//getTell_Handsel("17865313018");
		//getCIDnum_Handsel("370681199611083219");
		//deletehandsel("c001", "2018-01-15");
		//getrnum_Sum("r001");
		//getmemberType_member("金卡会员");
		//getcname_Sum("李明");
		//updatmembertype("普通会员", "c003");
		
	}
	//添加房间其他消费信息 
		public static int addotherfare(String rnum,String faretype,Float fare,String OPtime,String PS)
				throws SQLException, ClassNotFoundException{
			
			Class.forName(driverName);
			//获得连接对象
			Connection conn=(Connection) DriverManager.getConnection(url,dbUser,dbPassword);
			String sql="INSERT INTO otherfare VALUES(?,?,?,?,?); ";
		
			ps=conn.prepareStatement(sql);
			ps.setString(1, rnum);
			ps.setString(2, faretype);
			ps.setFloat(3, fare);
			ps.setString(4, OPtime);
			ps.setString(5, PS);
			
			//创建语句对象
			int lines=ps.executeUpdate();
			
			System.out.println("lines="+lines);
			ps.close();
			conn.close();
			return lines;
		}
		//修改房间的消费类型的消费金额
		public static int updateotherfare(String rnum,String faretype,Float fare,String OPtime,String Ps)
				throws SQLException, ClassNotFoundException{
			Class.forName(driverName);
			
			//获得连接对象
			Connection conn=(Connection) DriverManager.getConnection(url,dbUser,dbPassword);
			String sql="UPDATE otherfare set  Fare=? , PS=? where RoomNum=? and OPTime=? and FareType=?";
			//创建语句对象
			ps=conn.prepareStatement(sql);
			ps.setFloat(1, fare);
			ps.setString(2, Ps);
			ps.setString(3, rnum);
			ps.setString(4, OPtime);
			ps.setString(5, faretype);
			
			int lines=ps.executeUpdate();
			
			System.out.println("lines="+lines);
			ps.close();
			conn.close();
			return lines;
		}
		//修改会员表中的数据
		public static int updatmembertype(String membertype,String cnum)
				throws SQLException, ClassNotFoundException{
			Class.forName(driverName);
			
			//获得连接对象
			Connection conn=(Connection) DriverManager.getConnection(url,dbUser,dbPassword);
			String sql="UPDATE member set MemberType=? where CustomerNum=? ";
			//创建语句对象
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, membertype);
			ps.setString(2, cnum);
			
			int lines=ps.executeUpdate();
			
			System.out.println("lines="+lines);
			ps.close();
			conn.close();
			return lines;
		}
		
		//修改订金表 
		public static int updateHandsel(Float handsel,String RoomNum,String OPTime)
				throws SQLException, ClassNotFoundException{
			Class.forName(driverName);
			
			//获得连接对象
			Connection conn=(Connection) DriverManager.getConnection(url,dbUser,dbPassword);
			String sql="UPDATE handsel set Handsel= ? where RoomNum=? and OPTime=?";
			//创建语句对象
			ps=conn.prepareStatement(sql);
			ps.setFloat(1, handsel);
			ps.setString(2, RoomNum);
			ps.setString(3, OPTime);			
			int lines=ps.executeUpdate();
			
			System.out.println("lines="+lines);
			ps.close();
			conn.close();
			return lines;
		}
		//按照房间号查询其消费信息
		public static List<OtherFare> getOtherFare(String rnum)
				throws SQLException, ClassNotFoundException{
			Class.forName(driverName);
			//获得连接对象
			Connection conn=(Connection) DriverManager.getConnection(url,dbUser,dbPassword);
			String sql="CALL selOtherFare('"+rnum+"');";
			//创建语句对象
			Statement stmt=conn.createStatement();
			
			//返回结果语句
			ResultSet rs=stmt.executeQuery(sql);
			List <OtherFare>l = new ArrayList<OtherFare>();  
			while(rs.next()){
				String faretype=rs.getString(2);
				Float fare=rs.getFloat(3);
				String optime=rs.getDate(4).toString();
				String ps=rs.getString(5);
				OtherFare s1=new OtherFare();
				s1.setRnum(rnum);
				s1.setFaretype(faretype);
				s1.setFare(fare);
				s1.setOptime(optime);
				s1.setPs(ps);
				System.out.println("房间号："+rnum);
				System.out.println("消费类型："+faretype);
				System.out.println("消费金额："+fare);
				System.out.println("操作时间："+optime);
				System.out.println("备注："+ps);
				l.add(s1);
			}
			rs.close();
			stmt.close();
			conn.close();
			return l;
			
		}
		
		//查询所有会员信息
		public static List<Getmember> getall()
				throws SQLException, ClassNotFoundException{
			Class.forName(driverName);
			//获得连接对象
			Connection conn=(Connection) DriverManager.getConnection(url,dbUser,dbPassword);
			String sql="SELECT customer.CustomerNum as 客户编号 ,customer.CustomerName as 客户名 , member.MemberType as 会员类型 ,member.MemberNum as 会员编号 from customer,member "
					+ "WHERE customer.CustomerNum=member.CustomerNum and member.MemberNum=customer.MemberNum ";
			//创建语句对象
			Statement stmt=conn.createStatement();
			
			//返回结果语句
			ResultSet rs=stmt.executeQuery(sql);
			List <Getmember>l = new ArrayList<Getmember>();  
			while(rs.next()){
				String cnum=rs.getString("客户编号");
				String cname=rs.getString("客户名");
				String membertype=rs.getString("会员类型");
				String membernum=rs.getString(4);
				Getmember s1=new Getmember();
				s1.setCname(cname);
				s1.setCnum(cnum);
				s1.setMembertype(membertype);
				s1.setMembernum(membernum);
				System.out.println("客户编号："+cnum);
				System.out.println("客户名："+cname);
				System.out.println("会员类型："+membertype);
				System.out.println("会员编号："+membernum);
				l.add(s1);
				
			}
			rs.close();
			stmt.close();
			conn.close();
			return l;
			
		}
		//根据会员类型查询会员信息
				public static List<Getmember> getmemberType_member(String membertype)
						throws SQLException, ClassNotFoundException, UnsupportedEncodingException{
					Class.forName(driverName);
					
					//获得连接对象
					Connection conn=(Connection) DriverManager.getConnection(url,dbUser,dbPassword);
					String sql="SELECT customer.CustomerNum as 客户编号 ,customer.CustomerName as 客户名 , member.MemberType as 会员类型,member.MemberNum as 会员编号 from customer,member "
							+ "WHERE customer.CustomerNum=member.CustomerNum and member.MemberNum=customer.MemberNum  and member.MemberType='"+membertype+"'";
					//创建语句对象
					Statement stmt=conn.createStatement();
					
					//返回结果语句
					
					ResultSet rs=stmt.executeQuery(sql);
					
					List <Getmember>l = new ArrayList<Getmember>();  
					while(rs.next()){
						String cnum=rs.getString("客户编号");
						String cname=rs.getString("客户名");
						
						String membernum=rs.getString(4);
						Getmember s1=new Getmember();
						s1.setCname(cname);
						s1.setCnum(cnum);
						s1.setMembertype(membertype);
						s1.setMembernum(membernum);
						System.out.println("客户编号："+cnum);
						System.out.println("客户名："+cname);
						System.out.println("会员类型："+membertype);
						System.out.println("会员编号："+membernum);
						l.add(s1);
						
					}
					rs.close();
					stmt.close();
					conn.close();
					return l;
					
				}
		
		//显示统计不同会员类型的会员数量
				public static List<TJmember> getTJmember()
						throws SQLException, ClassNotFoundException{
					Class.forName(driverName);
					//获得连接对象
					Connection conn=(Connection) DriverManager.getConnection(url,dbUser,dbPassword);
					String sql="call sel_memberType();";
					//创建语句对象
					Statement stmt=conn.createStatement();
					
					//返回结果语句
					ResultSet rs=stmt.executeQuery(sql);
					List <TJmember>l = new ArrayList<TJmember>();  
					while(rs.next()){
						String membertype=rs.getString("会员类型");
						String sum=rs.getString("数量");
						TJmember s1=new TJmember();
						s1.setSum(sum);
						s1.setMembertype(membertype);
						
						System.out.println("会员类型："+membertype);
						System.out.println("数量："+sum);
						l.add(s1);
						
					}
					rs.close();
					stmt.close();
					conn.close();
					return l;
				} 
				//根据客户联系方式查询其所交的定金信息
				public static List<Customer_Fare> getTell_Handsel(String CustomerTel)
						throws SQLException, ClassNotFoundException{
					Class.forName(driverName);
					//获得连接对象
					Connection conn=(Connection) DriverManager.getConnection(url,dbUser,dbPassword);
					String sql="CALL selHandsel1('"+CustomerTel+"');";
					//创建语句对象
					Statement stmt=conn.createStatement();
					
					//返回结果语句
					ResultSet rs=stmt.executeQuery(sql);
					List <Customer_Fare>l = new ArrayList<Customer_Fare>();  
					while(rs.next()){
						String cnum=rs.getString(1);
						
						String cname=rs.getString(2);
						String cidnum=rs.getString(3);
						Float handsel=rs.getFloat(4);
						String rnum=rs.getString(5);
						String optime=rs.getString(6);
						
						Customer_Fare s1=new Customer_Fare();
						s1.setRnum(rnum);
						s1.setCustomerNum(cnum);
						s1.setCustomerName(cname);
						s1.setCustomerIDNum(cidnum);
						s1.setHandsel(handsel);
						s1.setRnum(rnum);
						s1.setOPTime(optime);
						System.out.println("客户编号："+rnum);
						System.out.println("客户姓名："+cname);
						System.out.println("身份证号："+cidnum);
						System.out.println("订金："+handsel);
						System.out.println("房间号："+rnum);
						System.out.println("操作时间："+optime);
						l.add(s1);
					}
					rs.close();
					stmt.close();
					conn.close();
					return l;
					
				}
				//根据身份证查询其所交的定金信息
				public static List<Customer_Fare> getCIDnum_Handsel(String cidnum)
						throws SQLException, ClassNotFoundException{
					Class.forName(driverName);
					//获得连接对象
					Connection conn=(Connection) DriverManager.getConnection(url,dbUser,dbPassword);
					String sql="CALL selHandsel2('"+cidnum+"');";
					//创建语句对象
					Statement stmt=conn.createStatement();
					
					//返回结果语句
					ResultSet rs=stmt.executeQuery(sql);
					List <Customer_Fare>l = new ArrayList<Customer_Fare>();  
					while(rs.next()){
						String cnum=rs.getString(1);
						
						String cname=rs.getString(2);
						String tell=rs.getString(3);
						Float handsel=rs.getFloat(4);
						String rnum=rs.getString(5);
						String optime=rs.getString(6);
						Customer_Fare s1=new Customer_Fare();
						
						s1.setCustomerNum(cnum);
						s1.setCustomerName(cname);
						s1.setCustomerTel(tell);
						s1.setHandsel(handsel);
						s1.setRnum(rnum);
						s1.setOPTime(optime);
						
						System.out.println("客户编号："+cnum);
						System.out.println("客户姓名："+cname);
						System.out.println("手机号："+tell);
						System.out.println("订金："+handsel);
						System.out.println("房间号："+rnum);
						System.out.println("操作时间："+optime);
						l.add(s1);
					}
					rs.close();
					stmt.close();
					conn.close();
					return l;	
				}
				//根据客户名显示总消费情况
				public static List<Customer_Fare> getcname_Sum(String cname)
						throws SQLException, ClassNotFoundException{
					Class.forName(driverName);
					//获得连接对象
					Connection conn=(Connection) DriverManager.getConnection(url,dbUser,dbPassword);
					String sql="CALL selActualFare('"+cname+"');";
					//创建语句对象
					Statement stmt=conn.createStatement();
					
					//返回结果语句
					ResultSet rs=stmt.executeQuery(sql);
					List <Customer_Fare>l = new ArrayList<Customer_Fare>();  
					while(rs.next()){
						String cnum=rs.getString(1);
						
						Float handsel=rs.getFloat(3);
						Float otherfare=rs.getFloat(4);
						Float roomcharge=rs.getFloat(5);
						Float actualfare=rs.getFloat(6);
						String rnum=rs.getString(7);

						Customer_Fare s1=new Customer_Fare();
						s1.setCustomerNum(cnum);
						s1.setCustomerName(cname);
						s1.setOtherfare(otherfare);
						s1.setHandsel(handsel);
						s1.setActualfare(actualfare);
						s1.setRoomcharge(roomcharge);
						s1.setRnum(rnum);
						
						System.out.println("客户编号："+cnum);
						System.out.println("客户姓名："+cname);
						System.out.println("房间号："+rnum);
						System.out.println("订金："+handsel);
						System.out.println("其他消费总额："+otherfare);
						System.out.println("房费："+roomcharge);
						System.out.println("总消费："+s1.getSumFare());
						System.out.println("实际费用："+actualfare);
						l.add(s1);
					}
					rs.close();
					stmt.close();
					conn.close();
					return l;	
				}
				//根据房间号显示总消费情况
				public static List<Customer_Fare> getrnum_Sum(String rnum)
						throws SQLException, ClassNotFoundException{
					Class.forName(driverName);
					//获得连接对象
					Connection conn=(Connection) DriverManager.getConnection(url,dbUser,dbPassword);
					String sql="CALL selSumFare('"+rnum+"');";
					//创建语句对象
					Statement stmt=conn.createStatement();
					
					//返回结果语句
					ResultSet rs=stmt.executeQuery(sql);
					List <Customer_Fare>l = new ArrayList<Customer_Fare>();  
					while(rs.next()){
						String cnum=rs.getString(1);
						String cname=rs.getString(2);
						Float handsel=rs.getFloat(3);
						Float otherfare=rs.getFloat(4);
						Float roomcharge=rs.getFloat(5);
						Float actualfare=rs.getFloat(6);

						Customer_Fare s1=new Customer_Fare();
						s1.setRnum(rnum);
						s1.setCustomerNum(cnum);
						s1.setCustomerName(cname);
						s1.setOtherfare(otherfare);
						s1.setHandsel(handsel);
						s1.setActualfare(actualfare);
						s1.setRoomcharge(roomcharge);
						
						
						System.out.println("客户编号："+cnum);
						System.out.println("客户姓名："+cname);
						System.out.println("房间号："+rnum);
						System.out.println("订金："+handsel);
						System.out.println("其他消费总额："+otherfare);
						System.out.println("房费："+roomcharge);
						System.out.println("总消费："+s1.getSumFare());
						System.out.println("实际费用："+actualfare);
						l.add(s1);
					}
					rs.close();
					stmt.close();
					conn.close();
					return l;	
				}
				
		//删除其他消费情况表
		public static int deleteotherfare(String rnum,String faretype,String OPtime)
				throws SQLException, ClassNotFoundException{
			Class.forName(driverName);
			//获得连接对象
			Connection conn=(Connection) DriverManager.getConnection(url,dbUser,dbPassword);
			String sql="delete from otherfare where RoomNum=? and FareType=? and OPTime=?";
			//创建语句对象
			ps=conn.prepareStatement(sql);
			ps.setString(1, rnum);
			ps.setString(2, faretype);
			ps.setString(3, OPtime);
			int lines=ps.executeUpdate();
			
			System.out.println("lines="+lines);
			ps.close();
			conn.close();
			return lines;
		
		
		}
		//删除订金
				public static int deletehandsel(String cnum,String OPtime)
						throws SQLException, ClassNotFoundException{
					Class.forName(driverName);
					//获得连接对象
					Connection conn=(Connection) DriverManager.getConnection(url,dbUser,dbPassword);
					String sql="delete from handsel where OPTime=? and CustomerNum=?";
					//创建语句对象
					ps=conn.prepareStatement(sql);
	
					ps.setString(1, OPtime);
					ps.setString(2, cnum);
					int lines=ps.executeUpdate();
					
					System.out.println("lines="+lines);
					ps.close();
					conn.close();
					return lines;
				
				
				}
}
