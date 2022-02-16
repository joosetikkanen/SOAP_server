package fi.jopitikk.service_orchestrator.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

import com.soap.ws.client.Add;
import com.soap.ws.client.AddService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AppServlet
 */
@WebServlet("/CalculateAdd")
public class CalculateAdd extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculateAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        //
        
    }

    /**
     * @throws IOException 
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TODO Auto-generated method stub
        //doGet(request, response);
        //CalculatorClient client = new CalculatorClient();
        String val1 = request.getParameter("value1");
        String val2 = request.getParameter("value2");
        
        AddService ws = new AddService();
        Add obj = ws.getAdd();
        int result = obj.add(Integer.parseInt(val1), Integer.parseInt(val2));
        PrintWriter out = response.getWriter();
     
        response.setStatus(200);
        out.write(result + "");
        out.flush();
        out.close();
        
    }

    

}
