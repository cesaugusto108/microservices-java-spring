package ces.augusto108.hroauth.feignclients;

import ces.augusto108.hroauth.model.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "hr-user", path = "/users")
public interface UserFeignClient {
    @GetMapping(value = "/list/email")
    User findByEmail(@RequestParam String email);
}
