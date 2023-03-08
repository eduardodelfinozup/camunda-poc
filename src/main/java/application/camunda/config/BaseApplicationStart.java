package application.camunda.config;

import application.camunda.constants.PocConstant;
import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.i18n.LocaleContextHolder;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Locale;
import java.util.TimeZone;

import static java.time.ZonedDateTime.now;

public abstract class BaseApplicationStart {

    protected void defaultSetup() {
        TimeZone.setDefault(TimeZone.getTimeZone(PocConstant.BRL_TIME_ZONE));
        Locale locale = new Locale("pt", "BR");
        Locale.setDefault(locale);
        LocaleContextHolder.setLocale(locale, true);
        LocaleContextHolder.setDefaultLocale(locale);
    }

    protected static void logApplicationSetup(ConfigurableApplicationContext app,
                                              Logger logger) throws UnknownHostException {
        String applicationName = app.getEnvironment().getProperty("spring.application.name");
        String contextPath = (app.getEnvironment().getProperty("server.contextPath") == null) ? "/"
                : app.getEnvironment().getProperty("server.contextPath");
        String port = app.getEnvironment().getProperty("server.port");
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        String applicationVersion = app.getEnvironment().getProperty("server.version");
        String currentTime = LocalDateTime.now().toString();
        String zonedTime = now().toString();
        String locale = LocaleContextHolder.getLocale().getLanguage() + "-" +
                LocaleContextHolder.getLocale().getCountry();

        logger.info("|\n" +
                        "|------------------------------------------------------------\n" +
                        "|   {} is running! Access URLs:\n" +
                        "|   Local:           http://127.0.0.1:{}{}\n" +
                        "|   External:        http://{}:{}{}\n" +
                        "|   Version:         {}\n" +
                        "|   Current time:    {}\n" +
                        "|   Zoned time:      {}\n" +
                        "|   Locale:          {}\n" +
                        "|------------------------------------------------------------",
                applicationName, port, contextPath, hostAddress, port, contextPath, applicationVersion, currentTime,
                zonedTime, locale);
    }
}