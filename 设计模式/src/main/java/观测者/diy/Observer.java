package 观测者.diy;

/**
 * @author zhangfx
 * @date 2023/1/30
 */
public interface Observer {
	default Observer reject(Subject subject) {
		subject.register(this);
		return this;
	}
	
	default Observer unReject(Subject subject) {
		subject.remove(this);
		return this;
	}
	
	/**
	 * 更新内容
	 * @param content 更新的内容对象
	 */
	void update(Object content);
}
