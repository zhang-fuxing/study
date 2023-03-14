package 代理.dynamicproxy.proxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhangfx
 * @date 2023/2/2
 */
public class CglibProxy<T> implements MethodInterceptor {
	
	private T target;
	
	public CglibProxy(T target) {
		this.target = target;
	}
	
	public CglibProxy() {}
	
	@SuppressWarnings("unchecked")
	public T getProxyObject() {
		var enhancer = new Enhancer();
		enhancer.setUseFactory(true);
		enhancer.setSuperclass(target.getClass());
		enhancer.setCallback(this);
		return (T) enhancer.create();
	}
	
	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		System.out.println("cglib 代理开始");
		Object invoke = methodProxy.invoke(target, args);
		System.out.println("cglib 代理完成");
		return invoke;
	}
}
