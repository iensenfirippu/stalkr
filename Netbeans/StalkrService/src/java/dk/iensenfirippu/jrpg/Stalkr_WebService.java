package dk.iensenfirippu.jrpg;

import dk.iensenfirippu.jrpg.stalkr.UserMapper;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 */
@WebService(serviceName = "WS", targetNamespace = "http://jrpg.iensenfirippu.dk/")
public class Stalkr_WebService
{
	@WebMethod(operationName = "login")
	public String Login(	@WebParam(name = "username") String username,
							@WebParam(name = "password") String password)
	{
		return UserMapper.userLogin(username, password);
	}
	
	@WebMethod(operationName = "adminLogin")
	public String AdminLogin(	@WebParam(name = "username") String username,
								@WebParam(name = "password") String password)
	{
		return UserMapper.adminLogin(username, password);
	}
	
	@WebMethod(operationName = "getUser")
	public String GetUser(	@WebParam(name = "username") String username,
							@WebParam(name = "password") String password,
							@WebParam(name = "id") String id)
	{
		return UserMapper.userGetUser(username, password, id);
	}

	@WebMethod(operationName = "adminGetUsers")
	public String[] AdminGetUsers(	@WebParam(name = "username") String username,
									@WebParam(name = "password") String password,
									@WebParam(name = "id") String id)
	{
		return UserMapper.adminGetUsers(username, password, id);
	}
	
	@WebMethod(operationName = "saveUser")
	public String SaveUser(	@WebParam(name = "username") String username,
								@WebParam(name = "password") String password,
								@WebParam(name = "user") String userasstring)
	{
		return UserMapper.userSaveUser(username, password, userasstring);
	}
	
	@WebMethod(operationName = "adminSaveUser")
	public String AdminSaveUser(	@WebParam(name = "username") String username,
									@WebParam(name = "password") String password,
									@WebParam(name = "user") String userasstring)
	{
		return UserMapper.adminSaveUser(username, password, userasstring);
	}

	@WebMethod(operationName = "deleteUser")
	public String DeleteUser(	@WebParam(name = "username") String username,
								@WebParam(name = "password") String password)
	{
		return UserMapper.userDeleteUser(username, password);
	}

	@WebMethod(operationName = "adminDeleteUser")
	public String AdminDeleteUser(	@WebParam(name = "username") String username,
										@WebParam(name = "password") String password,
										@WebParam(name = "id") String id)
	{
		return UserMapper.adminDeleteUser(username, password, id);
	}

	@WebMethod(operationName = "getMatches")
	public String[] GetMatches(@WebParam(name = "user") String userasstring)
	{
		return UserMapper.userGetMatches(userasstring);
	}
}
