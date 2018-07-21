package cn.itcast.shop.category.service;

import cn.itcast.shop.category.dao.CategoryDao;
import cn.itcast.shop.category.vo.Category;
import java.util.*;

import javax.transaction.Transactional;
/**
 * 一级分类的业务层
 * @author LB101514
 *
 */
@Transactional
public class CategoryService {
	//注入CategoryDao
	private CategoryDao categoryDao = new CategoryDao();

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	//业务层查询所有的一级分类
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		System.out.println("业务层查询所有的一级分类");
		return getCategoryDao().findAll();
	}

	public void delete(Integer cid) {
		// TODO Auto-generated method stub
		Category category = getCategoryDao().findByCid(cid);
		System.out.println("业务层删除一级分类cname:"+category.getCname());
		categoryDao.delete(category);
	}

	public void save(Category category) {
		// TODO Auto-generated method stub
		getCategoryDao().save(category);
	}

	public void update(Category category) {
		// TODO Auto-generated method stub
		getCategoryDao().update(category);
	}
	public Category findByCid(Integer cid) {
		// TODO Auto-generated method stub
		return getCategoryDao().findByCid(cid);
	}
}
