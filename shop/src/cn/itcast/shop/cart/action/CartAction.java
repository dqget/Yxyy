package cn.itcast.shop.cart.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.shop.cart.service.CartService;
import cn.itcast.shop.cart.vo.Cart;
import cn.itcast.shop.cart.vo.CartItem;
import cn.itcast.shop.product.service.ProductService;
import cn.itcast.shop.product.vo.Product;
import cn.itcast.shop.user.vo.User;

public class CartAction extends ActionSupport{
	private Cart cart = getCart();

	//注入ProductService
	private ProductService productService = new ProductService();
	public ProductService getProductService() {
		return productService;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	//注入count
	private Integer count;
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	//注入product的id
	private Integer pid;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	//注入service
	private CartService cartService = new CartService();
	public CartService getCartService() {
		return cartService;
	}
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
	//进入购物车界面
	public String indexCart(){
		User user = (User)ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if(user==null){
			this.addActionError("进入购物车失败！您还没有登录！");
			return "login";
		}
		return "indexCart";
	}
	//添加到购物车
	public String addCart(){
		Product product = getProductService().findByPid(pid);
		CartItem cartItem = new CartItem();
		cartItem.setCount(count);
		cartItem.setProduct(product);
		getCartService().addCart(cart,cartItem);
		Cart cc = (Cart)ServletActionContext.getRequest().getSession().getAttribute("cart");
		return "addCartSuccess";
	}
	//删除购物车中的某一项
	public String removeCart(){
		getCartService().removeCart(cart,pid);
		return "indexCart";
	}
	//清空购物车
	public String clearCart(){
		getCartService().clearCart(cart);
		return "indexCart";
	}
	//构建购物车
	public Cart getCart(){
		Cart c = (Cart)ServletActionContext.getRequest().getSession().getAttribute("cart");
		System.out.println("getCart方法");
		if(c==null){
			c = new Cart();
			ServletActionContext.getRequest().getSession().setAttribute("cart",c);
			System.out.println("session中没有cart 创建cart存入session中");
		}else{
			System.out.println("session中有cart 将cart从session中取出");
		}
		return c;
	}
	public void clearCartNoResult(){
		getCartService().clearCart(cart);
	}








}
