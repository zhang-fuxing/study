package 观测者.diy;

/**
 * 观测者模式的主题
 *
 * @author zhangfx
 * @date 2023/1/30
 */
public interface Subject {
	
	/**
	 * 注册观测者
	 * @param observer 观测者对象
	 */
	void register(Observer observer);
	
	/**
	 * 移除一个观测者
	 * @param observer 具体观察者对象
	 */
	void remove(Observer observer);
	
	/**
	 * 通知所有的观察者
	 */
	void notifyObserver();
}
