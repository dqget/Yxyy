package cn.itcast.shop.evaluate.dao;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.itcast.shop.evaluate.vo.Evaluate;

public class EvaluateDao extends HibernateDaoSupport{

	public void save(Evaluate evaluate) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(evaluate);
	}

}
