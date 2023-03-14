package 策略.role;

/**
 * @author zhangfx
 * @date 2023/1/30
 */
public class Main {
	public static void main(String[] args) {
		Hero hero = new Hero();
		RoleTemplate roleTemplate = hero.create()
				.setName("dc")
				.setRun(() -> System.out.println("dances"))
				.setAttack(() -> System.out.println("tao"))
				.setFly(() -> System.out.println("no no"));
		
	}
}
