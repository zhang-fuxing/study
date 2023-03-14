package 代理.dynamicproxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author zhangfx
 * @date 2023/2/2
 */
public class ProxyFactory<T> {
	private final T target;
	
	public ProxyFactory(T target) {
		this.target = target;
	}
	
	@SuppressWarnings("unchecked")
	public  T getProxyObject() {
		InvocationHandler h = (proxy, method, args) -> {
			System.out.println("经过动态代理");
			Object invoke = method.invoke(target, args);
			System.out.println("动态代理完成");
			return invoke;
		};
		Object instance = Proxy.newProxyInstance(
				target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),
				h);
		return (T) instance;
	}
}
