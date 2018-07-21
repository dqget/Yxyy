package cn.itcast.shop.admin.service;

import javax.transaction.Transactional;

import cn.itcast.shop.admin.dao.AdminDao;
import cn.itcast.shop.admin.vo.Admin;

@Transactional
public class AdminService {
	private AdminDao adminDao = new AdminDao();
	public AdminDao getAdminDao() {
		return adminDao;
	}
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	public Admin login(Admin admin) {
		// TODO Auto-generated method stub
		return getAdminDao().login(admin);
	}
	
}
