package z;

import cn.hutool.json.JSONUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisClientConfig;
import z.config.SpringConfig;
import z.pojo.Pojo;
import z.pojo.User;

/**
 * @author zhangfx
 * @date 2022/7/19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class MainTest {
	
	
	//  ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
	@Autowired
	User user;
	
	@Test
	public void test1() {
		StringBuilder sql = new StringBuilder("select distinct v.vpicsType.typeName,v.fileType from VgeoData v where v.projectid=222");
		
		Integer[] id = {4, 5, 6};
		sql.append(" and v.picType.picsTypeId in(");
		for (Integer item : id) {
			sql.append(item).append(",");
		}
		int index = sql.lastIndexOf(",");
		sql.replace(sql.length()-1, sql.length(),")");
		System.out.println(sql.toString());
		
	}
	
	@Test
	public void test2() {
	
	}
	
	public static void main(String[] args) {
		Pojo pojo = new Pojo();
		pojo.setAac("abcccdf");
		pojo.setName("zzz");
		
		Pojo pojo2 = new Pojo();
		pojo2.setAac("2222");
		pojo2.setName("ff222");
		Pojo[] pojos = new Pojo[2];
		JEDIS.hsetnx("map", "pojo", JSONUtil.parseObj(pojo).toJSONString(4));
		String hget = JEDIS.hget("map", "pojo");
		
	}
	
	public static final Jedis JEDIS;
	
	static {
		JEDIS = new Jedis(new HostAndPort("192.168.235.111", 6379), new JedisClientConfig() {
			@Override
			public String getPassword() {
				return "kingshine12345";
			}
			
			@Override
			public int getDatabase() {
				return 9;
			}
		});
	}
}
