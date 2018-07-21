package cn.itcast.shop.user.dao;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import java.util.*;
import cn.itcast.shop.user.vo.User;

/**
 * 用户模块持久化类的模块
 * @author LB101514
 *
 */
//继承HibernateDaoSupport类  好处：可以直接继承hibernate模板
//只需要将sessionFactory注入到application中配置的 用户持久化层的Actio
public class UserDao extends HibernateDaoSupport{
	User u = null;
	/*
	 * 根据用户名判断用户是否存在的方法
	 */
	public boolean judgeUser(String userName){
		String hql = "from User";
		List list = this.getHibernateTemplate().find(hql);
		if(list != null && list.size() > 0){
			for(int i = 0; i < list.size();i++){
				System.out.println(((User)list.get(i)).getUserName());
				if(((User)list.get(i)).getUserName().toString().equals(userName)){
					u = (User)list.get(i);
					return true;
				}
			}
		}
		u = null;
		return false;
	}
	// 按名字查询是否有该用户:
	public User findByUserName(String userName){
		System.out.println("dao=========="+userName);
		if(judgeUser(userName)){
			return u;
		}
		return null;
	}
	// 按名次查询是否有该用户:
//	public User findByUserName(String userName){
//		System.out.println("dao=========="+userName);
//		String hql = "from User user where user.userName = "+userName;
//		User u = null;
//		try {
//			u = (User)this.getHibernateTemplate().find(hql).get(0);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			u = null;
//		}
//		return u;
////		List list = this.getHibernateTemplate().find(hql);
////		if(list != null && list.size() > 0){
////			return (User)list.get(0);
////		}
////		return null;
//	}
	//注册用户，存入数据库 
	public void save(User user) {
		// TODO Auto-generated method stub
		System.out.println("dao========================");
		System.out.println("getUserName"+user.getUserName());
		System.out.println("getPassword"+user.getPassword());
		System.out.println("getName"+user.getName());
		System.out.println("getPhone"+user.getPhone());
		System.out.println("getAddr"+user.getAddr());
		System.out.println("getEmail"+user.getEmail());
		System.out.println("getCode"+user.getCode());
		System.out.println("getState"+user.getState());
		this.getHibernateTemplate().save(user);
	}
	public User login(User user) {
		// TODO Auto-generated method stub
//		User datauser = findByUserName(user.getUserName());
		User datauser = null;
		String hql = "from User";
		List list = this.getHibernateTemplate().find(hql);
		if(list != null && list.size() > 0){
			for(int i = 0; i < list.size();i++){
				System.out.println(((User)list.get(i)).getUserName());
				if(((User)list.get(i)).getUserName().toString().equals(user.getUserName())){
					datauser = (User)list.get(i);
				}
			}
		}
		if(datauser!=null&&datauser.getPassword().equals(user.getPassword())){
			//有用户并且密码正确
			return datauser;
		}
		return null;
	}
	public void delete(User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(user);
	}
	public List<User> findAll() {
		// TODO Auto-generated method stub
		String hql="from User order by uid";
		List<User> list = (List<User>)this.getHibernateTemplate().find(hql);
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}
	public User findByUserID(int uid) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.uid=?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, uid);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	public void update(User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(user);
	}
}
