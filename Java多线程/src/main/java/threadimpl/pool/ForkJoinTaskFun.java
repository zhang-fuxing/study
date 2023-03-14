package threadimpl.pool;

import java.util.concurrent.ForkJoinTask;

/**
 * @author zhangfx
 * @date 2023/2/17
 */
public class ForkJoinTaskFun<T> extends ForkJoinTask<T> {
	
	SupplyTask<T> supplyTask;
	
	T result;
	
	public ForkJoinTaskFun(SupplyTask<T> supplyTask) {
		this.supplyTask = supplyTask;
	}
	
	@Override
	public T getRawResult() {
		return result;
	}
	
	@Override
	protected void setRawResult(T value) {
		result = value;
	}
	
	@Override
	protected boolean exec() {
		try {
			result = supplyTask.task();
		} catch (InterruptedException e) {
			return false;
		}
		return true;
	}
}
