package threadimpl.implInterface;

/**
 * @author zhangfx
 * @date 2022/7/25
 */
public class RunnableImpl implements Runnable{
    @Override
    public void run() {
        System.out.println("线程："+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        // 使用thread类的start方法开启线程
        new Thread(new RunnableImpl()).start();
    }
}
