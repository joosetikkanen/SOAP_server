package fi.jopitikk.service_orchestrator.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
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
import numberconversion.NumberConversion;
import numberconversion.NumberConversionSoapType;

/**
 * Servlet implementation class AppServlet
 */
@WebServlet("/ConvertNumber")
public class ConvertNumber extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConvertNumber() {
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
        String val = request.getParameter("value");
        
        
        NumberConversion service = new NumberConversion();
        NumberConversionSoapType soap = service.getNumberConversionSoap();
        String result = soap.numberToWords(new BigInteger(val));
        
        PrintWriter out = response.getWriter();
     
        response.setStatus(200);
        out.write(result + "");
        out.flush();
        out.close();
        
    }

    

}
