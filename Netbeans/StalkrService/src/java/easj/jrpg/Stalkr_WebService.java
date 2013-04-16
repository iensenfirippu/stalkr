package easj.jrpg;

import easj.jrpg.mappers.UserMapper;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Sommer
 */
@WebService(serviceName = "WS")
public class Stalkr_WebService
{
	@WebMethod(operationName = "verifyLogin")
	public boolean verifyLogin(@WebParam(name = "user") String user, @WebParam(name = "pass") String pass)
	{
		UserMapper um = new UserMapper();
		return um.verifyLogin(user, pass);
	}
	
	@WebMethod(operationName = "getUser")
	public String getUser(@WebParam(name = "id") String id)
	{
		UserMapper um = new UserMapper();
		return um.getUser(id);
	}

	@WebMethod(operationName = "getUsers")
	public String[] getUsers(@WebParam(name = "id") String id)
	{
		UserMapper um = new UserMapper();
		return um.getUsers(id);
	}
	
	@WebMethod(operationName = "saveUser")
	public boolean saveUser(@WebParam(name = "user") String userasstring)
	{
		UserMapper um = new UserMapper();
		return um.saveUser(userasstring);
	}

	@WebMethod(operationName = "deleteUser")
	public boolean deleteUser(@WebParam(name = "user") String user, @WebParam(name = "pass") String pass, @WebParam(name = "id") String id)
	{
		boolean result = false;
		UserMapper um = new UserMapper();
		if (um.verifyLogin(user, pass))
		{
			result = um.deleteUser(id);
		}
		return result;
	}

	@WebMethod(operationName = "getMatches")
	public String[] getMatches(@WebParam(name = "id") String id)
	{
		UserMapper um = new UserMapper();
		return um.getMatches(um.getUser(id));
	}
}
