package threadimpl.pool;

import java.util.concurrent.ForkJoinPool;

/**
 * @author zhangfx
 * @date 2023/2/17
 */
public class AsyncTask {
	
	private static final ForkJoinPool POOL = new ForkJoinPool(Runtime.getRuntime().availableProcessors(),ForkJoinPool.defaultForkJoinWorkerThreadFactory
	,null, true);
	
	public static <T> T supply(SupplyTask<T> supplyTask, ForkJoinPool POOL) {
		if (POOL == null) POOL = AsyncTask.POOL;
		ForkJoinTaskFun<T> fun = new ForkJoinTaskFun<>(supplyTask);
		return POOL.invoke(fun);
	}
	
	public static <T> T supply(SupplyTask<T> supplyTask) {
		return supply(supplyTask, POOL);
	}
}
