package 代理.dynamicproxy.fun;

/**
 *
 * 被代理的接口
 *
 * @author zhangfx
 * @date 2023/2/2
 */
public interface UserService {
	
	void test();
	
	default void tt() {
		System.out.println("tt ......");
	}
}
