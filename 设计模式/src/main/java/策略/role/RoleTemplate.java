package 策略.role;

import 策略.fun.Attack;
import 策略.fun.Fly;
import 策略.fun.Run;

/**
 * @author zhangfx
 * @date 2023/1/30
 */
public class RoleTemplate {
	private String name;
	private Run run;
	private Attack attack;
	private Fly fly;
	
	public String getName() {
		return name;
	}
	
	public RoleTemplate setName(String name) {
		this.name = name;
		return this;
	}
	
	public Run getRun() {
		return run;
	}
	
	public RoleTemplate setRun(Run run) {
		this.run = run;
		return this;
	}
	
	public Attack getAttack() {
		return attack;
	}
	
	public RoleTemplate setAttack(Attack attack) {
		this.attack = attack;
		return this;
	}
	
	public Fly getFly() {
		return fly;
	}
	
	public RoleTemplate setFly(Fly fly) {
		this.fly = fly;
		return this;
	}
}
