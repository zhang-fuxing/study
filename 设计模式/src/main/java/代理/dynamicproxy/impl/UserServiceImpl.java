package 代理.dynamicproxy.impl;

import 代理.dynamicproxy.fun.UserService;

/**
 * 被代理接口的实现类
 *
 * @author zhangfx
 * @date 2023/2/2
 */
public class UserServiceImpl implements UserService {
	@Override
	public void test() {
		System.out.println("user service test method invoke......");
	}
}
