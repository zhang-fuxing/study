package threadimpl.extendsClass;

/**
 * @author zhangfx
 * @date 2022/7/25
 */
public class ThreadExtends extends Thread{
    @Override
    public void run() {
        System.out.println("11111");
    }

    public static void main(String[] args) {
        new ThreadExtends().start();
    }
}
