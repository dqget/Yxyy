package cn.itcast.shop.categorysecond.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.shop.categorysecond.dao.CategorySecondDao;
import cn.itcast.shop.categorysecond.vo.CategorySecond;
import cn.itcast.shop.utils.PageBean;
@Transactional
public class CategorySecondService {
	//注入dao
	private CategorySecondDao categorySecondDao = new CategorySecondDao();

	public CategorySecondDao getCategorySecondDao() {
		return categorySecondDao;
	}

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}
	//二级标题分页查询
	public PageBean<CategorySecond> findAllByPage(Integer page) {
		// TODO Auto-generated method stub
		System.out.println("CategorySecondService findAllByPageSuccess");
		PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>();
		//设置当前页数
		pageBean.setPage(page);
		//设置每一页显示的记录数
		int limit = 10;
		pageBean.setLimit(limit);
		//设置总的记录数
		int totalCount = categorySecondDao.findCount();
		System.out.println("totalCount"+totalCount);
		pageBean.setTotalCount(totalCount);
		//设置总的页数
		int totalPage = 0;
		//totalPage = (int)Math.ceil(totalCount%limit);
		if(totalCount%limit==0){
			totalPage = totalCount/limit;
		}else{
			totalPage = (totalCount/limit)+1;
		}
		pageBean.setTotalPage(totalPage);
		//设置页面记录数据
		int begin = (page - 1)*limit;
		List<CategorySecond> list = categorySecondDao.findAllByPage(begin,limit);
		pageBean.setList(list);
		System.out.println("页面记录数据:"+list.size());
		return pageBean;
	}

	public void save(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		categorySecondDao.save(categorySecond);
	}

	public void delete(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		categorySecondDao.delete(categorySecond);
	}
	
	public CategorySecond findByCsid(int csid) {
		// TODO Auto-generated method stub
		return categorySecondDao.findByCsid(csid);
	}

	public void update(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		categorySecondDao.update(categorySecond);
	}

	public List<CategorySecond> findAll() {
		// TODO Auto-generated method stub
		return categorySecondDao.findAll();
	}
	
}
