package z.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisClientConfig;

/**
 * @author zhangfx
 * @date 2023/3/1
 */
@Configuration
public class RedisConfig {
	
	@Bean
	public Jedis jedis() {
		return new Jedis("192.168.235.249", 6379, new JedisClientConfig() {
			@Override
			public String getPassword() {
				return "kingshine";
			}
		});
	}
}
