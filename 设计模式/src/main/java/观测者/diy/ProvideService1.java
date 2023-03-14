package 观测者.diy;

import java.util.LinkedList;
import java.util.List;

/**
 * 服务号1，实现主体Subject方便使用其功能
 * @author zhangfx
 * @date 2023/1/30
 */
public class ProvideService1 implements Subject {
	private Object content;
	
	private final List<Observer> rejects = new LinkedList<>();
	@Override
	public void register(Observer observer) {
		this.rejects.add(observer);
	}
	
	@Override
	public void remove(Observer observer) {
		this.rejects.remove(observer);
	}
	
	@Override
	public void notifyObserver() {
		rejects.forEach(observer -> observer.update(content));
	}
	
	public void setContent(Object content) {
		this.content = content;
		notifyObserver();
	}
}
