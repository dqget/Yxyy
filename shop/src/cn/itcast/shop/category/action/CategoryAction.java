package cn.itcast.shop.category.action;

import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.shop.category.service.CategoryService;

public class CategoryAction extends ActionSupport{
	//注入CategoryService
	private CategoryService categoryService = new CategoryService();

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	
}
