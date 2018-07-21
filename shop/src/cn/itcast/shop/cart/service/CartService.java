package cn.itcast.shop.cart.service;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import cn.itcast.shop.cart.vo.Cart;
import cn.itcast.shop.cart.vo.CartItem;

public class CartService {
	//将map集合转为list集合
	public Collection<CartItem> getCartItems(Map<Integer,CartItem> cartItems){
		return cartItems.values();
	}
	//添加购物项到购物车
	public void addCart(Cart cart,CartItem cartItem){
		//判断购物车中是否有该购物项
		/*
		 *		1、有该购物项
		 *			*	数量++
		 *			*	总计++
		 *		2、没有该购物项
		 *			*	总计++
		 *			*	添加该购物项到购物车 
		 */
		int pid = cartItem.getProduct().getPid();
		if(cart.getMap().containsKey(cartItem.getProduct().getPid())){
			Map<Integer,CartItem> cartItems = new LinkedHashMap<Integer,CartItem>();
			cartItems = cart.getMap();
			cartItems.get(pid).setCount(cartItems.get(pid).getCount()+cartItem.getCount());
			cart.setCartItems(cartItems);
		}else{
			Map<Integer,CartItem> cartItems = new LinkedHashMap<Integer,CartItem>();
			cartItems = cart.getMap();
			cartItems.put(pid, cartItem);
			cart.setCartItems(cartItems);
		}
		cart.setTotal(cart.getTotal()+cartItem.getSubtotal());
		ServletActionContext.getRequest().getSession().setAttribute("cart", cart);
		System.out.println("将add后的cart放入session");
	}
	//从购物车删除某个购物项
	public void removeCart(Cart cart,Integer pid){
		//移除购物项
		Map<Integer,CartItem> cartItems = new LinkedHashMap<Integer,CartItem>();
		cartItems = cart.getMap();
		CartItem cartItem = cartItems.remove(pid);
		cart.setCartItems(cartItems);
		//总计变化
		cart.setTotal(cart.getTotal() - cartItem.getSubtotal());
		ServletActionContext.getRequest().getSession().setAttribute("cart", cart);
	}
	//清空购物车
	public void clearCart(Cart cart){
		//清空购物项	
		Map<Integer,CartItem> cartItems = new LinkedHashMap<Integer,CartItem>();
		cart.setCartItems(cartItems);
		//总计设置为0
		cart.setTotal(0);
		ServletActionContext.getRequest().getSession().setAttribute("cart", cart);
	}
}
