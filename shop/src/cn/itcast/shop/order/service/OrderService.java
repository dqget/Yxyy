package cn.itcast.shop.order.service;


import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import cn.itcast.shop.order.dao.OrderDao;
import cn.itcast.shop.order.vo.Order;
import cn.itcast.shop.order.vo.OrderItem;
import cn.itcast.shop.utils.PageBean;

@Transactional
public class OrderService {
	// 注入OrderDao
	private OrderDao orderDao;
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	//保存订单到数据库
	public void save(Order order) {
		// TODO Auto-generated method stub
		orderDao.save(order);
	}
	//分页根据uid查询订单
	public PageBean<Order> findByUid(Integer uid,Integer page) {
		System.out.println("service层查询订单");
		PageBean<Order> pageBean = new PageBean<Order>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		// 显示5个
		int limit = 5;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = orderDao.findCountByUid(uid);
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		int totalPage = 0;
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 设置每页显示数据集合:
		int begin = (page - 1)*limit;
		List<Order> list = orderDao.findPageByUid(uid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	public Order findByOid(Integer oid) {
		// TODO Auto-generated method stub
		return orderDao.findByOid(oid);
	}
	public void pay(Order order) {
		// TODO Auto-generated method stub
		Order co = orderDao.findByOid(order.getOid());
		co.setState(2);
		co.setName(order.getName());
		co.setAddr(order.getAddr());
		co.setPhone(order.getPhone());
		System.out.println("service层付款");
		orderDao.pay(co);
	}
	public PageBean<Order> findAllByPage(Integer page) {
		System.out.println("service层后台查询订单");
		PageBean<Order> pageBean = new PageBean<Order>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		// 显示5个
		int limit = 10;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = orderDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		int totalPage = 0;
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 设置每页显示数据集合:
		int begin = (page - 1)*limit;
		List<Order> list = orderDao.findAllByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	public List<OrderItem> findOrderItems(Integer oid) {
		// TODO Auto-generated method stub
		return orderDao.findOrderItems(oid);
	}
	//确认收货修改订单状态为交易完成
	public void takeOverOrder(Integer oid) {
		// TODO Auto-generated method stub
		Order order = orderDao.findByOid(oid);
		order.setState(4);
		orderDao.updateOrderState(order);
	}
	//发货修改订单状态为已经发货
	public void sendGoods(Integer oid) {
		// TODO Auto-generated method stub
		Order order = orderDao.findByOid(oid);
		order.setState(3);
		System.out.println("order状态"+order.getOid());
		System.out.println("order状态"+order.getState());
		orderDao.updateOrderState(order);
	}
	public PageBean<Order> findOrderByPageState(Integer page,Integer state) {
		// TODO Auto-generated method stub
		PageBean<Order> pageBean = new PageBean<Order>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		// 显示5个
		int limit = 10;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = orderDao.findCountByStates(state);
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		int totalPage = 0;
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 设置每页显示数据集合:
		int begin = (page - 1)*limit;
		List<Order> list = orderDao.findOrderByPageState(state,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	public OrderItem findOrderItem(Integer itemid) {
		// TODO Auto-generated method stub
		return orderDao.findOrderItem(itemid);
	}
	public void updateEvaState(OrderItem orderItem) {
		// TODO Auto-generated method stub
		orderItem.setEvastate(1);
		orderDao.updateEvaState(orderItem);
	}
	public void deleteOrder(Order order) {
		// TODO Auto-generated method stub
		orderDao.delete(order);
	}
}
