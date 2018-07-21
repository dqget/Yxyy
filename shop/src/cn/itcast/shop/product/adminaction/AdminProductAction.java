package cn.itcast.shop.product.adminaction;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.categorysecond.service.CategorySecondService;
import cn.itcast.shop.categorysecond.vo.CategorySecond;
import cn.itcast.shop.product.service.ProductService;
import cn.itcast.shop.product.vo.Product;
import cn.itcast.shop.utils.PageBean;

public class AdminProductAction extends ActionSupport implements ModelDriven<Product>{
	private Product product = new Product();
	@Override
	public Product getModel() {
		// TODO Auto-generated method stub
		return product;
	}
	//注入ProductService
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	CategorySecondService categorySecondService;
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	Integer page;
	public void setPage(Integer page) {
		this.page = page;
	}
	//文件上传所需要的参数
	private File upload;			//上传的文件
	private String uploadFileName;	//上传的文件名
	private String uploadContextType;//上传的文件的类型
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public void setUploadContextType(String uploadContextType) {
		this.uploadContextType = uploadContextType;
	}
	//带分页查询商品
	public String findAllByPage(){
		if(page==null){
			page=1;
		}
		PageBean<Product> pageBean = productService.findAllByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean",pageBean);
		return "list";
	}
	//跳转到添加界面
	public String add(){
		List<CategorySecond> csList = categorySecondService.findAll();
		ActionContext.getContext().getValueStack().set("csList", csList);
		return "add";
	}

	
	public String save(){
		System.out.println(product.getPid());
		product.setPdate(new Date());
		if(upload!=null){
			//文件上传
			//  * 获得products文件夹的绝对路径
			String realPath = ServletActionContext.getServletContext().getRealPath("/products");
			//	* 创建一个文件夹
			File diskfile = new File(realPath+"//1//"+uploadFileName);
			try {
//				* 上传文件
				FileUtils.copyFile(upload, diskfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("上传失败");
				e.printStackTrace();
			}
			product.setImage("products/1/"+uploadFileName);
		}
		productService.save(product);
		return "saveSuccess";
	}
	public String delete(){
		productService.delete(product);
		return "deleteSuccess";
	}
	public String edit(){
		List<CategorySecond> csList = categorySecondService.findAll();
		ActionContext.getContext().getValueStack().set("csList", csList);
		product = productService.findByPid(product.getPid());
		return "editSuccess";
	}
	public String update(){
		product.setPdate(new Date());
		if(upload!=null){
			//删除掉原来商品的图片
			String path = product.getImage();
			File file = new File(path);
			file.delete();
			//文件上传
			//  * 获得products文件夹的绝对路径
			String realPath = ServletActionContext.getServletContext().getRealPath("/products");
			//	* 创建一个文件夹
			File diskfile = new File(realPath+"//1//"+uploadFileName);
			try {
//				* 上传文件
				FileUtils.copyFile(upload, diskfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("上传失败");
				e.printStackTrace();
			}
			product.setImage("products/1/"+uploadFileName);
		}
		productService.update(product);
		return "updateSuccess";
	}
	
	
	
	




}
