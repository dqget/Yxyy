package cn.itcast.shop.categorysecond.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.itcast.shop.categorysecond.vo.CategorySecond;
import cn.itcast.shop.utils.PageHibernateCallback;

public class CategorySecondDao extends HibernateDaoSupport{
	//分页查询二级分类的方法
	public List<CategorySecond> findAllByPage(int begin, int limit) {
		// TODO Auto-generated method stub
		String hql = "from CategorySecond order by csid desc";
		List<CategorySecond> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<CategorySecond>(hql,null, begin, limit));
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}
	//统计二级分类的个数
	public int findCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from CategorySecond";
		List list = this.getHibernateTemplate().find(hql);
		if(list.size()>0&&list!=null){
			return Integer.parseInt(String.valueOf(list.get(0)));
		}
		return 0;
	}
	public void save(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(categorySecond);
	}
	public CategorySecond findByCsid(int csid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(CategorySecond.class, csid);
	}
	public void delete(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(categorySecond);
	}
	public void update(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(categorySecond);
	}
	public List<CategorySecond> findAll() {
		// TODO Auto-generated method stub
		String hql = "from CategorySecond";
		List<CategorySecond> list = (List<CategorySecond>)this.getHibernateTemplate().find(hql);
		if(list.size()>0&&list!=null){
			return list;
		}
		return null;
	}
	
}
