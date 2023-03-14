package 代理.staticproxy;

import 代理.staticproxy.fun.UserService;
import 代理.staticproxy.impl.UserServiceImpl;
import 代理.staticproxy.proxy.UserServiceProxy;

/**
 * @author zfx
 * @date 2022-07-24 20:47
 */
public class Main {
	public static void main(String[] args) {
		// 静态
		var target = new UserServiceImpl();
		UserService userService = new UserServiceProxy(target);
		userService.test();
		
	}
}
