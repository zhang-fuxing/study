package threadimpl.implInterface;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author zhangfx
 * @date 2022/7/25
 */
public class CallableImpl implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("call:" + Thread.currentThread().getName());
        return "yes";
    }

    @lombok.SneakyThrows
    public static void main(String[] args) {
        FutureTask<String> task = new FutureTask<>(new CallableImpl());
        new Thread(task).start();
        System.out.println(task.get());
    }
}
