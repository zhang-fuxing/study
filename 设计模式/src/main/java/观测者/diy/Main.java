package 观测者.diy;

/**
 * @author zhangfx
 * @date 2023/1/30
 */
public class Main {
	public static void main(String[] args) {
		ProvideService1 service = new ProvideService1();
		var service2 = new ProvideService2();
		var r1 = new Reject1().reject(service);
		var r2 = new Reject2().reject(service);
		var r3 = new Reject3().reject(service);
		
		r1.reject(service2);
		
		service.setContent("aaaa");
		r1.unReject(service);
		r2.unReject(service);
		r3.reject(service2);
		service.setContent("bbbb");
		service2.setContent("11111");
	}
}
