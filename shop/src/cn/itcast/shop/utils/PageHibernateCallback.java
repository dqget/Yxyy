package cn.itcast.shop.utils;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;

public class PageHibernateCallback<T> implements HibernateCallback<List<T>>{
	
	private String hql;// hql语句
	private Object[] params;//  hql语句的参数
	private int startIndex;//开始个数
	private int pageSize;//每页的容量
	

	//构造函数   hql语句    hql语句的参数    开始个数    每页的容量
	public PageHibernateCallback(String hql, Object[] params,
			int startIndex, int pageSize) {
		super();
		this.hql = hql;
		this.params = params;
		this.startIndex = startIndex;
		this.pageSize = pageSize;
		System.out.println("hql:"+hql);
		System.out.println("startIndex:"+startIndex);
		System.out.println("pageSize:"+pageSize);
		if(params!=null){
			for(int i = 0; i < params.length;i++){
				System.out.println("params:"+params[i]);
			}
		}
	}

	public List<T> doInHibernate(Session session) throws HibernateException {
		//1 执行hql语句
		System.out.println("执行hql前");
		Query query = session.createQuery(hql);
		System.out.println("执行hql后");
		//2 实际参数
		if(params != null){
			for(int i = 0 ; i < params.length ; i ++){
				query.setParameter(i, params[i]);
			}
		}
		//3 分页
		query.setFirstResult(startIndex);
		query.setMaxResults(pageSize);
		
		return query.list();
	}

}
