package tests.properties;

import com.codeborne.selenide.Configuration;
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
        String remoteURL = System.getProperty("remoteURL");


        System.out.println("Login: " + login);
        System.out.println("Password: " + password);
        System.out.println("Remote URL " + remoteURL);
        Configuration.remote = String.format("https://%s:%s@%s", config.login(), config.password(), remoteURL );
        String URL = Configuration.remote;
        System.out.println("URL : " + URL);

    }

}