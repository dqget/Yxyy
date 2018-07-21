package cn.itcast.shop.cart.vo;

import cn.itcast.shop.product.vo.Product;

/**
 * 购物项
 * @author LB101514
 *
 */
public class CartItem {
	private int count;//购买商品的数量
	private Product product;//商品
	private double subtotal;//小计
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public double getSubtotal() {
		return count * product.getShop_price();
	}
}
