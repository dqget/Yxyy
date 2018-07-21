package cn.itcast.shop.evaluate.action;

import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.evaluate.service.EvaluateService;
import cn.itcast.shop.evaluate.vo.Evaluate;
import cn.itcast.shop.order.service.OrderService;
import cn.itcast.shop.order.vo.OrderItem;
import cn.itcast.shop.product.service.ProductService;
import cn.itcast.shop.product.vo.Product;
import cn.itcast.shop.user.vo.User;

public class EvaluateAction extends ActionSupport implements ModelDriven<Evaluate>{
	private Evaluate evaluate = new Evaluate();
	@Override
	public Evaluate getModel() {
		// TODO Auto-generated method stub
		return evaluate;
	}
	private EvaluateService evaluateService;
	public void setEvaluateService(EvaluateService evaluateService) {
		this.evaluateService = evaluateService;
	}
	private OrderService orderService;
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	private Integer itemid;
	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	private Integer pid;
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String enterEva(){
		System.out.println(pid);
		Product product = productService.findByPid(pid);
		ActionContext.getContext().getValueStack().set("product", product);
		System.out.println("itemid"+itemid);
		ServletActionContext.getRequest().getSession().setAttribute("itemid",itemid);
		ServletActionContext.getRequest().getSession().setAttribute("product",product);
		return "enterEvaSuccess";
	}
	public String addEva(){
		System.out.println(evaluate.getEcon());
		System.out.println(evaluate.getEva());
		Product product = (Product)ServletActionContext.getRequest().getSession().getAttribute("product");
		User user = (User)ServletActionContext.getRequest().getSession().getAttribute("existUser");
		itemid = (Integer)ServletActionContext.getRequest().getSession().getAttribute("itemid");
		OrderItem orderItem = orderService.findOrderItem(itemid);
		orderService.updateEvaState(orderItem);
		evaluate.setProduct(product);
		evaluate.setUser(user);
		evaluate.setEdate(new Date());
		evaluateService.save(evaluate);
		return "addEvaSuccess";
	}



	
	
	
}
