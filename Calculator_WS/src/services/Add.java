package services;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService (targetNamespace="http://Calculator_WS")
public class Add {
    
    @WebMethod
    public int add(int a, int b) {
        return a+b;
    }

}
