package cn.itcast.shop.user.adminaction;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.user.service.UserService;
import cn.itcast.shop.user.vo.User;

public class AdminUserAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String findAll(){
		List<User> uList = userService.findAll();
		ActionContext.getContext().getValueStack().set("uList", uList);
		return "findAllSuccess";
	}
	public String delete(){
		user = userService.findByUserID(user.getUid());
		userService.delete(user);
		return "deleteSuccess";
	}
}
