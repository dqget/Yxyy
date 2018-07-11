package JC;
import java.sql.*;

public class ConnDB {
	private Connection cn = null;
	public Connection getCT(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			cn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/room?useUnicode=true&characterEncoding=UTF-8","root","munaihe0521!");
		}catch(Exception e){
			e.getStackTrace();
		}
		return cn;
	}
}
