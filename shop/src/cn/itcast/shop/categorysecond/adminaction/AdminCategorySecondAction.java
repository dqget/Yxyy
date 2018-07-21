package cn.itcast.shop.categorysecond.adminaction;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.category.service.CategoryService;
import cn.itcast.shop.category.vo.Category;
import cn.itcast.shop.categorysecond.service.CategorySecondService;
import cn.itcast.shop.categorysecond.vo.CategorySecond;
import cn.itcast.shop.utils.PageBean;

public class AdminCategorySecondAction extends ActionSupport implements ModelDriven<CategorySecond>{
	private CategorySecond categorySecond  = new CategorySecond();
	@Override
	public CategorySecond getModel() {
		// TODO Auto-generated method stub
		return categorySecond;
	}
	//注入service
	private CategorySecondService categorySecondService;
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	//接收一下page
	private Integer page;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	//注入一级标题的Service
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public String findAllByPage(){
		System.out.println("findAllByPageSuccess");
		//因为删除成功与编辑成功重新查询出第一页的的二级标题时会出问题
		if(page==null||page==0){
			page=1;
		}
		PageBean<CategorySecond> pageBean = categorySecondService.findAllByPage(page);
		//将pageBean保存在值站中
		ActionContext.getContext().getValueStack().set("pageBean",pageBean);
		return "findAllByPageSuccess";
	}
	public String addPage(){
		//查询出所有的一级标题
		List<Category> clist = categoryService.findAll();
		ActionContext.getContext().getValueStack().set("clist", clist);
		return "addPage";
	}
	public String save(){
		//将二级分类保存到数据库中
		categorySecondService.save(categorySecond);
		System.out.println("将二级分类保存到数据库中");
		return "saveSuccess";
	}
	public String delete(){
		//删除二级分类的方法
		//级联删除 ： 先查询再删除 配置cascade
		System.out.println("级联删除二级分类 ： 先查询再删除 配置cascade");
		categorySecond = categorySecondService.findByCsid(categorySecond.getCsid());
		categorySecondService.delete(categorySecond);
		return "deleteSuccess";
	}
	public String edit(){
		System.out.println("edit categorySecond csid"+categorySecond.getCsid());
		categorySecond = categorySecondService.findByCsid(categorySecond.getCsid());
		List<Category> clist = categoryService.findAll();
		ActionContext.getContext().getValueStack().set("clist", clist);
		return "editSuccess";
	}
	public String update(){
		System.out.println(categorySecond.getCsid()+categorySecond.getCsname()+categorySecond.getCategory().getCid());
		categorySecondService.update(categorySecond);
		return "updateSuccess";
	}
	
	
	
	
	
	
	
	
	
	
	
}
