package cn.itcast.shop.product.service;

import java.util.List;

import javax.transaction.Transactional;

import cn.itcast.shop.product.dao.ProductDao;
import cn.itcast.shop.product.vo.Product;
import cn.itcast.shop.utils.PageBean;
@Transactional
public class ProductService {
	//注入productdao
	private ProductDao productDao = new ProductDao();

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	//查询首页的热门商品
	public List<Product> findHot() {
		// TODO Auto-generated method stub
		return getProductDao().findHot();
	}
	//查询首页的最新商品
	public List<Product> findNew() {
		// TODO Auto-generated method stub
		return getProductDao().findNew();
	}
	//根据商品id查询商品
	public Product findByPid(int pid) {
		// TODO Auto-generated method stub
		return getProductDao().findByPid(pid);
	}
	//根据一级标题查询商品分页
	public PageBean<Product> findByCid(Integer cid,Integer page) {
		// TODO Auto-generated method stub
		PageBean<Product> pageBean = new PageBean<Product>();
		//设置当前页数
		pageBean.setPage(page);
		//设置每一页显示的记录数
		int limit = 12;
		pageBean.setLimit(limit);
		//设置总的记录数
		int totalCount = getProductDao().findCountCid(cid);
		pageBean.setTotalCount(totalCount);
		//设置总的页数
		int totalPage = 0;
//		totalPage = (int)Math.ceil(totalCount%limit);
		if(totalCount%limit==0){
			totalPage = totalCount/limit;
		}else{
			totalPage = (totalCount/limit)+1;
		}
		pageBean.setTotalPage(totalPage);
		//设置页面记录数据
		int begin = (page - 1)*limit;
		List<Product> list = getProductDao().findByPageCid(cid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	//根据二级标题查询商品分页
	public PageBean<Product> findByCsid(Integer csid, Integer page) {
		// TODO Auto-generated method stub
		PageBean<Product> pageBean = new PageBean<Product>();
		//设置当前页数
		pageBean.setPage(page);
		//设置每一页显示的记录数
		int limit = 12;
		pageBean.setLimit(limit);
		//设置总的记录数
		int totalCount = getProductDao().findCountCsid(csid);
		pageBean.setTotalCount(totalCount);
		//设置总的页数
		int totalPage = 0;
		//totalPage = (int)Math.ceil(totalCount%limit);
		if(totalCount%limit==0){
			totalPage = totalCount/limit;
		}else{
			totalPage = (totalCount/limit)+1;
		}
		pageBean.setTotalPage(totalPage);
		//设置页面记录数据
		int begin = (page - 1)*limit;
		List<Product> list = getProductDao().findByPageCsid(csid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	//查询商品带分页

	public PageBean<Product> findAllByPage(Integer page) {
		// TODO Auto-generated method stub
		PageBean<Product> pageBean = new PageBean<Product>();
		//设置当前页数
		pageBean.setPage(page);
		//设置每一页显示的记录数
		int limit = 12;
		pageBean.setLimit(limit);
		//设置总的记录数
		int totalCount = getProductDao().findCount();
		pageBean.setTotalCount(totalCount);
		//设置总的页数
		int totalPage = 0;
		//totalPage = (int)Math.ceil(totalCount%limit);
		if(totalCount%limit==0){
			totalPage = totalCount/limit;
		}else{
			totalPage = (totalCount/limit)+1;
		}
		pageBean.setTotalPage(totalPage);
		//设置页面记录数据
		int begin = (page - 1)*limit;
		List<Product> list = getProductDao().findAllByPage(begin,limit);
		pageBean.setList(list);
		System.out.println("页面记录数据:"+list.size());
		return pageBean;
	}

	public void save(Product product) {
		// TODO Auto-generated method stub
		productDao.save(product);
	}

	public void delete(Product product) {
		// TODO Auto-generated method stub
		productDao.delete(product);
	}

	public void update(Product product) {
		// TODO Auto-generated method stub
		productDao.update(product);
	}
	public PageBean<Product> findByWay(String fw, String fp,Double smallprice,Double bigprice,int page) {
		// TODO Auto-generated method stub
		PageBean<Product> pageBean = new PageBean<Product>();
		//设置当前页数
		pageBean.setPage(page);
		//设置每一页显示的记录数
		int limit = 12;
		pageBean.setLimit(limit);
		//设置总的记录数
		int totalCount = getProductDao().findCountByWay(fw,fp,smallprice,bigprice);
		pageBean.setTotalCount(totalCount);
		//设置总的页数
		int totalPage = 0;
		//totalPage = (int)Math.ceil(totalCount%limit);
		if(totalCount%limit==0){
			totalPage = totalCount/limit;
		}else{
			totalPage = (totalCount/limit)+1;
		}
		pageBean.setTotalPage(totalPage);
		//设置页面记录数据
		int begin = (page - 1)*limit;
		List<Product> list = getProductDao().findAllByWay(fw,fp,smallprice,bigprice,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
