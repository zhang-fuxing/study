package threadimpl.lambda;

import java.util.concurrent.FutureTask;

/**
 * @author zhangfx
 * @date 2022/7/25
 */
public class Main {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("22222")).start();

        FutureTask<String> task = new FutureTask<>(() -> "33333");
        new Thread(task).start();
    }
}
