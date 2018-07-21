package cn.itcast.shop.utils;

import java.util.List;
/**
 * 封装一个pagebean 来分页
 * @author LB101514
 *
 * @param <T>
 */
public class PageBean<T> {
	private int page;//当前页数
	private int totalCount;//总记录数
	private int totalPage;//总页数
	private int limit;//每页的记录数
	private List<T> list;//每页的记录的数据
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
