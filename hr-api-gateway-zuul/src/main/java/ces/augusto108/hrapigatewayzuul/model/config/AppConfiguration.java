package ces.augusto108.hrapigatewayzuul.model.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class AppConfiguration {
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();

        jwtAccessTokenConverter.setSigningKey("my-secret-key");

        return jwtAccessTokenConverter;
    }

    @Bean
    public JwtTokenStore getTokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }
}
