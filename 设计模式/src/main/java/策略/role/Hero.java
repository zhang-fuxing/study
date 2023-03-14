package 策略.role;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zhangfx
 * @date 2023/1/30
 */
public class Hero extends RoleTemplate {
	private Map<String, RoleTemplate> heros = new LinkedHashMap<>();
	
	public Hero create() {
		return new Hero();
	}
	
	public void add(RoleTemplate role) {
		heros.put(role.getName(), role);
	}
}
