package ces.augusto108.hroauth.model.services;

import ces.augusto108.hroauth.feignclients.UserFeignClient;
import ces.augusto108.hroauth.model.entities.User;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private final static Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        try {
            return userFeignClient.findByEmail(email);
        } catch (FeignException e) {
            LOGGER.info("Login credentials not found.");

            return null;
        } finally {
            LOGGER.info("Email address: " + email);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try {
            return findByEmail(s);
        } catch (RuntimeException e) {
            throw new UsernameNotFoundException("Login details not found.");
        }
    }
}
