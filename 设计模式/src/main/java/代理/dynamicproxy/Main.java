package 代理.dynamicproxy;

import 代理.dynamicproxy.fun.UserService;
import 代理.dynamicproxy.impl.UserServiceImpl;
import 代理.dynamicproxy.proxy.CglibProxy;
import 代理.dynamicproxy.proxy.ProxyFactory;

/**
 * @author zfx
 * @date 2022-07-24 20:47
 */
public class Main {
	public static void main(String[] args) {
		// dynamic proxy
		UserServiceImpl userService = new UserServiceImpl();
		UserService proxyObject = new ProxyFactory<UserService>(userService).getProxyObject();
		proxyObject.tt();
		System.out.println();
		// cglib dynamic proxy
		TestClass testClass = new TestClass();
		TestClass proxy = new CglibProxy<>(testClass).getProxyObject();
		proxy.test();
	}
}
