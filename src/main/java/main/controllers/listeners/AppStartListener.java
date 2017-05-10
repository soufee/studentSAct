package main.controllers.listeners;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


import main.model.MailSender;

/**
 *
 */
public class AppStartListener implements ServletContextListener {

    static {
        PropertyConfigurator.configure(AppStartListener.class.getClassLoader()
                .getResource("log4j.properties"));
    }

    private static final Logger logger = Logger.getLogger(AppStartListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        Properties emailProps = new Properties();
        try {
            emailProps.load(AppStartListener.class.getClassLoader()
                    .getResourceAsStream("email.properties"));

            if (emailProps.size() > 0) {
                MailSender mailSender = new MailSender(emailProps.getProperty("email"),
                        emailProps.getProperty("password"));

                String adminEmail = sce.getServletContext()
                        .getInitParameter("ADMIN_EMAIL");

                logger.debug("mail send to: " + adminEmail);

                /* TODO: 20.04.2017 it works OK
                mailSender.sendMail("Context initialized",
                        sce.getServletContext().getContextPath(), adminEmail);
                */
            }
        } catch (IOException e) {
            logger.error(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
