package easj.jrpg;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Sommer
 */
@WebService(serviceName = "Stalkr_WebService")
public class Stalkr_WebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
		// Philip added and committed this comment as a test 07/03/13
    }
}
