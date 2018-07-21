package cn.itcast.shop.order.action;

import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.cart.action.CartAction;
import cn.itcast.shop.cart.vo.Cart;
import cn.itcast.shop.cart.vo.CartItem;
import cn.itcast.shop.order.service.OrderService;
import cn.itcast.shop.order.vo.Order;
import cn.itcast.shop.order.vo.OrderItem;
import cn.itcast.shop.user.service.UserService;
import cn.itcast.shop.user.vo.User;
import cn.itcast.shop.utils.PageBean;

public class OrderAction extends ActionSupport implements ModelDriven<Order>{
	private Order order = getMyOrder();
	@Override
	public Order getModel() {
		// TODO Auto-generated method stub
		return order;
	}
	//注入cartAction
	private CartAction cartAction;
	public void setCartAction(CartAction cartAction) {
		this.cartAction = cartAction;
	}
	//注入userService
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	//接收page
	private Integer page;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	// 注入OrderService
	private OrderService orderService = new OrderService();
	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public String save(){
		User existUser = (User)ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if(existUser==null){
			this.addActionError("您还没有登录！请先登录！");
			return "login";
		}
		System.out.println("1、将订单保存到数据库");
		//1、将数据保存到数据库
		Order order = new Order();
		order.setOrdertime(new Date());
		order.setState(1);
		Cart cart = (Cart)ServletActionContext.getRequest().getSession().getAttribute("cart");
		if(cart==null){
			//没有cart说明用户直接进入的订单页面
			//显示错误信息
			this.addActionError("您还没有购物！请先购物！");
			//跳转到错误界面
			return "msg";
		}
		order.setTotal(cart.getTotal());
		for(CartItem cartItem:cart.getCartItems()){
			OrderItem orderItem = new OrderItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setOrder(order);
			order.getOrderItems().add(orderItem);
		}
		order.setUser(existUser);
		getOrderService().save(order);
		System.out.println("2、将数据显示在界面");
		//2、将数据显示在界面
//		//因为用的是模型驱动所以模型驱动的对象默认就在值站的顶端直接在页面就可以取到
//		//所以不需要进行后台代码存放传递数据
//		ActionContext.getContext().getValueStack().set("order",order);
		//订单s列表存入session
		ServletActionContext.getRequest().getSession().setAttribute("order",order);
		//清空购物车
		cartAction.clearCartNoResult();
		//将实际付款放入值站
		double actuallyprice = order.getTotal()*(existUser.getDiscount()/10);
		System.out.println("actuallyprice:"+actuallyprice);
		ActionContext.getContext().getValueStack().set("actuallyprice",actuallyprice);
		return "saveSuccess";
	}
	//得到我的购物车方法
	public Order getMyOrder(){
		Order or = (Order)ServletActionContext.getRequest().getSession().getAttribute("order");
		if(or==null){
			or = new Order();
		}
		return or;
	}
	public String findByUid(){
		if(page==null){
			page=1;
		}
		User user = (User)ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if(user==null){
			System.out.println("user==null");
		}else{
			System.out.println("user!=null");
		}
		System.out.println("分页查询数据");
		if(getOrderService()!=null){
			System.out.println("getOrderService!=null;");
		}
		//分页查询数据
		PageBean<Order> pageBean = getOrderService().findByUid(user.getUid(),page);
		System.out.println("将pageBean的数据存入值站");
		//将pageBean的数据存入值站
		ActionContext.getContext().getValueStack().set("pageBean",pageBean);
		return "findByUid";
	}
	public String findByOid(){
		Order or = getOrderService().findByOid(order.getOid());
		ServletActionContext.getRequest().getSession().setAttribute("order",or);
		User user = (User)ServletActionContext.getRequest().getSession().getAttribute("existUser");
		double actuallyprice = or.getTotal()*(user.getDiscount()/10);
		System.out.println("actuallyprice:"+actuallyprice);
		ActionContext.getContext().getValueStack().set("actuallyprice",actuallyprice);
		return "findByOid";
	}
	public String pay(){
		Order or = orderService.findByOid(order.getOid());
		//支付成功修改用户的消费金额
		User user = (User)ServletActionContext.getRequest().getSession().getAttribute("existUser");
		System.out.println("用户原消费金额："+user.getMonetary());
		System.out.println("用户本次订单原价："+or.getTotal());
		System.out.println("用户折扣："+user.getDiscount()/100);
		double addScore = user.getMonetary()+or.getTotal()*(user.getDiscount()/10);
		System.out.println("用户增加的积分："+addScore);
		double score = user.getMonetary()+(or.getTotal()*user.getDiscount()/10);
		user.setMonetary(score);
		userService.update(user);
		//支付完成之后要更新session中存在的用户的折扣信息
		User existUser = userService.findByUserID(user.getUid());
		ServletActionContext.getRequest().getSession().setAttribute("existUser",existUser);
		//支付成功修改订单状态
		System.out.println("支付成功修改订单状态");
		getOrderService().pay(order);
		//跳转到支付成功界面
		System.out.println("跳转到支付成功界面");
		this.addActionMessage("支付成功！");
		return "msg";
	}
	public String takeOverOrder(){
		getOrderService().takeOverOrder(order.getOid());
		return "takeOverOrderSuccess";
	}
	public String deleteOrder(){
		order = getOrderService().findByOid(order.getOid());
		getOrderService().deleteOrder(order);
		return "deleteSuccess";
	}

}
