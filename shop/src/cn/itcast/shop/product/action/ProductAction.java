package cn.itcast.shop.product.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.evaluate.vo.Evaluate;
import cn.itcast.shop.product.service.ProductService;
import cn.itcast.shop.product.vo.Product;
import cn.itcast.shop.utils.PageBean;

public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	private Product product = new Product();
	@Override
	public Product getModel() {
		// TODO Auto-generated method stub
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	//注入ProductService
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	//注入jsp传来的参数cid
	private Integer cid;
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	//注入jsp传来的参数page
	private Integer page;
	public void setPage(Integer page) {
		this.page = page;
	}
	//注入jsp传来的参数csid
	private Integer csid;
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	private String smallprice;
	private String bigprice;
	private String fp;
	private String fw;
	public void setFp(String fp) {
		this.fp = fp;
	}
	public void setFw(String fw) {
		this.fw = fw;
	}
	//根据用户需求查询
	public String findByWay(){
		System.out.println(fw);
		if(fp==""){
			System.out.println(fp);
		}
		System.out.println("price"+smallprice+" "+bigprice);
		if(page==null){
			page=1;
		}
		if(smallprice==null){
			smallprice="0";
			bigprice="0";
		}
		PageBean<Product> pageBean = productService.findByWay(fw,fp,Double.parseDouble(smallprice),Double.parseDouble(bigprice),page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		ActionContext.getContext().getValueStack().set("fw", fw);
		if(fw.equals("3")){
			System.out.println("smallprice!=Kong");
			ActionContext.getContext().getValueStack().set("smallprice", smallprice);
			ActionContext.getContext().getValueStack().set("bigprice", bigprice);
			ActionContext.getContext().getValueStack().set("fp", null);
		}else if(!fw.equals("3")){
			System.out.println("fp!=Kong");
			ActionContext.getContext().getValueStack().set("fp", fp);
			ActionContext.getContext().getValueStack().set("smallprice", null);
			ActionContext.getContext().getValueStack().set("bigprice", null);
		}
		return "findByWay";
	}
	//根据商品的ID查询商品
	public String findByPid(){
		int sumEva = 0;
		int aveEva = 0;
		product = productService.findByPid(product.getPid());
		if(product.getEvaluates().size()>0){
			List<Evaluate> eList = new ArrayList<Evaluate>(product.getEvaluates());
			for(int i = 0; i < eList.size();i++){
				sumEva = sumEva + eList.get(i).getEva();
				System.out.println(eList.get(i).getUser().getUserName());
				System.out.println("评论内容"+eList.get(i).getEcon());
			}
			aveEva = sumEva/eList.size();
			HashSet<Evaluate> hs = new HashSet<Evaluate>(eList);
			ActionContext.getContext().getValueStack().set("eList", hs);
		}
		ActionContext.getContext().getValueStack().set("aveEva", aveEva);
		return "findByPid";
	}
	//根据一级标题查询商品并分页
	public String findByCid(){
		PageBean<Product> pageBean = productService.findByCid(cid,page);
		System.out.println("商品表现层获取到cid："+cid);
		System.out.println("商品表现层获取到page："+page);
		ActionContext.getContext().getValueStack().set("cid", cid);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCid";
	}
	//根据二级标题查询商品并分页
	public String findByCsid(){
		PageBean<Product> pageBean = productService.findByCsid(csid,page);
		ActionContext.getContext().getValueStack().set("csid", csid);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCsid";
	}
	public void setSmallprice(String smallprice) {
		this.smallprice = smallprice;
	}
	public void setBigprice(String bigprice) {
		this.bigprice = bigprice;
	}



}
