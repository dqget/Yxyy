package cn.itcast.shop.evaluate.vo;

import java.util.Date;

import cn.itcast.shop.product.vo.Product;
import cn.itcast.shop.user.vo.User;

public class Evaluate {
	private int eid;
	private String econ;
	private int eva;
	private User user;
	private Product product;
	private Date edate;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEcon() {
		return econ;
	}
	public void setEcon(String econ) {
		this.econ = econ;
	}
	public int getEva() {
		return eva;
	}
	public void setEva(int eva) {
		this.eva = eva;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Date getEdate() {
		return edate;
	}
	public void setEdate(Date edate) {
		this.edate = edate;
	}
}
