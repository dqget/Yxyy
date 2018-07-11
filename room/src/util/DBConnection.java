package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	private final static String driverName = "com.mysql.jdbc.Driver"; 
	private final static String url = "jdbc:mysql://localhost:3306/room?useUnicode=true&characterEncoding=UTF-8&useSSL=true";
	private final static String user = "root";
	private final static String password = "root";
	
	private DBConnection() {
	}

	static {
		try {
			Class.forName(driverName);
			
		} catch (ClassNotFoundException e) {
			System.out.println("数据库连接错误"+e.getMessage());
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public static void close(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	public static void closed( Statement st, Connection conn) {
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	
}
