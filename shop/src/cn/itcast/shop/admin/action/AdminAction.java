package cn.itcast.shop.admin.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.admin.service.AdminService;
import cn.itcast.shop.admin.vo.Admin;

public class AdminAction extends ActionSupport implements ModelDriven<Admin>{
	private Admin admin = new Admin();
	@Override
	public Admin getModel() {
		// TODO Auto-generated method stub
		return admin;
	}
	private AdminService adminService = new AdminService();
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	public String index(){
		return "index";
	}
	public String login(){
		Admin existadmin = getAdminService().login(admin);
		if(existadmin==null){
			//没有该用户或者密码错误
			this.addActionError("您的用户名或者密码错误！");
			return "loginFail";
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("admin", admin);
			return "loginSuccess";
		}
	}

	
}
