package cn.itcast.shop.category.dao;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.itcast.shop.category.vo.Category;
import java.util.*;

/**
 * 一级分类的持久层
 * @author LB101514
 *
 */
public class CategoryDao extends HibernateDaoSupport{
	//持久层查询数据库中的所有一级标题
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		System.out.println("持久层查询数据库中的所有一级标题");
		String hql="from Category";
		List<Category> al = (List<Category>)this.getHibernateTemplate().find(hql);
		for(int i = 0;i<al.size();i++){
			System.out.println(al.get(i).getCname());
		}
		return al;
	}

	public void delete(Category category) {
		// TODO Auto-generated method stub
		System.out.println("dao层删除一级分类");
		this.getHibernateTemplate().delete(category);
	}

	public void save(Category category) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(category);
	}

	public Category findByCid(Integer cid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Category.class, cid);
	}

	public void update(Category category) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(category);
	}
	
}
