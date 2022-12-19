package ces.augusto108.hrapigatewayzuul.model.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    private static final String[] PUBLIC_ROUTE = {"/hr-oauth/oauth/token"};
    private static final String[] OPERATOR_ROUTE = {"/hr-employee/**"};
    private static final String[] ADMIN_ROUTE = {"/hr-payroll/**", "/hr-user/**"};

    @Autowired
    private JwtTokenStore jwtTokenStore;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(jwtTokenStore);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(PUBLIC_ROUTE).permitAll()
                .antMatchers(HttpMethod.GET, OPERATOR_ROUTE).hasAnyRole("OPERATOR", "ADMIN")
                .antMatchers(ADMIN_ROUTE).hasAnyRole("ADMIN")
                .anyRequest().authenticated();
    }
}
