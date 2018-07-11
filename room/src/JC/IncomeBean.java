package JC;

public class IncomeBean {
	String Sumfr;
	String Sumfo;
	String Sumfa;
	public IncomeBean(){
		
	}
	public IncomeBean(	String Sumfr,String Sumfo,String Sumfa){
		this.Sumfr = Sumfr;
		this.Sumfa = Sumfa;
		this.Sumfo = Sumfo;
	}
	public String getSumfr() {
		return Sumfr;
	}
	public void setSumfr(String sumfr) {
		Sumfr = sumfr;
	}
	public String getSumfo() {
		return Sumfo;
	}
	public void setSumfo(String sumfo) {
		Sumfo = sumfo;
	}
	public String getSumfa() {
		return Sumfa;
	}
	public void setSumfa(String sumfa) {
		Sumfa = sumfa;
	}
}
