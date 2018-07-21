package cn.itcast.shop.index.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.shop.category.service.CategoryService;
import cn.itcast.shop.category.vo.Category;
import cn.itcast.shop.product.service.ProductService;
import cn.itcast.shop.product.vo.Product;
public class IndexAction extends ActionSupport{
	//注入CategoryService
	private CategoryService categoryService = new CategoryService();

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	//注入ProductService
	private ProductService productService = new ProductService();
	
	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	//登录到主页的action
	public String execute(){
		System.out.println("登录到主页");
		//将一级标题查询出来
		List<Category> cal = getCategoryService().findAll();
		//放入session
		ActionContext.getContext().getSession().put("cList", cal);
		//将热门商品查询出来
		List<Product> hal = getProductService().findHot();
		//放入值站
		ActionContext.getContext().getValueStack().set("hList", hal);
		
		//将最新商品查询出来
		List<Product> nal = getProductService().findNew();
		//放入值站
		ActionContext.getContext().getValueStack().set("nList", nal);
		return "index";
	}


}
