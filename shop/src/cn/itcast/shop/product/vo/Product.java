package cn.itcast.shop.product.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import cn.itcast.shop.categorysecond.vo.CategorySecond;
import cn.itcast.shop.evaluate.vo.Evaluate;
import cn.itcast.shop.order.vo.OrderItem;
/**
 * 商品的实体对象
 * @author LB101514
 *
 */
public class Product {
	private int pid;
	private String pname;
	private Double market_price;
	private Double shop_price;
	private String image;
	private String pdesc;
	private Integer is_hot;
	private Date pdate;
	private CategorySecond categorySecond;
	private Set<Evaluate> evaluates = new HashSet<Evaluate>();
	private int pnum;
	private int psales;
	private Set<OrderItem> orderItems = new HashSet<OrderItem>();
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Double getMarket_price() {
		return market_price;
	}
	public void setMarket_price(Double market_price) {
		this.market_price = market_price;
	}
	public Double getShop_price() {
		return shop_price;
	}
	public void setShop_price(Double shop_price) {
		this.shop_price = shop_price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public Integer getIs_hot() {
		return is_hot;
	}
	public void setIs_hot(Integer is_hot) {
		this.is_hot = is_hot;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public CategorySecond getCategorySecond() {
		return categorySecond;
	}
	public void setCategorySecond(CategorySecond categorySecond) {
		this.categorySecond = categorySecond;
	}
	public Set<Evaluate> getEvaluates() {
		return evaluates;
	}
	public void setEvaluates(Set<Evaluate> evaluates) {
		this.evaluates = evaluates;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public int getPsales() {
		return psales;
	}
	public void setPsales(int psales) {
		this.psales = psales;
	}
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
