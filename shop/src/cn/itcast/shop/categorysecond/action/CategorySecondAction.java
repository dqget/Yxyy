package cn.itcast.shop.categorysecond.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.categorysecond.service.CategorySecondService;
import cn.itcast.shop.categorysecond.vo.CategorySecond;

public class CategorySecondAction extends ActionSupport implements ModelDriven<CategorySecond>{
	//注入CategorySecondService
	private CategorySecondService categorySecondService = new CategorySecondService();

	@Override
	public CategorySecond getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public CategorySecondService getCategorySecondService() {
		return categorySecondService;
	}

	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
}
