package main.util;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;


/**
 *
 */
public class ApplicationListenerBean implements ApplicationListener<ContextStartedEvent> {

   // private static final Logger logger = Logger.getLogger(ApplicationListenerBean.class);

    @Override
    public void onApplicationEvent(ContextStartedEvent contextStartedEvent) {
        System.out.println("Spring context started...");
        //logger.debug("Spring context started...");
    }
}
