package com.lughtech;

import org.eclipse.jetty.ee10.servlet.ServletContextHandler;
import org.eclipse.jetty.ee10.servlet.ServletHolder;
import org.eclipse.jetty.server.Server;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.lughtech.api.MessageController;
import com.lughtech.config.modules.ClientModule;
import com.lughtech.config.modules.SenderModule;

public class Application {

    public static void main(String[] args) throws Exception {
        Injector injector = Guice.createInjector(
            new ClientModule(),
            new SenderModule()
        );
        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        context.addServlet(new ServletHolder(injector.getInstance(MessageController.class)), 
        "/messages");
        server.setHandler(context);
        server.start();
        server.join();
    }
    
}
