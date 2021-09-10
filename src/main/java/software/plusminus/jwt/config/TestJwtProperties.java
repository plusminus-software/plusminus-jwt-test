package software.plusminus.jwt.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.PostConstruct;

@Configuration
@ConfigurationProperties("jwt")
@Primary
@Profile("test")
public class TestJwtProperties extends JwtProperties {
    
    @PostConstruct
    void init() {
        if (getPrivateKey() == null) {
            setPrivateKey(new ClassPathResource("test_private_key_pkcs8.pem"));
        }
        if (getPublicKey() == null) {
            setPublicKey(new ClassPathResource("test_public_key.pem"));
        }
    }
}
