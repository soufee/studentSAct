package main.controllers.listeners;

import org.apache.log4j.Logger;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 *
 */
public class AddStudentServletRequestListener implements ServletRequestListener {

    private static final Logger logger = Logger.getLogger(AddStudentServletRequestListener.class);

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {

        String encoding = sre.getServletRequest().getCharacterEncoding();
       // sre.getServletContext().getRealPath()
       // logger.debug("encoding: " + encoding);
    }
}
