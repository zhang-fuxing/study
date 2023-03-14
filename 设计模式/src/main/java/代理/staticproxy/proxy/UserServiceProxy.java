package 代理.staticproxy.proxy;

import 代理.staticproxy.fun.UserService;

/**
 * @author zhangfx
 * @date 2023/2/2
 */
public class UserServiceProxy implements UserService{
	private UserService target;
	
	public UserServiceProxy() {
	}
	
	public UserServiceProxy(UserService target) {
		this.target = target;
	}
	
	@Override
	public void test() {
		System.out.println("经过代理。。。。。。");
		target.test();
		System.out.println("代理完成");
	}
}
