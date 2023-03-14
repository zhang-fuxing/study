package 观测者.diy;

/**
 * @author zhangfx
 * @date 2023/1/30
 */
public class Reject2 implements Observer{
	
	@Override
	public void update(Object content) {
		System.out.println(getClass().getSimpleName() + "获取到订阅:" + content);
	}
}
