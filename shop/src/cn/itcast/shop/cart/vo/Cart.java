package cn.itcast.shop.cart.vo;

import java.util.*;

public class Cart {
	private Map<Integer,CartItem> cartItems = new LinkedHashMap<Integer,CartItem>();
	private double total;
	
	public Collection<CartItem> getCartItems() {
		return cartItems.values();
	}

	public void setCartItems(Map<Integer,CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	public Map<Integer,CartItem> getMap(){
		return cartItems;
	}
}
