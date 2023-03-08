package application;

import application.camunda.config.BaseApplicationStart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;
import java.net.UnknownHostException;

@SpringBootApplication
public class CamundaPocApplication extends BaseApplicationStart {
    private static final Logger logger = LoggerFactory.getLogger(CamundaPocApplication.class);
    @PostConstruct
    private void init() {
        defaultSetup();
    }

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext app = SpringApplication.run(CamundaPocApplication.class, args);
        BaseApplicationStart.logApplicationSetup(app, logger);
    }
}
