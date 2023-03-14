package threadimpl.pool;

/**
 * @author zhangfx
 * @date 2023/2/17
 */
@FunctionalInterface
public interface SupplyTask<T> {
	T task() throws InterruptedException;
}
