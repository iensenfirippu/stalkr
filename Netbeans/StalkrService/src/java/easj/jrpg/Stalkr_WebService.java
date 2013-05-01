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
	public String verifyLogin(@WebParam(name = "username") String username, @WebParam(name = "password") String password)
	{
		UserMapper um = new UserMapper();
		return um.verifyLogin(username, password);
	}
	
	@WebMethod(operationName = "loginAdmin")
	public String loginAdmin(@WebParam(name = "username") String username, @WebParam(name = "password") String password)
	{
		UserMapper um = new UserMapper();
		return um.verifyAdminLogin(username, password);
	}
	
	@WebMethod(operationName = "getUser")
	public String getUser(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
							@WebParam(name = "id") String id)
	{
		UserMapper um = new UserMapper();
		return um.getUser(username, password, id);
	}

	@WebMethod(operationName = "getUsers")
	public String[] getUsers(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
							@WebParam(name = "id") String id)
	{
		UserMapper um = new UserMapper();
		return um.getUsers(username, password, id);
	}
	
	@WebMethod(operationName = "saveUser")
	public String saveUser(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
							@WebParam(name = "user") String userasstring)
	{
		UserMapper um = new UserMapper();
		return um.saveUser(username, password, userasstring);
	}

	@WebMethod(operationName = "deleteUser")
	public String deleteUser(@WebParam(name = "username") String username, @WebParam(name = "password") String password,	
								@WebParam(name = "id") String id)
	{
		UserMapper um = new UserMapper();
		return um.deleteUser(username, password, id);
	}

	@WebMethod(operationName = "getMatches")
	public String[] getMatches(	@WebParam(name = "username") String username,
									@WebParam(name = "password") String password,
									@WebParam(name = "id") String id)
	{
		UserMapper um = new UserMapper();
		return um.getMatches(username, password, id);
	}
}
