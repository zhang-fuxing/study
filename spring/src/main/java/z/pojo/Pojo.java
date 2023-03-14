package z.pojo;

/**
 * @author zhangfx
 * @date 2023/2/2
 */
public class Pojo {
	private String name;
	private String aac;
	
	public Pojo() {
		System.out.println("构造方法");
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAac() {
		return aac;
	}
	
	public void setAac(String aac) {
		this.aac = aac;
	}
	
	@Override
	public String toString() {
		return "Pojo{" +
				"name='" + name + '\'' +
				", aac='" + aac + '\'' +
				'}';
	}
}
