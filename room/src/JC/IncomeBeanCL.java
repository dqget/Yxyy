package JC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**/
public class IncomeBeanCL {
	private Connection cn = null;
	private Statement sm = null;
	private PreparedStatement psm = null;
	private ResultSet rs = null;
	IncomeBean ib = null;
	public List<IncomeBean> getIncomeBean(String st,String et){
		List<IncomeBean> al = new ArrayList<IncomeBean>();
		try{
			ConnDB cdb = new ConnDB();
			cn = cdb.getCT();
			sm = cn.createStatement();
			rs = sm.executeQuery("SELECT SUM(fcharge.OtherFare) , SUM(fcharge.RoomCharge), SUM(fcharge.ActualFare) ,'"+st+"','"+et+"' FROM fcharge where  DATEDIFF('"+st+"',fcharge.OPTime)<0 and DATEDIFF(fcharge.OPTime,'"+et+"')<0");
			while(rs.next()){
				ib = new IncomeBean();
				ib.setSumfo(rs.getString(1));
				ib.setSumfr(rs.getString(2));
				ib.setSumfa(rs.getString(3));
				al.add(ib);
			}
		}catch(Exception e){
			e.getStackTrace();
		}finally{
			this.CloseResourse();
		}
		return al;
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
