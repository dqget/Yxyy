package cn.itcast.shop.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.user.service.UserService;
import cn.itcast.shop.user.vo.User;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	//设置模型驱动来获取到user对象的信息
	private User user = new User();
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	//
	private String checkcode = new String();
	public String getCheckcode() {
		return checkcode;
	}
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	//注入userService
	private UserService userService = new UserService();
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	//跳转到注册界面的action
	public String registPage(){
		return "registPage";
	}
	public String regist(){
		String exitCode = ServletActionContext.getRequest().getSession().getAttribute("checkcode").toString();
		if(getCheckcode().equalsIgnoreCase(exitCode)){
			getUserService().save(getUser());
			this.addActionMessage("注册成功！欢迎您，用户："+getUser().getUserName());
			/*
			 * 发送邮件
			 */
			return "msg";
		}
		this.addActionError("验证码输入错误！");
		return "checkCodeFail";
	}
	//Ajax异步校验用户名的action
	public void findByUserName(){
		String userName = getUser().getUserName();
		System.out.println("user============"+userName);
		//通过调用UserService中的调用userdao包中的用户业务逻辑类中的方法进行查询数据库是否存在userName
		if(userService==null){
			System.out.println("userService is null ");
		}else if(userService!=null){
			System.out.println("userService isn't null ");
		}
		User u = getUserService().findByUserName(userName);
		//使用response对象将数据返回到页面
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		if(u==null){
			//没有查到这个用户：用户名可以使用
			try {
				response.getWriter().println("<font color='green'>用户名可以使用</font>");
				System.out.println("没有查到这个用户");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			//查到了这个用户：用户名已经存在
			try {
				response.getWriter().println("<font color='red'>用户名已经存在</font>");
				System.out.println("已经查到了这个用户");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public String loginPage(){
		return "loginPage";
	}
	public String login(){
		String exitCode = ServletActionContext.getRequest().getSession().getAttribute("checkcode").toString();
		if(getCheckcode().equalsIgnoreCase(exitCode)){
			User existUser = getUserService().login(getUser());
			if(existUser==null){
				//密码错误
				this.addActionError("登录失败！用户名或者密码错误！");
				return "login";
			}else{
				//密码正确
				ServletActionContext.getRequest().getSession().setAttribute("existUser",existUser);
				return "loginSuccess";
			}
		}else{
			this.addActionError("登录失败！验证码错误！");
			return "login";
		}
	}
	public String quit(){
		//销毁session
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}

}
