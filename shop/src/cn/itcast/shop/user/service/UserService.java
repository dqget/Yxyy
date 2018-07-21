package cn.itcast.shop.user.service;
import cn.itcast.shop.utils.UUIDUtils;

import java.util.List;

import javax.transaction.Transactional;
import cn.itcast.shop.user.dao.UserDao;
import cn.itcast.shop.user.vo.User;

/**
 * 用户模块业务层的代码
 * @author LB101514
 *
 */
@Transactional
public class UserService {
	//注入userDao
	private UserDao userDao = new UserDao();
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public User findByUserName(String userName){
		System.out.println("UserService==========="+userName);
		return getUserDao().findByUserName(userName);
	}
	public void save(User user) {
		// TODO Auto-generated method stub
		user.setState(0);//0 代表未激活 1 代表激活
		user.setCode(UUIDUtils.getUUID());
		System.out.println("service========================");
		System.out.println("getUserName"+user.getUserName());
		System.out.println("getPassword"+user.getPassword());
		System.out.println("getName"+user.getName());
		System.out.println("getPhone"+user.getPhone());
		System.out.println("getAddr"+user.getAddr());
		System.out.println("getEmail"+user.getEmail());
		System.out.println("getCode"+user.getCode());
		System.out.println("getState"+user.getState());
		getUserDao().save(user);
	}
	public void update(User user){
		getUserDao().update(user);
	}
	public User login(User user) {
		// TODO Auto-generated method stub
		return getUserDao().login(user);
	}
	public void delete(User user) {
		// TODO Auto-generated method stub
		getUserDao().delete(user);
	}
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return getUserDao().findAll();
	}
	public User findByUserID(int uid) {
		// TODO Auto-generated method stub
		return getUserDao().findByUserID(uid);
	}
}
