package z.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author zhangfx
 * @date 2022/7/19
 */
@Component
@Data
@NoArgsConstructor
public class User {

    public void t1() {
        System.out.println("user...");
    }
}
