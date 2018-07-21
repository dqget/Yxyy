package cn.itcast.shop.product.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.itcast.shop.product.vo.Product;
import cn.itcast.shop.utils.PageHibernateCallback;

public class ProductDao extends HibernateDaoSupport{
	//首页上的热门商品的查询
	public List<Product> findHot() {
		System.out.println("首页上的热门商品的查询");
		// 使用离线条件查询.
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		// 查询热门的商品,条件就是is_host = 1
		criteria.add(Restrictions.eq("is_hot",1));
		// 倒序排序输出:
		criteria.addOrder(Order.desc("pdate"));
		// 执行查询:
		List list =  this.getHibernateTemplate().findByCriteria(
				criteria, 0, 10);
		for(Object p:list){
			System.out.println(((Product)p).getImage());
		}
		return list;
	}

	public List<Product> findNew() {
		// TODO Auto-generated method stub
		System.out.println("首页上的最新商品的查询");
		// 使用离线条件查询.
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		// 倒序排序输出:
		criteria.addOrder(Order.desc("pdate"));
		// 执行查询:
		List list =  this.getHibernateTemplate().findByCriteria(
				criteria, 0, 10);
		for(Object p:list){
			System.out.println(((Product)p).getImage());
		}
		return list;
	}
	//根据pid查询商品
	public Product findByPid(int pid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Product.class, pid);
	}
	//根据cid查询商品
	public List<Product> findByPageCid(Integer cid,int begin,int limit) {
		//String hql = "select p from Product p join p.categorySecond cs where cs.csid = ?";
		String hql = "select p from Product p join p.categorySecond cs join cs.category c where c.cid = ?";
		//String hql = "select p.* from Product p join p.categorySecond cs join cs.category c and where c.cid=?";
		List<Product> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Product>(hql, new Object[]{cid}, begin, limit));
		if(list.size()>0&&list!=null){
			return list;
		}
		return null;
	}
	//根据cid查询商品数量
	public int findCountCid(Integer cid) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Product p where p.categorySecond.category.cid=?";
		List list = this.getHibernateTemplate().find(hql,cid);
		if(list.size()>0&&list!=null){
			System.out.println("=================list.get(0):"+String.valueOf(list.get(0)));
			return Integer.parseInt(String.valueOf(list.get(0)));
		}
		return 0;
	}
	//根据csid查询商品
	public List<Product> findByPageCsid(Integer csid, int begin, int limit) {
		// TODO Auto-generated method stub
		String hql = "select p from Product p join p.categorySecond cs where cs.csid = ?";
		List<Product> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Product>(hql,new Object[]{csid}, begin, limit));
		if(list.size()>0&&list!=null){
			return list;
		}
		return null;
	}
	//根据csid查询商品数量
	public int findCountCsid(Integer csid) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Product p where p.categorySecond.csid = ?";
		List list = this.getHibernateTemplate().find(hql,csid);
		if(list.size()>0&&list!=null){
			System.out.println("=================list.get(0):"+String.valueOf(list.get(0)));
			return Integer.parseInt(String.valueOf(list.get(0)));
		}
		return 0;
	}

	public int findCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Product p";
		List list = this.getHibernateTemplate().find(hql);
		if(list.size()>0&&list!=null){
			return Integer.parseInt(String.valueOf(list.get(0)));
		}
		return 0;
	}

	public List<Product> findAllByPage(int begin, int limit) {
		// TODO Auto-generated method stub
		String hql = "from Product order by psales asc";
		List<Product> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Product>(hql,null, begin, limit));
		if(list.size()>0&&list!=null){
			return list;
		}
		return null;
	}

	public void save(Product product) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(product);
	}

	public void delete(Product product) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(product);
	}

	public void update(Product product) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(product);
	}

	public List<Product> findAllByWay(String fw, String fp,double smallprice,double bigprice, int begin, int limit) {
		// TODO Auto-generated method stub
		String hql = "";
		List<Product> list = null;
		if(fw.equals("1")){
			hql = "from Product p where p.pid like '%"+fp+"%'";
			list = this.getHibernateTemplate().execute(
					new PageHibernateCallback<Product>(hql,null, begin, limit));
		}else if(fw.equals("2")){
			hql = "from Product p where p.pname like '%"+fp+"%'";
			list = this.getHibernateTemplate().execute(
					new PageHibernateCallback<Product>(hql,null, begin, limit));
		}else if(fw.equals("3")){
			hql = "from Product p where p.shop_price between ? and ? order by shop_price asc";
			list = this.getHibernateTemplate().execute(
					new PageHibernateCallback<Product>(hql,new Object[]{smallprice,bigprice}, begin, limit));
		}
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

	public int findCountByWay(String fw, String fp,Double smallprice,Double bigprice) {
		// TODO Auto-generated method stub
		String hql = "";
		List list = null;
		if(fw.equals("1")){
			if(fp!=null){
				fp = fp.trim();
			}
			hql = "select count(*) from Product p where p.pid like '%"+fp+"%'";
			list = this.getHibernateTemplate().find(hql);
		}else if(fw.equals("2")){
			fp = fp.trim();
			hql = "select count(*) from Product p where p.pname like '%"+fp+"%'";
			list = this.getHibernateTemplate().find(hql);
		}else if(fw.equals("3")){
			hql = "select count(*) from Product p where p.shop_price between "+smallprice+" and "+bigprice+"";
			list = this.getHibernateTemplate().find(hql);
		}
		if(list.size()>0&&list!=null){
			return Integer.parseInt(String.valueOf(list.get(0)));
		}
		return 0;
	}

	
}
