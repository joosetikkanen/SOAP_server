package fi.jopitikk.service_orchestrator.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;




public class JettyServer {

    public static void main(String[] args) throws Exception {
        
        ServletHandler handler = new ServletHandler();
        //handler.setDescriptor("WebContent/WEB-INF/web.xml");
        //handler.setResourceBase("WebContent/");
        //handler.setContextPath("/MyDBoxClient");
        
        
        //ServletHandler handler = new ServletHandler();
        //add all servlet to use to the handler, the second argument is the path (e.g. http://localhost:8080/searchPublication)
        //handler.addServletWithMapping("CalculateAdd", "/CalculateAdd");
        handler.addServletWithMapping(CalculateAdd.class, "/CalculateAdd");
        handler.addServletWithMapping(ConvertNumber.class, "/ConvertNumber");
       // handler.addServletWithMapping(UserProfile.class, "/getProfile");
       // handler.addServletWithMapping(CreateUserProfile.class, "/createProfile");
        //Create a new Server, add the handler to it and start
        Server server = new Server(1234);
        //handler.addServletWithMapping(servlet, pathSpec)
        server.setHandler(handler);
        
        server.start();
        
        //this dumps a lot of debug output to the console.
        server.dumpStdErr();
        server.join();
      
      }
}