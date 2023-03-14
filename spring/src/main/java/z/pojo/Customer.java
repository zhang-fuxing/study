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
public class Customer {


    private User user;
    public Customer(User user) {
        this.user = user;
    }
    public void c1() {
        user.t1();
        System.out.println("c1.....");
    }
}
