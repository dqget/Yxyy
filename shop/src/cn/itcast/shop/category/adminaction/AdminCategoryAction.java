package cn.itcast.shop.category.adminaction;

import java.util.List;

import cn.itcast.shop.category.service.CategoryService;
import cn.itcast.shop.category.vo.Category;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category>{
	private Category category = new Category();
	@Override
	public Category getModel() {
		// TODO Auto-generated method stub
		return category;
	}
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	// 查询所有一级分类
	public String findAll(){
		System.out.println("管理员查询一级分类");
		// 调用Service查询所有一级分类
		List<Category> cList = categoryService.findAll();
		// 通过值栈保存一级分类集合:
		System.out.println("cList的size:"+cList.size());
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "findAll";
	}
	public String edit(){
		System.out.println("管理员编辑一级分类");
		category = categoryService.findByCid(category.getCid());
		return "editSuccess";
	}
	public String update(){
		System.out.println("管理员更新一级分类");
		categoryService.update(category);
		return "updateSuccess";
	}
	public String delete(){
		System.out.println("管理员delete一级分类categorycid:"+category.getCid());
		categoryService.delete(category.getCid());
		return "deleteSuccess";
	}
	public String save(){
		System.out.println("管理员保存一级分类");
		System.out.println(category.getCname());
		System.out.println(category.getCid());
		categoryService.save(category);
		return "saveSuccess";
	}
}
