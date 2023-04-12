package com.torry.demo.project;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebListener;

@WebListener
public class NPLListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext ctx = servletContextEvent.getServletContext();

    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //ServletContext ctx = servletContextEvent.getServletContext();

    }
}
