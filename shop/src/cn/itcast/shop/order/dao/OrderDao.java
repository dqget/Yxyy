package cn.itcast.shop.order.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.itcast.shop.order.vo.Order;
import cn.itcast.shop.order.vo.OrderItem;
import cn.itcast.shop.utils.PageHibernateCallback;

public class OrderDao extends HibernateDaoSupport {

	public void save(Order order) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(order);
	}
	// Dao层查询我的订单分页查询:统计个数
	public int findCountByUid(Integer uid) {
		System.out.println("dao层查询订单个数");
		String hql = "select count(*) from Order o where o.user.uid = ?";
		List list = this.getHibernateTemplate().find(hql, uid);
		if (list != null && list.size() > 0) {
			return Integer.parseInt(String.valueOf(list.get(0)));
		}
		return 0;
	}

	// Dao层查询我的订单分页查询:查询数据
	public List<Order> findPageByUid(Integer uid, int begin, int limit) {
		System.out.println("dao层分页查询订单");
		String hql = "from Order o where o.user.uid = ? order by o.ordertime desc";
		List<Order> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Order>(hql, new Object[] { uid },
						begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	public Order findByOid(Integer oid) {
		// TODO Auto-generated method stub
		String hql = "from Order o where o.oid=?";
		List list = this.getHibernateTemplate().find(hql,oid);
		if(list!=null&&list.size()>0){
			return (Order)list.get(0);
		}
		return null;
	}
	public void pay(Order co) {
		// TODO Auto-generated method stub
		System.out.println("dao层付款");
		this.getHibernateTemplate().update(co);
	}
	//查询订单的数量
	public int findCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Order";
		List list = this.getHibernateTemplate().find(hql);
		if(list!=null&&list.size()>0){
			return Integer.parseInt(String.valueOf(list.get(0)));
		}
		return 0;
	}
	//分页查询订单
	public List<Order> findAllByPage(int begin, int limit) {
		// TODO Auto-generated method stub
		String hql = "from Order o order by o.ordertime desc";
		List<Order> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Order>(hql,null,begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	public List<OrderItem> findOrderItems(Integer oid) {
		// TODO Auto-generated method stub
		String hql = "from OrderItem oi where oi.order.oid=?";
		List<OrderItem> orderItems = (List<OrderItem>)this.getHibernateTemplate().find(hql, oid);
		if(orderItems!=null&&orderItems.size()>0){
			return orderItems;
		}
		return null;
	}
	public void updateOrderState(Order order){
		System.out.println("dao层更新订单");
		this.getHibernateTemplate().update(order);
	}
	public int findCountByStates(Integer state) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Order o where o.state=?";
		List list = this.getHibernateTemplate().find(hql,state);
		if(list!=null&&list.size()>0){
			return Integer.parseInt(String.valueOf(list.get(0)));
		}
		return 0;
	}
	public List<Order> findOrderByPageState(Integer state, int begin, int limit) {
		// TODO Auto-generated method stub
		String hql = "from Order o where o.state=?";
		List<Order> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Order>(hql,new Object[]{state},begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	public OrderItem findOrderItem(Integer itemid) {
		// TODO Auto-generated method stub
		String hql = "from OrderItem oi where oi.itemid=?";
		List list = this.getHibernateTemplate().find(hql,itemid);
		if(list!=null&&list.size()>0){
			return (OrderItem)list.get(0);
		}
		return null;
	}
	public void updateEvaState(OrderItem orderItem) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(orderItem);
	}
	public void delete(Order order) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(order);
	}

}
