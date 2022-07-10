package tests.properties;

import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class OwnerTests {
    CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

    @Test
    @Tag("owner")
    void someTest1() {
        String login = config.login();
        String password = config.password();
        String link = config.link();

        System.out.println("Login: " + login);
        System.out.println("Password: " + password);
        System.out.println("URL Selenoid: " + link);
    }

}