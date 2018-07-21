package cn.itcast.shop.admin.dao;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.*;
import cn.itcast.shop.admin.vo.Admin;

public class AdminDao extends HibernateDaoSupport{

	public Admin login(Admin admin) {
		// TODO Auto-generated method stub
		String hql = "from Admin a where a.adminname=? and a.adminpassword=?";
		List list = this.getHibernateTemplate().find(hql,admin.getAdminname(),admin.getAdminpassword());
		if(list!=null&&list.size()>0){
			return admin;
		}
		return null;
	}
	
}
