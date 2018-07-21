package cn.itcast.shop.order.adminaction;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.order.service.OrderService;
import cn.itcast.shop.order.vo.Order;
import cn.itcast.shop.order.vo.OrderItem;
import cn.itcast.shop.product.service.ProductService;
import cn.itcast.shop.product.vo.Product;
import cn.itcast.shop.utils.PageBean;

public class AdminOrderAction extends ActionSupport implements ModelDriven<Order>{
	private Order order = new Order();
	@Override
	public Order getModel() {
		// TODO Auto-generated method stub
		return order;
	}
	private OrderService orderService;
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	private Integer page;
	public void setPage(Integer page) {
		this.page = page;
	}
	public String findAllByPage(){
		if(page==null){
			page=1;
		}
		PageBean<Order> pageBean = orderService.findAllByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAllSuccess";
	}
	public String findOrderItems(){
		System.out.println("根据订单的oid查询到订单项们");
		//根据订单的oid查询到订单项们
		List<OrderItem> orderItems = orderService.findOrderItems(order.getOid());
		//将订单项显示到页面
		//方法一  ： 把list集合转换为json的对象在界面中解析json对象
		//方法二  ： 把list集合数据显示到另一个jsp上  jsp内容显示回去
		ActionContext.getContext().getValueStack().set("orderItems", orderItems);
		for(int i = 0; i < orderItems.size();i++){
			System.out.println(orderItems.get(i).getItemid());
		}
		return "findOrderItems";
	}
	//发货时执行的方法
	public String sendGoods(){
		orderService.sendGoods(order.getOid());
		//存货减去购买的数量 销售数量加
		List<OrderItem> orderItems = orderService.findOrderItems(order.getOid());
		for(int i = 0; i < orderItems.size();i++){
			int nowpid = orderItems.get(i).getProduct().getPid();
			int nowbuycount = orderItems.get(i).getCount();
			Product product = productService.findByPid(nowpid);
			product.setPnum(product.getPnum()-nowbuycount);
			product.setPsales(product.getPsales()+nowbuycount);
			productService.update(product);
		}
		return "sendSuccess";
	}
	public String findOrderByPageState(){
		if(page==null){
			page=1;
		}
		PageBean<Order> pageBean = orderService.findOrderByPageState(page,order.getState());
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		ActionContext.getContext().getValueStack().set("orderState", order.getState());
		return "findOrderByPageStateSuccess";
	}

	
	
	
	
	
	
	
	
}
