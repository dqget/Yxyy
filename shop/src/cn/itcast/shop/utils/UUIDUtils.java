package cn.itcast.shop.utils;
import java.util.UUID;
/**
 * 随机生成一个uuid的工具类
 * uuid作为user对象的激活码code
 * @author LB101514
 *
 */
public class UUIDUtils {

	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-","");
	}
	
}
